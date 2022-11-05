package pers.lzb.platform;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class ChangeFood {
    public void changeFood(String foodFileName) throws IOException {
        Read read = new Read();
        ArrayList<Menu> array;
        array=read.read(foodFileName);
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你的店名！");
        String shopName = sc.nextLine();

        JudgeShopName judgeShopName = new JudgeShopName();

        if (judgeShopName.judgeShopName(array,shopName)) {
            System.out.println("你还没有输入你的菜品！");
        } else {
<<<<<<< HEAD
            ChangeFoodChoice changeFoodChoice = new ChangeFoodChoice();
            changeFoodChoice.changeFoodChoice(foodFileName,shopName);
=======
            System.out.println("如果你要修改店名，输入:1   如果你要修改菜名，输入:2   如果你要修改价格，输入:3");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    ChangeShopName changeShopName = new ChangeShopName();
                    changeShopName.changeShopName(foodFileName, shopName);
                    break;
                case 2:
                    ChangeFoodName changeFoodName = new ChangeFoodName();
                    changeFoodName.changeFoodName(foodFileName, shopName);
                    break;
                case 3:
                    ChangeFoodPrice changeFoodPrice = new ChangeFoodPrice();
                    changeFoodPrice.changeFoodPrice(foodFileName, shopName);
                    break;
                default:
                    break;

            }
>>>>>>> 913256cc50054b46235986208786b218c86e5f2f
        }
    }
}
