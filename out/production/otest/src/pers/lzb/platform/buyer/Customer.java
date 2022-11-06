package pers.lzb.platform.buyer;

import java.io.IOException;

public class Customer {
    /**
     * 顾客点餐开始页面
     *
     * @param foodFileName 菜单文件路径
     * @author lzb
     */
    public void customer(String foodFileName) throws IOException {
        System.out.println("请看菜单！！");
        System.out.println("店名 菜名 价格");
        ViewMenu viewMenu = new ViewMenu();
        viewMenu.viewMenu(foodFileName);
        OrderStart order = new OrderStart();
        order.order(foodFileName);
    }
}
