package com.ProductCrud.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProductCrud.demo.domain.product.Product;
import com.ProductCrud.demo.domain.product.ProductDTO;
import com.ProductCrud.demo.domain.product.ProductRepository;

@Service
public class DataBaseService {

    @Autowired
    ProductRepository repository;

    public int ValidatePrice(Integer price){
        String StringPrice = Integer.toString(price);
        StringPrice.replaceAll("[0-9]", StringPrice);
        int priceFiltered = Integer.parseInt(StringPrice);
        return priceFiltered;
    }

    public void SaveProduct(ProductDTO dto){
        Product NewProduct = new Product(dto);
        repository.save(NewProduct);
    }

    public List<Product> GetAll(){
        List<Product> Products = repository.findAll();  
        return Products;
    }
    
    public List<Product> FilteredProducts(ProductDTO productDTO){
        List<Product> Products;
        if (productDTO.category().equals("Tudo")){
            Products = repository.findAll();
        } else {
            Products = repository.findBycategory(productDTO.category());
        }
        return Products;
    }

    public List<Product> FilteredByName(String Name){
        List<Product> Products;
        Products = repository.findByproductNameContaining(Name);
        return Products;
    }
}