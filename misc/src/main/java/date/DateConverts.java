package date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateConverts {
  public static LocalDate dateToLocalDate(Date date, ZoneId zoneId) {

    return date.toInstant()
            .atZone(zoneId)
            .toLocalDate();
  }

  public static LocalDate dateToLocalDate(Date date) {
    return dateToLocalDate(date, ZoneId.systemDefault());
  }

  public static LocalDateTime dateToLocalDateTime(Date date, ZoneId zoneId) {
    return date.toInstant()
            .atZone(zoneId)
            .toLocalDateTime();
  }

  public static LocalDateTime dateToLocalDateTime(Date date) {
    return dateToLocalDateTime(date, ZoneId.systemDefault());
  }

  public static Date localDateToDate(LocalDate localDate, ZoneId zoneId) {
    return Date.from(localDate.atStartOfDay().atZone(zoneId).toInstant());
  }

  public static Date localDateToDate(LocalDate localDate) {
    return localDateToDate(localDate, ZoneId.systemDefault());
  }

}
