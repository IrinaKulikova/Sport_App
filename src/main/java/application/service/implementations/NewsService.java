package application.service.implementations;

import application.entity.News;
import application.repository.RepositoryNews;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class NewsService implements EntityService<News> {

    @Autowired
    RepositoryNews repositoryNews;

    @Override
    public List<News> getAll() {  return repositoryNews.findAll(); }

    @Override
    public News getById(int id)  {  return repositoryNews.findById(id).get();  }

    @Override
    public void save(News news)  { repositoryNews.save(news); }

    @Override
    public void delete(int id) { repositoryNews.delete(repositoryNews.findById(id).get()); }
}
