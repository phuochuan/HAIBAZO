package com.phanhuochuan.shopwebserver.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "`SpuSpecs`")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SpuSpecs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
