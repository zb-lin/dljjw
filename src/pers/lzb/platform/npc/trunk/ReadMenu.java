package pers.lzb.platform.npc.trunk;


import java.io.*;
import java.util.*;

public class ReadMenu {
    /**
     * 读取菜单文件信息
     *
     * @param foodFilmName 菜单文件路径
     * @param array        存储菜单信息的数组
     * @author lzb
     */
    public void readMenu(String foodFilmName, ArrayList<Menu> array) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(foodFilmName));
        String line;
        while ((line = br.readLine()) != null) {  // line为非空
            if (!line.isEmpty()) {  // 跳过空行
                String[] str = line.split("!@#%#@!#@#@");  // 使用用户不会用到的字符串分隔信息便于输入读取
                Menu menu = new Menu();
                menu.setShopName(str[0]);
                menu.setFood(str[1]);
                menu.setPrice(str[2]);
                array.add(menu);
            }
        }
        br.close();
    }
}
