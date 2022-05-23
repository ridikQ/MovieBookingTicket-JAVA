package model;

import java.sql.Time;
import java.sql.Date;

public class TimeTable {
    private Date date;
    private Integer movie_id;
    private Time startTime;
    private Time endTime;

    public TimeTable(){

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "TimeTable{" +
                "date=" + date +
                ", movie_id=" + movie_id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
