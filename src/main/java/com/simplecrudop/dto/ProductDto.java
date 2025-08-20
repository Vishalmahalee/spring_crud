package com.simplecrudop.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    @NotBlank(message="Product name is required")
    private String name;
    @Min(value = 1, message = "Price must be at least 1")
    private double price;
    @Min(value = 1,message = "Quantity must be least 1")
    private int quantity;

}
