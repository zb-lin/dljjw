package pers.lzb.platform.major.trunk.administrator;

import pers.lzb.platform.major.tools.io.Print;
import pers.lzb.platform.npc.trunk.NpcDatabase;

import java.io.IOException;
import java.util.Scanner;

public class AdministratorDeleteFood {
    /**
     * 管理员删除菜品信息
     *
     * @author lzb
     */
    public void administratorDeleteFood() throws IOException {
        Print print = new Print();
        Scanner sc = new Scanner(System.in);
        print.print("请输入要删除的菜品的id");
        String id = sc.nextLine();
        NpcDatabase.npcDatabase(2, id, null, null, null);
    }
}
