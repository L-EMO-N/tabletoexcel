package com.lemon.table;

import com.lemon.table.entity.CreateTableInfo;
import com.lemon.table.entity.TableInfo;
import com.lemon.table.util.EasypoiUtil;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        String tableName = "tuprjectmanagerment";
        int index = 0;
        String[] fileName = {"common","system"};
        String[] databaseName = {"mw_20200107104215592695","mwsystemdb"};

        System.out.println("请输入表名和index。用,隔开:");

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.next();
            if(str.equals("exit")){
                System.exit(0);
            }
            String[] split = str.split(",");
            tableName = split[0];
            if(StringUtils.isNotBlank(split[1])){
                index = Integer.parseInt(split[1]);
            }

            Map<String,List> map = new HashMap<>();

            //查询表中各字段
            StringBuilder tableInfoBuilder = new StringBuilder("describe ");
            tableInfoBuilder.append(databaseName[index]).append(".").append(tableName);
            List<TableInfo> tableInfos = new QueryDatabase().getTableInfo(tableInfoBuilder.toString());
            map.put("TableInfo",tableInfos);

            //查询建表语句
            StringBuilder tableSqlBuilder = new StringBuilder("show create table ");
            tableSqlBuilder.append(databaseName[index]).append(".").append(tableName);
            List<CreateTableInfo> createTableInfos = new QueryDatabase().getCreateTableInfo(tableSqlBuilder.toString());
            map.put("Sql",createTableInfos);

            //文件保存路径
            StringBuilder pathBuilder = new StringBuilder();
            pathBuilder.append("C:\\Users\\lemon\\Desktop\\databaseExcel\\").append(fileName[index]).append("\\")
                    .append(tableName).append(".xls");
            EasypoiUtil.generateMultipleSheet(map,pathBuilder.toString());
            System.out.println("生成成功！！！！！");

            index = 0;
            System.out.println("请输入表名和index,用,隔开:");
        }



    }




}
