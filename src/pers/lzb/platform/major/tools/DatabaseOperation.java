package pers.lzb.platform.major.tools;

import java.io.IOException;
import java.sql.*;

public class DatabaseOperation {
    /**
     * 通过MySQL进行对账户信息的操作
     *
     * @param num      传入不同数字选择操作
     * @param id       账户id
     * @param username 用户名
     * @param password 密码
     * @author lzb
     */

    public static void connect(int num, int id, String username, String password) throws IOException {
        String driverName = "com.mysql.cj.jdbc.Driver";

        String dbURL = "jdbc:mysql://localhost:3306/test?&useSSL=false&serverTimezone=Asia/Shanghai";

        String userName = "root";
        String userPwd = "123456";
        // 通过DriverManager类获得该连接对象才能访问数据库
        Connection connection = null;
        // 通过Connection获得该结果对象用于执行静态的SQL语句
        Statement statement = null;

        Print print = new Print();
        try {
            // 注册JDBC驱动
            Class.forName(driverName);

            // 数据库的连接：通过DriverManager类的getConnection方法，传入三个参数：数据库URL、用户名、用户密码，实例化connection对象
            connection = DriverManager.getConnection(dbURL, userName, userPwd);

            // 实例化statement对象
            statement = (Statement) connection.createStatement();


            if (num == 1) {
                statement.executeUpdate("insert  into account value ('" + id + "','" + username + "','" + password + "')");
            } else if (num == 2) {
                statement.executeUpdate("delete  from  account where idAccount='" + id + "'");  // 删除
                print.printAndNote("删除成功","id为: "+id+" 的账户成功被注销");

            } else if (num == 3) {
                // 定义数据库查询语句：查询account表中的Name、password两列数据
                String sql = "SELECT idAccount,Name,password FROM test.account";
                // 执行查询语句
                ResultSet rSet = statement.executeQuery(sql);

                // 展开查询到的数据
                while (rSet.next()) {

                    // 这里getString()方法中的参数对应的是数据库表中的列名
                    String getIdAccount = rSet.getString("idAccount");
                    String getName = rSet.getString("Name");
                    String getPassword = rSet.getString("password");
                    // 输出数据
                    System.out.print("id: " + getIdAccount + " ");
                    System.out.print("名字:" + getName + " ");
                    System.out.println("密码:" + getPassword);

                }
                rSet.close();
            } else if (num == 4) {
                statement.executeUpdate("update  account set Name='" + username + "' ,"
                        + " password='" + password + "' where idAccount='" + id + "'");  // 修改
                print.printAndNote("修改成功","账户id的用户名被修改为: "+username+" 密码被修改为: "+password);
            }


            // 依次关闭对象
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}


