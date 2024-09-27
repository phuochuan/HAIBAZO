package com.phanhuochuan.shopwebserver.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "`SalesOffer`")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SalesOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float proportion;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
}
