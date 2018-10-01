package application.service.interfaces;

import java.io.IOException;
import java.util.List;

public interface EntityService<Entity> {
    List<Entity> getAll() throws IOException;
    Entity getById(int id) throws IOException;
    void save(Entity entity) throws IOException;
    void delete(int id) throws IOException;
}
