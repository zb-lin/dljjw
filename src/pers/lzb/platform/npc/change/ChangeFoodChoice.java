package pers.lzb.platform.npc.change;

import java.io.IOException;
import java.util.Scanner;

public class ChangeFoodChoice {
    /**
     * 改变菜单信息
     *
     * @param foodFileName 菜单文件路径
     * @param shopName     店名
     * @author lzb
     */
    public void changeFoodChoice(String foodFileName, String shopName) throws IOException {
        System.out.println("如果你要修改店名，输入:1   如果你要修改菜名，输入:2   如果你要修改价格，输入:3");
        Scanner sc = new Scanner(System.in);
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
                System.out.println("输入无效！");
                break;

        }
    }
}
