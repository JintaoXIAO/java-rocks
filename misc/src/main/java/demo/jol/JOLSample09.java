package demo.jol;

import org.openjdk.jol.info.ClassLayout;

public class JOLSample09 {
  public static void main(String[] args) {
    System.out.println(ClassLayout.parseClass(B.class).toPrintable());
  }
  public static class A {
    int a;
    int b;
    int c;
    int d;
  }

  public static class B extends A{
    int e;
  }
}
