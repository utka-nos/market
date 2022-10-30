package com.utkanos.service;

import com.utkanos.model.product.Product;
import com.utkanos.model.product.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product addNewProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public void deleteProduct(String id) {
        productRepo.deleteById(id);
    }
}
