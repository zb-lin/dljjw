package pers.lzb.platform.npc.function;

import pers.lzb.platform.major.tools.GetName;
import pers.lzb.platform.major.tools.Print;
import pers.lzb.platform.major.tools.Read;
import pers.lzb.platform.npc.judge.JudgeFood;
import pers.lzb.platform.npc.judge.JudgeFoodPrice;
import pers.lzb.platform.npc.trunk.Menu;
import pers.lzb.platform.npc.trunk.Set;

import java.io.*;
import java.util.*;

public class AddFood {
    /**
     * 添加菜品
     *
     * @param foodFileName 菜单文件路径
     * @author lzb
     */
    public void addFood(String foodFileName) throws IOException {
        Read read = new Read();
        ArrayList<Menu> array = read.read(foodFileName);
        Print print = new Print();

        Scanner sc = new Scanner(System.in);
        print.print("请输入你的店名！");
        String shopName = sc.nextLine();

        print.print("请输入菜的名字！");
        String foodName = sc.nextLine();

        JudgeFood judgeFood = new JudgeFood();
        if (judgeFood.judgeFood(array, shopName, foodName)) {
            print.printAndNote("你已经添加过该菜品！", GetName.name + " 已经添加过 " + foodName + ",添加失败");
            return;
        }
        print.print("请输入菜的价格！");
        String price = sc.nextLine();

        JudgeFoodPrice judgeFoodPrice = new JudgeFoodPrice();
        if (judgeFoodPrice.judgeFoodPrice(price)) {
            print.printAndNote("输入价格不为整数!", GetName.name + " 输入的价格 " + price + " 不为整数,添加失败");
            return;
        }

        Set set = new Set();
        set.set(array, foodFileName, shopName, foodName, price);
        print.printAndNote("您的菜品已添加成功！！", GetName.name + " 在 " + shopName + " 添加菜品 " + foodName + " 成功," + "价格为 " + price + "元");
        print.print("\n");
    }

}

