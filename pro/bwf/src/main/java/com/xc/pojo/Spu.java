package com.xc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Spu {
    private Long spu_id;
    private String spu_name;
    private String spu_title;
    private String spu_introduction;
    private String spu_unit;
    private Integer spu_status;
    private Date createtime;
    private Date updatetime;
    private String spu_brand_id;
    private brand brand;
    //当前商品的sku列表
    private List<Sku> skuList=new ArrayList<>();
    //当前商品的属性键列表
    private List<SpuAttrKey> spuAttrKeyList=new ArrayList<>();

    private List<SpuAttrValueSpus> spuAttrValueSpusList=new ArrayList<>();

    public List<SpuAttrValueSpus> getSpuAttrValueSpusList() {
        return spuAttrValueSpusList;
    }

    public void setSpuAttrValueSpusList(List<SpuAttrValueSpus> spuAttrValueSpusList) {
        this.spuAttrValueSpusList = spuAttrValueSpusList;
    }

    public List<Sku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<Sku> skuList) {
        this.skuList = skuList;
    }

    public List<SpuAttrKey> getSpuAttrKeyList() {
        return spuAttrKeyList;
    }

    public void setSpuAttrKeyList(List<SpuAttrKey> spuAttrKeyList) {
        this.spuAttrKeyList = spuAttrKeyList;
    }

    public brand getBrand() {
        return brand;
    }

    public void setBrand(brand brand) {
        this.brand = brand;
    }

    public Long getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(Long spu_id) {
        this.spu_id = spu_id;
    }

    public String getSpu_name() {
        return spu_name;
    }

    public void setSpu_name(String spu_name) {
        this.spu_name = spu_name;
    }

    public String getSpu_title() {
        return spu_title;
    }

    public void setSpu_title(String spu_title) {
        this.spu_title = spu_title;
    }

    public String getSpu_introduction() {
        return spu_introduction;
    }

    public void setSpu_introduction(String spu_introduction) {
        this.spu_introduction = spu_introduction;
    }

    public String getSpu_unit() {
        return spu_unit;
    }

    public void setSpu_unit(String spu_unit) {
        this.spu_unit = spu_unit;
    }

    public Integer getSpu_status() {
        return spu_status;
    }

    public void setSpu_status(Integer spu_status) {
        this.spu_status = spu_status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getSpu_brand_id() {
        return spu_brand_id;
    }

    public void setSpu_brand_id(String spu_brand_id) {
        this.spu_brand_id = spu_brand_id;
    }

    @Override
    public String toString() {
        return "Spu{" +
                "spu_name='" + spu_name + '\'' +
                ", spuAttrKeyList=" + spuAttrKeyList +
                '}';
    }
}
