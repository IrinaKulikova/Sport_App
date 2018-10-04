package application.api;

import application.entity.Filiation;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.FiliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/1.0/filiations", produces = "application/json")
public class FiliationController {

    @Autowired
    private FiliationService filiationService;

    @GetMapping("/{id}")
    public JSONResult<Filiation> getFiliationById(@PathVariable int id) {
        Filiation filiation = new Filiation();
        try {
            filiation = filiationService.getById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<Filiation>(filiation, ex.getMessage());
        }
        return new JSONResultOk<Filiation>(filiation);
    }

    @GetMapping
    public JSONResult<List<Filiation>> getAll() {
        List<Filiation> filiation = new ArrayList<>();
        try {
            filiation = filiationService.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<List<Filiation>>(filiation, ex.getMessage());
        }
        return new JSONResultOk<List<Filiation>>(filiation);
    }

    @DeleteMapping("/{id}")
    public JSONResult<Filiation> deleteFilial(@PathVariable int id) {
        Filiation filiation = new Filiation();
        try {
            filiation = filiationService.getById(id);
            filiationService.delete(filiation);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<Filiation>(filiation, ex.getMessage());
        }
        return new JSONResultOk<Filiation>(filiation);
    }

    @PutMapping("/{id}")
    public JSONResult<Filiation> updateInfo(@RequestBody Filiation filiation, @PathVariable int id) {
        Filiation currentFiliation = new Filiation();
        try {
            currentFiliation = filiationService.getById(id);
            currentFiliation.setCaption(filiation.getCaption());
            currentFiliation.setCountry(filiation.getCountry());
            currentFiliation.setCity(filiation.getCity());
            currentFiliation.setStreet(filiation.getStreet());
            currentFiliation.setBuilding(filiation.getBuilding());
            currentFiliation.setIndexCity(filiation.getIndexCity());
            filiationService.save(currentFiliation);
        } catch (Exception ex) {
            return new JSONResultError<>(filiation, ex.getMessage());
        }
        return new JSONResultOk<>(currentFiliation);
    }
}