package pers.lzb.platform;

import java.io.IOException;

public class Customer {
    public void customer(String foodFileName) throws IOException {
        System.out.println("请看菜单！！");
        System.out.println("店名 菜名 价格");
        ViewMenu viewMenu = new ViewMenu();  //看菜单
        viewMenu.viewMenu(foodFileName);
        Order order = new Order();           //点餐
        order.order(foodFileName);
    }
}
