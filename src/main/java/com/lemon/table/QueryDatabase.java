package com.lemon.table;

import com.lemon.table.entity.CreateTableInfo;
import com.lemon.table.entity.TableInfo;
import com.lemon.table.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class QueryDatabase {

    private   Connection connection;

    private   PreparedStatement preparedStatement;

    private   ResultSet resultSet;


    /**
     * 初始化
     * @param sql
     */
    private void init(String sql){
        connection = JdbcUtil.getConnection();
        preparedStatement = JdbcUtil.getPredStatement(connection,sql);
        resultSet = JdbcUtil.excuteSql(preparedStatement);
    }

    /**
     * 关闭连接
     */
    private void close(){
        JdbcUtil.close(connection,preparedStatement,resultSet);
    }

    /**
     * describe tablename
     * 获取表的字段信息
     * @param sql
     * @return
     */
    public  List<TableInfo> getTableInfo(String sql){
        init(sql);
        List<TableInfo> list = new LinkedList<>();
        try {
            while(resultSet.next()){
    //            resultSet.
                TableInfo tableInfo = new TableInfo();
                tableInfo.setField(resultSet.getString(1));
                tableInfo.setType(resultSet.getString(2));
                tableInfo.setNullValue(resultSet.getString(3));
                tableInfo.setKey(resultSet.getString(4));
                tableInfo.setDefaultValue(resultSet.getString(5));
                tableInfo.setExtra(resultSet.getString(6));
                list.add(tableInfo);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return list;
    }

    /**
     * 获取建表语句
     * show create table tablename
     * @param sql
     * @return
     */
    public List<CreateTableInfo> getCreateTableInfo(String sql){
        init(sql);
        List<CreateTableInfo> list = new LinkedList<>();
        try {
            while(resultSet.next()){
                CreateTableInfo createTableInfo = new CreateTableInfo();
                createTableInfo.setCreateTableSql(resultSet.getString(2));
                list.add(createTableInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return list;
    }
}
