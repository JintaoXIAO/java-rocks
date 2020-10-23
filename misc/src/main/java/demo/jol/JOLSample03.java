package demo.jol;

import org.openjdk.jol.info.ClassLayout;

public class JOLSample03 {
  public static class A {
    boolean bo1, bo2;
    byte b1, b2;
    char c1, c2;
    double d1, d2;
    float f1, f2;
    int i1, i2;
    long l1, l2;
    short s1, s2;
  }

  public static void main(String[] args) {
    System.out.println(ClassLayout.parseClass(A.class).toPrintable());
  }
}
