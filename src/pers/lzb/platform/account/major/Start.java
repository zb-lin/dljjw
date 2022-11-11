package pers.lzb.platform.account.major;


import pers.lzb.platform.account.tools.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class Start {
    /**
     * 通过输入数字进入选择方法
     *
     * @param conn 连接
     * @author lzb
     */


    public void start(Connection conn) throws IOException, SQLException, ClassNotFoundException {
        Print print = new Print();
        Scanner sc = new Scanner(System.in);
        while (true) {
            print.print("如果你还没有注册,请按: 1");
            print.print("如果你想登录,请按: 2 ");
            print.print("如果你想修改密码,请按: 3");
            print.print("如果你想注销账号.请按: 4");
            print.print("如果你想退出,请按: 其他数字");

            int num = sc.nextInt();
            StartChoice startChoice = new StartChoice();

            if (num == 1) {
                startChoice.startChoice(StartChoice.Operation.SIGNUP, conn);

            } else if (num == 2) {
                startChoice.startChoice(StartChoice.Operation.LOGIN, conn);

            } else if (num == 3) {

                startChoice.startChoice(StartChoice.Operation.CHANGE, conn);
            } else if (num == 4) {

                startChoice.startChoice(StartChoice.Operation.DELETE, conn);
            } else {
                conn.close();

                System.exit(0);
            }

        }
    }
}

