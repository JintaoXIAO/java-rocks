package demo.jol;

import org.openjdk.jol.info.ClassLayout;

public class JOLSample02 {
  public static class A {
    long f;
  }

  public static void main(String[] args) {
    System.out.println(ClassLayout.parseClass(A.class).toPrintable());
  }
}
