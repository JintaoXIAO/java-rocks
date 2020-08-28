package demo;

import java.util.concurrent.ThreadLocalRandom;

public class AlmostFinal {
  static final int l = printNM();
  static final int n = ThreadLocalRandom.current().nextInt();
  static final int m = Math.min(10, 10);
  static final int o = printNM();

  static int printNM() {
    System.out.println(n + " " + m);
    return 8;
  }

  public static void main(String[] args) {

  }
}
