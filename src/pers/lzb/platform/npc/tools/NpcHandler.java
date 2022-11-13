package pers.lzb.platform.npc.tools;

import pers.lzb.platform.account.tools.AccountHandler;
import pers.lzb.platform.account.tools.Print;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class NpcHandler {

    /**
     * 添加菜品
     *
     * @author lzb
     */
    public void addFood(Connection connection) throws IOException, SQLException {
        Statement statement = connection.createStatement();
        Scanner sc = new Scanner(System.in);
        Print print = new Print();

        print.print("请输入菜的编号:");
        String id = sc.nextLine();

        String sql = " select id from npc where id=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);  // 给sql语句的第1个问号赋值
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next() && this.judgeInt(id)) {
            print.print("该编号不可用");
        } else {
            print.print("请输入店名");
            String shopName = sc.nextLine();
            print.print("请输入菜名");
            String foodName = sc.nextLine();
            print.print("请输入价格");
            int price = sc.nextInt();
            print.print("请输入美食数量");
            int quantity = sc.nextInt();


            statement.executeUpdate("insert  into npc value ('" + id + "','" + shopName + "','" + foodName + "','" + price + "','" + quantity + "')");
            print.printAndNote("您的菜品已添加成功!", AccountHandler.ID + ": " + "菜品添加成功,店名为: "
                    + shopName + " 菜名为: " + foodName + " 价格为: " + price + " 数量为: " + quantity);


        }


    }


    /**
     * 删除菜品
     *
     * @author lzb
     */
    public void deleteFood(Connection connection) throws IOException, SQLException {

        Print print = new Print();
        Scanner sc = new Scanner(System.in);

        print.print("输入你想删除的菜品的编号！");
        String id = sc.nextLine();


        String sql = "select id from npc where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String sql2 = "delete from npc where id = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
            preparedStatement1.setString(1, id);
            preparedStatement1.executeUpdate();
            print.printAndNote("删除成功！", AccountHandler.ID + " 删除编号为 " + id + " 的菜品 ");
        } else {
            print.print("未找到该菜品!");
        }
    }


    /**
     * 查询菜名
     *
     * @author lzb
     */

    public void findFood(Connection connection) throws IOException, SQLException {
        Print print = new Print();
        Scanner sc = new Scanner(System.in);
        print.print("请输入要查询的菜品的编号");
        String id = sc.nextLine();
        String sql1 = " select id ,shopName,food,price,quantity from npc where id= ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        preparedStatement.setString(1, id);
        ResultSet res = preparedStatement.executeQuery();
        if (res.next()) {
            print.note(AccountHandler.ID + "查找id为" + id + "的菜的信息");
            print.print("编号  店名  菜名  价格  数量");
            print.printAndNote(res.getString("id") + " " + res.getString("shopName")
                    + " " + res.getString("food") + " " + res.getString("price")
                    + " " + res.getString("quantity"), AccountHandler.ID + "查找菜品: " +
                    res.getString("id") + " " + res.getString("shopName") + " " +
                    res.getString("food") + " " + res.getString("price") + " " +
                    res.getString("quantity"));
        } else {
            print.print("找不到该菜品");
        }
        preparedStatement.close();
        res.close();

    }


    /**
     * 改变菜单信息的方法的入口
     *
     * @author lzb
     */
    public void changeFood(Connection connection) throws IOException, SQLException {

        Scanner sc = new Scanner(System.in);
        Print print = new Print();

        print.print("请输入要修改的菜名的id！");
        String id = sc.nextLine();

        String sql = "select id,shopName,food,price,quantity from npc where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            print.print("请输入修改后的店名");
            String shopName = sc.nextLine();
            print.print("请输入修改后的菜名");
            String foodName = sc.nextLine();
            print.print("请输入修改后的价格");
            int price = sc.nextInt();
            print.print("请输入修改后的数量");
            int quantity = sc.nextInt();


            String sql1 = "update npc set shopName = ? ,food=?,price=? ,quantity=? where id = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);

            preparedStatement1.setString(1, shopName);
            preparedStatement1.setString(2, foodName);
            preparedStatement1.setInt(3, price);
            preparedStatement1.setInt(4, quantity);
            preparedStatement1.setString(5, id);
            preparedStatement1.executeUpdate();
            print.printAndNote("修改成功", AccountHandler.ID + "将编号为: " + id + " 的菜的信息修改为 "
                    + "店名: " + shopName + "菜名: " + foodName + "价格: " + price + " 数量: " + quantity);


        } else {
            print.print("该编号为空");
        }
        preparedStatement.close();
        resultSet.close();
    }


    /**
     * 判断价格是否为整数
     *
     * @param price 价格
     * @return 是否为整数
     * @author lzb
     */
    public boolean judgeInt(String price) {
        for (int i = 0; i < price.length(); ++i) {
            int ch = price.charAt(i);
            if (ch < 48 || ch > 57) {  // 使用ACSII判断
                return false;
            }
        }
        return true;
    }

    /**
     * 查询操作note
     *
     * @author lzb
     */
    public void findNote() throws IOException {
        Print print = new Print();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("note.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] str = line.split(" ");
            if ((!line.isEmpty()) && AccountHandler.ID.equals(str[0])) {
                print.print(line);
            }
        }
        bufferedReader.close();
    }

}
