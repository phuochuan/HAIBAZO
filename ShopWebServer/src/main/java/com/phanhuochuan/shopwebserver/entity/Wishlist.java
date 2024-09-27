package com.phanhuochuan.shopwebserver.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "`Wishlist`")
@IdClass(WishlistId.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Wishlist {

    @ManyToOne
    @Id
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @Id
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private boolean isOnList;
}
