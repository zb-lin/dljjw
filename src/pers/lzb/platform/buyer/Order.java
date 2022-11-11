package pers.lzb.platform.buyer;

import pers.lzb.platform.account.tools.GetID;
import pers.lzb.platform.account.tools.Print;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

public class Order {
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
                print.note(GetID.ID + " 在 " + resultSet.getString("shopName") + " 点了 " + resultSet.getString("food"));
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
            print.printAndNote("谢谢惠顾,一共是" + sum + "元", GetID.ID + " 点餐完毕,花费 " + sum + " 元");
        }
    }
}
