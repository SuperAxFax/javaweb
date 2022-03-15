package com.kuang.test;

import org.junit.Test;

import java.sql.*;

public class TestJdbc3 {
    @Test
    public void test() throws SQLException {

    //配置信息
    String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
    String username = "root";
    String password = "123456";

    Connection connection = null;
    //1: 加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");

        //2：连接数据库，代表数据库
            connection = DriverManager.getConnection(url, username, password);
       //3：通知数据库开启事务，false开启
            connection.setAutoCommit(false);

            String sql1 = "update account set money = money-100 where name= 'A';";
            connection.prepareStatement(sql1).executeUpdate();
            connection.commit();
        //制造错误
           /* int i = 1/0;*/
            String sql2 = "update account set money = money + 100 where name= 'B';";
            connection.prepareStatement(sql2).executeUpdate();
            connection.commit();
            System.out.println("success");
        } catch (ClassNotFoundException e) {
            connection.rollback();
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
    }
}