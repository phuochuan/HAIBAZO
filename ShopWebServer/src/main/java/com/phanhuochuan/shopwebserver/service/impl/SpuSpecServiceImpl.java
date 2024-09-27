package com.phanhuochuan.shopwebserver.service.impl;

import com.phanhuochuan.shopwebserver.db.repo.SpuSpecsRepository;
import com.phanhuochuan.shopwebserver.dto.SpuSpecsOptionPublicData;
import com.phanhuochuan.shopwebserver.dto.SpuSpecsPublicData;
import com.phanhuochuan.shopwebserver.service.SpuSpecService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpuSpecServiceImpl implements SpuSpecService {
    private final SpuSpecsRepository specsRepository;

    @Override
    public List<SpuSpecsPublicData> getAll() {
        return specsRepository.findAll().stream().map(
                spuSpecs ->
                        new SpuSpecsPublicData(spuSpecs.getId(), spuSpecs.getName(), spuSpecs.getSpecsOptions().stream().map(specsOption -> new SpuSpecsOptionPublicData(specsOption.getId(), specsOption.getValue())).toList())

        ).toList();
    }
}
