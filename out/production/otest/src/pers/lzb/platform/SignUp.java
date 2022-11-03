package pers.lzb.platform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class SignUp {
    public void signUp(String fileName) throws IOException {
        ArrayList<Account> array = new ArrayList<>();
        ReadFile readFile =new ReadFile();
        readFile.readFile(fileName, array);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名");
        String username = sc.nextLine();
        System.out.println("请输入你的密码");
        String password = sc.nextLine();
        //        boolean flag = false;

        for (int i = 0; i < array.size(); ++i) {
            if (array.get(i).getUsername().equals(username)) {
                System.out.println("你已经注册！");
                return;
            }
        }
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        array.add(account);
        WriteFile writeFile = new WriteFile();
        writeFile.writeFile(fileName, array);
        System.out.println("注册成功");


//            }
//            if (flag) {
//                System.out.println("你已经注册！");
//            } else {
//                break;
//            }
    }

}
