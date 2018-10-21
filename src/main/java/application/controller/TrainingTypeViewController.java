package application.controller;

import application.service.implementations.TrainingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trainingtypes")
public class TrainingTypeViewController {

    @Autowired
    TrainingTypeService trainingTypeService;

    @GetMapping()
    public String getAll(Model model) {
        try {
            model.addAttribute("trainingtypes", trainingTypeService.getAll());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return "trainingtypes/trainingtypes";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable int id, Model model) {
        try {
            model.addAttribute("trainingtype", trainingTypeService.getById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "trainingtypes/trainingtype_edit";
    }


    @GetMapping("/create")
    public String edit(Model model) {
        return "trainingtypes/trainingtype_create";
    }
}