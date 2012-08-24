/**
 * create:2011年12月8日
 * lastmodify:2011年12月8日
 * @author mang
 * 功能：从mysql的openfire数据库的ofUser表中读出注册用户信息*/
package mang.database;

import java.sql.*;
public class testMysql {
  public static void main(String args[]) {
    try {
      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
      //Class.forName("org.gjt.mm.mysql.Driver");
     System.out.println("Success loading Mysql Driver!");
    }
    catch (Exception e) {
      System.out.print("Error loading Mysql Driver!");
      e.printStackTrace();
    }
    try {
      Connection connect = DriverManager.getConnection(
//          "jdbc:mysql://localhost:3306/openfire","root","123");
    		 "jdbc:mysql://202.201.14.104:3306/openfire","root","123");
           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

      System.out.println("Success connect Mysql server!");
      Statement stmt = connect.createStatement();
      System.out.println("openfire中注册的用户有");
      ResultSet rs = stmt.executeQuery("select * from ofUser");
                                                              //user 为你表的名称
      while (rs.next()) {
        System.out.println(rs.getString("username"));
      }
    }
    catch (Exception e) {
      System.out.print("get data error!");
      e.printStackTrace();
    }
  }
}

