package mate.academy.dao;

import java.util.List;
import java.util.Optional;
import mate.academy.model.User;

public interface UserDao {

    User save(User user);

    List<User> findAll();

    Optional<User> get(Long id);

    void delete(Long id);

    User update(User user);
}
