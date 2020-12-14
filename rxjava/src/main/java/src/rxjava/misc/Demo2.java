package rxjava.misc;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.jetbrains.annotations.NotNull;

public class Demo2 implements ObservableSource<Integer>, Disposable {
  private boolean isDisposed = false;
  private int[] arr;
  private Observer<? super Integer> d;


  public Demo2(int[] arr) {
    this.arr = arr;
  }

  public static void main(String[] args) {
    Demo2 demo2 = new Demo2(new int[]{1, 23, 3});

    demo2.subscribe(new Observer<Integer>() {
      @Override
      public void onSubscribe(@NotNull Disposable d) {
        System.out.println("this observer is subscribed");
      }

      @Override
      public void onNext(@NotNull Integer integer) {
        System.out.println("value: " + integer);
      }

      @Override
      public void onError(@NotNull Throwable e) {
        System.err.println("error " + e);
      }

      @Override
      public void onComplete() {
        System.out.println("finished");
      }
    });

    demo2.work();
  }

  void work() {
    for (int i = 0; i < arr.length; i++) {
      d.onNext(arr[i]);
    }

    d.onComplete();
  }


  void register(Observer<Integer> observer) {
  }

  @Override
  public void subscribe(@NotNull Observer<? super Integer> observer) {
    observer.onSubscribe(this);
    this.d = observer;
  }

  @Override
  public void dispose() {

  }

  @Override
  public boolean isDisposed() {
    return false;
  }
}
