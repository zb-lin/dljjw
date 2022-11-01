package pers.lzb.platform;

import java.util.Scanner;

public class NpcFood {
    public static void npcFood() {
        System.out.println("你应该是一名合格的大厨！");//增删改查（增加，删除，修改，查询）
        System.out.println("请告诉我你的想法是:");
        System.out.println("1.在客人的外卖平台上增添一道风景！");
        System.out.println("2.让客人无法欣赏你的一道艺术品！");
        System.out.println("3.打磨你的菜品！让你的美食更美味！");
        System.out.println("4.看看你是否为客人们增加了某一道菜");
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        if (n == 1) {                     //增

        } else if (n == 2) {                 //删

        } else if (n == 3) {                 //改

        } else if (n == 4) {                  //查

        } else {
            System.out.println("你没有资格成为一位合格的因地安人！");
        }

    }
}