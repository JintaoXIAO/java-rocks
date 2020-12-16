package rxjava.misc;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class DoubleObservable implements ObservableSource<Integer> , Disposable{

  public static void main(String[] args) {
    DoubleObservable doubleObservable = new DoubleObservable(new int[]{1, 2, 3});
    doubleObservable.subscribe(new Observer<Integer>() {
      @Override
      public void onSubscribe(@NotNull Disposable d) {

      }

      @Override
      public void onNext(@NotNull Integer integer) {
        System.out.println("value: " + integer);
      }

      @Override
      public void onError(@NotNull Throwable e) {

      }

      @Override
      public void onComplete() {

      }
    });
    doubleObservable.run();

  }



  private void run() {
    for (int i = 0; i < arr.length; i++) {
      this.downstream.onNext(arr[i]);
    }
  }

  private Observer downstream;
  private int[] arr;

  public DoubleObservable(int[] arr) {
    this.arr = arr;
  }

  @Override
  public void subscribe(@NotNull Observer<? super Integer> observer) {
    this.downstream = new DoubleObserver(observer);
    this.downstream.onSubscribe(this);
  }

  @Override
  public void dispose() {

  }

  @Override
  public boolean isDisposed() {
    return false;
  }

  static class DoubleObserver implements Observer<Integer> {

    private Observer<? super Integer> downstream;

    public DoubleObserver(Observer<? super Integer> downstream) {
      this.downstream = downstream;
    }

    @Override
    public void onSubscribe(@NotNull Disposable d) {
      downstream.onSubscribe(d);
    }

    @Override
    public void onNext(@NotNull Integer integer) {
      downstream.onNext(integer * 2);
    }

    @Override
    public void onError(@NotNull Throwable e) {
      downstream.onError(e);
    }

    @Override
    public void onComplete() {
      downstream.onComplete();
    }
  }
}
