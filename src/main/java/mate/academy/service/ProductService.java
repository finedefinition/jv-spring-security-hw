package mate.academy.service;

import java.util.List;
import mate.academy.model.Product;

public interface ProductService {
    Product save(Product product);

    List<Product> findall();

    Product get(Long id);

    void delete(Long id);

    Product update(Product product);
}
