package com.josevictor.productmanager.repository;

import com.josevictor.productmanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
