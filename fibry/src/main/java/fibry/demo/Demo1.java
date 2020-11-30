package fibry.demo;

import eu.lucaventuri.fibry.Actor;
import eu.lucaventuri.fibry.ActorSystem;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
  public static void main(String[] args) {
    Actor<String, Void, Void> actor = ActorSystem.named("myActorDemo").newActor(Demo1::processWithException);
    actor.sendMessage("hello world");
    actor.close();
  }

  static void processWithException(String msg) {
    System.out.println(msg);
    throw new RuntimeException();
  }
}
