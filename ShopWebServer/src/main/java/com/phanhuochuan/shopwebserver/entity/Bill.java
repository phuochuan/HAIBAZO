package com.phanhuochuan.shopwebserver.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "`Review`")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer discount;
    private float payment;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_sku_id", nullable = false)
    private ProductSku productSku;
}
