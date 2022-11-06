package pers.lzb.platform.npc.trunk;

import pers.lzb.platform.npc.trunk.Menu;
import pers.lzb.platform.npc.trunk.WriteMenu;

import java.io.IOException;
import java.util.ArrayList;

public class Set {
    public void set(ArrayList<Menu> array, String foodFileName, String shopName, String foodName, String price) throws IOException {
        Menu menu = new Menu();
        menu.setShopName(shopName);
        menu.setFood(foodName);
        menu.setPrice(price);
        array.add(menu);
        WriteMenu writeMenu = new WriteMenu();
        writeMenu.writeMenu(foodFileName, array);
    }
}
