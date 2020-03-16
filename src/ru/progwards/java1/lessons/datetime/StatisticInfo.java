package ru.progwards.java1.lessons.datetime;

public class StatisticInfo {
    public String sectionName;
    public int fullTime;
    public int selfTime;
    public int count;
    private long startTime;
    private long endTime;

    public StatisticInfo(String sectionName) {
        this.sectionName = sectionName;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
