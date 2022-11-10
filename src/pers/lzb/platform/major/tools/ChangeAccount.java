package pers.lzb.platform.major.tools;

import pers.lzb.platform.major.tools.io.Print;

import java.io.IOException;
import java.util.Scanner;

public class ChangeAccount {
    /**
     * 利用MySQL修改账号信息
     *
     * @author lzb
     */
    public void changeAccount() throws IOException {
        Print print = new Print();
        Scanner sc = new Scanner(System.in);
        print.print("请输入你的账号id");
        String id = sc.nextLine();
        sc.nextLine();
        print.print("请输入修改后的名字");
        String userName = sc.nextLine();
        print.print("请输入修改后的密码");
        String password = sc.nextLine();
        DatabaseOperation.connect(4, id, userName, password);
        print.printAndNote("修改成功", "id为: " + id + "的账户名被修改为" + userName + " 密码被修改为: " + password);
    }
}
