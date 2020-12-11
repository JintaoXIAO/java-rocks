package observer;

public interface Observerable<T> {
  void subscribe(Observer<T> observer);
}
