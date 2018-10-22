package application.api;

import application.entity.Filiation;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.FiliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


@RestController
@RequestMapping(value = "/api/1.0/filiations", produces = "application/json")
public class FiliationController {

    @Autowired
    private FiliationService filiationService;

    @GetMapping("/{id}")
    public JSONResult<Filiation> getById(@PathVariable int id) {
        Filiation filiation = new Filiation();
        try {
            filiation = filiationService.getById(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(filiation, ex.getMessage());
        }
        return new JSONResultOk<>(filiation);
    }

    @DeleteMapping("/{id}")
    public JSONResult<Filiation> delete(@PathVariable int id) {
        Filiation filiation = new Filiation();
        try {
            filiation = filiationService.getById(id);
            filiationService.delete(filiation);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(filiation, ex.getMessage());
        }
        return new JSONResultOk<>(filiation);
    }

    @PutMapping("/{id}")
    public JSONResult<Filiation> update(@RequestBody Filiation filiation, @PathVariable int id) {
        Filiation currentFiliation = null;
        try {
            currentFiliation = filiationService.getById(id);
            if (currentFiliation == null) {
                currentFiliation = new Filiation();
            }
            currentFiliation.setCaption(filiation.getCaption());
            currentFiliation.setCountry(filiation.getCountry());
            currentFiliation.setCity(filiation.getCity());
            currentFiliation.setStreet(filiation.getStreet());
            currentFiliation.setBuilding(filiation.getBuilding());
            currentFiliation.setIndexCity(filiation.getIndexCity());
            filiationService.save(currentFiliation);
        } catch (SQLException ex) {
            return new JSONResultError<>(filiation, ex.getMessage());
        }
        return new JSONResultOk<>(currentFiliation);
    }

    @PostMapping()
    public JSONResult<Filiation> add(@RequestBody Filiation filiation) {
        Filiation currentFiliation =  new Filiation();
        try {
            currentFiliation.setCaption(filiation.getCaption());
            currentFiliation.setCountry(filiation.getCountry());
            currentFiliation.setCity(filiation.getCity());
            currentFiliation.setStreet(filiation.getStreet());
            currentFiliation.setBuilding(filiation.getBuilding());
            currentFiliation.setIndexCity(filiation.getIndexCity());
            filiationService.save(currentFiliation);
        } catch (SQLException ex) {
            return new JSONResultError<>(filiation, ex.getMessage());
        }
        return new JSONResultOk<>(currentFiliation);
    }
}