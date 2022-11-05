package pers.lzb.platform;

import java.io.IOException;
import java.util.Scanner;

public class Start {
    public void start(String fileName, String foodFileName) throws IOException {
        while (true) {
            System.out.println("如果你还没有注册，请按:1");
            System.out.println("如果你已经注册，请按:2登录");
            System.out.println("如果你想退出，请按:3");
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();

            switch (number) {
                case 1:                                //注册

                    SignUp signUp = new SignUp();
                    signUp.signUp(fileName);
                    break;

                case 2:                                //登录
                    Login login = new Login();
                    if (login.login(fileName)) {
                        System.out.println("如果你是indiaNpc请按:1,如果你是买家，请按:2");
                        int num = sc.nextInt();

                        if (num == 1) {
                            Npc npc = new Npc();
                            npc.npc(foodFileName);
                        } else if (num == 2) {                     //买家
                            Customer customer = new Customer();
                            customer.customer(foodFileName);
                        }

                    } else {            //登录失败
                        System.out.println("登录失败！");
                        break;
                    }
                case 3:               //退出
                    System.exit(0);
            }
        }
    }
}
