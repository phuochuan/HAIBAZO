package com.phanhuochuan.shopwebserver.db.repo;

import com.phanhuochuan.shopwebserver.dto.SpuSpecsPublicData;
import com.phanhuochuan.shopwebserver.entity.SpuSpecs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpuSpecsRepository extends JpaRepository<SpuSpecs, Long> {

}
