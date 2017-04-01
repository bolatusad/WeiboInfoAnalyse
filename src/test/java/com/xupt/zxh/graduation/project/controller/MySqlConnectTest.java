package com.xupt.zxh.graduation.project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by 张涛 on 2017/3/14.
 */
public class MySqlConnectTest {
    public static void main(String[] args) {
        try{
            //加载MySql的驱动类
            Class.forName("com.mysql.jdbc.Driver") ;
        }catch(ClassNotFoundException e){
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace() ;
        }
        //连接MySql数据库，用户名和密码都是root
        String url = "jdbc:mysql://123.207.11.170:3306/weibo" ;
        String username = "root" ;
        String password = "Taojiayou921+++" ;
        try{
            Connection con = DriverManager.getConnection(url , username , password ) ;
            System.out.println(con);
        }catch(SQLException se){
            System.out.println("数据库连接失败！");
            se.printStackTrace() ;
        }
    }
}
