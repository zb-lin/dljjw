package pers.lzb.platform.major.tools;

import pers.lzb.platform.npc.trunk.ReadMenu;
import pers.lzb.platform.npc.trunk.Menu;

import java.io.IOException;
import java.util.ArrayList;

public class Read {
    /**
     * 创建并返回存有文件菜单信息的数组
     *
     * @param foodFileName 菜单文件数据
     * @return 存有文件菜单信息的数组
     * @author lzb
     */
    public ArrayList<Menu> read(String foodFileName) throws IOException {
        ArrayList<Menu> array = new ArrayList<>();
        ReadMenu readMenu = new ReadMenu();
        readMenu.readMenu(foodFileName, array);
        return array;
    }

}
