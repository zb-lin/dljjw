package pers.lzb.platform.major.trunk.administrator;

import pers.lzb.platform.major.tools.io.Print;

import java.util.Scanner;

public class JudgeAdministrator {
    /**
     * 判断管理员密码是否正确
     *
     * @return 是否正确
     * @author lzb
     */
    public boolean judgeAdministrator() {
        Print print = new Print();
        Scanner sc = new Scanner(System.in);
        print.print("请输入管理员密码");
        String password = sc.nextLine();
        if (password.equals("lzbabab")) {
            return true;
        }
        return false;

    }
}
