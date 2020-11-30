package concurrency.activeObject;

import java.util.concurrent.TimeUnit;

public class Servant implements ActiveObject {
  
  @Override
  public Result<String> makeString(int count, char c) {
    char[] buffer = new char[count];
    for (int i = 0; i < count; i++) {
      buffer[i] = c;
      try {
        TimeUnit.MILLISECONDS.sleep(100);
      } catch (InterruptedException e) {

      }
    }
    return new RealResult<>(new String(buffer));
  }

  @Override
  public void displayString(String str) {
    System.out.println("display string: " + str);
    try {
      TimeUnit.MILLISECONDS.sleep(100);
    } catch (InterruptedException e) {
    }
  }
}
