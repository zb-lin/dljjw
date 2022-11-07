package pers.lzb.platform.buyer;

import pers.lzb.platform.major.tools.GetName;
import pers.lzb.platform.major.tools.Print;

import java.io.IOException;
import java.util.Scanner;

public class Customer {
    /**
     * 顾客点餐开始页面
     *
     * @param foodFileName 菜单文件路径
     * @author lzb
     */
    public void customer(String foodFileName) throws IOException {
        Print print = new Print();
        Scanner sc = new Scanner(System.in);
        while (true) {
            print.print("如果你想看菜单,请按: 1 ,如果你想搜索某样菜,请按: 2,直接点餐请按其他数字");
            int num = sc.nextInt();
            if (num == 1) {
                print.note(GetName.name + " 看菜单");
                print.print("请看菜单！！");
                print.print("店名 菜名 价格");
                ViewMenu viewMenu = new ViewMenu();
                viewMenu.viewMenu(foodFileName);
            } else if (num == 2) {
                SearchFood searchFood = new SearchFood();
                searchFood.searchFood();
            } else {
                break;
            }
        }

        print.note(GetName.name + " 买家点餐");
        OrderStart order = new OrderStart();
        order.order(foodFileName);
        print.note("点餐完毕");
    }
}
