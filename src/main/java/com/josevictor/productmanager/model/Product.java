package com.josevictor.productmanager.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gerar ID automaticamente
    private Long id;

    @Column(nullable = false) //Precisa ter
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Boolean active = true;

    private String description; //Opcional

    public Product(String name, BigDecimal price, Integer quantity, String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.active = true;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Product(){
        //Classe vazia
    }
}

