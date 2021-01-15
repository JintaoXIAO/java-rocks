package p6;

public class ZigZagConversion {

  public String convert(String s, int numRows) {
    StringBuilder[] builders = new StringBuilder[numRows];
    for (int i = 0; i < builders.length; i++) {
      builders[i] = new StringBuilder();
    }

    ZigZagCalc zzg = new ZigZagCalc(numRows);

    for (int i = 0; i < s.length(); i++) {
      builders[zzg.next()].append(s.charAt(i));
    }
    StringBuilder r = new StringBuilder();
    for (int i = 0; i < builders.length; i++) {
      r.append(builders[i]);
    }
    return r.toString();
  }

  static class ZigZagCalc {
    final private int seed;
    final private int base;
    private int counter;

    /**
     * seed > 1
     *
     * @param seed
     */
    public ZigZagCalc(int seed) {
      this.seed = seed;
      this.base = seed + seed - 2;
      this.counter = 0;
    }

    public int next() {
      if (base == 0)
        return 0;

      int r = counter % base;
      counter++;
      return r < seed ? r : base - r;
    }
  }
}
