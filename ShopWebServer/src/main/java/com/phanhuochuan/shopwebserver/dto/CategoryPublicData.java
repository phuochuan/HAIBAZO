package com.phanhuochuan.shopwebserver.dto;

public record CategoryPublicData(
        Long id,
        String name,
        String description
) {
    public CategoryPublicData(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
