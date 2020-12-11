package observer;

public class StopwatchObserver implements Observer<Long>{
  @Override
  public void notify(Event<Long> event) {
    System.out.println("[" + this.hashCode() + "]" + "event: " + event.getEventSource());
  }
}
