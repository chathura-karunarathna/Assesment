package com.example.assessment;

import com.example.assessment.dto.ProductDto;
import com.example.assessment.entity.Product;
import com.example.assessment.service.ProductService;
import com.example.assessment.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductServiceImpl productServiceImpl;



    @Test
    public void testSave(){
        ProductDto productDto = new ProductDto(1,"penguin ears",15,0,175,20);
        String results = productService.save(productDto);
        assertEquals("penguin ears saved successfully",results);
    }

    @Test
    public void testGetAllProducts(){
        List<ProductDto> products = productService.getAllProducts();
        assertNotNull(products);
    }

    @Test
    public void testGetProductById(){
        int productId = 1;
        ProductDto productDto = productService.getProductById(productId);
        assertNotNull(productDto);
        assertEquals(productId,productDto.getProductId());
        assertEquals("penguin ears",productDto.getProductName());
        assertEquals(15,productDto.getAvailableCartons());
        assertEquals(0,productDto.getAvailableSingleUnits());
        assertEquals(175,productDto.getPricePerCarton());
        assertEquals(20,productDto.getUnitsPerCarton());
    }

    @Test
    public  void testCalculateSingleUnitePrice(){
        double singaleUnitePrice = productServiceImpl.calculateSingleUnitePrice(20,175);
        assertEquals(11.375,singaleUnitePrice);
    }

    @Test
    public void testAddDiscount(){
        double discountedPrice = productServiceImpl.addDiscount(175);
        assertEquals(157.5,discountedPrice);
    }

    @Test
    public void testCalculateTotalPrice(){
        double totalPrice = productService.calculateTotalPrice(1,1,0);
        assertEquals(175,totalPrice);
    }

}
