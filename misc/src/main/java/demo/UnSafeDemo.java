package demo;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnSafeDemo {
  static Unsafe UNSAFE;
  static {
    try {
      Field f = Unsafe.class.getDeclaredField("theUnsafe");
      f.setAccessible(true);
      UNSAFE = (Unsafe) f.get(null);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }
  public static void main(String[] args) throws Exception {
     ClassWithExpensiveConstructor c = (ClassWithExpensiveConstructor) UNSAFE.allocateInstance(ClassWithExpensiveConstructor.class);
    System.out.println(c.getValue());
    System.out.println(c.getValue1());
    System.out.println(c.getName());
  }
}

class ClassWithExpensiveConstructor {

  private final int value;
  private int value1 = 10;
  private final String name = "hello";

  private ClassWithExpensiveConstructor() {
    //value = doExpensiveLookup();
    throw new RuntimeException();
  }

  private int doExpensiveLookup() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return 1;
  }

  public int getValue() {
    return value;
  }

  public int getValue1() {
    return value1;
  }

  public String getName() {
    return name;
  }
}