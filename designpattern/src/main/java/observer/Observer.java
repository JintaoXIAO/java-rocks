package observer;

public interface Observer<T> {
  void  notify(Event<T> event);

  class Event<T> {
    private T eventSource;

    public Event(T eventSource) {
      this.eventSource = eventSource;
    }

    public T getEventSource() {
      return eventSource;
    }
  }
}
