package p7;

public class ReverseInteger {
  public int reverse(int x) {
    int r = 0;
    while (x != 0) {
      int m = x % 10;
      int d = x / 10;
      if (d == 0) {
        if (overflowAdd(r, m)) return 0;
        else return r + m;
      } else {
        if (overflowAdd(r, m))return 0;
        else if (overflowMulti10(r+m)) return 0;
        else
          r = (r + m) * 10;
      }
      x = x / 10;
    }
    return r;
  }

  boolean overflowMulti10(int base) {
    return base>0
            ? Integer.MAX_VALUE / 10 < base
            : Integer.MIN_VALUE / 10 > base;
  }

  boolean overflowAdd(int base, int offset){
    return base>0
            ? Integer.MAX_VALUE - base < offset
            : Integer.MIN_VALUE - base > offset;
  }
}
