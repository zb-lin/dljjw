package pers.lzb.platform.major.trunk.administrator;

import pers.lzb.platform.major.tools.*;
import pers.lzb.platform.major.tools.io.Print;

import java.io.IOException;
import java.util.Scanner;

public class Administrator {
    /**
     * 管理员界面
     *
     * @author lzb
     */
    public void administrator() throws IOException {

        JudgeAdministrator judgeAdministrator = new JudgeAdministrator();
        Print print = new Print();
        Scanner sc = new Scanner(System.in);
        if (judgeAdministrator.judgeAdministrator()) {
            while (true) {
                print.print("如果你想查询账号,请按: 1");
                print.print("如果你想删除账号,请按: 2");
                print.print("如果你想删除菜品,请按: 3");
                print.print("如果你想查询所有菜品,请按: 4");
                print.print("退出请按其他数字");
                int num = sc.nextInt();
                if (num == 1) {
                    print.print("查询账号");
                    DatabaseOperation.connect(3, "1", null, null);
                } else if (num == 2) {
                    print.note("注销账号");
                    DeleteAccount deleteAccount = new DeleteAccount();
                    deleteAccount.deleteAccount();
                } else if (num == 3) {
                    AdministratorDeleteFood administratorDeleteFood = new AdministratorDeleteFood();
                    administratorDeleteFood.administratorDeleteFood();
                } else if (num == 4) {
                    AdministratorViewFood administratorViewFood = new AdministratorViewFood();
                    administratorViewFood.administratorViewFood();
                } else {
                    break;
                }
            }

        } else {
            print.print("密码错误");
        }

    }
}
