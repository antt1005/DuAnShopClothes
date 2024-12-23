package com.example.shopclothes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PDUpdateRequestDto {

    private Long productId;

    private Long sizeId;

    private Long materialId;

    private Long colorId;
}
