package application.service.interfaces;

import application.entity.Card;
import application.entity.Contacts;

import java.util.List;

public interface IEntityService<Entity> {
    List<Entity> getAll();
    Entity getById(int id);
    void save(Entity entity);
    void delete(Entity entity);
}
