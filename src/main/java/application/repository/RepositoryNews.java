package application.repository;

import application.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryNews extends JpaRepository<News, Integer> {
}
