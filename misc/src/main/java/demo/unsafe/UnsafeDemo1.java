package demo.unsafe;

import sun.misc.Unsafe;

import java.util.Arrays;

public class UnsafeDemo1 {
  public static void main(String[] args) throws Exception {
    Unsafe unsafe = UnsafeLocator.get();

    int offset = unsafe.arrayBaseOffset(int[].class);
    int indexScale = unsafe.arrayIndexScale(int[].class);
    int[] arr = new int[10];
    System.out.println("indexScale: " + indexScale);
    System.out.println("before: " + Arrays.toString(arr));
    unsafe.putInt(arr, offset + 3 * indexScale, 10);
    System.out.println("after: " + Arrays.toString(arr));
  }
}
