package rxjava.conditional;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Amb {

  static ThreadLocalRandom tlr = ThreadLocalRandom.current();

  static void fetchFromWeb(Observer observer, String flag, long st){
    new Thread(() -> {
      try {
        TimeUnit.MILLISECONDS.sleep(st);
      } catch (InterruptedException e) {

      }
      observer.onNext("value from "  + flag);
    }).start();
  }

  public static void main(String[] args) throws InterruptedException {
    ObservableSource<String> os1 = observer -> {
      fetchFromWeb(observer, "os1", 1000);
    };

    ObservableSource<String> os2 = observer -> {
      fetchFromWeb(observer, "os2", 500);
    };

    Observable.ambArray(os1, os2)
            .subscribe(System.out::println);

    TimeUnit.SECONDS.sleep(1);

  }
}
