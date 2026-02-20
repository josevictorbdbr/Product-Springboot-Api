package com.josevictor.productmanager.controller;

import com.josevictor.productmanager.model.Product;
import com.josevictor.productmanager.service.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Criar
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){
        Product savedProduct = productService.create(product);
        return ResponseEntity.ok(savedProduct);
    }

    //Listar
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id){
        Optional<Product> productOptional = productService.findById(id);

        if(productOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Product product = productOptional.get();
        return ResponseEntity.ok(product);
    }
}
