package com.josevictor.productmanager.service;

import com.josevictor.productmanager.model.Product;
import com.josevictor.productmanager.repository.ProductRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    //Criar repositorio do Produto
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    //Lidar com "não encontrado"
    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }
}
