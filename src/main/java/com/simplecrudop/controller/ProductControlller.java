package com.simplecrudop.controller;

import com.simplecrudop.dto.ProductDto;
import com.simplecrudop.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductControlller {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductDto> saveProduct( @Valid @RequestBody ProductDto productDto){

        return ResponseEntity.ok(productService.save(productDto));
    }
    @GetMapping("/byId/{prodcutId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long prodcutId ){
        ProductDto productyById = productService.getProductById(prodcutId);
        return ResponseEntity.ok(productyById);
    }
}

