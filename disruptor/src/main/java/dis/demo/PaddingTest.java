package dis.demo;

import com.lmax.disruptor.util.Util;
import sun.misc.Unsafe;

public class PaddingTest {
  public static void main(String[] args) {
    Unsafe unsafe = Util.getUnsafe();
    int bufferSize = 64;
    int scale = unsafe.arrayIndexScale(Object[].class);
    int buffer_pad = 128 / scale;
    int ref_element_shift = scale == 4 ? 2 : scale == 8 ? 3 : -1;
    if (ref_element_shift == -1) throw new IllegalStateException();
    int ref_array_base = unsafe.arrayBaseOffset(Object[].class) + (buffer_pad << ref_element_shift);
    Object[] entries = new Object[buffer_pad + 2 * buffer_pad];
    int indexMask = bufferSize - 1;
    for (int i = 0; i < bufferSize; i++) {
      entries[buffer_pad + i] = "filled";
    }

    Object target = unsafe.getObject(entries, ref_array_base + ((2 & indexMask)) << ref_element_shift);
    System.out.println(target);
  }

}
