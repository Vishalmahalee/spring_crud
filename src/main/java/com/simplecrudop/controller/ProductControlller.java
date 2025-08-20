package com.simplecrudop.controller;

import com.simplecrudop.dto.ProductDto;
import com.simplecrudop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crude")
public class ProductControlller {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ProductDto saveProduct(@RequestBody ProductDto productDto){

        return  productService.save(productDto);
    }
}

