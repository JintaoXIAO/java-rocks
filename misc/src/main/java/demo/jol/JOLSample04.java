package demo.jol;

import org.openjdk.jol.info.ClassLayout;

public class JOLSample04 {
  public static class A {
    int a;
  }
  public static class B extends A {
    int b;
  }
  public static class C extends B {
    int c;
  }

  public static void main(String[] args) {
    System.out.println(ClassLayout.parseClass(C.class).toPrintable());
  }
}
