package orm.DAO;

import org.junit.Test;
import orm.entity.DetailsOrder;
import orm.entity.Order;
import orm.entity.Product;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class DetailsOrderDAOTest {

    private String number_product= "B0001";
    private Integer id_Order = 1;
    private Integer count = 5;
    private Order order = new OrderDAO().getById(1);
    private Product product = new ProductDAO().getById(number_product);
    private DetailsOrderDAO detailsOrderDAO = new DetailsOrderDAO();
    @Test
    public void add() throws SQLException {
        DetailsOrder detailsOrder = new DetailsOrder();
        detailsOrder.setCount(count);
        detailsOrder.setId_order(order);
        detailsOrder.setNumber_product(product);
        Integer id = detailsOrderDAO.add(detailsOrder);
        assertEquals(count, detailsOrderDAO.getById(id).getCount());
        assertEquals(number_product, detailsOrderDAO.getById(id).getNumber_product().getNumber());
    }
}