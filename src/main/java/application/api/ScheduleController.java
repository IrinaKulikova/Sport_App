package application.api;

import application.entity.Schedule;
import application.entity.ScheduleEvent;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.ScheduleService;
import application.service.implementations.SchedulesEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/1.0/schedules")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleServise;
    @Autowired
    SchedulesEventService schedulesEventService;
    // получить список расписание

    //сохранить раписание
 //   @PostMapping()
   // public void saveSchedule(Schedule schedule){
     //   scheduleServise.save(schedule);
    //}

    //получить список событий
/*    @GetMapping("/schedules_event")
    public List<ScheduleEvent> getSchedulesEvent(){
       return eventServise.getAll();
    }
    //сохранить событие
    @PostMapping("/schedules_event")
    public void saveSchedulesEventServise(ScheduleEvent event){
        eventServise.save(event);
    }*/


}
