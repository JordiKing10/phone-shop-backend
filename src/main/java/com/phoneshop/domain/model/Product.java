package com.phoneshop.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String brand;
    private String model;
    private Double price;
    private String cpu;
    private String ram;
    private String operatingSystem;
    private String screenResolution;
    private String battery;
    private String cameras;
    private String dimensions;
    private String weight;

    public Product() {
    }

    public Product(Long id, String brand, String model, Double price, String cpu, String ram,
                   String operatingSystem, String screenResolution, String battery, String cameras,
                   String dimensions, String weight) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.cpu = cpu;
        this.ram = ram;
        this.operatingSystem = operatingSystem;
        this.screenResolution = screenResolution;
        this.battery = battery;
        this.cameras = cameras;
        this.dimensions = dimensions;
        this.weight = weight;
    }
}
