package rxjava.misc;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Demo {
  public static List<Integer> doSquares() {
    var squares = new ArrayList<Integer>();
    Flowable.range(1, 64)
            .observeOn(Schedulers.computation())
            .map(v -> v * v)
            .blockingSubscribe(squares::add);
    return squares;
  }

  public static List<Integer> doParallelSquares() {
    var squares = new ArrayList<Integer>();
    Flowable.range(1, 64)
            .flatMap(v -> Flowable.just(v)
                    .subscribeOn(Schedulers.computation())
                    .map(w -> w * w)
            )
            .doOnError(Throwable::printStackTrace)
            .doOnComplete(() -> System.out.println("Completed"))
            .blockingSubscribe(squares::add);
    return squares;
  }

  public static void observeOn_subscribeOn() throws InterruptedException {
    ObservableOnSubscribe<Integer> oos = emitter -> {
      System.out.println(Thread.currentThread().getName() + " Subscribed");
      emitter.onNext(2);
      emitter.onNext(3);
      emitter.onComplete();
    };

    Observable.create(oos)
            .doOnNext(i -> {
              System.out.println(Thread.currentThread().getName() + " calculate " + i);
            })
            .observeOn(Schedulers.newThread())
            //.subscribeOn(Schedulers.newThread())
            .doOnNext(i -> {
              System.out.println(Thread.currentThread().getName() + " calculate " + i);
            })
            .map(i -> i * 2)
            .subscribe(i -> System.out.println(Thread.currentThread().getName() + " consume " + i));

    TimeUnit.SECONDS.sleep(1);

  }

  public static void main(String[] args) throws InterruptedException {
    observeOn_subscribeOn();
  }

}
