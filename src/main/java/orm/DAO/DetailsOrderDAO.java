package orm.DAO;

import org.hibernate.Session;
import orm.HibernateSessionFactory;
import orm.entity.DetailsOrder;

public class DetailsOrderDAO implements EntityOperations<Integer,DetailsOrder> {
    @Override
    public Integer add(DetailsOrder detailsOrder) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Integer id = (Integer) session.save(detailsOrder);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    @Override
    public DetailsOrder getById(Integer id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        DetailsOrder detailsOrder = session.get(DetailsOrder.class, id);
        session.close();
        return detailsOrder;
    }
}
