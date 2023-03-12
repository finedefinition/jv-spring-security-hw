package mate.academy.dao.impl;

import java.util.Optional;
import mate.academy.dao.CategoryDao;
import mate.academy.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    private SessionFactory sessionFactory;

    public CategoryDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<Category> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Query<Category> findById = session.createQuery(
                    "FROM Category WHERE id = :id", Category.class);
            findById.setParameter("id", id);
            return findById.uniqueResultOptional();
        } catch (Exception e) {
            throw new RuntimeException("Can't get user, id: " + id, e);
        }
    }
}
