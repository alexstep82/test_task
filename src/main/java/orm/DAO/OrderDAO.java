package orm.DAO;

import org.hibernate.Session;
import orm.HibernateSessionFactory;
import orm.entity.Order;

public class OrderDAO implements EntityOperations<Order> {
    @Override
    public int add(Order order) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Integer id = (Integer) session.save(order);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    @Override
    public Order getById(Integer id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Order order = session.get(Order.class, id);
        session.close();
        return order;
    }
}
