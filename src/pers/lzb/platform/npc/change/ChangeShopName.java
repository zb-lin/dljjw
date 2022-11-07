package pers.lzb.platform.npc.change;

import pers.lzb.platform.major.tools.GetName;
import pers.lzb.platform.major.tools.Print;
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
        Print print = new Print();

        print.print("请输入你新的店名！");
        String newShopName = sc.nextLine();

        if (newShopName.equals(shopName)) {
            print.printAndNote("你的新店名与旧店名相同！", GetName.name + " 输入的新店名与原来相同,修改失败");
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
            print.printAndNote("修改成功！", GetName.name + " 成功将原店名: " + shopName + " 修改为" + "新店名: " + newShopName);
        }
    }

}
