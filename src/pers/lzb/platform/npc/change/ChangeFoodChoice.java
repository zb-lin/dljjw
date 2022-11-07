package pers.lzb.platform.npc.change;

import pers.lzb.platform.major.tools.GetName;
import pers.lzb.platform.major.tools.Print;

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
        Print print = new Print();
        print.print("如果你要修改店名，输入:1   如果你要修改菜名，输入:2   如果你要修改价格，输入:3");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        switch (num) {
            case 1:
                print.note(GetName.name + " 修改 " + shopName + " 的店名");
                ChangeShopName changeShopName = new ChangeShopName();
                changeShopName.changeShopName(foodFileName, shopName);
                break;
            case 2:
                print.note(GetName.name + " 修改菜品");
                ChangeFoodName changeFoodName = new ChangeFoodName();
                changeFoodName.changeFoodName(foodFileName, shopName);
                break;
            case 3:
                print.note(GetName.name + " 修改价格");
                ChangeFoodPrice changeFoodPrice = new ChangeFoodPrice();
                changeFoodPrice.changeFoodPrice(foodFileName, shopName);
                break;
            default:
                print.printAndNote("输入无效！", GetName.name + " 在修改信息操作选择中输入无效数字");
                break;
        }
    }
}