package com.phanhuochuan.shopwebserver.dto;

import java.util.List;

public record SpuSpecsPublicData(
        Long id,
        String name,
        List<SpuSpecsOptionPublicData> options
) {
}
