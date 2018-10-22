package application.service.implementations;

import application.entity.News;
import application.repository.NewsRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class NewsService implements EntityService<News> {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> getAll() throws SQLException {
        return newsRepository.findAll();
    }

    @Override
    public News getById(int id)throws SQLException {
        return newsRepository.findById(id).get();
    }

    @Override
    public News save(News news) throws SQLException {
        return newsRepository.save(news);
    }

    @Override
    public void delete(int id) throws SQLException {
        newsRepository.delete(newsRepository.findById(id).get());
    }
}
