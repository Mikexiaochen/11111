package com.xc.pojo;

import java.util.Date;

public class Sku {
    private Long sku_id;
    private Long sku_spu_id;
    private String sku_name;
    private String sku_spuattr;
    private Double sku_price;
    private Double sku_originalprice;
    private Double sku_costprice;
    private Integer sku_quantity;
    private Integer sortno;
    private Date createtime;
    private Date updatetime;

    public Long getSku_id() {
        return sku_id;
    }

    public void setSku_id(Long sku_id) {
        this.sku_id = sku_id;
    }

    public Long getSku_spu_id() {
        return sku_spu_id;
    }

    public void setSku_spu_id(Long sku_spu_id) {
        this.sku_spu_id = sku_spu_id;
    }

    public String getSku_name() {
        return sku_name;
    }

    public void setSku_name(String sku_name) {
        this.sku_name = sku_name;
    }

    public String getSku_spuattr() {
        return sku_spuattr;
    }

    public void setSku_spuattr(String sku_spuattr) {
        this.sku_spuattr = sku_spuattr;
    }

    public Double getSku_price() {
        return sku_price;
    }

    public void setSku_price(Double sku_price) {
        this.sku_price = sku_price;
    }

    public Double getSku_originalprice() {
        return sku_originalprice;
    }

    public void setSku_originalprice(Double sku_originalprice) {
        this.sku_originalprice = sku_originalprice;
    }

    public Double getSku_costprice() {
        return sku_costprice;
    }

    public void setSku_costprice(Double sku_costprice) {
        this.sku_costprice = sku_costprice;
    }

    public Integer getSku_quantity() {
        return sku_quantity;
    }

    public void setSku_quantity(Integer sku_quantity) {
        this.sku_quantity = sku_quantity;
    }

    public Integer getSortno() {
        return sortno;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
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
}
