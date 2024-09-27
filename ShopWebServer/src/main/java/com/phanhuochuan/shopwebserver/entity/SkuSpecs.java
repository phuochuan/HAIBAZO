package com.phanhuochuan.shopwebserver.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "`SkuSpecs`")
@IdClass(SkuSpecsId.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SkuSpecs {

    @Id
    @ManyToOne
    @JoinColumn(name = "spuSpecs_id")
    private SpuSpecs spuSpecs;

    @Id
    @ManyToOne
    @JoinColumn(name = "specsOption_id")
    private SpecsOption specsOption;

    @Id
    @ManyToOne
    @JoinColumn(name = "productSku_id")
    private ProductSku productSku;
}

