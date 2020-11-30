package gpars;

import groovyx.gpars.MessagingRunnable;
import groovyx.gpars.actor.DynamicDispatchActor;

import java.util.concurrent.TimeUnit;

public class StatelessActorDemo {
  public static void main(String[] args) throws InterruptedException {
    MyStatelessActor actor = new MyStatelessActor();
    actor.start();
    actor.send("hello");
    actor.sendAndWait(10);
    actor.sendAndContinue(10.0, new MessagingRunnable() {
      @Override
      protected void doRun(Object argument) {
        System.out.println("Received a reply: " + argument);
      }
    });
    TimeUnit.MILLISECONDS.sleep(100);
  }
}

class MyStatelessActor extends DynamicDispatchActor {
  public void onMessage(final String msg) {
    System.out.println("Received: " + msg);
    replyIfExists("Thank you");
  }

  public void onMessage(final Integer msg) {
    System.out.println("Received: " + msg);
    replyIfExists("Thank you");
  }

  public void onMessage(final Object msg) {
    System.out.println("Received: " + msg);
    replyIfExists("Thank you");
  }
}
