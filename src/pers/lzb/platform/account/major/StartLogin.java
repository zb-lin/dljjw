package pers.lzb.platform.account.major;

import pers.lzb.platform.account.tools.AccountHandler;
import pers.lzb.platform.account.tools.GetID;
import pers.lzb.platform.account.tools.Print;
import pers.lzb.platform.buyer.Customer;
import pers.lzb.platform.npc.Npc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 选择登录买家或卖家或修改信息
 *
 * @author lzb
 */
public class StartLogin {
    public void startLogin(Connection connection) throws SQLException, IOException, ClassNotFoundException {
        AccountHandler.Login login = new AccountHandler.Login();
        Scanner sc = new Scanner(System.in);
        Print print = new Print();

        if (login.login(connection)) {
            print.print("如果你是indiaNpc请按:1 ,如果你是买家，请按:2");
            int num = sc.nextInt();

            if (num == 1) {
                print.note(GetID.ID + " 进入npc平台");
                Npc npc = new Npc();
                npc.npc(connection);
            } else if (num == 2) {
                print.note(GetID.ID + " 进入买家平台");
                Customer customer = new Customer();
                customer.customer(connection);
            }
        } else {
            print.print("登陆失败");
        }
    }

}
