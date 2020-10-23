package demo.jol;

import org.openjdk.jol.info.ClassLayout;

public class JOLSample10 {
  public static void main(String[] args) {
    System.out.println(ClassLayout.parseInstance(new A()).toPrintable());
    System.out.println(ClassLayout.parseInstance(new B()).toPrintable());
  }
  public static class A {

  }

  public static class B {

  }
}
