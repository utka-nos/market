package com.utkanos.model.product;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product, String> {



}
