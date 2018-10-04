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
    ScheduleService scheduleService;

    @Autowired
    SchedulesEventService eventService;

    @GetMapping()
    public JSONResult<List<Schedule>> getSchedule(){
        List<Schedule> schedules = new ArrayList<>();
        try {
            schedules = scheduleService.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(schedules, ex.getMessage());
        }
        return new JSONResultOk<>(schedules);
    }

    @PostMapping()
    public void addSchedule(Schedule schedule){
        scheduleService.save(schedule);
    }

    @GetMapping("/schedules_event")
    public List<ScheduleEvent> getSchedulesEvent(){
       return eventService.getAll();
    }

    @PostMapping("/schedules_event")
    public void saveSchedulesEventService(ScheduleEvent event){
        eventService.save(event);
    }


}
