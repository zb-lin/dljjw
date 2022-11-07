package pers.lzb.platform.buyer;

import pers.lzb.platform.major.tools.GetName;
import pers.lzb.platform.major.tools.Print;
import pers.lzb.platform.npc.judge.JudgeFood;
import pers.lzb.platform.npc.judge.JudgeFoodInFor;
import pers.lzb.platform.npc.trunk.Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    /**
     * 点餐交互界面
     *
     * @param array 传入菜单文件数据
     * @author lzb
     */
    public void order(ArrayList<Menu> array) throws IOException {
        float sum = 0;  // 计算应付金额
        Scanner sc = new Scanner(System.in);
        Print print = new Print();
        while (true) {
            print.print("请输入你要的店家！！");
            String shopName = sc.nextLine();
            print.print("请输入你要的菜！");
            String foodName = sc.nextLine();

            JudgeFood judgeFood = new JudgeFood();
            if (!judgeFood.judgeFood(array, shopName, foodName)) {
                print.printAndNote("你要的菜不存在！", GetName.name+" 在 "+shopName+" 点的菜 "+foodName+" 不存在");

            }

            JudgeFoodInFor judgeFoodInFor = new JudgeFoodInFor();
            for (int i = 0; i < array.size(); ++i) {  // 计算总金额
                if (judgeFoodInFor.judgeFoodInFor(array, shopName, foodName, i)) {
                    sum = sum + Float.parseFloat(array.get(i).getPrice());
                    print.note(GetName.name+" 在 "+shopName+" 点了 "+foodName);
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
        if(sum == 0){
            print.printAndNote("欢迎下次再来",GetName.name+" 没有点餐就退出");
        }else{
            print.printAndNote("谢谢惠顾,一共是" + sum + "元",GetName.name+" 点餐完毕,花费 "+sum+" 元");
        }

        print.note("\n");
    }
}
