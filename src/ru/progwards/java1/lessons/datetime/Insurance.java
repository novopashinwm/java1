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
        switch (style) {

            case SHORT:
                /* получаем локальную дату без времени */
                LocalDate localDate = LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE.parse(strStart));
                /* устанавливаем время всеми нолями */
                LocalTime localTime = LocalTime.of(0, 0, 0);
                /* преобразуем в дату ZonedDateTime, где время будет состоять из нолей */
                start = ZonedDateTime.of(localDate, localTime, ZoneId.systemDefault());
                break;
            case LONG:
                LocalDateTime localDateTime = LocalDateTime.from(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse(strStart));
                start = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
                break;
            case FULL:
                DateTimeFormatter dtFormatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
                start = ZonedDateTime.parse(strStart, dtFormatter);
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
        ZonedDateTime endDate = start.plusMonths(months).plusDays(days).plusHours(hours);
        setDuration(endDate);
    }

    public void setDuration(String strDuration, FormatStyle style) {
        switch (style) {

            case SHORT:

                /* закомментированная строка рабочая, просто в более длинном написание */
//                duration = Duration.of(Long.parseLong(strDuration), ChronoUnit.MILLIS);
                duration = Duration.ofMillis(Long.parseLong(strDuration));
                break;

            case LONG:
                /* получаем дату в формате "0000-01-01T00:00:00", которая означает продолжительность 1 месяц и 1 день.
                 * парсим дату из текстового формата и далее поочередно выдергивая значения - количество лет, месяцев, дней, часов и т.д.
                 * приплюссовываем к стартовой дате */
                ZonedDateTime inputDateTime = ZonedDateTime.parse(strDuration, DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneOffset.UTC));
                ZonedDateTime endDateTime = start.plusYears(inputDateTime.getYear()).
                        plusMonths(inputDateTime.getMonthValue()).
                        plusDays(inputDateTime.getDayOfMonth()).
                        plusHours(inputDateTime.getHour()).
                        plusMinutes(inputDateTime.getMinute()).
                        plusSeconds(inputDateTime.getSecond()).
                        plusNanos(inputDateTime.getNano());
                /* рассчитываем продолжительность между начальной и конечной датами */
                duration = Duration.between(start, endDateTime);
                break;
            case FULL:
                duration = Duration.parse(strDuration);
                break;
        }
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
        String validStr = checkValid(ZonedDateTime.now()) ? " is valid" : " is not valid";
        return "Insurance issued on " + start + validStr;
    }

    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.parse("2020-03-11T09:04:11.399493+03:00[Europe/Moscow]");
        Insurance insurance = new Insurance(zdt);
        System.out.println(insurance);
        zdt = ZonedDateTime.parse("");
    }
}
