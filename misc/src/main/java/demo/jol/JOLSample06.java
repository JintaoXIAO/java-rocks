package demo.jol;

import org.openjdk.jol.info.ClassLayout;

public class JOLSample06 {

  public static class A {
    boolean a;
  }

  public static class B extends A {
    boolean b;
  }

  public static class C extends B {
    boolean c;
  }

  public static void main(String[] args) {
    System.out.println(ClassLayout.parseClass(C.class).toPrintable());
  }
}
