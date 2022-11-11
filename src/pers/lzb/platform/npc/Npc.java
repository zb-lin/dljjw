package pers.lzb.platform.npc;

import pers.lzb.platform.account.tools.GetID;
import pers.lzb.platform.account.tools.Print;
import pers.lzb.platform.npc.tools.FindNote;
import pers.lzb.platform.npc.tools.NpcHandler;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Npc {
    /**
     * 卖家操作交互界面
     */
    public void npc(Connection connection) throws IOException, SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Print print = new Print();
        while (true) {
            print.print("如果你想增加菜品，请输入:1  如果你想删除菜品，请输入:2");
            print.print("如果你想查询所有菜品，请输入:3  如果你想改你信息或菜品，请输入:4");
            print.print("如果你想查询你的操作日记,请输入: 5");
            print.print("按其他键退出！");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:  // 增加菜品
                    print.note(GetID.ID + " 进行增加菜品操作");
                    NpcHandler.AddFood addFood = new NpcHandler.AddFood();
                    addFood.addFood(connection);
                    break;
                case 2:  // 删除菜品
                    print.note(GetID.ID + " 进行删除菜品操作");
                    NpcHandler.DeleteFood deleteFood = new NpcHandler.DeleteFood();
                    deleteFood.deleteFood(connection);
                    break;
                case 3:  // 查找菜品
                    print.note(GetID.ID + " 进行查找菜品操作");
                    NpcHandler.FindFood findFood = new NpcHandler.FindFood();
                    findFood.findFood(connection);
                    break;
                case 4:  // 修改菜品信息
                    print.note(GetID.ID + " 进行修改菜品信息操作");
                    NpcHandler.ChangeFood changeFood = new NpcHandler.ChangeFood();
                    changeFood.changeFood(connection);
                    break;

                case 5: // 查询操作日志
                    print.note(GetID.ID + " 进行查找日记操作");
                    FindNote findNote = new FindNote();
                    findNote.findNote();
                    break;
                default:  // 退出
                    print.note(GetID.ID + "退出");
                    connection.close();
                    System.exit(0);
            }
        }

    }

}
