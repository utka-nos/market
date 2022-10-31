package com.utkanos.api;

import com.utkanos.model.product.Product;
import com.utkanos.model.product.ProductDTO;
import com.utkanos.model.product.ProductMapper;
import com.utkanos.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Operation(summary = "Add new product")
    @PostMapping
    public ResponseEntity<ProductDTO> addNewProduct(
            @RequestBody ProductDTO productDTO
    ) {
        Product savedProduct = productService.addNewProduct(productMapper.toEntity(productDTO));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productMapper.toDTO(savedProduct));
    }

    @Operation(summary = "Get all products")
    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products =
                productService.getAllProducts()
                .stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(products);
    }

    @Operation(summary = "Delete product by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(
            @PathVariable String id
    ) {
        productService.deleteProduct(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        ApiResponse
                                .builder()
                                .message("OK")
                                .status(HttpStatus.OK.value())
                                .build()
                );
    }

}
