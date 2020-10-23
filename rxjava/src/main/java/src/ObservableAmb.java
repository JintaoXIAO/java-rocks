package src;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ObservableAmb<T> extends Observable<T> {
  final ObservableSource<? extends T>[] sources;
  final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;

  public ObservableAmb(ObservableSource<? extends T>[] sources, Iterable<? extends ObservableSource<? extends T>> sourcesIterable) {
    this.sources = sources;
    this.sourcesIterable = sourcesIterable;
  }

  @Override
  protected void subscribeActual(Observer<? super T> observer) {
    ObservableSource<? extends T>[] sources = this.sources;
    int count = 0;
    if (sources == null) {
      sources = new ObservableSource[8];
      try {
        for (ObservableSource<? extends T> p : sourcesIterable) {
          if (p == null) {
            EmptyDisposable.error(new NullPointerException("One of the sources is null"), observer);
            return;
          }

          if (count == sources.length) {
            ObservableSource<? extends T>[] b = new ObservableSource[count + (count >> 2)];
            System.arraycopy(sources, 0, b, 0, count);
            sources = b;
          }
          sources[count++] = p;
        }
      } catch (Throwable e) {
        Exceptions.throwIfFatal(e);;
        EmptyDisposable.error(e, observer);
        return;
      }
    } else {
      count = sources.length;
    }

    if (count == 0) {
      EmptyDisposable.complete(observer);
      return;
    } else if (count == 1) {
      sources[0].subscribe(observer);
      return;
    }

    AmbCoordinator<T> ac = new AmbCoordinator<>(observer, count);
    ac.subscribe(sources);
  }

  static final class AmbCoordinator<T> implements Disposable {
    final Observer<? super T> downstream;
    final AmbInnerObserver<T>[] observers;

    final AtomicInteger winner = new AtomicInteger();

    AmbCoordinator(Observer<? super T> observer, int count) {
      this.downstream = observer;
      this.observers = new AmbInnerObserver[count];
    }

    @Override
    public void dispose() {
      if (winner.get() != -1) {
        winner.lazySet(-1);

        for (AmbInnerObserver<T> a : observers) {
          a.dispose();
        }
      }
    }

    @Override
    public boolean isDisposed() {
      return winner.get() == -1;
    }

    public void subscribe(ObservableSource<? extends T>[] sources) {
      AmbInnerObserver<T>[] as = observers;
      int len = as.length;
      for (int i = 0; i < len; i++) {
        as[i] = new AmbInnerObserver<>(this, i+1, downstream);
      }
      winner.lazySet(0);
      downstream.onSubscribe(this);

      for (int i = 0; i < len; i++) {
        if (winner.get() != 0) {
          return;
        }
        sources[i].subscribe(as[i]);
      }
    }

    public boolean win(int index) {
      int w = winner.get();
      if (w == 0) {
        if (winner.compareAndSet(0, index)) {
          AmbInnerObserver<T>[] a = observers;
          int n = a.length;
          for (int i = 0; i < n; i++) {
            if (i + 1 != index) {
              a[i].dispose();
            }
          }
          return true;
        }
      }
      return false;
    }
  }

  static final class AmbInnerObserver<T>  extends AtomicReference<Disposable> implements Observer<T> {
    final AmbCoordinator<T> parent;
    final int index;
    final Observer<? super T> downstream;

    boolean won;

    AmbInnerObserver(AmbCoordinator<T> parent, int index, Observer<? super T> downstream) {
      this.parent = parent;
      this.index = index;
      this.downstream = downstream;
    }

    @Override
    public void onSubscribe(@org.jetbrains.annotations.NotNull Disposable d) {
      DisposableHelper.setOnce(this, d);
    }

    @Override
    public void onNext(@org.jetbrains.annotations.NotNull T t) {
      if (won) {
        downstream.onNext(t);
      } else {
        if (parent.win(index)) {
          won = true;
          downstream.onNext(t);
        } else {
          get().dispose();
        }
      }
    }

    @Override
    public void onError(@org.jetbrains.annotations.NotNull Throwable e) {

    }

    @Override
    public void onComplete() {

    }

    public void dispose() {
      DisposableHelper.dispose(this);
    }
  }
}
