package com.xc.service;

import com.xc.pojo.Sku;

public interface SkuService {
    Sku findSku(String[] arrs, Long spu_id);

    String saveSku(String[] vids, Long spu_id, Double skuprice, int kucun);
}
