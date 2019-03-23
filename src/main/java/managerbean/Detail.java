package managerbean;

import orm.DAO.DetailsOrderDAO;
import orm.DAO.ProductDAO;
import orm.entity.DetailsOrder;
import orm.entity.Order;
import service.UpdateProduct;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.xml.bind.JAXBException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class Detail implements Serializable {

    private List<DetailsOrder> detailsOrders;

    private Order order;

    public List<DetailsOrder> getDetailsOrders() {
        return detailsOrders;
    }

    public void setDetailsOrders(List<DetailsOrder> detailsOrders) {
        this.detailsOrders = detailsOrders;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<DetailsOrder> showDetail(Order order){
        List<DetailsOrder> result = new ArrayList<>();
        for(Object o: detailsOrders){
            DetailsOrder d = (DetailsOrder) o;
            if (d.getId_order().equals(order)){
                result.add(d);
            }
        }
        return result;
    }


    @PostConstruct
    public void init(){
      this.detailsOrders = (List<DetailsOrder>) new DetailsOrderDAO().getAll();
    }


}
