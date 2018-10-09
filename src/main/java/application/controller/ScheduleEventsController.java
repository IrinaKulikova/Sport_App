package application.controller;

import application.service.implementations.SchedulesEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
public class ScheduleEventsController {

    @Autowired
    SchedulesEventService schedulesEventService;

    @GetMapping()
    public String index(Model model) {
        try {
            model.addAttribute("events", schedulesEventService.getAll());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return "events/events";
    }

    @GetMapping("/edit/{id}")
    public String userEdit(@PathVariable int id, Model model){
        try {
            model.addAttribute("event",schedulesEventService.getById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "users/user_edit";
    }

    @GetMapping("/create")
    public String userCreate(){
        return "events/event_create";
    }
}
