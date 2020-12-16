package rxjava.filtering;

import io.reactivex.Observable;
import io.reactivex.internal.operators.flowable.FlowableJust;
import io.reactivex.internal.operators.observable.ObservableBuffer;
import org.reactivestreams.Publisher;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;


public class Debounce {
  public static void main(String[] args) {
    final Publisher<String> publisher = s -> {
      Random r = new Random(System.currentTimeMillis());
      IntStream.range(1,10).forEach(i -> {
        s.onNext("current time stamp: " + System.nanoTime());
        try {
          TimeUnit.MILLISECONDS.sleep(r.nextInt(30));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });

    };

    ObservableBuffer.fromPublisher(publisher)
            .debounce(10, TimeUnit.MILLISECONDS)
            .subscribe(s -> System.out.println(s));
  }
}
