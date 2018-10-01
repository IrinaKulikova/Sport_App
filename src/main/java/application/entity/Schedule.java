package application.entity;

import lombok.Data;

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
    @OneToMany(targetEntity = Day.class,fetch = FetchType.EAGER)
    @JoinColumn(name="dayofweek")
    private List<Day> dayList=new ArrayList<>();
    //время начала занятия
    @Column(columnDefinition ="time")
   private Date starttime;
    //вторичный ключ schedule_event
    @OneToMany(targetEntity = ScheduleEvent.class,fetch = FetchType.EAGER)
    @JoinColumn(name="event_schedule")
    private  List<ScheduleEvent> eventsList=new ArrayList<>();

}
