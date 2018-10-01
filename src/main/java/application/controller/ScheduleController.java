package application.controller;

import application.entity.Schedule;
import application.service.implementations.ScheduleServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    ScheduleServise scheduleServise;
   // получить расписание
    @GetMapping("/getall")
    public String getSchedule(Model model){
        List<Schedule> scheduleList=scheduleServise.getAll();
        return "hello";
    }
}
