package pers.lzb.platform.npc.function;

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

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的店名！");
        String shopName = sc.nextLine();

        System.out.println("请输入菜的名字！");
        String foodName = sc.nextLine();

        JudgeFood judgeFood = new JudgeFood();
        if (judgeFood.judgeFood(array, shopName, foodName)) {
            System.out.println("你已经添加过该菜品！");
            return;
        }
        System.out.println("请输入菜的价格！");
        String price = sc.nextLine();

        JudgeFoodPrice judgeFoodPrice = new JudgeFoodPrice();
        if (judgeFoodPrice.judgeFoodPrice(price)) {
            System.out.println("输入价格不为整数!");
            return;
        }

        Set set = new Set();
        set.set(array, foodFileName, shopName, foodName, price);
        System.out.println("您的菜品已添加成功！！");

    }

}

