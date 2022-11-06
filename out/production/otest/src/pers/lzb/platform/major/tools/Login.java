package pers.lzb.platform.major.tools;

import pers.lzb.platform.major.trunk.Account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Login {
    public boolean login(String fileName) throws IOException {
        ArrayList<Account> array = new ArrayList<Account>();
        ReadFile readFile = new ReadFile();
        readFile.readFile(fileName, array);

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入姓名");
        String username = sc.nextLine();

        System.out.println("请输入密码！");
        String password = sc.nextLine();
        JudgePassword judge = new JudgePassword();
        return judge.judgePassword(array, username, password);
    }
}
