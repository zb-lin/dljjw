package pers.lzb.platform.npc.change;

import pers.lzb.platform.major.tools.GetName;
import pers.lzb.platform.major.tools.Print;
import pers.lzb.platform.major.tools.Read;
import pers.lzb.platform.npc.judge.JudgeFood;
import pers.lzb.platform.npc.judge.JudgeFoodInFor;
import pers.lzb.platform.npc.judge.JudgeFoodPrice;
import pers.lzb.platform.npc.trunk.Menu;
import pers.lzb.platform.npc.trunk.SetName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChangeFoodPrice {
    /**
     * 修改价格
     *
     * @param foodFileName 菜单文件路径
     * @param shopName     店名
     * @author lzb
     */
    public void changeFoodPrice(String foodFileName, String shopName) throws IOException {
        Read read = new Read();
        ArrayList<Menu> array;
        array = read.read(foodFileName);

        Scanner sc = new Scanner(System.in);

        Print print = new Print();
        print.print("请输入你要修改的价格的菜名！");
        String foodName = sc.nextLine();

        JudgeFood judgeFood = new JudgeFood();

        if (!judgeFood.judgeFood(array, shopName, foodName)) {
            print.printAndNote("你要修改的菜不存在！", GetName.name + " 输入的菜 " + foodName + " 不存在");
        } else {

            print.print("请输入新的价格！");
            String newFoodPrice = sc.nextLine();

            JudgeFoodPrice judgeFoodPrice = new JudgeFoodPrice();
            if (judgeFoodPrice.judgeFoodPrice(newFoodPrice)) {
                print.printAndNote("输入的价格不为整数", GetName.name + " 输入的价格 " + newFoodPrice + " 不为整数");
            }
            JudgeFoodInFor judgeFoodInFor = new JudgeFoodInFor();
            for (int i = 0; i < array.size(); ++i) {
                if (judgeFoodInFor.judgeFoodInFor(array, shopName, foodName, i)) {
                    SetName setName = new SetName();
                    setName.setName(array, foodFileName, shopName, foodName, newFoodPrice, i);
                }

            }
            print.printAndNote("修改成功！", GetName.name + " 修改 " + shopName + " 的 " + foodName + " 的价格为 " + newFoodPrice + "元");

        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 9ca00c1522d237e8c1b7547038182fa02ddc376f
