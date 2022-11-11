
package pers.lzb.platform.buyer;

import pers.lzb.platform.account.tools.GetID;
import pers.lzb.platform.account.tools.Print;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Customer {
    /**
     * 顾客点餐开始页面
     *
     * @author lzb
     */
    public void customer(Connection connection) throws IOException, SQLException {
        Print print = new Print();
        Scanner sc = new Scanner(System.in);
        while (true) {
            print.print("如果你想看菜单,请按: 1 ");
            print.print("如果你想搜索某样菜,请按: 2");
            print.print("直接点餐请按其他数字");
            int num = sc.nextInt();
            if (num == 1) {
                print.note(GetID.ID + " 看菜单");
                print.print("请看菜单！！");
                print.print("编号  店名  菜名  价格");
                ViewMenu viewMenu = new ViewMenu();
                viewMenu.viewMenu(connection);
            } else if (num == 2) {
//                SearchFood searchFood = new SearchFood();  // 单字符串精确搜索
//                searchFood.searchFood();
//                print.print("");
//                FuzzySearch fuzzySearch = new FuzzySearch();
//                fuzzySearch.fuzzySearch();
            } else {
                break;
            }
        }

        print.note(GetID.ID + " 买家点餐");
        Order order = new Order();  // 点餐
        order.order(connection);
        FoodDelivery foodDelivery = new FoodDelivery();  // 送餐
        foodDelivery.foodDelivery();
        print.note("点餐完毕");
    }
}
