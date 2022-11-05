package pers.lzb.platform.npc.trunk;

import pers.lzb.platform.npc.trunk.Menu;
import pers.lzb.platform.npc.trunk.WriteMenu;

import java.io.IOException;
import java.util.ArrayList;

public class SetName {
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
