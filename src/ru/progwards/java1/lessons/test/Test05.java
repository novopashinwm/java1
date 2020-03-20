package ru.progwards.java1.lessons.test;

import ru.progwards.java1.lessons.queues.Calculate;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Test05 {
    public static void main(String[] args) {

        ZoneId zid1 = ZoneId.of("Europe/Moscow");
        System.out.println(zid1.getRules().getOffset(Instant.now()));

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("EEEE dd MMMMM yyyy");
        System.out.println(format.format(date));
        //"dd.MM.yyyy HH:mm:ss.S"
        //"'От''езд' - EEEE dd MMMM 'в' ha"
        //"yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS'Z'"

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("'От''езд -' EEEE dd MMMM 'в' ha");
        OffsetDateTime odt = Instant.now().atOffset(ZoneOffset.UTC);
        System.out.println(dtf.format(odt));
        /*DateTimeFormatter dtf1= DateTimeFormatter.ofPattern("YYYY-MM-dd'T'HH:mm:ss.SSS'Z'").withZone(ZoneOffset.UTC);
        System.out.println(Instant.now().toString());
        System.out.println(dtf1.format(Instant.from(dtf1.parse(Instant.now().toString()))));*/
        Test05 t = new Test05();
        System.out.println(t.parseZDT("01.01.2020 16:27:14.444 +0300 Moscow Standard Time"));
        System.out.println(t.createInstant());
        LocalDateTime ldt1= LocalDateTime.now();
        LocalDateTime ldt2= ldt1.plusDays(4);
        Duration duration = Duration.between(ldt1,ldt2);
        System.out.println(duration.toHours());
    }

    ZonedDateTime parseZDT(String str) {
        Locale l = Locale.forLanguageTag("EN");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD.MM.yyyy HH:mm:ss.SSS Z zzzz", l);
        return ZonedDateTime.parse(str, dtf.withZone(ZoneId.of("Europe/Moscow")));
    }

    Date createDate() {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(0);
        c.set(1986,1,28,0,0,0);

        return  c.getTime();
    }

    Instant createInstant() {
        return Instant.parse("2020-01-01T12:00:00.000000001Z");
    }
}
