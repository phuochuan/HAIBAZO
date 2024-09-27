package com.phanhuochuan.shopwebserver.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SkuSpecsId implements Serializable {
    private Long spuSpecs;
    private Long specsOption;
    private Long productSku;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkuSpecsId that = (SkuSpecsId) o;
        return spuSpecs.equals(that.spuSpecs) &&
                specsOption.equals(that.specsOption) &&
                productSku.equals(that.productSku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spuSpecs, specsOption, productSku);
    }
}
