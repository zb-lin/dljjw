package pers.lzb.platform.npc.trunk;

import pers.lzb.platform.major.tools.io.Print;
import pers.lzb.platform.major.tools.io.WriteNum;

import java.io.IOException;
import java.sql.*;


public class NpcDatabase {


    public static void npcDatabase(int num, String id, String shopName, String food, String price) throws IOException {
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
                statement.executeUpdate("insert  into npc value ('"+id+"','" + shopName + "','" + food + "','" + price + "')");
              WriteNum writeNum = new WriteNum();
              writeNum.writeNum();
            } else if (num == 2) {
                statement.executeUpdate("delete  from  npc where id='" + id + "'");  // 删除
                print.printAndNote("删除成功", "id为: " + id + " 的菜成功被删除");

            } else if (num == 3) {
                // 定义数据库查询语句：查询account表中的Name、password两列数据
                String sql = "SELECT id,shopName,food,price FROM test.npc";
                // 执行查询语句
                ResultSet rSet = statement.executeQuery(sql);

                // 展开查询到的数据
                while (rSet.next()) {

                    // 这里getString()方法中的参数对应的是数据库表中的列名
                    String getId = rSet.getString("id");
                    String getshopName = rSet.getString("shopName");
                    String getFood = rSet.getString("food");
                    String getPrice = rSet.getString("price");
                    // 输出数据
                    System.out.print("编号: " + getId + " ");
                    System.out.print("店名:" + getshopName + " ");
                    System.out.print("菜名:" + getFood);
                    System.out.println("价格:" + getPrice);

                }
                rSet.close();
            } else if (num == 4) {
                statement.executeUpdate("update  npc set shopName='" + shopName + "' ,"
                        + " food='" + food + "' where id='" + id + "'");  // 修改
                print.printAndNote("修改成功", "编号为 " + id + " 的信息被修改为: 店名: " + shopName + " 菜名: " + food + "价格: " + price);
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



