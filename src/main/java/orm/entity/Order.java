package orm.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table (name = "orders", schema = "testtask")
public class Order implements Serializable {
    private Integer id;
    private String nameCustomer;
    private String addressCustomer;
    private Integer sumPrice;
    private LocalDate date;

    public Order() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nameCustomer")
    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    @Basic
    @Column(name = "addressCustomer")
    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    @Basic
    @Column(name = "sumPrice")
    public Integer getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Integer sumPrice) {
        this.sumPrice = sumPrice;
    }

    @Basic
    @Column(name = "dateorder")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(nameCustomer, order.nameCustomer) &&
                Objects.equals(addressCustomer, order.addressCustomer) &&
                Objects.equals(sumPrice, order.sumPrice) &&
                Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameCustomer, addressCustomer, sumPrice, date);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", addressCustomer='" + addressCustomer + '\'' +
                ", sumPrice=" + sumPrice +
                ", date=" + date +
                '}';
    }
}
