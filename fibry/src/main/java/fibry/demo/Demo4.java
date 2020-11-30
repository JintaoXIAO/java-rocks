package fibry.demo;

import eu.lucaventuri.fibry.Actor;
import eu.lucaventuri.fibry.ActorSystem;


public class Demo4 {
  public static void main(String[] args) {
    Actor actor = ActorSystem.anonymous().newActor((msg, actor1) -> {
      System.out.println("msg accepted: " + msg + " by actor: " + actor1);

      actor1.sendMessage("world");
      actor1.sendPoisonPill();

    });
    actor.sendMessage("hello");
  }
}
