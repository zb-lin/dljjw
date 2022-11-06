package pers.lzb.platform.major.trunk;

import pers.lzb.platform.buyer.Customer;
import pers.lzb.platform.major.tools.Login;
import pers.lzb.platform.npc.trunk.Npc;

import java.io.IOException;
import java.util.Scanner;

public class StartLogin {
    /**
     * 选择登录买家或卖家
     *
     * @param fileName     账号文件路径
     * @param foodFileName 菜单文件路径
     * @author lzb
     */
    public void startLogin(String fileName, String foodFileName) throws IOException {
        Login login = new Login();
        Scanner sc = new Scanner(System.in);

        if (login.login(fileName)) {
            System.out.println("如果你是indiaNpc请按:1,如果你是买家，请按:2");
            int num = sc.nextInt();

            if (num == 1) {  // 卖家
                Npc npc = new Npc();
                npc.npc(foodFileName);
            } else if (num == 2) {  // 买家
                Customer customer = new Customer();
                customer.customer(foodFileName);
            }

        } else {  // 登录失败
            System.out.println("登录失败！");
        }
    }
}
