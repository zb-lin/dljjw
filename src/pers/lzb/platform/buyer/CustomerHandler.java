package pers.lzb.platform.buyer;


import pers.lzb.platform.account.tools.AccountHandler;
import pers.lzb.platform.account.tools.Print;

import java.io.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class CustomerHandler {
    /**
     * 看菜单
     *
     * @author lzb
     */
    public void viewMenu(Connection connection) throws SQLException {
        Print print = new Print();
        String sql = "SELECT id,shopName,food,price FROM test.npc";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String shopName = resultSet.getString("shopName");
            String foodName = resultSet.getString("food");
            String price = resultSet.getString("price");
            print.print(id + "  " + shopName + "  " + foodName + "  " + price);

        }
        resultSet.close();
        preparedStatement.close();

    }

    /**
     * 送餐服务
     *
     * @author lzb
     */
    public void foodDelivery() throws IOException {
        Calendar nowTime = Calendar.getInstance();  // 得到当前时间
        Scanner sc = new Scanner(System.in);
        Print print = new Print();
        print.print("请填写您的外卖地址！");

        String address = sc.nextLine();
        if (address.equals("印度") || address.equals("india") || address.equals("India")) {  // 送到本国比较快
            print.print("商家正在备餐！");
            nowTime.add(Calendar.MINUTE, 30);  // 当前时间加30分钟
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 转换时间格式
            print.print("预计送达时间:" + sdf.format(nowTime.getTime()));
        } else {  // 送到外国比较慢
            print.print("商家正在备餐！");
            nowTime.add(Calendar.YEAR, 1);  // 当前时间加1小时
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 转换时间格式
            print.print("预计送达时间:" + sdf.format(nowTime.getTime()));
            sc.nextLine();  // 吞掉一个回车,避免后续地址输入回车
        }
    }

    /**
     * 实现对菜单的模糊搜索
     *
     * @author lzb
     */
    public void fuzzySearch(Connection connection) throws SQLException {
        Print print = new Print();
        Scanner sc = new Scanner(System.in);
        print.print("请输入关键词");
        String key = sc.nextLine();
        Statement statement = connection.createStatement();
//        String sql = "select * from npc where   shopName or food   like '%" + key + "%' or '" + key + "' or '" + key + "'or'" + key + "'    ";
        String sql = "select * from npc where id like '%" + key + "%' or shopName like '%"
                + key + "%' or food like '%" + key + "%' or price like '%" + key + "%'";

//        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            print.print(resultSet.getString("id") + " " + resultSet.getString("shopName") + " "
                    + resultSet.getString("food") + " " + resultSet.getString("price"));
        }
        resultSet.close();
        statement.close();
    }

    /**
     * 点餐交互界面
     *
     * @author lzb
     */
    public void order(Connection connection) throws IOException, SQLException {
        float sum = 0;  // 计算应付金额
        Scanner sc = new Scanner(System.in);
        Print print = new Print();
        while (true) {
            print.print("请输入你要的菜的编号！");
            String id = sc.nextLine();
            String sql = "select id,shopName,food,price from npc where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sum = sum + Float.parseFloat(resultSet.getString("price"));
                print.note(AccountHandler.ID + " 在 " + resultSet.getString("shopName") + " 点了 " + resultSet.getString("food"));
            } else {
                print.print("你要的菜不存在");
            }

            print.print("如果你点餐完毕，请按:1");
            int num = sc.nextInt();
            if (num == 1) {
                sc.nextLine();
                break;
            }
            sc.nextLine();
        }
        if (sum == 0) {
            print.print("欢迎下次再来");
        } else {
            print.printAndNote("谢谢惠顾,一共是" + sum + "元", AccountHandler.ID + " 点餐完毕,花费 " + sum + " 元");
        }
    }
}



