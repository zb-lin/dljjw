package pers.lzb.platform.npc.trunk;


import java.io.*;

import java.util.ArrayList;

public class WriteMenu {
    /**
     * 将菜单信息写入文件
     *
     * @param foodFileName 菜单文件路径
     * @param array        存储菜单数据的数组
     * @author lzb
     */
    public void writeMenu(String foodFileName, ArrayList<Menu> array) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(foodFileName));
        for (int i = 0; i < array.size(); ++i) {
            Menu menu = array.get(i);
            bw.write(menu.getShopName() + "阿斯达多所大所" + menu.getFood() + "阿斯达多所大所" + menu.getPrice() // 用不常用到的字符串分隔
            );
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }


<<<<<<< HEAD
}
=======
}
>>>>>>> 9ca00c1522d237e8c1b7547038182fa02ddc376f
