package pers.lzb.platform.npc.function;

import pers.lzb.platform.major.tools.Read;
import pers.lzb.platform.npc.judge.JudgeShopName;
import pers.lzb.platform.npc.trunk.Menu;

import java.io.IOException;
import java.util.*;


//查询菜品
public class FindFood {

    public void findFood(String foodFileName) throws IOException {
        Read read = new Read();
        ArrayList<Menu> array;
        array = read.read(foodFileName);
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你的店名！");
        String shopName = sc.nextLine();

        JudgeShopName judgeShopName = new JudgeShopName();
        if (!judgeShopName.judgeShopName(array, shopName)) {
            System.out.println("你还没有输入你的菜品！");
        } else {
            for (int i = 0; i < array.size(); ++i) {
                if (shopName.equals(array.get(i).getShopName())) {
                    System.out.println(array.get(i).getShopName() + " " + array.get(i).getFood() + " " + array.get(i).getPrice());
                }
            }
        }
    }
}
