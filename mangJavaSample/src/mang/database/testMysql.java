/**
 * create:2011��12��8��
 * lastmodify:2011��12��8��
 * @author mang
 * ���ܣ���mysql��openfire���ݿ��ofUser���ж���ע���û���Ϣ*/
package mang.database;

import java.sql.*;
public class testMysql {
  public static void main(String args[]) {
    try {
      Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
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
           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������

      System.out.println("Success connect Mysql server!");
      Statement stmt = connect.createStatement();
      System.out.println("openfire��ע����û���");
      ResultSet rs = stmt.executeQuery("select * from ofUser");
                                                              //user Ϊ��������
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

