package managerbean;

import orm.DAO.OrderDAO;
import orm.entity.Order;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class OrdersView implements Serializable {
    private List<Order> orders;

    private Order selectOrder;

    public List<Order> getOrders() {
        return orders;
    }

    public Order getSelectOrder() {
        return selectOrder;
    }

    public void setSelectOrder(Order selectOrder) {
        this.selectOrder = selectOrder;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @PostConstruct
    public void init(){
        orders = (List<Order>) new OrderDAO().getAll();

    }
}
