package pers.lzb.platform.account.major;


import pers.lzb.platform.account.tools.*;
import pers.lzb.platform.buyer.Customer;
import pers.lzb.platform.npc.Npc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class StartHandler {

    /**
     * 通过输入数字进入选择方法
     *
     * @param conn 连接
     * @author lzb
     */


    public void start(Connection conn) throws IOException, SQLException, ClassNotFoundException {
        Print print = new Print();
        Scanner sc = new Scanner(System.in);
        AccountHandler accountHandler = new AccountHandler();
        while (true) {
            print.print("如果你还没有注册,请按: 1");
            print.print("如果你想登录,请按: 2 ");
            print.print("如果你想修改密码,请按: 3");
            print.print("如果你想注销账号.请按: 4");
            print.print("如果你想退出,请按: 其他");

            String num = sc.nextLine();

            switch (num) {
                case "1" -> accountHandler.signUp(conn);  // 注册
                case "2" -> this.startLogin(conn);  // 登录
                case "3" -> accountHandler.changePassword(conn);  // 修改密码
                case "4" -> accountHandler.deleteAccount(conn);  // 注销账号
                default -> {
                    conn.close();
                    System.exit(0);  // 退出
                }
            }

        }
    }


    /**
     * 选择登录买家或卖家或修改信息
     *
     * @author lzb
     */
    public void startLogin(Connection connection) throws SQLException, IOException, ClassNotFoundException {
        AccountHandler accountHandler = new AccountHandler();
        Scanner sc = new Scanner(System.in);
        Print print = new Print();

        if (accountHandler.login(connection)) {
            print.print("如果你是indiaNpc请按:1 ,如果你是买家，请按:2,  按其他回到开始界面");
            String num = sc.nextLine();

            if (num.equals("1")) {
                print.note(AccountHandler.ID + " 进入npc平台");
                Npc npc = new Npc();
                npc.npc(connection);
            } else if (num.equals("2")) {
                print.note(AccountHandler.ID + " 进入买家平台");
                Customer customer = new Customer();
                customer.customer(connection);
            }
        } else {
            print.print("登陆失败");
        }
    }
}

