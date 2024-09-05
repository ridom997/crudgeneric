package test.java.com.generic_crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import test.java.com.generic_crud.generics.GenericEntity;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "product")
@NoArgsConstructor
public class Product extends GenericEntity<Long> implements Serializable {

    private String name;
    private Double price;
    private List<String> labels;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", id=" + super.getId() +
                ", labels=" + labels +
                '}';
    }
}
