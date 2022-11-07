package pers.lzb.platform.buyer;

<<<<<<< HEAD
=======
import pers.lzb.platform.major.tools.GetName;
>>>>>>> 9ca00c1522d237e8c1b7547038182fa02ddc376f
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
<<<<<<< HEAD
}
=======
}
>>>>>>> 9ca00c1522d237e8c1b7547038182fa02ddc376f
