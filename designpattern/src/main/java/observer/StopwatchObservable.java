package observer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class StopwatchObservable implements Observerable<Long>, Runnable{
  private Map<Integer, Observer<Long>> observerMap;

  public StopwatchObservable() {
    this.observerMap = new HashMap<>();
  }

  @Override
  public void subscribe(Observer<Long> observer) {
    this.observerMap.put(observer.hashCode(), observer);
  }


  @Override
  public void run() {
    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException ignore) {

    }
    long ct = System.currentTimeMillis();
    observerMap.values().stream().forEach(o -> o.notify(new Observer.Event<>(ct)));
  }
}
