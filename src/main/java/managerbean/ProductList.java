package managerbean;

import orm.DAO.ProductDAO;
import orm.entity.Product;
import service.UpdateProduct;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.xml.bind.JAXBException;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.List;


@Named
@ViewScoped
public class ProductList implements Serializable {

    private List<Product> listProduct;

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public void update() throws JAXBException {
        String path = Paths.get("").toAbsolutePath().toString();
                System.out.println(path);
        new UpdateProduct(new ProductDAO()).updateProduct(path + "/products.xml");
    }

    @PostConstruct
    public void init(){
        this.listProduct = (List<Product>) new ProductDAO().getAll();
    }
}
