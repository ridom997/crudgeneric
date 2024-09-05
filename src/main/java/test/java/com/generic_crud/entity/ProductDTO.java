package test.java.com.generic_crud.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ProductDTO implements Serializable {

    private Serializable id;
    private String name;
    private Double price;
    private List<String> labels;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", id=" + id +
                ", labels=" + labels +
                '}';
    }
}
