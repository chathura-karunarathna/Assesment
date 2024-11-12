package com.example.assessment.util.mappers;

import com.example.assessment.dto.ProductDto;
import com.example.assessment.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-12T00:53:06+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public List<ProductDto> productEntityToProductDto(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( products.size() );
        for ( Product product : products ) {
            list.add( productToProductDto( product ) );
        }

        return list;
    }

    protected ProductDto productToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setProductId( product.getProductId() );
        productDto.setProductName( product.getProductName() );
        productDto.setAvailableCartons( product.getAvailableCartons() );
        productDto.setAvailableSingleUnits( product.getAvailableSingleUnits() );
        productDto.setPricePerCarton( product.getPricePerCarton() );
        productDto.setUnitsPerCarton( product.getUnitsPerCarton() );

        return productDto;
    }
}
