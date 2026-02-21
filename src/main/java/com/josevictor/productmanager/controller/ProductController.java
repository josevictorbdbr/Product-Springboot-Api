package com.josevictor.productmanager.controller;

import com.josevictor.productmanager.model.Product;
import com.josevictor.productmanager.service.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        List<Product> allProducts = productService.findAll();
        List<Product> activeProducts = new ArrayList<>();

        for (Product product : allProducts) {
            if(Boolean.TRUE.equals(product.getActive())){
                activeProducts.add(product);
            }
        }
        return ResponseEntity.ok(activeProducts);
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

    //Editar
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product updateProduct){
        Optional<Product> productOptional = productService.findById(id);

        if (productOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Product product = productOptional.get();

        product.setName(updateProduct.getName());
        product.setPrice(updateProduct.getPrice());
        product.setQuantity(updateProduct.getQuantity());
        product.setDescription(updateProduct.getDescription());

        Product savedProduct = productService.create(product);

        return ResponseEntity.ok(savedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        Optional<Product> productOptional = productService.findById(id);

        if(productOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Product product = productOptional.get();
        product.setActive(false);

        productService.create(product);

        return ResponseEntity.ok().build();
    }
}
