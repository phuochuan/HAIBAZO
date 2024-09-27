package com.phanhuochuan.shopwebserver.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "`SpecsOption`")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SpecsOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String value;

    @ManyToOne
    @JoinColumn(name = "spu_specs_id")
    private SpuSpecs spuSpecs;

}
