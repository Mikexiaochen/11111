package com.xc.service.Impl;

import com.xc.dao.BrandDao;
import com.xc.pojo.brand;
import com.xc.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl  implements BrandService {
    @Autowired
    private BrandDao brandDao;
    /**
     * 查询品牌列表
     * @return
     */
    @Override
    public List<brand> findBrand() {
        return brandDao.findBrand();
    }
}
