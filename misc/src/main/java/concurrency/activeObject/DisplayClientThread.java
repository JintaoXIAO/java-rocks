package concurrency.activeObject;

import java.util.concurrent.TimeUnit;

public class DisplayClientThread extends Thread{
  private final ActiveObject activeObject;
  public DisplayClientThread(String name, ActiveObject activeObject) {
    super(name);
    this.activeObject = activeObject;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; true; i++) {
        String str = Thread.currentThread().getName() + " " + i;
        activeObject.displayString(str);
        TimeUnit.MILLISECONDS.sleep(100);
      }
    } catch (InterruptedException e) {

    }
  }
}
