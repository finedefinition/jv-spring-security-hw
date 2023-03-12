package mate.academy.service.impl;

import mate.academy.dao.CategoryDao;
import mate.academy.model.Category;
import mate.academy.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category get(Long id) {
        return categoryDao.get(id).orElseThrow(
                () -> new RuntimeException("User with id " + id + " not found"));
    }
}
