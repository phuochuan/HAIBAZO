package com.phanhuochuan.shopwebserver.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @ManyToMany
    private List<Product> products;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "spuSpecs")
    private List<SpecsOption> specsOptions;
}
