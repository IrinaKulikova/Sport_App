package application.api;

import application.entity.News;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.implementations.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/1.0/news", produces = "application/json")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/{id}")
    public JSONResult<News> getNewsById(@PathVariable("id") int id) {
        News news = new News();
        try {
            news = newsService.getById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<News>(news, ex.getMessage());
        }
        return new JSONResultOk<News>(news);
    }

    @GetMapping
    public JSONResult<List<News>> getAll() {
        List<News> news = new ArrayList<>();
        try {
            news = newsService.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(news, ex.getMessage());
        }
        return new JSONResultOk<List<News>>(news);
    }

    @PutMapping("/{id}")
    public JSONResult<News> updateNews(@RequestBody News news, @PathVariable("id") int id) {
        News currentNews = new News();
        try {
            currentNews = newsService.getById(id);
            if (currentNews == null) {
                return new JSONResultError<>(currentNews, "entity no find!");
            }
            currentNews.setTitle(news.getTitle());
            currentNews.setDate(news.getDate());
            currentNews.setDescription(news.getDescription());
            currentNews.setImageURL(news.getDate());
            newsService.save(currentNews);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(currentNews, ex.getMessage());
        }
        return new JSONResultOk<>(currentNews);
    }

    @PostMapping
    public JSONResult<News> addNews(@RequestBody News news) {
        try {
            newsService.save(news);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<News>(news, ex.getMessage());
        }
        return new JSONResultOk<News>(news);
    }

    @DeleteMapping("/{id}")
    public JSONResult<News> deleteNews(@PathVariable int id) {
        News news = new News();
        try {
            news = newsService.getById(id);
            newsService.delete(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(news, ex.getMessage());
        }
        return new JSONResultOk<>(news);
    }
}