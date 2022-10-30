package com.utkanos.model.product;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ProductDTO {

    private String id;

    private String name;

    private Map<String, String> properties = new HashMap<>();

}
