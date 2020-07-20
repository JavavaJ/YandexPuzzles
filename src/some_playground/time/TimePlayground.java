package some_playground.time;

import javax.lang.model.element.AnnotationValueVisitor;
import java.nio.file.FileVisitor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Calendar;

public class TimePlayground {

    public static void main(String[] args) {

        LocalDateTime dateTime = LocalDateTime.
            of(2017,05,17,5,25);
        LocalDateTime dateTime2 = dateTime.plusDays(5); //add 5 days

        dateTime2 = dateTime.minusMinutes(10);
        dateTime2 = dateTime.withYear(2019);//year set to 2019
        dateTime2 = dateTime.withHour(8);// hour set to 8

        int dayOfYear = dateTime.getDayOfYear(); // 137
        int minute = dateTime.getMinute(); // 25
        Month month = dateTime.getMonth(); // MAY
        LocalDate localDate = dateTime.toLocalDate(); // 2017-05-17

        LocalTime now = LocalTime.now(); // 17:11:53.883
        LocalTime parsedTime = LocalTime.parse("12:30");
        LocalTime time = LocalTime.of(6, 30);

        LocalTime plus2hours = time.plusHours(2);
        LocalTime minus10Minutes = time.minusMinutes(10);
        LocalTime timeWith8hours = time.withHour(8); // hour set to 8

        int hour = time.getHour(); // 6

        LocalTime almostMidDay = LocalTime.of(11, 59);
        boolean isAfter = almostMidDay.isAfter(time); // true

        LocalTime alsoMidDay = LocalTime.of(11, 59);
        boolean equals = almostMidDay.equals(alsoMidDay); // true

    }

}
