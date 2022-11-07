package pers.lzb.platform.npc.trunk;

import pers.lzb.platform.major.tools.GetName;
import pers.lzb.platform.major.tools.Print;
import pers.lzb.platform.npc.function.AddFood;
import pers.lzb.platform.npc.function.ChangeFood;
import pers.lzb.platform.npc.function.DeleteFood;
import pers.lzb.platform.npc.function.FindFood;

import java.io.IOException;
import java.util.Scanner;

public class Npc {
    /**
     * 卖家操作交互界面
     *
     * @param foodFileName 菜单文件路径
     * @author lzb
     */
    public void npc(String foodFileName) throws IOException {
        Scanner sc = new Scanner(System.in);
        Print print = new Print();
        while (true) {
            print.print("如果你想增加菜品，请输入:1  如果你想删除菜品，请输入:2");
            print.print("如果你想查询所有菜品，请输入:3  如果你想改你信息或菜品，请输入:4");
            print.print("按其他键退出！");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:  // 增加菜品
                    print.note("\n");
                    print.note(GetName.name+" 进行增加菜品操作");
                    AddFood addFood = new AddFood();
                    addFood.addFood(foodFileName);
                    break;
                case 2:  // 删除菜品
                    print.note("\n");
                    print.note(GetName.name+" 进行删除菜品操作");
                    DeleteFood deleteFood = new DeleteFood();
                    deleteFood.deleteFood(foodFileName);
                    break;
                case 3:  // 查找菜品
                    print.note("\n");
                    print.note(GetName.name+" 进行查找菜品操作");
                    FindFood findFood = new FindFood();
                    findFood.findFood(foodFileName);
                    break;
                case 4:  // 修改菜品信息
                    print.note("\n");
                    print.note(GetName.name+" 进行修改菜品信息操作");
                    ChangeFood changeFood = new ChangeFood();
                    changeFood.changeFood(foodFileName);
                    break;
                default:  // 退出
                    print.note("退出");
                    System.exit(0);
            }
        }

    }
}
