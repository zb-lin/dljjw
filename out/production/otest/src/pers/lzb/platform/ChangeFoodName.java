package pers.lzb.platform;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ChangeFoodName {


    public void changeFoodName(String foodFileName, String shopName) throws IOException {
        Read read = new Read();
        ArrayList<Menu> array;
        array = read.read(foodFileName);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要修改的菜名！");
        String foodName = sc.nextLine();

        JudgeFood judge = new JudgeFood();
        if (!judge.judgeFood(array, shopName, foodName)) {
            System.out.println("你要修改的菜不存在！");
        } else {
            System.out.println("请输入你新的菜名！");
            String newFoodName = sc.nextLine();

            if (newFoodName.equals(foodName)) {
                System.out.println("你的新菜名与旧菜名相同！");
            } else {
                for (int i = 0; i < array.size(); ++i) {
<<<<<<< HEAD
                    JudgeFood judgeFood = new JudgeFood();
                    if (judgeFood.judgeFoodInFor(array, shopName, foodName,i)) {
                        SetName setName =new SetName();
                        setName.setName(array ,foodFileName, shopName, newFoodName,array.get(i).getPrice(),i);
=======
                    if (shopName.equals(array.get(i).getShopName())) {
                        if (foodName.equals(array.get(i).getFood())) {
                            menu.setShopName(shopName);
                            menu.setFood(newFoodName);
                            menu.setPrice(array.get(i).getPrice());
                            array.set(i, menu);
                            writeMenu.writeMenu(foodFileName, array);
                        }
>>>>>>> 913256cc50054b46235986208786b218c86e5f2f
                    }
                }
                System.out.println("修改成功！");
            }
        }
    }
}
