package pers.lzb.platform.major.trunk;

import pers.lzb.platform.buyer.Customer;
import pers.lzb.platform.major.tools.ChangeAccount;
import pers.lzb.platform.major.tools.io.GetName;
import pers.lzb.platform.major.tools.Login;
import pers.lzb.platform.major.tools.io.Print;
import pers.lzb.platform.npc.trunk.Npc;

import java.io.IOException;
import java.util.Scanner;

public class StartLogin {
    /**
     * 选择登录买家或卖家或修改信息
     *
     * @param fileName     账号文件路径
     * @param foodFileName 菜单文件路径
     * @author lzb
     */
    public void startLogin(String fileName, String foodFileName) throws IOException {
        Login login = new Login();
        Scanner sc = new Scanner(System.in);
        Print print = new Print();

        if (login.login(fileName)) {
            print.print("如果你是indiaNpc请按:1 ,如果你是买家，请按:2 ,如果你想修改账号信息,请按: 3");
            int num = sc.nextInt();

            if (num == 1) {  // 卖家
                print.note("\n");
                print.note(GetName.name + " 进入npc平台");
                Npc npc = new Npc();
                npc.npc(foodFileName);
            } else if (num == 2) {  // 买家
                print.note("\n");
                print.note(GetName.name + " 进入买家平台");
                Customer customer = new Customer();
                customer.customer(foodFileName);
            } else if (num == 3) {
                print.note("修改信息");
                ChangeAccount changeAccount = new ChangeAccount();
                changeAccount.changeAccount();
            }

        } else {  // 登录失败
            print.printAndNote("登录失败！", "登录失败");
        }
    }

}


