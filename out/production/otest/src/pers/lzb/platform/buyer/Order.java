package pers.lzb.platform.buyer;

import pers.lzb.platform.major.tools.Read;
import pers.lzb.platform.npc.trunk.Menu;
import pers.lzb.platform.npc.judge.JudgeFood;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class Order {
    public void order(String foodFileName) throws IOException {
        Read read = new Read();
        ArrayList<Menu> array;
        array = read.read(foodFileName);
        Calendar nowTime = Calendar.getInstance();
        Scanner sc = new Scanner(System.in);
        float sum = 0;

        while (true) {
            System.out.println("请输入你要的店家！！");
            String shopName = sc.nextLine();

            System.out.println("请输入你要的菜！");
            String foodName = sc.nextLine();

            JudgeFood judgeFood = new JudgeFood();
            if (!judgeFood.judgeFood(array, shopName, foodName)) {
                System.out.println("你要的菜不存在！");
            }

            for (int i = 0; i < array.size(); ++i) {
                if (judgeFood.judgeFoodInFor(array, shopName, foodName, i)) {
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
        System.out.println("请填写您的外卖地址！");

        String address = sc.nextLine();
        if (address.equals("印度") || address.equals("india") || address.equals("India")) {
            System.out.println("商家正在备餐！");
            nowTime.add(Calendar.MINUTE, 30);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("预计送达时间:" + sdf.format(nowTime.getTime()));
        } else {
            System.out.println("商家正在备餐！");
            nowTime.add(Calendar.YEAR, 1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("预计送达时间:" + sdf.format(nowTime.getTime()));
            System.out.println("感觉太晚就按:1启用飞机运输！！");
            int num = sc.nextInt();
            if (num == 1) {
                System.out.println("无飞机，等明年去吧！");
            }
            sc.nextLine();
        }
    }
}
