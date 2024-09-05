package test.java.com.generic_crud.generics;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.io.Serializable;

@Data
@MappedSuperclass
public class GenericDTO  <ID extends Serializable> implements Serializable{
    private ID id;
}
