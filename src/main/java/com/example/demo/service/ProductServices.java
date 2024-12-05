package com.example.demo.service;

import com.example.shopclothes.dto.*;
import com.example.shopclothes.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductServices {
    public Product add(Product sanPham);

    public Product detail(Long id);

    public List<Product> finByName();

    public Page<ProductFilterResponseDto> findProductsAdminByFilters(ProductDetailFilterRequestDto requestDto, Pageable pageable);

    public Product createProduct(ProductRequestDto productRequestDto);

    public Boolean updateProduct(ProductRequestDto productRequestDto, Long id);

    public Product findProductById(Long productId);

    public Boolean deleteProduct(Long id);

    public List<Product> findAllByDeletedTrue();

    public Page<ProductUserResponseDto> getHomePageProduct(Pageable page);

    public List<Top10SaleResponseDto> findByTop10Sell();

    public Integer getToatalStockInstore(LocalDateTime starDate, LocalDateTime endDate);
}
