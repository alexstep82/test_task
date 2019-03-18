package orm.DAO;

import org.junit.Test;
import orm.entity.Product;

import java.time.Clock;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ProductDAOTest {

    private String number = "B0001";
    private String description = "Table for working";
    private String name = "Table";
    private LocalDate date = LocalDate.now();
    private ProductDAO productDAO = new ProductDAO();
    @Test
    public void add() {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setNumber(number);
        product.setProductionDate(date);
        String n = productDAO.add(product);
        assertEquals(number, productDAO.getById(number).getNumber());
    }
}
