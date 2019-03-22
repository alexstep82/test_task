package orm.DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import orm.HibernateSessionFactory;
import orm.entity.DetailsOrder;
import orm.entity.Order;

import java.util.Collection;
import java.util.List;

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

    @Override
    public Collection<DetailsOrder> getAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Query query = session.createQuery("from DetailsOrder ");
        Collection<DetailsOrder> result = query.getResultList();
        session.close();
        return result;
    }

    public Collection<DetailsOrder> getAllByOrder(Order order){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Query query = session.createQuery("from DetailsOrder D where D.id_order =:order ");
        query.setParameter("order", order);
        List result = query.getResultList();
        session.close();
        return result;
    }
}
