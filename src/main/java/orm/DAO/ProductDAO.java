package orm.DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import orm.HibernateSessionFactory;
import orm.entity.Product;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class ProductDAO implements EntityOperations<String, Product> {
    @Override
    public String add(Product product) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        String id = (String) session.save(product);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    @Override
    public Product getById(String id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }

    public Collection<Product> getAll(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Query query = session.createQuery("from Product ");
        List result = query.getResultList();
        session.close();
        return result;
    }
}
