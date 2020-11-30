package demo;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;

public class ArrayIndexScale {
  private static final Unsafe THE_UNSAFE;

  static
  {
    try
    {
      final PrivilegedExceptionAction<Unsafe> action = new PrivilegedExceptionAction<Unsafe>()
      {
        public Unsafe run() throws Exception
        {
          Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
          theUnsafe.setAccessible(true);
          return (Unsafe) theUnsafe.get(null);
        }
      };

      THE_UNSAFE = AccessController.doPrivileged(action);
    }
    catch (Exception e)
    {
      throw new RuntimeException("Unable to load unsafe", e);
    }
  }

  public static void main(String[] args) {
    int b = THE_UNSAFE.arrayBaseOffset(Object[].class);
    System.out.println(b);
    int s = THE_UNSAFE.arrayIndexScale(Object[].class);
    System.out.println(s);
  }
}
