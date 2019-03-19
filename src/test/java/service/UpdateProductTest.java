package service;

import org.junit.Test;
import orm.DAO.ProductDAO;

import javax.xml.bind.JAXBException;

import static org.junit.Assert.*;

public class UpdateProductTest {

    private ProductDAO productDAO = new ProductDAO();
    @Test
    public void updateProduct() throws JAXBException {
        UpdateProduct updateProduct = new UpdateProduct(productDAO);
        updateProduct.updateProduct("/home/alexbash/IdeaProjects/testtask/products.xml");
//        assertEquals("C0003", productDAO.getById("C0003").getNumber());
    }
}