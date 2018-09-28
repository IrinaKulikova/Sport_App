package application.api;

import application.entity.Filial;
import application.service.implementations.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/1.0/filials")
public class FilialController {

    @Autowired
    private FilialService service;

    @GetMapping("/{id}")
    public Filial getContactsById(@PathVariable int id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Filial> getAll() {
        return service.getAll();
    }

}