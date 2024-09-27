package com.phanhuochuan.shopwebserver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleProductPublicData {
    private Long id;
    private String name;
    private Float price;
    private Float realPrice;
    private String imgUrl;
    private Float rate;


    // Constructor
    public SimpleProductPublicData(Long id, String name, Float price, Float realPrice, String imgUrl, Object rate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.realPrice = realPrice;
        this.imgUrl = imgUrl;
        this.rate = Float.parseFloat(rate.toString());


    }
}