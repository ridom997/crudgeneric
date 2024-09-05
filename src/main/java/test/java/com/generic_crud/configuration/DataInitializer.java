package test.java.com.generic_crud.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import test.java.com.generic_crud.entity.Product;
import test.java.com.generic_crud.entity.ProductDTO;
import test.java.com.generic_crud.generics.GenericMapper;
import test.java.com.generic_crud.generics.GenericRepository;

import java.util.Arrays;

@Component
public class DataInitializer {

    @Autowired
    private GenericRepository<Product, Long> productRepository;

    @Autowired
    private GenericMapper<Product, ProductDTO, Long> productMapper;



    @Bean
    CommandLineRunner initData() {
        Product productA = new Product("Product A", 100000.0);
        productA.setId(2L);
        productA.setLabels(Arrays.asList("LabelA","LabelB","LabelC","LabelD"));
        productMapper.map(productA, ProductDTO.class);
        return args -> {
            productRepository.save(productA);
            productRepository.save(new Product("Product B", 200000.0));
            productRepository.save(new Product("Product C", 300000.0));
        };
    }
}
