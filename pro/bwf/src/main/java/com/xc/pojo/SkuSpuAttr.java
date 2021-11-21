package com.xc.pojo;

public class SkuSpuAttr {
    private String key_id;
    private String key_name;
    private Long value_id;
    private String value_name;

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getKey_name() {
        return key_name;
    }

    public void setKey_name(String key_name) {
        this.key_name = key_name;
    }

    public Long getValue_id() {
        return value_id;
    }

    public void setValue_id(Long value_id) {
        this.value_id = value_id;
    }

    public String getValue_name() {
        return value_name;
    }

    public void setValue_name(String value_name) {
        this.value_name = value_name;
    }

    @Override
    public String toString() {
        return "{" +
                "\"key_id\"='" + key_id + '\'' +
                ", \"key_name\"='" + key_name + '\'' +
                ", \"value_id\"=" + value_id +
                ", \"value_name\"='" + value_name + '\'' +
                '}';
    }
}
