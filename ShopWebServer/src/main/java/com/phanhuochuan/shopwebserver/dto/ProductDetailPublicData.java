package com.phanhuochuan.shopwebserver.dto;

import lombok.*;

import java.util.List;


public class ProductDetailPublicData {
    private Long id;
    private String name;
    private String description;
    private String thumbnailUrl;
    private int reviewCount;
    private float rating;
    private String category;
    private List<ProductSkuPublicData> productSkuPublicList;
    private Boolean isInWishlist = false;

    public List<ProductSkuPublicData> getProductSkuPublicList() {
        return productSkuPublicList;
    }

    public void setProductSkuPublicList(List<ProductSkuPublicData> productSkuPublicList) {
        this.productSkuPublicList = productSkuPublicList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getInWishlist() {
        return isInWishlist;
    }

    public void setInWishlist(Boolean inWishlist) {
        isInWishlist = inWishlist;
    }
}
