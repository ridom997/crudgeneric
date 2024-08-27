package test.java.com.generic_crud.generics;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import java.io.Serializable;
import jakarta.persistence.Id;

@Data
@MappedSuperclass
public class GenericEntity  <ID extends Serializable> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ID id;
}
