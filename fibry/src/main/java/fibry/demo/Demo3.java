package fibry.demo;

import eu.lucaventuri.fibry.Actor;
import eu.lucaventuri.fibry.ActorSystem;

public class Demo3 {
  public static void main(String[] args) {
    Actor<String, Integer, Void> actor = ActorSystem.anonymous(10).newActorWithReturn((String msg) -> {
      System.out.println("working..." + msg);
      return msg.length();
    });
    Integer r = actor.sendMessageReturnWait("hello", -1);
    System.out.println("length: " + r);
    actor.close();

  }
}
