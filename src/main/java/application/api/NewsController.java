package application.api;

import application.entity.News;
import application.service.implementations.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping( value = "/api/1.0/news", produces = "application/json")
public class NewsController {

    @Autowired
    private NewsService service;

    @GetMapping(value = "/{id}")
    public News getNewsById(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @GetMapping
    public List<News> getAll() {
        return service.getAll();
    }
}