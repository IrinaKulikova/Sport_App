package application.api;

import application.entity.Filiation;
import application.entity.Training;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.FiliationService;
import application.service.implementations.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/1.0/trainings")
public class TrainingController {

    private final TrainingService trainingService;
    private final FiliationService filiationService;

    @Autowired
    public TrainingController(TrainingService trainingService, FiliationService filiationService) {
        this.trainingService = trainingService;
        this.filiationService = filiationService;
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

    @PutMapping("/{id}/{id_filiation}")
    public JSONResult<Training> update(@RequestBody Training training, @PathVariable("id") int id,
                                                @PathVariable int id_filiation) {
        return null;
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
