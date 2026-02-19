package com.josevictor.productmanager.service;

import com.josevictor.productmanager.model.Product;
import com.josevictor.productmanager.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    //Cria repositorio do Produto
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product){
        return productRepository.save(product);
    }

    public List<Product> FindAll(){
        return productRepository.findAll();
    }

    public Optional<Product> FindbyId(long id){   //Lidar com "não encontrado"
        return productRepository.findById(id);
    }
}
