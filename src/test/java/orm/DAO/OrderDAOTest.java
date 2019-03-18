package orm.DAO;

import org.junit.Test;
import orm.entity.Order;

import java.sql.SQLException;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.Assert.*;

public class OrderDAOTest {

    String nameCustomer = "Bashmakov";
    String addressCustomer = "Lenina 19";
    Integer sumPrice = 10;
    LocalDate date = LocalDate.now(Clock.systemUTC());
    private OrderDAO orderDAO = new OrderDAO();
    @Test
    public void add() throws SQLException {
        Order order = new Order();
        order.setNameCustomer(nameCustomer);
        order.setAddressCustomer(addressCustomer);
        order.setSumPrice(sumPrice);
        order.setDate(date);
        int id = orderDAO.add(order);
        assertEquals(nameCustomer, orderDAO.getById(id).getNameCustomer());
        assertEquals(addressCustomer, orderDAO.getById(id).getAddressCustomer());
        assertEquals(sumPrice, orderDAO.getById(id).getSumPrice());
        assertEquals(date, orderDAO.getById(id).getDate());

    }
}