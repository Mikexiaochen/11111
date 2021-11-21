package com.xc.service;

import com.xc.pojo.Spu;
import com.xc.pojo.Vo;

import java.util.List;

public interface SpuService {
    /**
     * 获取所有的商品列表
     * @return
     */
    List<Spu> getSpuList();

    /**
     * 保存spu页面获取的值，并更新
     * @param spu
     * @param spu_brand_id
     * @param cate_id
     * @param value_id
     * @param vo
     */
    void saveSpu(Spu spu, String spu_brand_id, Integer cate_id, Integer[] value_id, Vo vo);

    Spu getSpuById(Long spu_id);
}
