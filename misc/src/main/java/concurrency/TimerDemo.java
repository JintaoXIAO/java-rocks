package concurrency;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
  public static void main(String[] args) {
    Timer timer = new Timer();
    System.out.println("see you after 2 seconds " + System.currentTimeMillis());
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        System.out.println("see " + System.currentTimeMillis());
      }
    }, 2 * 1000);
  }
}
