package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/schadules")
public class ScheduleController {
    @RequestMapping(method = RequestMethod.GET)
    public String getSchedule(Model model){
        return "hello";
    }
}
