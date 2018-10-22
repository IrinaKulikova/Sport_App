package application.controller;

import application.service.implementations.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;


@Controller
@RequestMapping("/news")
public class NewsViewController {

    private final NewsService newsService;

    @Autowired
    public NewsViewController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping()
    public String news(Model model) {
        try {
            model.addAttribute("news",newsService.getAll());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "news/news";
    }

    @GetMapping("/edit/{id}")
    public String newsEdit(@PathVariable int id, Model model){
        try {
            model.addAttribute("news",newsService.getById(id));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "news/news_edit";
    }

    @GetMapping("/create")
    public String newsCreate(){
        return "news/news_create";
    }
}