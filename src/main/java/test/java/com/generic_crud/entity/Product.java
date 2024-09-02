package test.java.com.generic_crud.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import test.java.com.generic_crud.generics.GenericEntity;

import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "product")
public class Product extends GenericEntity<Long> implements Serializable {

    private String name;
    private Double price;


    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
