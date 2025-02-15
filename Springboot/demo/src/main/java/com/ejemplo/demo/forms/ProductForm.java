package com.ejemplo.demo.forms;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductForm {

    @NotEmpty(message = "El nombre del producto es requerido")
    private String name;

    @NotNull(message = "El precio es requerido")
    @Positive(message = "El precio debe ser mayor a cero")
    private Double price;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
