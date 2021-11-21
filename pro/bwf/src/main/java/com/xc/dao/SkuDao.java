package com.xc.dao;


import com.xc.pojo.Sku;
import com.xc.pojo.SkuSpuAttr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SkuDao {
    List<Sku> findSkuListBySpuId(@Param("spu_id")Long spu_id);
    List<SkuSpuAttr> findSkuSpuAttr(@Param("ids") String[] arrs);

    Sku findSkuBySpuIdAndSkuName(@Param("spu_id") Long spu_id,@Param("sku_name") String sku_name);

    /**
     * 插入当前的sku
     * @param sku_name
     * @param jsonArr
     * @param spu_id
     * @param skuprice
     * @param kucun
     */
    void insertSku(@Param("sku_name") String sku_name,@Param("sku_spuattr") String jsonArr,@Param("sku_spu_id") Long spu_id,@Param("sku_price") Double skuprice,@Param("sku_quantity") int kucun);
}
