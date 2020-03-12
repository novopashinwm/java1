package ru.progwards.java1.lessons.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Insurance {
    public static enum FormatStyle {SHORT, LONG, FULL}
    private ZonedDateTime start;
    private Duration duration;
    private FormatStyle style;
    private ZonedDateTime end;

    public Insurance(ZonedDateTime start) {
        this.start = start;
    }

    public Insurance(String strStart, FormatStyle style) {
        switch (style){
            case SHORT:
                start = ZonedDateTime.of(LocalDate.parse(strStart, DateTimeFormatter.ISO_LOCAL_DATE), LocalTime.MIDNIGHT, ZoneId.systemDefault());
                break;
            case LONG:
                start = ZonedDateTime.parse(strStart, DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.systemDefault()));
                break;
            case FULL:
                start = ZonedDateTime.parse(strStart, DateTimeFormatter.ISO_ZONED_DATE_TIME);
                break;
        }
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setDuration(ZonedDateTime expiration) {
        this.duration = Duration.between(start,expiration);
    }

    public void setDuration(int months, int days, int hours) {

    }

    public void setDuration(String strDuration, FormatStyle style) {

    }

    public boolean checkValid(ZonedDateTime dateTime) {
        /* преобразуем дату-время в миллисекунды */
        long longStart = start.toEpochSecond();
        long longDateTime = dateTime.toEpochSecond();

        /* если проверочная дата меньше даты начала, то есть, до того как страховка начала действовать, возвращаем ложь */
        if (longDateTime < longStart){
            return false;
            /* если продолжительность ровна нулю, значит страховка бессрочная и возвращаем истину */
        } else if (duration == null){
            return true;
            /* если проверочная дата меньше даты окончания страховки, возвращается истина, если больше, то возвращается ложь */
        } else
            return longDateTime <= (start.plus(duration)).toEpochSecond();
    }

    @Override
    public String toString() {
        String add = " is valid";
        if (checkValid(start)) {
            add = " is not valid";
        }
        return "Insurance issued on " + start +  add;
    }

    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.parse("2020-03-11T09:04:11.399493+03:00[Europe/Moscow]");
        Insurance insurance = new Insurance(zdt);
        System.out.println(insurance);
        zdt = ZonedDateTime.parse("");
    }
}
