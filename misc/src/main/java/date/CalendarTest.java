package date;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarTest {
  public static void main(String[] args) {
    Calendar cc = Calendar.getInstance(Locale.CHINA);
    Calendar cu = Calendar.getInstance(Locale.US);
    cc.setTime(new Date());
    cu.setTime(new Date());
  }
}
