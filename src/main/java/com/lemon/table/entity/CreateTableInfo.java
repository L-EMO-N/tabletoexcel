package com.lemon.table.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class CreateTableInfo {

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 建表语句
     */
    @Excel(name = "Sql",width = 200,height = 100,orderNum = "0")
    private String createTableSql;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getCreateTableSql() {
        return createTableSql;
    }

    public void setCreateTableSql(String createTableSql) {
        this.createTableSql = createTableSql;
    }
}
