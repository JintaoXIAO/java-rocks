package concurrency.actordemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Actor<M> implements Runnable {

  private final BlockingQueue<M> queue;
  private State state;
  private final Behavior<M> behavior;
  private final static int DEFAULT_QUEUE_CAPACITY = 100;


  private Actor(Behavior<M> behavior, int queueCapacity) {
    this.behavior = behavior;
    this.queue = new ArrayBlockingQueue<>(queueCapacity);
    this.state = State.alive;
  }

  public static <M> Actor<M> create(Behavior<M> behavior) {
    Actor<M> actor = new Actor<>(behavior, DEFAULT_QUEUE_CAPACITY);
    new Thread(actor).start();
    return actor;
  }

  boolean send(M msg) throws DeadException {
    if (state == State.dead) {
      throw new DeadException();
    }
    return queue.offer(msg);
  }

  @Override
  public void run() {
    try {
      while (behavior.onReceive(this, queue.take())){

      }
    } catch (InterruptedException e) {
      behavior.onException(this, e);
    }
    this.state = State.dead;
    this.queue.clear();
  }

  enum State {
    alive,
    dead;
  }

  public static class DeadException extends Exception{}

  interface Behavior<M> {
    boolean onReceive(Actor<M> self, M msg);
    void onException(Actor<M> self, Exception exp);
  }
}
