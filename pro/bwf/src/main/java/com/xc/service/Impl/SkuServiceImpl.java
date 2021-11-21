package com.xc.service.Impl;

import com.xc.dao.SkuDao;
import com.xc.pojo.Sku;
import com.xc.pojo.SkuSpuAttr;
import com.xc.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    private SkuDao skuDao;

    @Override
    //根据当前三个属性值，去查询指定的key 和value的值
    public Sku findSku(String[] arrs, Long spu_id) {

        //根据当前三个属性值，去查询指定的key 和value的值
        List<SkuSpuAttr> attrList=skuDao.findSkuSpuAttr(arrs);
        //查询完成以后，将key和value的值封装成对象SkuSpuAttr 理解成对应着我们数据库中数组中的一个json对象
        String jsonArr=attrList.toString();
        System.out.println(jsonArr);
        String sku_name="";
        for (SkuSpuAttr ssa:attrList
        ) {
            sku_name+=ssa.getKey_name()+ssa.getValue_name();
        }
        System.out.println(sku_name);
        //根据skuname查询这个商品的这条sku是否存在
        Sku sku=skuDao.findSkuBySpuIdAndSkuName(spu_id,sku_name);

        return sku;
    }

    @Override
    //根据当前选择的属性值，判断数据库是否有这条sku，如果有的话，返回1，代表已经存在不需要添加
    //根据当前三个属性值，去查询指定的key 和value的值
    public String saveSku(String[] vids, Long spu_id, Double skuprice, int kucun) {
        //根据当前选择的属性值，判断数据库是否有这条sku，如果有的话，返回1，代表已经存在不需要添加
        //根据当前三个属性值，去查询指定的key 和value的值
        List<SkuSpuAttr> attrList=skuDao.findSkuSpuAttr(vids);
        //查询完成以后，将key和value的值封装成对象SkuSpuAttr 理解成对应着我们数据库中数组中的一个json对象
        String jsonArr=attrList.toString();
        System.out.println(jsonArr);
        //如果没有的话，再做添加操作
        String sku_name="";
        for (SkuSpuAttr ssa:attrList
        ) {
            sku_name+=ssa.getKey_name()+ssa.getValue_name();
        }
        System.out.println(sku_name);
        //根据skuname查询这个商品的这条sku是否存在
        Sku sku=skuDao.findSkuBySpuIdAndSkuName(spu_id,sku_name);

        //如果存在，则返回0，否则做插入操作1
        if(sku==null){
            //插入当前spu指定的sku
            skuDao.insertSku(sku_name,jsonArr,spu_id,skuprice,kucun);
            return "1";
        }
        return "0";
    }
}
