package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.ZonedDateTime;

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
        //this.start = ZonedDateTime.parse(strStart);
        this.style = style;
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
        end = start.plus(duration);
        return dateTime.isAfter(start) && dateTime.isBefore(end);
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
