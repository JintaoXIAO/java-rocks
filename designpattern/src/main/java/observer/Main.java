package observer;

public class Main {
  public static void main(String[] args) {
    StopwatchObservable stopwatchObservable = new StopwatchObservable();
    stopwatchObservable.subscribe(new StopwatchObserver());
    stopwatchObservable.subscribe(new StopwatchObserver());

    stopwatchObservable.run();
  }
}
