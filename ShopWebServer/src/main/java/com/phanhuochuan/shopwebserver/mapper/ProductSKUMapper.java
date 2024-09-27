package com.phanhuochuan.shopwebserver.mapper;

import com.phanhuochuan.shopwebserver.dto.ProductSkuPublicData;
import com.phanhuochuan.shopwebserver.dto.SpuSpecsOptionPublicData;
import com.phanhuochuan.shopwebserver.dto.SpuSpecsPublicData;
import com.phanhuochuan.shopwebserver.entity.ProductSku;
import com.phanhuochuan.shopwebserver.entity.Resource;
import com.phanhuochuan.shopwebserver.entity.SkuSpecs;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductSKUMapper {
    ProductSKUMapper INSTANCE = Mappers.getMapper(ProductSKUMapper.class);

    @Mapping(source = "productSku", target ="realPrice", qualifiedByName = "computeRealPrice")
    @Mapping(source = "productSku.salesOffer.endAt", target = "endSaleDate")
    @Mapping(source = "resources", target = "resourceUrls",ignore = true) // Renamed here
    @Mapping(source = "skuSpecs", target = "spuSpecsPublicData", qualifiedByName = "toSpuSpecsPublicData")
    ProductSkuPublicData mapToProductSkuPublicData(ProductSku productSku);

    @Named("computeRealPrice")
    default float computeRealPrice(ProductSku productSku) {
        var so = productSku.getSalesOffer();
        if (so == null)
            return productSku.getSkuPrice();
        var proportion = so.getProportion();
        return (1 - proportion) * productSku.getSkuPrice();
    }

    @Named("toResources") // Renamed here
    default List<String> toResources(ProductSku productSku) { // Renamed here
        return productSku.getResources().stream().map(Resource::getUrl).toList();
    }

    @Named("toSpuSpecsPublicData")
    default List<SpuSpecsPublicData> toSpuSpecsPublicData(List<SkuSpecs> skuSpecs) {
        return skuSpecs.stream().map(spk -> new SpuSpecsPublicData(spk.getSpuSpecs().getId(), spk.getSpuSpecs().getName(), List.of(new SpuSpecsOptionPublicData(spk.getSpecsOption().getId(), spk.getSpecsOption().getValue())))).toList();
    }
}
