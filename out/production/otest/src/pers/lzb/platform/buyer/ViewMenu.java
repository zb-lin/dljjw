package pers.lzb.platform.buyer;

import pers.lzb.platform.major.tools.GetName;
import pers.lzb.platform.major.tools.Print;
import pers.lzb.platform.major.tools.Read;
import pers.lzb.platform.npc.trunk.Menu;

import java.io.*;

import java.util.ArrayList;

public class ViewMenu {
    /**
     * 看菜单
     *
     * @param foodFileName 菜单文件路径
     * @author lzb
     */
    public void viewMenu(String foodFileName) throws IOException {
        Read read = new Read();
        ArrayList<Menu> array;
        array = read.read(foodFileName);  // 用数组读取菜单文件信息
        Print print = new Print();

        for (int i = 0; i < array.size(); ++i) {  // 输出菜单信息
            print.print(array.get(i).getShopName() + " " + array.get(i).getFood() + " " + array.get(i).getPrice() + "元");
        }
    }
}
