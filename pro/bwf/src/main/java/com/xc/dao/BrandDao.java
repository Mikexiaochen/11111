package com.xc.dao;

import com.xc.pojo.brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandDao {
    List<brand> findBrand();

    brand findBrandById(@Param("brand_id") Integer spu_brand_id);
}
