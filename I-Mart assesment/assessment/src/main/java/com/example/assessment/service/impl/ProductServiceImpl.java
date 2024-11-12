package com.example.assessment.service.impl;

import com.example.assessment.dto.ProductDto;
import com.example.assessment.entity.Product;
import com.example.assessment.exception.NotFoundException;
import com.example.assessment.repo.ProductRepo;
import com.example.assessment.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductRepo productRepo;

    @Override
    public String save(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        productRepo.save(product);
        return product.getProductName()+" saved successfully";
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> allProducts = productRepo.findAll();
        List<Product> showingProducts = new ArrayList<>();
        if(allProducts.size()>0){
            for (Product product: allProducts) {
                if((product.getAvailableCartons()>0 || product.getAvailableSingleUnits()>0) && (product.getAvailableCartons()<=50 || product.getAvailableSingleUnits()<=50)){
                    showingProducts.add(product);
            }
            }
           List <ProductDto> productDto = modelMapper.map(showingProducts,new TypeToken<List<ProductDto>>(){}.getType());
            return productDto;
        } else {
            throw new NotFoundException("No data found...!!");
        }

    }

    @Override
    public ProductDto getProductById(int id) {
        if(productRepo.existsById(id)){
            Product product = productRepo.getReferenceById(id);
            return modelMapper.map(product, ProductDto.class);
        }else{
            throw new NotFoundException("No data found for that id");
        }
    }

    @Override
    public double calculateTotalPrice(int id, int cartons, int unites) {
        if (productRepo.existsById(id)){
            Product product = productRepo.getReferenceById(id);
            double cartonPrice = product.getPricePerCarton();

            if(unites>product.getUnitsPerCarton()){
                for (int i=0; unites>product.getUnitsPerCarton(); i++){
                    cartons = cartons + 1;
                    unites = unites - product.getUnitsPerCarton();
                }
            }
            if(cartons>3){
                cartonPrice = addDiscount(cartonPrice);
            }
            double totalPrice = ((calculateSingleUnitePrice(product.getUnitsPerCarton(),product.getPricePerCarton())) * unites) + (cartonPrice * cartons);
            return totalPrice;
        }else {
            throw new NotFoundException("No data found");
        }

    }

    public double calculateSingleUnitePrice (double unitePerCarton, double pricePerCarton ){
       double singleUnitePrice = (pricePerCarton/unitePerCarton)*1.3;
       return singleUnitePrice;
    }

    public double addDiscount (double cartonPrice){
        double discountedPrice = cartonPrice - ((cartonPrice * 10)/ 100) ;
        return discountedPrice;
    }
}
