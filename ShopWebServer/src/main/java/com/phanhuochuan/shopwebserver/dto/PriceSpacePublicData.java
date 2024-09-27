package com.phanhuochuan.shopwebserver.dto;

public record PriceSpacePublicData(
        Float maximumPrice,
        Float minimalPrice

) {
    public PriceSpacePublicData(Float maximumPrice, Float  minimalPrice) {
        this.minimalPrice = minimalPrice;
        this.maximumPrice = maximumPrice;
    }
}
