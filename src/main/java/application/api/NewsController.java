package application.api;

import application.entity.News;
import application.service.implementations.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/1.0/news", produces = "application/json")
public class NewsController {

    @Autowired
    private NewsService service;

    @GetMapping(value = "/{id}")
    public News getNewsById(@PathVariable("id") int id) {
        try {
            return service.getById(id);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return new News();
    }

    @GetMapping
    public List<News> getAll() {
        try {
            return service.getAll();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return new ArrayList<>();
    }

    @PostMapping
    public void newEmployee(@RequestBody News news) {
        try {
            service.save(news);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @PutMapping("/{id}")
    public void replaceNews(@RequestBody News news) {
        try {
            service.save(news);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @DeleteMapping("/{id}")
    void deleteNews(@PathVariable int id) {
        try {
            service.delete(id);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}