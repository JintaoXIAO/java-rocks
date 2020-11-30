package demo.unsafe;

import sun.misc.Unsafe;

public class UnsafeDemo2 {
  public static void main(String[] args) throws Exception {
    Unsafe unsafe = UnsafeLocator.get();
    IntValue v = new IntValue(10);
    long offset = unsafe.objectFieldOffset(IntValue.class.getDeclaredField("val"));
    int val = unsafe.getInt(v, offset);
    System.out.println(val);
    unsafe.putInt(v, offset, 123);
    System.out.println(v.getVal());
  }
}

class IntValue {
  private int val;

  IntValue(int val) {
    this.val = val;
  }

  public int getVal() {
    return val;
  }
}
