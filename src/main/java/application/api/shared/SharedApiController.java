package application.api.shared;


import application.entity.Filiation;
import application.entity.News;
import application.entity.Schedule;
import application.entity.ScheduleEvent;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.FiliationService;
import application.service.implementations.NewsService;
import application.service.implementations.ScheduleService;
import application.service.implementations.SchedulesEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api/1.0/shared/", produces = "application/json")
public class SharedApiController {

    @Autowired
    FiliationService filiationService;
    @Autowired
    NewsService newsService;
    @Autowired
    SchedulesEventService eventService;
    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/schedules")
    public JSONResult<List<Schedule>> getAllSchedule(){
        List<Schedule> schedules = new ArrayList<>();
        try {
            schedules = scheduleService.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(schedules, ex.getMessage());
        }
        return new JSONResultOk<>(schedules);
    }

    @GetMapping("/events")
    public JSONResult<List<ScheduleEvent>> getAllScheduleEvents() {
        List<ScheduleEvent> events = new ArrayList<>();
        try {
            events = eventService.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<List<ScheduleEvent>>(events, ex.getMessage());
        }
        return new JSONResultOk<>(events);
    }


    @GetMapping("/filiations")
    public JSONResult<List<Filiation>> getAllFiliations() {
        List<Filiation> filiation = new ArrayList<>();
        try {
            filiation = filiationService.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<List<Filiation>>(filiation, ex.getMessage());
        }
        return new JSONResultOk<List<Filiation>>(filiation);
    }

    @GetMapping("/news")
    public JSONResult<List<News>> getAllNews() {
        List<News> news = new ArrayList<>();
        try {
            news = newsService.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(news, ex.getMessage());
        }
        return new JSONResultOk<List<News>>(news);
    }



}