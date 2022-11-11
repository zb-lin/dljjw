package pers.lzb.platform.npc.tools;

import pers.lzb.platform.account.tools.GetID;
import pers.lzb.platform.account.tools.Print;
import pers.lzb.platform.npc.tools.JudgeFoodPrice;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class NpcHandler {
    public static class AddFood {
        /**
         * 添加菜品
         *
         * @author lzb
         */
        public void addFood(Connection connection) throws IOException, SQLException, ClassNotFoundException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement statement = connection.createStatement();
            Scanner sc = new Scanner(System.in);
            Print print = new Print();

            print.print("请输入菜的编号:");
            String id = sc.nextLine();

            String sql = " select id from npc where id=? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);  // 给sql语句的第1个问号赋值
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                print.print("该编号已被占用");
            } else {
                print.print("请输入店名");
                String shopName = sc.nextLine();
                print.print("请输入菜名");
                String foodName = sc.nextLine();
                print.print("请输入价格");
                String price = sc.nextLine();
                JudgeFoodPrice judgeFoodPrice = new JudgeFoodPrice();
                if (judgeFoodPrice.judgeFoodPrice(price)) {
                    statement.executeUpdate("insert  into npc value ('" + id + "','" + shopName + "','" + foodName + "','" + price + "')");
                    print.printAndNote("您的菜品已添加成功!", GetID.ID + ": " + "菜品添加成功,店名为: "
                            + shopName + " 菜名为: " + foodName + " 价格为: " + price);
                } else {
                    print.print("价格不为整数,添加失败");
                }
            }


        }


    }
    public static class DeleteFood {
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
                print.printAndNote("删除成功！", GetID.ID + " 删除编号为 " + id + " 的菜品 ");
            } else {
                print.print("未找到该菜品!");
            }
        }

    }

    public static class FindFood {
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
            String sql1 = " select id ,shopName,food,price from npc where id= ? ";
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.setString(1, id);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                print.print("编号  店名  菜名  价格");
                print.print(res.getString("id") + " " + res.getString("shopName") + " " +
                        res.getString("food") + " " + res.getString("price"));
                print.note(GetID.ID + "查找id为" + id + "的菜的信息");
            } else {
                print.print("找不到该菜品");
            }
            ps.close();
            res.close();

        }
    }
    public static class ChangeFood {
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

            String sql = "select id,shopName,food,price from npc where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                print.print("请输入修改后的店名");
                String shopName = sc.nextLine();
                print.print("请输入修改后的菜名");
                String foodName = sc.nextLine();
                print.print("请输入修改后的价格");
                String price = sc.nextLine();
                JudgeFoodPrice judgeFoodPrice = new JudgeFoodPrice();
                if (judgeFoodPrice.judgeFoodPrice(price)) {
                    String sql1 = "update npc set shopName = ? ,food=?,price=? where id = ?";
                    PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);

                    preparedStatement1.setString(1, shopName);
                    preparedStatement1.setString(2, foodName);
                    preparedStatement1.setString(3, price);
                    preparedStatement1.setString(4, id);
                    preparedStatement1.executeUpdate();
                    print.printAndNote("修改成功", GetID.ID + "将编号为: " + id + " 的菜的信息修改为 " + "店名: " + shopName + "菜名: " + foodName + "价格: " + price);
                } else {
                    print.print("输入价格不为整数,添加失败");
                }

            } else {
                print.print("该编号为空");
            }
            preparedStatement.close();
            resultSet.close();
        }
    }

}
