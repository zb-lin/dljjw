package pers.lzb.platform.buyer;

import pers.lzb.platform.major.tools.GetName;
import pers.lzb.platform.major.tools.Print;

import java.io.IOException;

public class Customer {
    /**
     * 顾客点餐开始页面
     *
     * @param foodFileName 菜单文件路径
     * @author lzb
     */
    public void customer(String foodFileName) throws IOException {
        Print print = new Print();
        print.note(GetName.name+"买家看菜单");
        print.print("请看菜单！！");
        print.print("店名 菜名 价格");

        ViewMenu viewMenu = new ViewMenu();
        viewMenu.viewMenu(foodFileName);
        print.note(GetName.name+"买家点餐");
        OrderStart order = new OrderStart();
        order.order(foodFileName);
        print.note("点餐完毕");
    }
}
