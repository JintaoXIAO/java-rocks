package demo;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class Demo1 {
  Generic<String, Integer> g1;
  Generic<Integer, Long> g2;


  public static void main(String[] args) throws Exception{
    Field field = Demo1.class.getDeclaredField("g1");
    Type gt = field.getGenericType();
    gt.getTypeName();
    System.out.println(gt);

  }
}
class Generic<T,R> {
  T arg;
  R val;
}