package demo;


public class ThisEscape {
  private String name;

  public ThisEscape(EventSource source) {
    source.registerListener(
            new EventListener() {
              @Override
              public void onEvent(Event e) {

              }
            }
    );
  }

}
class EventSource {
  public void registerListener(EventListener eventListener) {

  }
}
class EventListener {
  public void onEvent(Event e) {
    
  }
}

class Event {

}


