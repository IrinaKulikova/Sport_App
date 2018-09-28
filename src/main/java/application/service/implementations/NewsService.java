package application.service.implementations;

import application.entity.News;
import application.repository.RepositoryNews;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService implements EntityService<News> {

    @Autowired
    RepositoryNews repositoryNews;

    @Override
    public List<News> getAll() throws  Throwable {
        return repositoryNews.findAll();
    }

    @Override
    public News getById(int id) throws Throwable {
        return repositoryNews.findById(id).get();
    }

    @Override
    public void save(News news) throws Throwable {
        repositoryNews.save(news);
    }

    @Override
    public void delete(int id) throws Throwable {
        repositoryNews.delete(repositoryNews.findById(id).get());
    }
}
