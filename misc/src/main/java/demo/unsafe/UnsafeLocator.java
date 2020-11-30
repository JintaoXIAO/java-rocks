package demo.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeLocator {
  public static Unsafe get() {
    return UNSAFE;
  }
  private static Unsafe UNSAFE;
  static {
    try {
      Field f = Unsafe.class.getDeclaredField("theUnsafe");
      f.setAccessible(true);
      UNSAFE = (Unsafe) f.get(null);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }
}
