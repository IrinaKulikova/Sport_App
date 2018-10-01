package application.api;

import application.entity.Filial;
import application.result.JSONResult;
import application.service.implementations.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/1.0/filials")
public class FilialController {

    @Autowired
    private FilialService service;

    @GetMapping("/{id}")
    public JSONResult<Filial> getFilialById(@PathVariable int id) {
        JSONResult<Filial> result = new JSONResult<>();
        Filial filial = new Filial();
        try {
            filial = service.getById(id);
        } catch (Exception ex) {
            result.setStatus(ex.getMessage());
            result.setMessage("Error, entity not find!");
            ex.printStackTrace();
        }
        result.setData(filial);
        return result;
    }

    @GetMapping
    public JSONResult<List<Filial>> getAll() {
        List<Filial> filials = new ArrayList<>();
        JSONResult<List<Filial>> result = new JSONResult<>();
        try {
            filials = service.getAll();
        } catch (Exception ex) {
            result.setMessage(ex.getMessage());
            result.setMessage("Error, entity not find!");
            ex.printStackTrace();
        }
        result.setData(filials);
        return result;
    }


    @DeleteMapping("/{id}")
    public JSONResult<Filial> deleteFilial(@PathVariable int id) {
        JSONResult<Filial> result = new JSONResult<>();
        Filial currentFilial = new Filial();
        try {
            currentFilial = service.getById(id);
            service.delete(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            result.setStatus("error");
            result.setMessage("Error, entity not find!");
        }
        result.setData(currentFilial);
        return result;
    }
}