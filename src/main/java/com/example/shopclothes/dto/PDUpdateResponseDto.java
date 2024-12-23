package com.example.shopclothes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PDUpdateResponseDto {

    private  Long id;
    private  Integer quantity;
    private  Double price;
}
