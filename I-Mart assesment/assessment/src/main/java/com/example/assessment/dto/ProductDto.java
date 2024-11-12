package com.example.assessment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {

    private int productId;
    private String productName;
    private int availableCartons;
    private int availableSingleUnits;
    private int pricePerCarton;
    private int UnitsPerCarton;
}
