package orm.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table (name = "product", schema = "testtask")
public class Product implements Serializable {
    private String number;
    private String name;
    private String description;
    private LocalDate productionDate;

    public Product() {
    }

    @Id
    @Column (name = "number", unique = true)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column (name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column (name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column (name = "productionDate")
    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(number, product.number) &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(productionDate, product.productionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, description, productionDate);
    }

    @Override
    public String toString() {
        return "Product{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", productionDate=" + productionDate +
                '}';
    }
}
