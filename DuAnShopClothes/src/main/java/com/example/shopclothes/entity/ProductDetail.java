package com.example.shopclothes.entity;

import com.example.shopclothes.entity.propertis.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"idProduct", "idCategory", "idColor", "idMaterial", "idProducer", "idCartDetail", "billDetails","idSize"})
@Table(name = "ProductDetail")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private Double price;


    @Column(name = "dateCreate")
    private Date dateCreate;

    @Column(name = "dateUpdate")
    private Date dateUpdate;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    @JsonIgnore
    private Status status;

    @Column(name = "peopleUpdate")
    private String peopleUpdate;

    @Column(name = "people_create")
    private String people_create;


//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne()
    @JoinColumn(name = "idProduct")
    @JsonProperty("idProduct")
    private Product idProduct;



    @ManyToOne()
//    @JoinColumn(name = "idColor")
    @JoinColumn(name = "id_col")
    @JsonProperty("idColor")
    private Color idColor;

    @ManyToOne()
    @JoinColumn(name = "id_mate")
    @JsonProperty("idMaterial")
    private Material idMaterial;


    @ManyToOne()
    @JoinColumn(name = "id_size")
    @JsonProperty("idSize")
    private Size idSize;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idCtsp")
    List<BillDetail> billDetails;
}
