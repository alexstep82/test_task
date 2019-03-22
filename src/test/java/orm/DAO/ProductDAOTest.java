package orm.DAO;

import org.junit.Test;
import orm.entity.Product;

import java.time.Clock;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductDAOTest {

    private String number = "B0008";
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
        System.out.println(n);
        assertEquals(number, productDAO.getById(number).getNumber());
        System.out.println(productDAO.getById("23456"));
    }

    @Test
    public void getAll(){
        List result = (List) productDAO.getAll();
        Iterator iterator = result.iterator();
        while (iterator.hasNext()){
            Product product = (Product) iterator.next();
            System.out.print(product.getNumber());
            System.out.println(product.getName());
        }
    }
}
