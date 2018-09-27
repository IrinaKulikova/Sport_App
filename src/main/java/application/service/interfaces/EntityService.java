package application.service.interfaces;

import java.util.List;

public interface EntityService<Entity> {
    List<Entity> getAll();
    Entity getById(int id);
    void save(Entity entity);
    void delete(Entity entity);
}
