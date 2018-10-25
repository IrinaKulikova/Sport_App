package application.controller;

import application.entity.*;
import application.service.implementations.DayService;
import application.service.implementations.FiliationService;
import application.service.implementations.TimeService;
import application.service.implementations.TrainingTypeService;
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
    private final DayService dayService;
    private final TimeService timeService;
    private final TrainingTypeService trainingTypeService;

    @Autowired
    public TrainingViewController(FiliationService filiationService, DayService dayService, TimeService timeService,
                                  TrainingTypeService trainingTypeService) {
        this.filiationService = filiationService;
        this.dayService = dayService;
        this.timeService = timeService;
        this.trainingTypeService = trainingTypeService;
    }

    @GetMapping("/{id}")
    public String getSchedule(@PathVariable int id, Model model) {
        Filiation filiation = new Filiation();
        List<Training> trainings = new ArrayList<>();
        List<Day> days = new ArrayList<>();
        List<Time> times = new ArrayList<>();
        List<TrainingType> trainingtypes = new ArrayList<>();
        try {
            filiation = filiationService.getById(id);
            trainings = filiation.getTrainings();
            days = dayService.getAll();
            times = timeService.getAll();
            trainingtypes = trainingTypeService.getAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        model.addAttribute("trainings", trainings);
        model.addAttribute("trainingtypes", trainingtypes);
        model.addAttribute("filiation", filiation);
        model.addAttribute("days", days);
        model.addAttribute("times", times);
        return "trainings/trainings";
    }
}