package testing;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;
import io.reactivex.subscribers.TestSubscriber;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;


@Test
public class Tests {
  public void testscuscriber() {
    Flowable<Integer> flowable = Flowable.create(src -> {
      src.onNext(1);
      src.onError(new RuntimeException());
    }, BackpressureStrategy.LATEST);

    TestSubscriber<Integer> ts = flowable.test();
    ts.assertSubscribed();
    ts.assertError(RuntimeException.class);
  }

  public void testscheduler() {
    TestScheduler scheduler = new TestScheduler();
    Observable<Long> tick = Observable
            .interval(1, TimeUnit.SECONDS, scheduler);

    Observable<String> observable = Observable.just("foo", "bar", "biz", "baz")
            .zipWith(tick, (s, i) -> i + "-" + s);

    TestObserver<String> to = observable.subscribeOn(scheduler).test();
    scheduler.advanceTimeBy(2300, TimeUnit.MILLISECONDS);
    to.assertNoErrors();
    to.assertValues("0-foo", "1-bar");
    to.assertNotComplete();

  }


}
