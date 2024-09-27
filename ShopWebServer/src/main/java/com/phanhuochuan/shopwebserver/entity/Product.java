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
    @Column(length = 50)
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    @Column(length = 1000)
    private String description;
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String,String> attributes;
    private Boolean isDeleted;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Resource> resources;
    private String thumbnailUrl;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductSku> productSkus;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Review> reviews;



}
