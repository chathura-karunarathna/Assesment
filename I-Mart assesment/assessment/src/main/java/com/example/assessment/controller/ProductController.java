package com.example.assessment.controller;

import com.example.assessment.dto.ProductDto;
import com.example.assessment.service.ProductService;
import com.example.assessment.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> SaveProduct(@RequestBody ProductDto productDto){
        String message = productService.save(productDto);
        return new ResponseEntity<StandardResponse>(new StandardResponse(201, "Successfully saved",message), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-all-products")
    public ResponseEntity<StandardResponse> GetAllProducts(){
        List<ProductDto> allProducts = productService.getAllProducts();
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"All products", allProducts),HttpStatus.OK);
    }

    @GetMapping(value = "/get-product-by-id",params = {"id"})
    public ResponseEntity<StandardResponse> GetProductByID(@RequestParam(value = "id") int id){
        System.out.println("product id "+id);
        ProductDto productDto = productService.getProductById(id);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Product found for id",productDto),HttpStatus.OK);
    }

    @GetMapping(value = "/get-total-price",params = {"id","cartons","unites"})
    public ResponseEntity<StandardResponse> GetTotalPrice(@RequestParam(value = "id")int id,
                                                          @RequestParam(value = "cartons")int cartons,
                                                          @RequestParam(value = "unites")int unites){
        double totalPrice = productService.calculateTotalPrice(id,cartons,unites);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200, "Total Price",totalPrice),HttpStatus.OK);
    }

}
