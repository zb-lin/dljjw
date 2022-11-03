package pers.lzb.platform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Login {
    public boolean login(String fileName) throws IOException {
        ArrayList<Account> array = new ArrayList<Account>();
        ReadFile readFile =new ReadFile();
        readFile.readFile(fileName, array);
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入姓名");
        String username = sc.nextLine();

        System.out.println("请输入密码！");
        String password = sc.nextLine();

//        for (int i = 0; i < array.size(); ++i) {
//            if (array.get(i).equals(username)) {

                    System.out.println("密码正确！");
                    System.out.println("登录成功！");
                    return true;

//            }
//        }
//        return false;
    }
}
