package pers.lzb.platform.npc.trunk;

import java.io.IOException;
import java.util.ArrayList;

public class SetName {
    /**
     * 将店名,菜名,价格输入数组
     *
     * @param shopName  店名
     * @param FoodName  菜名
     * @param foodPrice 价格
     * @author lzb
     */
    public void setName(ArrayList<Menu> array, String foodFileName, String shopName, String FoodName, String foodPrice, int i) throws IOException {
        Menu menu = new Menu();
        WriteMenu writeMenu = new WriteMenu();
        menu.setShopName(shopName);
        menu.setFood(FoodName);
        menu.setPrice(foodPrice);
        array.set(i, menu);
        writeMenu.writeMenu(foodFileName, array);
    }
}
