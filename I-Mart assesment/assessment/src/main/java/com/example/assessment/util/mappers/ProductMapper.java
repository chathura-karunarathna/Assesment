package com.example.assessment.util.mappers;

import com.example.assessment.dto.ProductDto;
import com.example.assessment.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    List<ProductDto> productEntityToProductDto(List<Product> products);
}
