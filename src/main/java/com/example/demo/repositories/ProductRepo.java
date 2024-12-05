package com.example.demo.repositories;

import com.example.shopclothes.dto.ProductFilterResponseDto;
import com.example.shopclothes.dto.Top10SaleResponseDto;
import com.example.shopclothes.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository

public interface ProductRepo extends JpaRepository<Product, Long> {

    @Modifying
    @Transactional
    @Query(value = "update Product set status = 0 where id = ?1", nativeQuery = true)
    void delete(Long id);

    @Query("SELECT c FROM Product c WHERE c.status = 'DANG_HOAT_DONG' ORDER BY c.dateCreate DESC")
    List<Product> findByName();

    Boolean existsByProductName(String productName);

    @Query("SELECT new com.example.shopclothes.dto.ProductFilterResponseDto(" +
            "p.id, i.imageLink, p.productName, c.categoryName, s.producerName, p.discribe, SUM(pd.quantity) AS quantityTotal, pd.price, p.status, p.dateCreate, p.dateUpdate) " +
            "FROM Product p " +
            "JOIN Imege i ON i.product.id = p.id " +
            "JOIN ProductDetail pd ON pd.idProduct.id = p.id " +
            "JOIN Category c ON c.id = p.idCategory.id " +
            "JOIN Producer s ON s.id = p.idProducer.id " +
            "WHERE (:colorId IS NULL OR pd.idColor.id = :colorId) " +
            "AND (:sizeId IS NULL OR pd.idSize.id = :sizeId) " +
            "AND i.status = 'DANG_HOAT_DONG' " +
            "AND (:materialId IS NULL OR pd.idMaterial.id = :materialId) " +
            "AND (:priceMin IS NULL OR pd.price >= :priceMin) " +
            "AND (:priceMax IS NULL OR pd.price <= :priceMax) " +
            "AND (:categoryId IS NULL OR p.idCategory.id = :categoryId) " +
            "AND ((:keyword IS NULL) OR (p.productName LIKE %:keyword%) OR CAST(p.id AS STRING) = :keyword) " +
            "GROUP BY p.id, i.imageLink, p.productName, c.categoryName, s.producerName,pd.price,p.discribe, p.status, p.dateCreate, p.dateUpdate " +
            "ORDER BY p.dateCreate DESC")
    Page<ProductFilterResponseDto> findProductsAdminByFilters(
            @Param("colorId") Long colorId,
            @Param("sizeId") Long sizeId,
            @Param("materialId") Long materialId,
            @Param("priceMin") Double priceMin,
            @Param("priceMax") Double priceMax,
            @Param("categoryId") Long categoryId,
            @Param("keyword") String keyword,
            Pageable pageable);


    @Query("SELECT p FROM Product p WHERE p.status =  'DANG_HOAT_DONG' ORDER BY p.dateCreate DESC")
    List<Product> findAllByDeletedTrue();

    @Query("SELECT new com.example.shopclothes.dto.Top10SaleResponseDto( i.imageLink, p.productName,SUM(od.quantity),SUM(od.quantity * od.price)) " +
            "FROM OrderDetail od " +
            "JOIN ProductDetail pd on pd.id = od.productDetail.id " +
            "JOIN Product p on p.id = pd.idProduct.id " +
            "JOIN Imege i on i.product.id = p.id " +
            "JOIN Order o on o.id = od.order.id " +
            "WHERE  i.status = 'DANG_HOAT_DONG' AND o.orderStatus.statusName = 'Hoàn thành' " +
            "GROUP BY i.imageLink, p.productName " +
            "ORDER BY SUM(od.quantity) DESC " +
            "LIMIT 10")
    List<Top10SaleResponseDto> findTop10BestSellingProducts();

    @Query("SELECT COALESCE(SUM(pd.quantity), 0) " +
            "FROM Product p " +
            "JOIN ProductDetail pd ON pd.idProduct.id = p.id " +
            "WHERE p.status = 'DANG_HOAT_DONG' " +
            "AND pd.status = 'DANG_HOAT_DONG' " +
            "AND (:startDate IS NULL OR pd.dateCreate >= :startDate) " +
            "AND (:endDate IS NULL OR pd.dateCreate <= :endDate)")
    Integer getTotalStockQuantityInDateRange(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

}
