package pers.lzb.platform.npc.trunk;

import java.io.IOException;
import java.util.ArrayList;

public class Set {
    /**
     * 添加信息到数组
     *
     * @param array        存储数据的数组
     * @param foodFileName 菜单文件名
     * @param shopName     店名
     * @param foodName     菜名
     * @param price        价格
     * @author lzb
     */
    public void set(ArrayList<Menu> array, String foodFileName, String shopName, String foodName, String price) throws IOException {
        Menu menu = new Menu();
        menu.setShopName(shopName);
        menu.setFood(foodName);
        menu.setPrice(price);
        array.add(menu);
        WriteMenu writeMenu = new WriteMenu();
        writeMenu.writeMenu(foodFileName, array);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 9ca00c1522d237e8c1b7547038182fa02ddc376f
