package pers.lzb.platform.npc.change;

import pers.lzb.platform.major.tools.Read;
import pers.lzb.platform.npc.trunk.Menu;
import pers.lzb.platform.npc.trunk.WriteMenu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChangeShopName {
    /**
     * 改变店名
     *
     * @param foodFileName 菜单文件路径
     * @param shopName     店名
     * @author lzb
     */
    public void changeShopName(String foodFileName, String shopName) throws IOException {
        Read read = new Read();
        ArrayList<Menu> array;
        array = read.read(foodFileName);

        Menu menu = new Menu();
        WriteMenu writeMenu = new WriteMenu();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你新的店名！");
        String newShopName = sc.nextLine();
        if (newShopName.equals(shopName)) {
            System.out.println("你的新店名与旧店名相同！");
        } else {
            for (int i = 0; i < array.size(); ++i) {
                if (shopName.equals(array.get(i).getShopName())) {
                    menu.setShopName(newShopName);  // 输入新店名
                    menu.setFood(array.get(i).getFood());
                    menu.setPrice(array.get(i).getPrice());
                    array.set(i, menu);
                    writeMenu.writeMenu(foodFileName, array);
                }
            }
            System.out.println("修改成功！");
        }
    }
}
