package pers.lzb.platform.npc.judge;

import pers.lzb.platform.npc.trunk.Menu;

import java.util.ArrayList;


public class JudgeFood {
    /**
     * 判断菜品是否存在
     *
     * @param array    存放菜品数据的数组
     * @param shopName 店名
     * @param foodName 菜名
     * @return 是否正确
     * @author lzb
     */

    public boolean judgeFood(ArrayList<Menu> array, String shopName, String foodName) {
        for (int i = 0; i < array.size(); ++i) {
            if (shopName.equals(array.get(i).getShopName())) {
                if (foodName.equals(array.get(i).getFood())) {
                    return true;
                }
            }
        }
        return false;
    }

}

