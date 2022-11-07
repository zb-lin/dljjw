package pers.lzb.platform.major.tools;

import pers.lzb.platform.major.trunk.Account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


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
        Print print = new Print();
        print.print("请输入你的姓名");
        String username = sc.nextLine();
        for (int i = 0; i < array.size(); ++i) {
            if (array.get(i).getUsername().equals(username)) {
                print.printAndNote("你已经注册！", "错误:用户输入的用户名" + username + "已注册");
                return;
            }
        }
        print.print("请输入你的密码");
        print.print("你的密码必须同时包括数字和字母且大于3位");
        String password = sc.nextLine();
        String pattern = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{3,1000}$";  // 正则表达式

        boolean flag = Pattern.matches(pattern, password);  // 判断password是否符合要求
        if (!flag) {
            print.print("你的密码必须同时包括数字和字母且大于3位");
        } else {
            Account account = new Account();
            account.setUsername(username);
            account.setPassword(password);
            array.add(account);
            WriteFile writeFile = new WriteFile();
            writeFile.writeFile(fileName, array);
            print.printAndNote("注册成功!", "用户注册成功,账号为 " + username + ",密码为 " + password);
        }


    }

}

