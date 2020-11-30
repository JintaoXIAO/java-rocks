package fibry.demo;

import eu.lucaventuri.fibry.Actor;
import eu.lucaventuri.fibry.ActorSystem;
import eu.lucaventuri.fibry.MessageReceiver;

public class Demo5 {
  public static void main(String[] args) {
    var actor = ActorSystem.named("demo")
            .newReceivingActor((receiver, msg) -> {
              System.out.println("currently receive " + msg);
              System.out.println("start receiving another one...");
            });
    actor.sendMessage("world");
    MessageReceiver mr = actor.getMessageReceiver();
    System.out.println(mr.readMessage());
  }
}
