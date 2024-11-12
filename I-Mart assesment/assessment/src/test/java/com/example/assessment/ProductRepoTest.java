package com.example.assessment;

import com.example.assessment.entity.Product;
import com.example.assessment.repo.ProductRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductRepoTest {
    @Autowired
    private ProductRepo productRepo;

    @Test
    public void testSaveEntity(){
        Product product = new Product();
        product.setProductId(0);
        product.setProductName("Test");
        product.setAvailableCartons(2);
        product.setPricePerCarton(130);
        product.setAvailableSingleUnits(2);
        product.setUnitsPerCarton(6);
        productRepo.save(product);

        assertNotNull(product.getProductId());
        assertEquals("Test",product.getProductName());
        assertEquals(2,product.getAvailableCartons());
    }
}
