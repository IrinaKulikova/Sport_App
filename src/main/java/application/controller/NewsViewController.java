package application.controller;

import application.service.implementations.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/news")
public class NewsViewController {

    @Autowired
    private NewsService newsService;

    @GetMapping()
    public String news(Model model) {
        try {
            model.addAttribute("news",newsService.getAll());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return "news/news";
    }

    @GetMapping("/edit/{id}")
    public String newsEdit(@PathVariable int id, Model model){
        try {
            model.addAttribute("news",newsService.getById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "news/news_edit";
    }

    @GetMapping("/create")
    public String newsCreate(){
        return "news/news_create";
    }
}