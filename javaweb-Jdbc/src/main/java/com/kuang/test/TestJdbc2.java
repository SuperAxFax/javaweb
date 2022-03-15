package com.kuang.test;


import java.sql.*;

public class TestJdbc2 {
        public static void main(String[] args) throws ClassNotFoundException, SQLException {
            //配置信息
            String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
            String username = "root";
            String password = "123456";

            //1: 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2：连接数据库，代表数据库
            Connection connection = DriverManager.getConnection(url, username, password);
            ///3：编写SQL
            String sql = "insert into users(id,name,password,email,birthday) values (?,?,?,?,?);";
            //4：预编译
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,7);//给第一个占位符？的值赋值为1；
            preparedStatement.setString(2,"狂神说java");//给第二个占位符？的值赋值为“狂神说java”
            preparedStatement.setString(3,"123456");//给第三个占位符？的值赋值为123456
            preparedStatement.setString(4,"213456448@qq.com");//给第四个占位符？的值赋值为"213456448@qq.com"
            preparedStatement.setDate(5,new Date(new java.util.Date().getTime()));
            //5：执行SQL
            int i = preparedStatement.executeUpdate();
            if(i>0){
                System.out.println("插入成功");
            }

            //6：关闭连接，释放资源（一定要做）先开后关
            preparedStatement.close();
            connection.close();

        }
    }


