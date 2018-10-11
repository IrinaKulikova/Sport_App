package application.api;

import application.entity.Day;
import application.entity.Schedule;
import application.entity.ScheduleEvent;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.DayServise;
import application.service.implementations.ScheduleService;
import application.service.implementations.SchedulesEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/api/1.0/schedules")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleServise;
    @Autowired
    SchedulesEventService schedulesEventService;
    @Autowired
    DayServise dayServise;
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
    @PutMapping("/scheduleedit/{id}")
     public JSONResult<Schedule> putSaveSchdule(@RequestParam String starttime, @RequestParam int sheduleevent, @RequestParam int day,@PathVariable("id") int id){
        System.out.println(starttime);
        System.out.println(sheduleevent);
        System.out.println(day);
        System.out.println(id);
        Day newDay = null;
        Schedule currentShedule=null;
        try {
            newDay = dayServise.getById(day);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResultError<>(currentShedule,"day not read!");
        }
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        localDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+2"));
        Date date = null;
        try {
            date = localDateFormat.parse(starttime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        java.sql.Time sd = new java.sql.Time(date.getTime());
        ScheduleEvent scheduleEvent = schedulesEventService.getById(sheduleevent);
        Schedule schedule=new Schedule(newDay,sd,scheduleEvent);
        schedule.setId(id);

        try {
            scheduleServise.getById(id);;
            if(currentShedule==null){
                return new JSONResultError<>(currentShedule,"schedule not find!");
            }
            currentShedule.setDay(schedule.getDay());
            currentShedule.setScheduleEvent(schedule.getScheduleEvent());
            currentShedule.setStarttime(schedule.getStarttime());
            scheduleServise.save(currentShedule);
        }catch (Exception ex){
             ex.printStackTrace();
             return new JSONResultError<>(currentShedule,ex.getMessage());
        }
         return new JSONResultOk<>(currentShedule);
     }
}
