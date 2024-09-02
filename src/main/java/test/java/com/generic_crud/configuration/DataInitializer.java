package test.java.com.generic_crud.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import test.java.com.generic_crud.entity.Product;
import test.java.com.generic_crud.generics.GenericRepository;

@Component
public class DataInitializer {

    @Autowired
    private GenericRepository<Product, Long> productRepository;

    @Bean
    CommandLineRunner initData() {
        return args -> {
            productRepository.save(new Product("Product A", 100000.0));
            productRepository.save(new Product("Product B", 200000.0));
            productRepository.save(new Product("Product C", 300000.0));
        };
    }
}
