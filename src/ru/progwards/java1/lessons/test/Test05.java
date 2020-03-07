package ru.progwards.java1.lessons.test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Locale;

public class Test05 {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("EEEE dd MMMMM yyyy");
        System.out.println(format.format(date));
        //"dd.MM.yyyy HH:mm:ss.S"
        //"'От''езд' - EEEE dd MMMM 'в' ha"
        //"yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS'Z'"

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("'От''езд -' EEEE dd MMMM 'в' hha");
        OffsetDateTime odt = Instant.now().atOffset(ZoneOffset.UTC);
        System.out.println(dtf.format(odt));
        /*DateTimeFormatter dtf1= DateTimeFormatter.ofPattern("YYYY-MM-dd'T'HH:mm:ss.SSS'Z'").withZone(ZoneOffset.UTC);
        System.out.println(Instant.now().toString());
        System.out.println(dtf1.format(Instant.from(dtf1.parse(Instant.now().toString()))));*/
        Test05 t = new Test05();
        System.out.println(t.parseZDT("01.01.2020 16:27:14.444 +0300 Moscow Standard Time"));
    }

    ZonedDateTime parseZDT(String str) {
        Locale l = Locale.forLanguageTag("EN");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD.MM.yyyy HH:mm:ss.SSS Z zzzz", l);
        return ZonedDateTime.parse(str, dtf.withZone(ZoneId.of("Europe/Moscow")));
    }
}
