package test.java.com.generic_crud.generics;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface GenericRepository <T extends GenericEntity, ID extends Serializable> extends JpaRepository<T, ID> {
}
