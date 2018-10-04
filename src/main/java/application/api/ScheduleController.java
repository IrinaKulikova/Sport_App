package application.api;

import application.entity.Schedule;
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
    ScheduleService scheduleService;

    @GetMapping()
    public JSONResult<List<Schedule>> getSchedule() {
        List<Schedule> schedules = new ArrayList<>();
        try {
            schedules = scheduleService.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(schedules, ex.getMessage());
        }
        return new JSONResultOk<>(schedules);
    }
}
