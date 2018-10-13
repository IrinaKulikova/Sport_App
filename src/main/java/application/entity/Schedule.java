package application.entity;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Entity
@Data
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

    @ManyToOne(targetEntity = Day.class,fetch = FetchType.EAGER)
    @JoinColumn(name="dayid")
    Day day;

    @Column(columnDefinition ="time")
    private Time starttime;

    @ManyToOne(targetEntity = ScheduleEvent.class, fetch = FetchType.EAGER)
    @JoinColumn(name="event_schedule")
    ScheduleEvent scheduleEvent;

    public Schedule(Day day, Time starttime, ScheduleEvent scheduleEvent) {
        this.day = day;
        this.starttime = starttime;
        this.scheduleEvent = scheduleEvent;
    }

    public Schedule() {
    }
    public ScheduleEvent getScheduleEvent() {
        return scheduleEvent;
    }

    public Day getDay() {
        return day;
    }

    public Time getStarttime() {
        return starttime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public void setStarttime(Time starttime) {
        this.starttime = starttime;
    }

    public void setScheduleEvent(ScheduleEvent scheduleEvent) {
        this.scheduleEvent = scheduleEvent;
    }

}
