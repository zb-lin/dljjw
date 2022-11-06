package pers.lzb.platform.buyer;

import pers.lzb.platform.npc.judge.JudgeFood;
import pers.lzb.platform.npc.judge.JudgeFoodInFor;
import pers.lzb.platform.npc.trunk.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    /**
     * 点餐交互界面
     *
     * @param array 传入菜单文件数据
     * @author lzb
     */
    public void order(ArrayList<Menu> array) {
        float sum = 0;  // 计算应付金额
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你要的店家！！");
            String shopName = sc.nextLine();

            System.out.println("请输入你要的菜！");
            String foodName = sc.nextLine();

            JudgeFood judgeFood = new JudgeFood();
            if (!judgeFood.judgeFood(array, shopName, foodName)) {
                System.out.println("你要的菜不存在！");
            }

            JudgeFoodInFor judgeFoodInFor = new JudgeFoodInFor();
            for (int i = 0; i < array.size(); ++i) {  // 计算总金额
                if (judgeFoodInFor.judgeFoodInFor(array, shopName, foodName, i)) {
                    sum = sum + Float.parseFloat(array.get(i).getPrice());
                }
            }
            System.out.println("如果你点餐完毕，请按:1");
            int num = sc.nextInt();
            if (num == 1) {
                sc.nextLine();
                break;
            }
            sc.nextLine();
        }
        System.out.println("谢谢惠顾,一共是" + sum + "元");
    }
}
