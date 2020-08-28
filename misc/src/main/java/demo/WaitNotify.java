package demo;

import java.util.concurrent.TimeUnit;

public class WaitNotify {
  volatile boolean ready = false;

  synchronized void n() {
    try {
      TimeUnit.SECONDS.sleep(1);
      ready = true;
      notifyAll();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  synchronized void check() {
    while (!ready) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("Thread " + Thread.currentThread().getName() + " check status: " + ready);
  }

  public static void main(String[] args) throws InterruptedException {
    WaitNotify wn = new WaitNotify();


    Runnable r = () -> {
      wn.check();
    };

    Thread cThread = new Thread(null, r, "01");
    Thread c2Thread = new Thread(null, r, "02");
    Thread nThread = new Thread(()->{
      wn.n();
    });

    cThread.start();
    c2Thread.start();
    nThread.start();

    TimeUnit.SECONDS.sleep(2);
  }

}
