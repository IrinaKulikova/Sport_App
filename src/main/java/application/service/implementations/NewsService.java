package application.service.implementations;

import application.entity.News;
import application.repository.NewsRepository;
import application.service.interfaces.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService implements EntityService<News> {

    @Autowired
    NewsRepository newsRepository;

    @Override
    public List<News> getAll() {  return newsRepository.findAll(); }

    @Override
    public News getById(int id)  {  return newsRepository.findById(id).get();  }

    @Override
    public void save(News news)  { newsRepository.save(news); }

    @Override
    public void delete(int id) { newsRepository.delete(newsRepository.findById(id).get()); }
}
