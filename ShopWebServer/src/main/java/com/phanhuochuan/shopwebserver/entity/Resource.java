package com.phanhuochuan.shopwebserver.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "`Resource`")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500)
    private String url;
    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "product_sku_id")
    private ProductSku productSku;
}
