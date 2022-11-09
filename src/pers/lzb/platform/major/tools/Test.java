package pers.lzb.platform.major.tools;

import java.sql.*;

public class Test {
    //    public static void main(String[] args) {
    public static Statement connect(String username,String password) {


        String driverName = "com.mysql.cj.jdbc.Driver";

        String dbURL = "jdbc:mysql://localhost:3306/test?&useSSL=false&serverTimezone=Asia/Shanghai";
        // test_db 为数据库名

        String userName = "root";

        String userPwd = "123456";

        // 通过DriverManager类获得该连接对象才能访问数据库
        Connection connection = null;
        // 通过Connection获得该结果对象用于执行静态的SQL语句
        Statement statement = null;

        try {
            // 注册JDBC驱动
            Class.forName(driverName);

            // 数据库的连接：通过DriverManager类的getConnection方法，传入三个参数：数据库URL、用户名、用户密码，实例化connection对象
            connection = DriverManager.getConnection(dbURL, userName, userPwd);

            // 实例化statement对象
            statement = (Statement) connection.createStatement();

            // 定义数据库查询语句：查询new_table表中的name、sex两列数据
//            String sql = "SELECT Name,password FROM test.account";
            // 执行查询语句
//            ResultSet rSet = statement.executeQuery(sql);

//            // 展开查询到的数据
//            while (rSet.next()) {
//
//                // 这里getString()方法中的参数对应的是数据库表中的列名
//                String getName = rSet.getString("Name");
//                String getPassword = rSet.getString("password");
//
//                // 输出数据
//                System.out.print("名字:" + getName);
//                System.out.println("密码:" + getPassword);
//
//
//            }

//            statement.addBatch("insert  into account value (7,'tx','130')");  // 添加在Batch
//            statement.addBatch("insert  into account value (8,'bd','123')");
//            statement.addBatch("insert  into account value (9,'zj','13')");
//            statement.executeBatch();  // 添加在表
//            statement.executeUpdate("delete  from  account where idAccount='9'");  // 删除
//            statement.executeUpdate("update  account set Name='14' where idAccount='9'");  // 修改

            statement.executeUpdate("insert  into account value (12,username,password)");



            // 依次关闭对象
//            rSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return statement;


    }
}
//}

