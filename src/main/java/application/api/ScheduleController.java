package application.api;

import application.entity.Schedule;
import application.entity.ScheduleEvent;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/1.0/schedules")
public class ScheduleController {

    @Autowired
    ScheduleServise scheduleServise;
    @Autowired
    SchedulesEventServise eventServise;
    // получить список расписание
    @GetMapping()
    public JSONResult<List<Schedule>> getSchedule(){
        List<Schedule> schedules = new ArrayList<>();
        try {
            schedules = scheduleServise.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(schedules, ex.getMessage());
        }
        return new JSONResultOk<>(schedules);
    }
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
