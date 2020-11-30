package demo.jol1;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class ObjectWithNoFieldsLayout {
  public static void main(String[] args) {
    System.out.println(VM.current().details());
    String s = ClassLayout.parseClass(WithNoField.class).toPrintable();
    System.out.println("::::class layout: \n" + s);

    WithNoField w = new WithNoField();
    System.out.println("::::object layout: \n" +
            ClassLayout.parseInstance(w).toPrintable());
    System.out.println("after calculate the hashCode: " + w.hashCode());

    System.out.println("::::object layout: \n" +
            ClassLayout.parseInstance(w).toPrintable());

  }
}

class WithNoField {

}
