package demo.jol;

import org.openjdk.jol.info.ClassLayout;

public class JOLSample07 {
  public static void main(String[] args) {
    System.out.println(ClassLayout.parseClass(Throwable.class).toPrintable());
  }
}
