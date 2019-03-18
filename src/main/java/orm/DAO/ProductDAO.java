package orm.DAO;

import org.hibernate.Session;
import orm.HibernateSessionFactory;
import orm.entity.Product;

public class ProductDAO implements EntityOperations<Product> {
    @Override
    public int add(Product product) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Integer id = (Integer) session.save(product);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    @Override
    public Product getById(Integer id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }
}
