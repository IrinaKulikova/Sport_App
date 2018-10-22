package application.api;

import application.entity.News;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "/api/1.0/news", produces = "application/json")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/{id}")
    public JSONResult<News> getById(@PathVariable("id") int id) {
        News news = new News();
        try {
            news = newsService.getById(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(news, ex.getMessage());
        }
        return new JSONResultOk<>(news);
    }

    @PutMapping("/{id}")
    public JSONResult<News> update(@RequestBody News news, @PathVariable("id") int id) {
        News currentNews = new News();
        try {
            currentNews = newsService.getById(id);
            if (currentNews == null) {
                return new JSONResultError<>(new News(), "entity no find!");
            }
            currentNews.setTitle(news.getTitle());
            currentNews.setDate(news.getDate());
            currentNews.setDescription(news.getDescription());
            currentNews.setImageURL(news.getImageURL());
            newsService.save(currentNews);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(currentNews, ex.getMessage());
        }
        return new JSONResultOk<>(currentNews);
    }

    @PostMapping
    public JSONResult<News> add(@RequestBody News news) {
        try {
            newsService.save(news);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(news, ex.getMessage());
        }
        return new JSONResultOk<>(news);
    }

    @DeleteMapping("/{id}")
    public JSONResult<News> delete(@PathVariable int id) {
        News news = new News();
        try {
            news = newsService.getById(id);
            newsService.delete(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JSONResultError<>(news, ex.getMessage());
        }
        return new JSONResultOk<>(news);
    }
}