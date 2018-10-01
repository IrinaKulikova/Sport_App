package application.api;

import application.entity.Filial;
import application.service.implementations.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/1.0/filials")
public class FilialController {

    @Autowired
    private FilialService service;

    @GetMapping("/{id}")
    public Filial getContactsById(@PathVariable int id) {
        try {
            return service.getById(id);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return new Filial();
    }

    @GetMapping
    public List<Filial> getAll() {
        try {
            return service.getAll();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return new ArrayList<>();
    }

    @PutMapping()
    public void replaceNews(@RequestBody Filial filial) {
        try {
            service.save(filial);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @PostMapping
    public void newEmployee(@RequestBody Filial filial) {
        try {
            service.save(filial);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @DeleteMapping("/{id}")
    void deleteContacts(@PathVariable int id) {
        try {
            service.delete(id);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}