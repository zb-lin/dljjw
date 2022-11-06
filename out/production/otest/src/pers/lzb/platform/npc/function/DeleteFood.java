package pers.lzb.platform.npc.function;

import pers.lzb.platform.major.tools.Read;
import pers.lzb.platform.npc.judge.JudgeFood;
import pers.lzb.platform.npc.judge.JudgeShopName;
import pers.lzb.platform.npc.trunk.Menu;
import pers.lzb.platform.npc.trunk.WriteMenu;

import java.io.*;
import java.util.*;

public class DeleteFood {
    public void deleteFood(String foodFileName) throws IOException {
        Read read = new Read();
        ArrayList<Menu> array;
        array = read.read(foodFileName);

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你的店名！");
        String shopName = sc.nextLine();
        boolean flag = true;
        JudgeShopName judgeShopName = new JudgeShopName();
        if (!judgeShopName.judgeShopName(array, shopName)) {
            System.out.println("未找到该店铺信息！");
            return;
        }

        System.out.println("输入你想删除的菜品！");
        String foodName = sc.nextLine();

        for (int i = 0; i < array.size(); ++i) {
            JudgeFood judgeFoodInFor = new JudgeFood();
            if (judgeFoodInFor.judgeFoodInFor(array, shopName, foodName, i)) {
                array.remove(i);
                WriteMenu writeMenu = new WriteMenu();
                writeMenu.writeMenu(foodFileName, array);
                System.out.println("删除成功！");
            }
        }
    }
}
