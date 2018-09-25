package application.repositories;

import application.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryNews extends JpaRepository<News, Integer> {
}
