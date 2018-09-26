package application.service.implementations;

import application.entity.News;
import application.repository.RepositoryNews;
import application.service.interfaces.IEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService implements IEntityService<News> {

    @Autowired
    RepositoryNews repositoryNews;

    @Override
    public List<News> getAll() {
        return repositoryNews.findAll();
    }

    @Override
    public News getById(int id) {
        return repositoryNews.getOne(id);
    }

    @Override
    public void save(News news) {
        repositoryNews.save(news);
    }

    @Override
    public void delete(News news) {
        repositoryNews.delete(news);
    }
}
