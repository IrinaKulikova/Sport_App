package application.api;

import application.entity.Schedule;
import application.service.implementations.ScheduleServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/schedules")
public class ScheduleAdminController {
    @Autowired
    ScheduleServise scheduleServise;
    public String getSchedules(Model model){
        List<Schedule> scheduleList=scheduleServise.getAll();
        return "hallo";
    }
}
