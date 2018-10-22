package application.service.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface EntityService<Entity> {
    List<Entity> getAll() throws SQLException;
    Entity getById(int id) throws SQLException;
    Entity save(Entity entity) throws SQLException;
    void delete(int id) throws SQLException;
}
