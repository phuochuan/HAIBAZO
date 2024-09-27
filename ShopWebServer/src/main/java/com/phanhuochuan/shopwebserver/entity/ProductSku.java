package com.phanhuochuan.shopwebserver.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "`ProductSku`")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProductSku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 40)
    private String skuNo;
    @Column(length = 100)
    private String skuName;
    @Column(length = 1000)
    private String skuDesc;
    @Column(length = 100)
    @Enumerated(EnumType.STRING)
    private ProductStatus skuStatus;
    private Integer skuStock;
    private Float skuPrice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "productSku")
    private List<Resource> resources;

    @ManyToOne
    @JoinColumn(name = "sales_offder_id")
    private SalesOffer salesOffer;



}
