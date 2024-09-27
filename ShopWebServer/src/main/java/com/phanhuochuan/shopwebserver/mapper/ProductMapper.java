package com.phanhuochuan.shopwebserver.mapper;

import com.phanhuochuan.shopwebserver.dto.ProductDetailPublicData;
import com.phanhuochuan.shopwebserver.dto.ProductSkuPublicData;
import com.phanhuochuan.shopwebserver.entity.Product;
import com.phanhuochuan.shopwebserver.entity.ProductSku;
import com.phanhuochuan.shopwebserver.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "product",target = "reviewCount", qualifiedByName = "countReviewQuality")
    @Mapping(source = "product",target = "rating", qualifiedByName = "computeRating")
    @Mapping(source = "product.category.name", target = "category")
    @Mapping(source = "product.productSkus", target = "productSkuPublicList", qualifiedByName = "mapToSKU")
    ProductDetailPublicData mapProductDetailPublicData(Product product);
    @Named("countReviewQuality")
    default int countReviewQuality(Product product) {
        List<Review> reviews = product.getReviews();
        return reviews != null ? reviews.size() : 0;
    }
    @Named("computeRating")
    default float computeRating(Product product) {
        List<Review> reviews = product.getReviews();
        if (reviews == null || reviews.isEmpty()) {
            return 0;
        }
        return (float) (reviews.stream().mapToDouble(Review::getRate).sum() / reviews.size());
    }
    @Named("mapToSKU")
    default List<ProductSkuPublicData> mapToSKU(List<ProductSku> productSkus){
        return productSkus.stream().map(ProductSKUMapper.INSTANCE::mapToProductSkuPublicData).toList();
    }
}
