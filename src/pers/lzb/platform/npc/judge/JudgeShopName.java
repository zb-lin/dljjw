package pers.lzb.platform.npc.judge;

import pers.lzb.platform.npc.trunk.Menu;

import java.util.ArrayList;

public class JudgeShopName {
    /**
     * 判断店名是否存在
     *
     * @param shopName 店名
     * @return 是否存在
     * @author lzb
     */
    public boolean judgeShopName(ArrayList<Menu> array, String shopName) {
        for (int i = 0; i < array.size(); i++) {
            if (shopName.equals(array.get(i).getShopName())) {
                return true;
            }
        }
        return false;
    }
}