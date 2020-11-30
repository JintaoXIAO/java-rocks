package fibry.demo;

import eu.lucaventuri.fibry.Actor;
import eu.lucaventuri.fibry.ActorSystem;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo2 {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    Actor server = ActorSystem.named("server").newActorWithReturn((String msg) -> msg.toUpperCase());

  }
}
