package application.api;

import application.entity.TrainingType;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.TrainingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/1.0/trainingtypes")
public class TrainingTypeController {

    @Autowired
    TrainingTypeService trainingTypeService;

    @PostMapping()
    public JSONResult<TrainingType> add(@RequestBody TrainingType trainingType) {
        TrainingType newTrainingType = new TrainingType();
        try {
            newTrainingType.setName(trainingType.getName());
            newTrainingType.setDescription(trainingType.getDescription());
            newTrainingType = trainingTypeService.save(newTrainingType);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(newTrainingType, ex.getMessage());
        }
        return new JSONResultOk<>(newTrainingType);
    }

    @PutMapping("/{id}")
    public JSONResult<TrainingType> update(@RequestBody TrainingType trainingType, @PathVariable int id) {
        TrainingType newTrainingType = new TrainingType();
        try {
            newTrainingType = trainingTypeService.getById(id);
            newTrainingType.setName(trainingType.getName());
            newTrainingType.setDescription(trainingType.getDescription());
            newTrainingType = trainingTypeService.save(newTrainingType);
            newTrainingType.setTrainings(new ArrayList<>());
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(newTrainingType, ex.getMessage());
        }
        return new JSONResultOk<>(newTrainingType);
    }

    @DeleteMapping("/{id}")
    public JSONResult<TrainingType> delete(@PathVariable int id) {
        TrainingType trainingType = new TrainingType();
        try {
            trainingType = trainingTypeService.getById(id);
            trainingTypeService.delete(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(trainingType, ex.getMessage());
        }
        return new JSONResultOk<>(new TrainingType());
    }
}