package application.service;

import application.entity.News;
import application.repository.RepositoryNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    RepositoryNews repositoryNews;

    public List<News> findAll() {
        return repositoryNews.findAll();
    }

    public void save(News news) {
        repositoryNews.save(news);
    }
}
