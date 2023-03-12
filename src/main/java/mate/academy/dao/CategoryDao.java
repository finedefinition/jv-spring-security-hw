package mate.academy.dao;

import java.util.Optional;
import mate.academy.model.Category;

public interface CategoryDao {
    Optional<Category> get(Long id);
}
