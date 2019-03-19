package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.Date;

@XmlRootElement(name = "product")
@XmlAccessorType (XmlAccessType.FIELD)
public class Product {
    private String number;
    private String name;
    private String description;
    private Date productionDate;

    public Product() {
    }

    public Product(String number, String name, String description, Date productionDate) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.productionDate = productionDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }
}
