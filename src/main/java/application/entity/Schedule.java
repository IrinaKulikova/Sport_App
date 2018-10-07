package application.entity;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Entity
@Data
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
    //день недели
 //   @OneToMany(targetEntity = Day.class,fetch = FetchType.LAZY)
    @ManyToOne(targetEntity = Day.class,fetch = FetchType.EAGER)
    @JoinColumn(name="dayid")
    Day day;
 //   private List<Day> dayList=new ArrayList<>();
    //время начала занятия
    @Column(columnDefinition ="time")
   private Date starttime;
    //вторичный ключ schedule_event
    //@OneToMany(targetEntity = ScheduleEvent.class,fetch = FetchType.EAGER)
    @ManyToOne(targetEntity = ScheduleEvent.class,fetch = FetchType.EAGER)
    @JoinColumn(name="event_schedule")
    ScheduleEvent scheduleEvent;
  //  private  List<ScheduleEvent> eventsList=new ArrayList<>();

    public Schedule(Day day, Date starttime, ScheduleEvent scheduleEvent) {
        this.day = day;
        this.starttime = starttime;
        this.scheduleEvent = scheduleEvent;
    }

    public Schedule() {
    }
}
