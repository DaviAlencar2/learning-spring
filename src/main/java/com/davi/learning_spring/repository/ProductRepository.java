package com.davi.learning_spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.davi.learning_spring.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
