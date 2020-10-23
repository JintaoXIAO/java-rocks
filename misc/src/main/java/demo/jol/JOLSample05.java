package demo.jol;

import org.openjdk.jol.info.ClassLayout;

public class JOLSample05 {
  public static class A {
    long a;
  }
  public static class B extends A {
    long b;
  }
  public static class C extends B {
    long c;
    int d;
  }

  public static void main(String[] args) {
    System.out.println(ClassLayout.parseClass(C.class).toPrintable());
  }
}
