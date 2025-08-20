package com.simplecrudop.service;

import com.simplecrudop.dto.ProductDto;

public interface ProductService {
    ProductDto save(ProductDto productDto);

    ProductDto getProductById(Long prodcutId);

}
