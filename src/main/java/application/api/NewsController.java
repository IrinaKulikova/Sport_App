package application.api;

import application.entity.Filial;
import application.entity.News;
import application.result.JSONResult;
import application.service.implementations.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/1.0/news", produces = "application/json")
public class NewsController {

    @Autowired
    private NewsService service;

    @GetMapping("/{id}")
    public JSONResult<News> getNewsById(@PathVariable("id") int id) {
        JSONResult<News> result = new JSONResult<>();
        News news = new News();
        try {
            news = service.getById(id);
        } catch (IOException ex) {
            result.setStatus(ex.getMessage());
            result.setMessage("Error, entity not find!");
            ex.printStackTrace();
        }
        result.setData(news);
        return result;
    }

    @GetMapping
    public JSONResult<List<News>> getAll() {
        JSONResult<List<News>> result = new JSONResult<>();
        List<News> news = new ArrayList<>();
        try {
            news = service.getAll();
        } catch (IOException ex) {
            result.setMessage(ex.getMessage());
            result.setMessage("Error, entity not find!");
            ex.printStackTrace();
        }
        result.setData(news);
        return result;
    }


    @PutMapping("/{id}")
    public JSONResult<News> replaceNews(@RequestBody News news, @PathVariable("id") int id) {
        JSONResult<News> result = new JSONResult<>();
        News currentNews = new News();
        try {
            currentNews = service.getById(id);
            if (currentNews == null) {
                result.setStatus("error");
                result.setMessage("Error, entity not find!");
                result.setData(currentNews);
                return result;
            }
            currentNews.setTitle(news.getTitle());
            currentNews.setDate(news.getDate());
            currentNews.setDescription(news.getDescription());
            currentNews.setImageURL(news.getDate());
            service.save(news);
        } catch (IOException ex) {
            result.setStatus("error");
            result.setMessage("Error, entity not find!");
            ex.printStackTrace();
        }
        result.setData(news);
        return result;
    }

    @PostMapping
    public JSONResult<News> newNews(@RequestBody News news) {
        JSONResult<News> result = new JSONResult<>();
        News currentNews = new News();
        try {
            currentNews = service.getById(news.getId());
            service.save(news);
        } catch (IOException ex) {
            ex.printStackTrace();
            result.setStatus("error");
            result.setMessage("Error, entity not find!");
        }
        result.setData(currentNews);
        return result;
    }

    @DeleteMapping("/{id}")
    public JSONResult<News> deleteNews(@PathVariable int id) {
        JSONResult<News> result = new JSONResult<>();
        News currentNews = new News();
        try {
            currentNews = service.getById(id);
            service.delete(id);
        } catch (IOException ex) {
            ex.printStackTrace();
            result.setStatus("error");
            result.setMessage("Error, entity not find!");
        }
        result.setData(currentNews);
        return result;
    }
}