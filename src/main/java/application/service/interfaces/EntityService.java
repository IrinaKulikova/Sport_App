package application.service.interfaces;

import java.util.List;

public interface EntityService<Entity> {
    List<Entity> getAll() throws Throwable;
    Entity getById(int id) throws Throwable;
    void save(Entity entity) throws Throwable;
    void delete(Entity entity) throws Throwable;
}
