package com.utkanos.model.product;

import com.utkanos.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements Mapper<Product, ProductDTO> {

    private final ModelMapper modelMapper;

    public ProductMapper() {
        modelMapper = new ModelMapper();
    }

    @Override
    public Product toEntity(ProductDTO dto) {
        return modelMapper.map(dto, Product.class);
    }

    @Override
    public ProductDTO toDTO(Product entity) {
        return modelMapper.map(entity, ProductDTO.class);
    }
}
