package com.simplecrudop.serviceImpl;

import com.simplecrudop.dto.ProductDto;
import com.simplecrudop.entity.Product;
import com.simplecrudop.exception.ResourceNotFoundException;
import com.simplecrudop.repository.ProductRepository;
import com.simplecrudop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    private ProductDto convertToDTO(Product product){
       return ProductDto.builder()
               .id(product.getId())
               .name(product.getName())
               .price(product.getPrice())
               .quantity(product.getQuantity())
               .build();
    }
    private Product convertToEntity(ProductDto productDto){
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .build();
    }


    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = convertToEntity(productDto);
        return convertToDTO(productRepository.save(product));
    }

    @Override
    public ProductDto getProductById(Long prodcutId) {
        int x = 10/0;
        Product product = productRepository.findById(prodcutId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with given id DB: " + prodcutId));
        return convertToDTO(product);
    }

}



