package time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Demo1 {
  public static void main(String[] args) {
    System.out.println(DayOfWeek.MONDAY.plus(10));
    System.out.println(Month.FEBRUARY.plus(1234));
    System.out.println(LocalDate.now());
    System.out.println(LocalDate.now(ZoneId.of("America/New_York")));

    LocalDate today = LocalDate.now();
    TemporalAdjuster adj = TemporalAdjusters.next(DayOfWeek.FRIDAY);
    LocalDate nextFri = today.with(adj);
    System.out.println("today: " + today);
    System.out.println("next friday: " + nextFri);

    System.out.printf("now in shanghai: %s%n", LocalDateTime.now());
    System.out.printf("now in new_york: %s%n", LocalDateTime.now(ZoneId.of("America/New_York")));

    LocalDateTime shdt = LocalDateTime.now();
    ZoneId zny = ZoneId.of("America/New_York");

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");
    LocalDateTime leaving = LocalDateTime.of(2013, Month.JULY, 20,19,30);
    ZonedDateTime departure = leaving.atZone(ZoneId.of("America/Los_Angeles"));
    System.out.println("LA.  Leaving: " + dtf.format(departure));
    ZonedDateTime arrival = departure.withZoneSameInstant(ZoneId.of("Asia/Tokyo")).plusMinutes(650);
    System.out.println("Tokyo.  Arriving: " + dtf.format(arrival));

  }
}
