package test.java.com.generic_crud.configuration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.java.com.generic_crud.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
