package com.utkanos.model.product;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.HashMap;
import java.util.Map;

@Document(collection = "products")
@Data
public class Product {

    @MongoId
    private String id;

    private String name;

    private Map<String, String> properties = new HashMap<>();

}
