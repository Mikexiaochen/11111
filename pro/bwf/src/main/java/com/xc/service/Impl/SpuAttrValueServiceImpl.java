package com.xc.service.Impl;

import com.xc.dao.SpuAttrValueDao;
import com.xc.pojo.SpuAttrValue;
import com.xc.service.SpuAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuAttrValueServiceImpl implements SpuAttrValueService {
    @Autowired
    private SpuAttrValueDao spuAttrValueDao;

    /**
     * 根据id获取属性值
     * @param key_id
     * @return
     */
    @Override
    public List<SpuAttrValue> findValueById(String key_id) {
        return spuAttrValueDao.findValueById(key_id);
    }
}
