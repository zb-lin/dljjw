package pers.lzb.platform.npc.change;

import pers.lzb.platform.major.tools.Read;
import pers.lzb.platform.npc.judge.JudgeFood;
import pers.lzb.platform.npc.judge.JudgeFoodInFor;
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

        System.out.println("请输入你要修改的价格的菜名！");
        String foodName = sc.nextLine();

        JudgeFood judgeFood = new JudgeFood();

        if (!judgeFood.judgeFood(array, shopName, foodName)) {
            System.out.println("你要修改的菜不存在！");
        } else {

            System.out.println("请输入新的价格！");
            String newFoodPrice = sc.nextLine();

            JudgeFoodInFor judgeFoodInFor = new JudgeFoodInFor();
            for (int i = 0; i < array.size(); ++i) {
                if (judgeFoodInFor.judgeFoodInFor(array, shopName, foodName, i)) {
                    SetName setName = new SetName();
                    setName.setName(array, foodFileName, shopName, foodName, newFoodPrice, i);
                }

            }
            System.out.println("修改成功！");
        }
    }
}
