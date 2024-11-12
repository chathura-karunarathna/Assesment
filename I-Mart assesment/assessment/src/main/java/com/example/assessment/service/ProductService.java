package com.example.assessment.service;

import com.example.assessment.dto.ProductDto;

import java.util.List;

public interface ProductService {
    String save(ProductDto productDto);

    List<ProductDto> getAllProducts();

    ProductDto getProductById(int id);

    double calculateTotalPrice(int id, int cartons, int unites);
}
