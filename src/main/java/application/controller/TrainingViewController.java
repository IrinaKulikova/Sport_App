package application.controller;

import application.entity.Day;
import application.entity.Filiation;
import application.entity.Time;
import application.entity.Training;
import application.service.implementations.DayService;
import application.service.implementations.FiliationService;
import application.service.implementations.TimeService;
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

    @Autowired
    public TrainingViewController(FiliationService filiationService, DayService dayService, TimeService timeService) {
        this.filiationService = filiationService;
        this.dayService = dayService;
        this.timeService = timeService;
    }

    @GetMapping("/{id}")
    public String getSchedule(@PathVariable int id, Model model) {
        Filiation filiation = new Filiation();
        List<Training> trainings = new ArrayList<>();
        List<Day> days = new ArrayList<>();
        List<Time> times = new ArrayList<>();
        try {
            filiation = filiationService.getById(id);
            trainings = filiation.getTrainings();
            days = dayService.getAll();
            times = timeService.getAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        model.addAttribute("trainings", trainings);
        model.addAttribute("filiation", filiation);
        model.addAttribute("days", days);
        model.addAttribute("times", times);
        return "trainings/trainings";
    }
}