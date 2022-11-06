package pers.lzb.platform.buyer;

import pers.lzb.platform.major.tools.Read;
import pers.lzb.platform.npc.trunk.Menu;

import java.io.IOException;
import java.util.ArrayList;


public class OrderStart {
    /**
     * 买家点单准备程序
     *
     * @param foodFileName 菜单文件路径
     * @author lzb
     */
    public void order(String foodFileName) throws IOException {
        Read read = new Read();
        ArrayList<Menu> array;  // 建立数组存储菜单文件数据
        array = read.read(foodFileName);  // 读入数据
        Order order = new Order();  // 点餐
        order.order(array);
        FoodDelivery foodDelivery = new FoodDelivery();  // 送餐
        foodDelivery.foodDelivery();
    }
}
