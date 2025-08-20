package com.simplecrudop.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductDto {

    private Long id;
    private String name;
    private double price;
    private int quantity;

}
