package demo.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class JOLSample01 {
  public static class A {
    boolean f;
  }

  public static void main(String[] args) {
    System.out.println(VM.current().details());
    System.out.println("----------------------------------");
    System.out.println(ClassLayout.parseClass(A.class).toPrintable());
  }
}
