package joda;

import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.Instant;

public class Demo1 {
  public static void main(String[] args) {
    DateTime dt = new DateTime();
    System.out.println(dt.monthOfYear().getAsText());
    System.out.println(dt.monthOfYear().get());
    System.out.println(dt.monthOfYear().getAsShortText());
  }
}
