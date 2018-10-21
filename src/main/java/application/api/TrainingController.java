package application.api;

import application.entity.Filiation;
import application.entity.Training;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.DayService;
import application.service.implementations.FiliationService;
import application.service.implementations.TrainingService;
import application.service.implementations.TrainingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/1.0/trainings")
public class TrainingController {

    @Autowired
    TrainingService trainingService;

    @Autowired
    TrainingTypeService trainingTypeService;

    @Autowired
    DayService dayService;

    @Autowired
    FiliationService filiationService;

    @GetMapping("/{id_filiation}")
    public JSONResult<List<Training>> getSchedule(@PathVariable int id_filiation) {
        List<Training> trainings = new ArrayList<>();
        try {
            Filiation filiation = filiationService.getById(id_filiation);
            trainings = filiation.getTrainings();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(trainings, ex.getMessage());
        }
        return new JSONResultOk<>(trainings);
    }

    @PutMapping("/{id}/{id_filiation}")
    public JSONResult<Training> putSaveSchedule(@RequestBody Training training, @PathVariable("id") int id,
                                                @PathVariable int id_filiation) {
        return null;
    }

    @DeleteMapping("/{id}")
    public JSONResult<Training> deleteSchedule(@PathVariable("id") int id) {
        Training training = new Training();
        try {
            training = trainingService.getById(id);
            trainingService.delete(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(training, ex.getMessage());
        }
        return new JSONResultOk<>(training);
    }
}
