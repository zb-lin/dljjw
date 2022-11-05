package pers.lzb.platform.npc.judge;

import pers.lzb.platform.npc.trunk.Menu;

import java.io.IOException;
import java.util.ArrayList;

public class JudgeShopName {
    public boolean judgeShopName(ArrayList<Menu> array, String shopName) throws IOException {
        for (int i = 0; i < array.size(); i++) {
            if (shopName.equals(array.get(i).getShopName())) {
                return false;
            }
        }
        return true;
    }
}
