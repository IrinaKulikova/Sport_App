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
    private FilialService service;

    @GetMapping("/{id}")
    public JSONResult<Filial> getFilialById(@PathVariable int id) {
        Filial filial = new Filial();
        try {
            filial = service.getById(id);
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
            filials = service.getAll();
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
            filial = service.getById(id);
            service.delete(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<Filial>(filial, ex.getMessage());
        }
        return new JSONResultOk<Filial>(filial);
    }

    public JSONResult<Filial> updateAddress(@PathVariable int id){
        return new JSONResultError<>(service.getById(id),"error");
    }
}