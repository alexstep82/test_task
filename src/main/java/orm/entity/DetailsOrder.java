package orm.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "detailsOrder", schema = "testtask")
public class DetailsOrder implements Serializable {
    private Integer id;
    private Product number_product;
    private Integer count;
    private Order id_order;

    public DetailsOrder() {
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (nullable = false)
    public Product getNumber_product() {
        return number_product;
    }

    public void setNumber_product(Product number_product) {
        this.number_product = number_product;
    }

    @Basic
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (nullable = false)
    public Order getId_order() {
        return id_order;
    }

    public void setId_order(Order id_order) {
        this.id_order = id_order;
    }
}
