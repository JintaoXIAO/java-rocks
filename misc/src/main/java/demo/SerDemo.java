package demo;

import java.io.*;

public class SerDemo {
  public static void main(String[] args) throws IOException {

    System.out.println(">> start write");
    try (
            ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
            ObjectOutput oo = new ObjectOutputStream(baos)
    ) {
      String k = "name";
      String v = "jintao_xiao";
      byte[] kb = k.getBytes();
      byte[] vb = v.getBytes();
      oo.writeShort(kb.length);oo.write(kb);
      oo.writeShort(vb.length);oo.write(vb);
      oo.flush();

      System.out.println(">> start read");
      try(ObjectInput oi = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))){
        short len;
        byte[] bytes = new byte[1024];
        while (oi.available() > 0) {
          len = oi.readShort();
          oi.read(bytes, 0, len);
          System.out.println(new String(bytes, 0, len));
        }
      }
    }
  }
}
