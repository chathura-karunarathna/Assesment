package com.example.assessment;

import com.example.assessment.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductDtoTest {

    @Test
    public void testProductDto(){
        ProductDto productDto = new ProductDto(1,"penguin ears",15,0,175,20);

        assertNotNull(productDto);
        assertEquals(1, productDto.getProductId());
        assertEquals("penguin ears",productDto.getProductName());
        assertEquals(15,productDto.getAvailableCartons());
        assertEquals(0,productDto.getAvailableSingleUnits());
        assertEquals(175,productDto.getPricePerCarton());
        assertEquals(20,productDto.getUnitsPerCarton());
    }
}
