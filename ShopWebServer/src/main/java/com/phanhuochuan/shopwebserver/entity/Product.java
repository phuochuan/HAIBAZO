package com.phanhuochuan.shopwebserver.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "`Product`")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    private String description;
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String,String> attributes;
    private Boolean isDeleted;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private List<Resource> resources;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductSku> productSkus;

}
