package mate.academy.service;

import java.util.List;
import mate.academy.model.User;

public interface UserService {
    User save(User user);

    List<User> findAll();

    User get(Long id);

    void delete(Long id);

    User update(User user);
}
