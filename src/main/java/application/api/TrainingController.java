package application.api;

import application.dto.TrainingDTO;
import application.entity.Filiation;
import application.entity.Training;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/1.0/trainings")
public class TrainingController {

    private final TrainingService trainingService;
    private final TrainingTypeService trainingTypeService;
    private final FiliationService filiationService;
    private final DayService dayService;
    private final TimeService timeService;

    @Autowired
    public TrainingController(TrainingService trainingService,
                              TrainingTypeService trainingTypeService,
                              FiliationService filiationService,
                              DayService dayService,
                              TimeService timeService) {
        this.trainingService = trainingService;
        this.trainingTypeService = trainingTypeService;
        this.filiationService = filiationService;
        this.dayService = dayService;
        this.timeService = timeService;
    }

    @GetMapping("/{id_filiation}")
    public JSONResult<List<Training>> getById(@PathVariable int id_filiation) {
        List<Training> trainings = new ArrayList<>();
        try {
            Filiation filiation = filiationService.getById(id_filiation);
            trainings = filiation.getTrainings();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(trainings, ex.getMessage());
        }
        return new JSONResultOk<>(trainings);
    }

    @PutMapping()
    public JSONResult<Training> update(@RequestBody TrainingDTO trainingDTO) {
        Training training = new Training();
        try {
            Filiation filiation = filiationService.getById(trainingDTO.getFiliationid());
            training.setDay(dayService.getById(trainingDTO.getDayid()));
            training.setTime(timeService.getById(trainingDTO.getTimeid()));
            training.setFiliation(filiation);
            training.setTrainingType(trainingTypeService.getById(trainingDTO.getTrainingtypeid()));
            filiation.getTrainings().add(training);
            trainingService.save(training);
        } catch (SQLException e) {
            e.printStackTrace();
            return new JSONResultError<>(training, e.getMessage());
        }
        return new JSONResultOk<>(training);
    }

    @DeleteMapping("/{id}")
    public JSONResult<Training> delete(@PathVariable("id") int id) {
        Training training = new Training();
        try {
            training = trainingService.getById(id);
            trainingService.delete(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(training, ex.getMessage());
        }
        return new JSONResultOk<>(training);
    }
}
