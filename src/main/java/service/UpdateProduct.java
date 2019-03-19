package service;

import orm.DAO.ProductDAO;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.time.ZoneId;
import java.util.logging.Logger;

public class UpdateProduct {

    private static final Logger log = Logger.getLogger(UpdateProduct.class.getName());
    private ProductDAO productDAO;

    public UpdateProduct(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Products unMarshaling (String path) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (Products) unmarshaller.unmarshal(new File(path));
    }

    public void updateProduct(String path) throws JAXBException {
        Products products = unMarshaling(path);
        for (Product product: products.getProductList()){
            String n = product.getNumber();
            if (productDAO.getById(n) != null) {
                log.info("Product with number " + n + " already exist");
                continue;
            } else {
                orm.entity.Product productEntity = new orm.entity.Product();
                productEntity.setNumber(product.getNumber());
                productEntity.setName(product.getName());
                productEntity.setDescription(product.getDescription());
                productEntity.setProductionDate(product.getProductionDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                try {
                    productDAO.add(productEntity);
                    log.info("Add product with number: " + product.getNumber());
                } catch (Exception e){
                    log.warning("Error save in database!!!");
                }
            }

        }

    }
}
