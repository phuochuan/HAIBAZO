package com.phanhuochuan.shopwebserver.dto;

import com.phanhuochuan.shopwebserver.entity.ProductStatus;

import java.time.LocalDate;
import java.util.List;

public class ProductSkuPublicData {
    private Long id;
    private ProductStatus skuStatus;
    private String skuDesc;
    private String skuNo;
    private String skuName;
    private Float skuPrice;
    private Float realPrice;
    private LocalDate endSaleDate;
    private List<String> resourceUrls;
    private int skuStock;
    List<SpuSpecsPublicData> spuSpecsPublicData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductStatus getSkuStatus() {
        return skuStatus;
    }

    public void setSkuStatus(ProductStatus skuStatus) {
        this.skuStatus = skuStatus;
    }

    public String getSkuDesc() {
        return skuDesc;
    }

    public void setSkuDesc(String skuDesc) {
        this.skuDesc = skuDesc;
    }

    public String getSkuNo() {
        return skuNo;
    }

    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Float getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(Float skuPrice) {
        this.skuPrice = skuPrice;
    }

    public Float getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Float realPrice) {
        this.realPrice = realPrice;
    }

    public LocalDate getEndSaleDate() {
        return endSaleDate;
    }

    public void setEndSaleDate(LocalDate endSaleDate) {
        this.endSaleDate = endSaleDate;
    }

    public List<String> getResourceUrls() {
        return resourceUrls;
    }

    public void setResourceUrls(List<String> resourceUrls) {
        this.resourceUrls = resourceUrls;
    }

    public int getSkuStock() {
        return skuStock;
    }

    public void setSkuStock(int skuStock) {
        this.skuStock = skuStock;
    }

    public List<SpuSpecsPublicData> getSpuSpecsPublicData() {
        return spuSpecsPublicData;
    }

    public void setSpuSpecsPublicData(List<SpuSpecsPublicData> spuSpecsPublicData) {
        this.spuSpecsPublicData = spuSpecsPublicData;
    }
}
