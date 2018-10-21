package application.api.shared;


import application.entity.Filiation;
import application.entity.News;
import application.entity.Training;
import application.entity.TrainingType;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.FiliationService;
import application.service.implementations.NewsService;
import application.service.implementations.TrainingService;
import application.service.implementations.TrainingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api/1.0/shared", produces = "application/json")
public class SharedApiController {

    @Autowired
    FiliationService filiationService;
    @Autowired
    NewsService newsService;
    @Autowired
    TrainingTypeService typeTrainingService;
    @Autowired
    TrainingService trainingService;

    @GetMapping("/{id}/schedule")
    public JSONResult<List<Training>> getAllTrainings(@PathVariable int id) {
        List<Training> schedule = new ArrayList<>();
        try {
            Filiation filiation = filiationService.getById(id);
            schedule = filiation.getTrainings();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(schedule, ex.getMessage());
        }
        return new JSONResultOk<>(schedule);
    }

    @GetMapping("/typetrainings")
    public JSONResult<List<TrainingType>> getAllScheduleEvents() {
        List<TrainingType> events = new ArrayList<>();
        try {
            events = typeTrainingService.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(events, ex.getMessage());
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
            return new JSONResultError<>(filiation, ex.getMessage());
        }
        return new JSONResultOk<>(filiation);
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
        return new JSONResultOk<>(news);
    }
}