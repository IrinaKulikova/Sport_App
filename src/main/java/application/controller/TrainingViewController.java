package application.controller;

import application.entity.Day;
import application.entity.Filiation;
import application.entity.Training;
import application.entity.TrainingType;
import application.service.implementations.DayService;
import application.service.implementations.FiliationService;
import application.service.implementations.TrainingService;
import application.service.implementations.TrainingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/trainings")
public class TrainingViewController {

    @Autowired
    FiliationService filiationService;

    @GetMapping("/{id}")
    public String getSchedule(@PathVariable int id, Model model) {
        List<Training> schedule = new ArrayList<>();
        try {
            Filiation filiation = filiationService.getById(id);
            schedule = filiation.getTrainings();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("schedule", schedule);
        return "trainings/trainings";
    }
}