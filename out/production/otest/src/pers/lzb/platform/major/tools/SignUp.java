package pers.lzb.platform.major.tools;

import pers.lzb.platform.major.trunk.Account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class SignUp {
    /**
     * 注册交互界面
     *
     * @param fileName 账号文件路径
     * @author lzb
     */
    public void signUp(String fileName) throws IOException {
        ArrayList<Account> array = new ArrayList<>();
        ReadFile readFile = new ReadFile();
        readFile.readFile(fileName, array);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名");
        String username = sc.nextLine();
        for (int i = 0; i < array.size(); ++i) {
            if (array.get(i).getUsername().equals(username)) {
                System.out.println("你已经注册！");
                return;
            }
        }
        System.out.println("请输入你的密码");
        String password = sc.nextLine();

        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        array.add(account);
        WriteFile writeFile = new WriteFile();
        writeFile.writeFile(fileName, array);
        System.out.println("注册成功");
    }
}
