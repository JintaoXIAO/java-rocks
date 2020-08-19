package demo.rxjava.creating;

import io.reactivex.Observable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Defer {
  public static void main(String[] args) throws InterruptedException {
    long now = System.currentTimeMillis();
    System.out.println("now: " + new Date(now));
    Observable<Date> obs = Observable.defer(() -> Observable.fromArray(new Date(System.currentTimeMillis())));

    TimeUnit.SECONDS.sleep(10);
    obs.subscribe(date -> {
      System.out.println("current time: " + date);
    });

  }
}
