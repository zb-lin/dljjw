package pers.lzb.platform.npc.change;

import pers.lzb.platform.major.tools.GetName;
import pers.lzb.platform.major.tools.Print;
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
        Print print = new Print();
        print.print("请输入你要修改的菜名！");
        String foodName = sc.nextLine();

        JudgeFood judge = new JudgeFood();
        if (!judge.judgeFood(array, shopName, foodName)) {
            print.printAndNote("你要修改的菜不存在！", GetName.name + " 要修改的菜 " + foodName + " 还未添加在 " + shopName + " 中");
        } else {
            print.print("请输入你新的菜名！");
            String newFoodName = sc.nextLine();

            if (newFoodName.equals(foodName)) {
                print.printAndNote("你的新菜名与旧菜名相同！", GetName.name + " 修改菜名 " + foodName + " 前后一致");
            } else {
                for (int i = 0; i < array.size(); ++i) {
                    JudgeFoodInFor judgeFoodInFor = new JudgeFoodInFor();
                    if (judgeFoodInFor.judgeFoodInFor(array, shopName, foodName, i)) {
                        SetName setName = new SetName();
                        setName.setName(array, foodFileName, shopName, newFoodName, array.get(i).getPrice(), i);
                    }
                }
                print.printAndNote("修改成功！", GetName.name + " 修改 " + shopName + " 的菜 " + foodName + " 为 " + newFoodName);
            }
        }
    }

}

