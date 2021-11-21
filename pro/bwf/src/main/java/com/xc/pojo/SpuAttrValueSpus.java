package com.xc.pojo;

public class SpuAttrValueSpus {
    private Integer id;
    private Long spu_attr_value_id;
    private String spu_attr_imgs;
    private Long spu_id;
    private String value_name;

    public String getValue_name() {
        return value_name;
    }

    public void setValue_name(String value_name) {
        this.value_name = value_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getSpu_attr_value_id() {
        return spu_attr_value_id;
    }

    public void setSpu_attr_value_id(Long spu_attr_value_id) {
        this.spu_attr_value_id = spu_attr_value_id;
    }

    public String getSpu_attr_imgs() {
        return spu_attr_imgs;
    }

    public void setSpu_attr_imgs(String spu_attr_imgs) {
        this.spu_attr_imgs = spu_attr_imgs;
    }

    public Long getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(Long spu_id) {
        this.spu_id = spu_id;
    }

    @Override
    public String toString() {
        return "SpuAttrValueSpus{" +
                "id=" + id +
                ", spu_attr_value_id=" + spu_attr_value_id +
                ", spu_attr_imgs='" + spu_attr_imgs + '\'' +
                ", spu_id=" + spu_id +
                '}';
    }
}
