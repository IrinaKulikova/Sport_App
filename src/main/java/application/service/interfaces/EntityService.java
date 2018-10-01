package application.service.interfaces;

import java.io.IOException;
import java.util.List;

public interface EntityService<Entity> {
    List<Entity> getAll() throws Exception;
    Entity getById(int id) throws Exception;
    void save(Entity entity) throws Exception;
    void delete(int id) throws Exception;
}
