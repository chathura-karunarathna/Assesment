package com.example.assessment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "available_cartons")
    private int availableCartons;
    @Column(name = "available_single_unites")
    private int availableSingleUnits;
    @Column(name = "price_per_carton")
    private int pricePerCarton;
    @Column(name = "unites_per_carton")
    private int UnitsPerCarton;
}
