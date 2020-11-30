package gpars;

import groovyx.gpars.ReactorMessagingRunnable;
import groovyx.gpars.actor.ReactiveActor;

public class ReactorDemo {
  public static void main(String[] args) throws InterruptedException {
    var handler = new ReactorMessagingRunnable<String, Integer>(){
      @Override
      protected Integer doRun(String argument) {
        return argument.length();
      }
    };

    var actor = new ReactiveActor(handler);
    actor.start();

    System.out.println("calculate...");
    System.out.println("::1 " + actor.sendAndWait("hello world"));
    System.out.println("::2 " + actor.sendAndWait("world"));
  }
}
