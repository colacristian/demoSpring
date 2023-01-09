package edu.example.demospring.model;

import java.io.Serializable;

public class ProductDTO implements Serializable {

    private Long id;
    private String name;

    private double price;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
