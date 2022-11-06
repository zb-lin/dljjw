package pers.lzb.platform.npc.change;

import pers.lzb.platform.major.tools.Read;
import pers.lzb.platform.npc.judge.JudgeFood;
import pers.lzb.platform.npc.judge.JudgeFoodInFor;
import pers.lzb.platform.npc.trunk.Menu;
import pers.lzb.platform.npc.trunk.SetName;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ChangeFoodName {
    /**
     * 修改菜名
     *
     * @param foodFileName 菜单文件路径
     * @param shopName     店名
     * @author lzb
     */


    public void changeFoodName(String foodFileName, String shopName) throws IOException {
        Read read = new Read();
        ArrayList<Menu> array;
        array = read.read(foodFileName);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要修改的菜名！");
        String foodName = sc.nextLine();

        JudgeFood judge = new JudgeFood();
        if (!judge.judgeFood(array, shopName, foodName)) {
            System.out.println("你要修改的菜不存在！");
        } else {
            System.out.println("请输入你新的菜名！");
            String newFoodName = sc.nextLine();

            if (newFoodName.equals(foodName)) {
                System.out.println("你的新菜名与旧菜名相同！");
            } else {
                for (int i = 0; i < array.size(); ++i) {
                    JudgeFoodInFor judgeFoodInFor = new JudgeFoodInFor();
                    if (judgeFoodInFor.judgeFoodInFor(array, shopName, foodName, i)) {
                        SetName setName = new SetName();
                        setName.setName(array, foodFileName, shopName, newFoodName, array.get(i).getPrice(), i);
                    }
                }
                System.out.println("修改成功！");
            }
        }
    }
}
