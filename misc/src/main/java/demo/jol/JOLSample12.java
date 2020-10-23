package demo.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.io.OutputStream;
import java.io.PrintStream;

public class JOLSample12 {
  /*
   * This is another dive into the mark word.
   *
   * Among other things, mark words store locking information.
   * We can clearly see how the mark word contents change when
   * we acquire the lock, and release it subsequently.
   *
   * This one is the example of thin (displaced) lock. The data
   * in mark word when lock is acquired is the reference to the
   * displaced object header, allocated on stack. Once we leave
   * the lock, the displaced header is discarded, and mark word
   * is reverted to the default value.
   */

  public static void main(String[] args) throws Exception {
    PrintStream out = System.out;

    out.println(VM.current().details());

    final A a = new A();

    ClassLayout layout = ClassLayout.parseInstance(a);

    out.println("**** Fresh object");
    out.println(layout.toPrintable());

    synchronized (a) {
      out.println("**** With the lock");
      out.println(layout.toPrintable());
    }

    out.println("**** After the lock");
    out.println(layout.toPrintable());
    out.println("current thread id: " + Thread.currentThread().hashCode());
  }

  public static class A {
    // no fields
  }
}
