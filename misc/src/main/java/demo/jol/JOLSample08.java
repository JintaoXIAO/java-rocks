package demo.jol;

import org.openjdk.jol.info.ClassLayout;

public class JOLSample08 {
  public static void main(String[] args) {
    System.out.println(ClassLayout.parseClass(Class.class).toPrintable());
  }
}
