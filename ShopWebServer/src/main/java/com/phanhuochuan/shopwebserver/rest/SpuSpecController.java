package com.phanhuochuan.shopwebserver.rest;

import com.phanhuochuan.shopwebserver.dto.SpuSpecsPublicData;
import com.phanhuochuan.shopwebserver.service.SpuSpecService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/spu-specs")
@RequiredArgsConstructor
public class SpuSpecController {
    private final SpuSpecService spuSpecService;
    @GetMapping
    public List<SpuSpecsPublicData> getSpuSpecsPublicData() {
        return spuSpecService.getAll();
    }
}
