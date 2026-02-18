package com.josevictor.productmanager.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gerar ID automaticamente
    private Long id;

    @Column(nullable = false) // precisa ter
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Boolean active = true;

    private String description; // opcional

    public Product(String name, BigDecimal price, Integer quantity, String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.active = true;
    }
    //Classe vazia obrigatoria
    public Product() {
    }
}

