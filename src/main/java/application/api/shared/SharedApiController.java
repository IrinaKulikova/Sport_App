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
import application.service.implementations.TrainingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api/1.0/shared", produces = "application/json")
public class SharedApiController {

    private final FiliationService filiationService;
    private final NewsService newsService;
    private final TrainingTypeService typeTrainingService;

    @Autowired
    public SharedApiController(FiliationService filiationService, NewsService newsService,
                               TrainingTypeService typeTrainingService) {
        this.filiationService = filiationService;
        this.newsService = newsService;
        this.typeTrainingService = typeTrainingService;
    }

    @GetMapping("/{id}/trainings")
    public JSONResult<List<Training>> getAllTrainings(@PathVariable int id) {
        List<Training> trainings = new ArrayList<>();
        try {
            Filiation filiation = filiationService.getById(id);
            trainings = filiation.getTrainings();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(trainings, ex.getMessage());
        }
        return new JSONResultOk<>(trainings);
    }

    @GetMapping("/trainingtypes")
    public JSONResult<List<TrainingType>> getAllTrainingTypes() {
        List<TrainingType> trainingTypes = new ArrayList<>();
        try {
            trainingTypes = typeTrainingService.getAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(trainingTypes, ex.getMessage());
        }
        return new JSONResultOk<>(trainingTypes);
    }


    @GetMapping("/filiations")
    public JSONResult<List<Filiation>> getAllFiliations() {
        List<Filiation> filiation = new ArrayList<>();
        try {
            filiation = filiationService.getAll();
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(news, ex.getMessage());
        }
        return new JSONResultOk<>(news);
    }
}