package application.api;

import application.entity.Schedule;
import application.entity.ScheduleEvent;
import application.service.implementations.ScheduleServise;
import application.service.implementations.SchedulesEventServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/schedules")
public class ScheduleAdminController {
    @Autowired
    ScheduleServise scheduleServise;
    @Autowired
    SchedulesEventServise schedulesEventServise;
    public String getSchedules(Model model){
        List<Schedule> scheduleList=scheduleServise.getAll();
        return "hallo";
    }
    @GetMapping("/save_schedulele_event")
    public String getSaveScheduleEvent(){
        return "save_schedule_event";
    }
    @PostMapping("/save_schedulele_event")
    public String postSaveScheduleEvent(ScheduleEvent event){
        schedulesEventServise.save(event);
        return "redirect:/";
    }
}
