package pers.lzb.platform;

import java.io.IOException;
import java.util.Scanner;

public class Npc {
    public void npc(String foodFileName) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("如果你想增加菜品，请输入:1  如果你想删除菜品，请输入:2");
            System.out.println("如果你想查询所有菜品，请输入:3  如果你想改你信息或菜品，请输入:4");
            System.out.println("按其他键退出！");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:                            //增
                    AddFood addFood = new AddFood();
                    addFood.addFood(foodFileName);
                    break;
                case 2:                           //删
                    DeleteFood deleteFood = new DeleteFood();
                    deleteFood.deleteFood(foodFileName);
                    break;
                case 3:                           //查
                    FindFood findFood = new FindFood();
                    findFood.findFood(foodFileName);
                    break;
                case 4:                            //改
                    ChangeFood changeFood = new ChangeFood();
                    changeFood.changeFood(foodFileName);
                    break;
                default:
                    System.exit(0);
            }
        }

    }
}
