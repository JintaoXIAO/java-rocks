package demo;

import io.vertx.core.Vertx;

import java.util.concurrent.TimeUnit;

public class Main01 {
  public static void main(String[] args) throws InterruptedException {
    Vertx vertx = Vertx.vertx();

    vertx.setPeriodic(600, id -> {
      System.out.println("timer fired! --- " + id);
    });


    TimeUnit.SECONDS.sleep(3);
    vertx.close();

  }
}
