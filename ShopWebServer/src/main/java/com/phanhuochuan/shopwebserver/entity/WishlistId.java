package com.phanhuochuan.shopwebserver.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import java.util.Objects;

@Setter
@Getter
public class WishlistId implements Serializable {
    private Long product;
    private String user;

    public WishlistId() {}

    public WishlistId(Long productId, String userId) {
        this.product = productId;
        this.user = userId;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WishlistId)) return false;
        WishlistId that = (WishlistId) o;
        return Objects.equals(product, that.product) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, user);
    }
}
