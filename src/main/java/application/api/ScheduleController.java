package application.api;

import application.entity.Schedule;
import application.entity.ScheduleEvent;
import application.service.implementations.ScheduleServise;
import application.service.implementations.SchedulesEventServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schedules")
public class ScheduleController {

    @Autowired
    ScheduleServise scheduleServise;
    @Autowired
    SchedulesEventServise eventServise;
   // получить список расписание
    @GetMapping()
    public  List<Schedule> getSchedule(){
        return scheduleServise.getAll();
    }
    //сохранить раписание
    @PostMapping()
    public void saveSchedule(Schedule schedule){
        scheduleServise.save(schedule);
    }

    //получить список событий
    @GetMapping("/schedules_event")
    public List<ScheduleEvent> getSchedulesEvent(){
       return eventServise.getAll();
    }
    //сохранить событие
    @PostMapping("/schedules_event")
    public void saveSchedulesEventServise(ScheduleEvent event){
        eventServise.save(event);
    }


}
