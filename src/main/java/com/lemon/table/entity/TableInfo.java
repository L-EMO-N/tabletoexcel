package com.lemon.table.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class TableInfo {

    /**
     * 字段名称
     */
    @Excel(name = "Field",width =25 ,orderNum = "0")
    private String field;

    /**
     * 字段类型
     */
    @Excel(name = "Type",width = 25,orderNum = "1")
    private String type;
    /**
     * 是否为null
     */
    @Excel(name = "Null",orderNum = "2")
    private String nullValue;

    /**
     * 主键类型
     */
    @Excel(name = "Key",width = 25,orderNum = "3")
    private String key;

    /**
     * 默认值
     */
    @Excel(name = "Default",width = 25,orderNum = "4")
    private String defaultValue;

    /**
     * 补充信息
     */
    @Excel(name = "Extra",width = 25,orderNum = "5")
    private String extra;


    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNullValue() {
        return nullValue;
    }

    public void setNullValue(String nullValue) {
        this.nullValue = nullValue;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "TableInfo{" +
                "field='" + field + '\'' +
                ", type='" + type + '\'' +
                ", nullValue='" + nullValue + '\'' +
                ", key='" + key + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                ", extra='" + extra + '\'' +
                '}';
    }
}
