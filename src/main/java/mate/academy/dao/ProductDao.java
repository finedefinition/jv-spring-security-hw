package mate.academy.dao;

import java.util.List;
import java.util.Optional;
import mate.academy.model.Product;

public interface ProductDao {
    Product save(Product product);

    List<Product> findAll();

    Optional<Product> get(Long id);

    void delete(Long id);

    Product update(Product product);
}
