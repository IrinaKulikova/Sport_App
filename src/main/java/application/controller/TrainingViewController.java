package application.controller;

import application.entity.Filiation;
import application.entity.Training;
import application.service.implementations.FiliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;

@Controller
@RequestMapping("/trainings")
public class TrainingViewController {

    private final FiliationService filiationService;

    @Autowired
    public TrainingViewController(FiliationService filiationService) {
        this.filiationService = filiationService;
    }

    @GetMapping("/{id}")
    public String getSchedule(@PathVariable int id, Model model) {
        List<Training> trainings = new ArrayList<>();
        try {
            Filiation filiation = filiationService.getById(id);
            trainings = filiation.getTrainings();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        model.addAttribute("trainings", trainings);
        return "trainings/trainings";
    }
}