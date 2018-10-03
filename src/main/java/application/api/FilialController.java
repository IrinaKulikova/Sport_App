package application.api;

import application.entity.Filial;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/1.0/filials", produces = "application/json")
public class FilialController {

    @Autowired
    private FilialService filialService;

    @GetMapping("/{id}")
    public JSONResult<Filial> getFilialById(@PathVariable int id) {
        Filial filial = new Filial();
        try {
            filial = filialService.getById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<Filial>(filial, ex.getMessage());
        }
        return new JSONResultOk<Filial>(filial);
    }

    @GetMapping
    public JSONResult<List<Filial>> getAll() {
        List<Filial> filials = new ArrayList<>();
        try {
            filials = filialService.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<List<Filial>>(filials, ex.getMessage());
        }
        return new JSONResultOk<List<Filial>>(filials);
    }

    @DeleteMapping("/{id}")
    public JSONResult<Filial> deleteFilial(@PathVariable int id) {
        Filial filial = new Filial();
        try {
            filial = filialService.getById(id);
            filialService.delete(filial);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<Filial>(filial, ex.getMessage());
        }
        return new JSONResultOk<Filial>(filial);
    }

    @PutMapping("/{id}")
    public JSONResult<Filial> updateInfo(@RequestBody Filial filial, @PathVariable int id) {
        Filial currentFilial = new Filial();
        try {
            currentFilial = filialService.getById(id);
            currentFilial.setCaption(filial.getCaption());
            currentFilial.setCountry(filial.getCountry());
            currentFilial.setCity(filial.getCity());
            currentFilial.setStreet(filial.getStreet());
            currentFilial.setBuilding(filial.getBuilding());
            currentFilial.setIndexCity(filial.getIndexCity());
            filialService.save(currentFilial);
        } catch (Exception ex) {
            return new JSONResultError<>(filial, ex.getMessage());
        }
        return new JSONResultOk<>(currentFilial);
    }
}