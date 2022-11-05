package pers.lzb.platform;

import java.io.IOException;
import java.util.ArrayList;


public class JudgeFood {
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

    public boolean judgeFoodInFor(ArrayList<Menu> array, String shopName, String foodName, int i) {
        if (shopName.equals(array.get(i).getShopName())) {
            if (foodName.equals(array.get(i).getFood())) {
                return true;
            }
        }
        return false;
    }
}
