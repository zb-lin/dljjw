import pers.lzb.platform.Login;
import pers.lzb.platform.SignUp;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        String fileName = "data.txt";
        String foodFileName = "foodData";

        System.out.println("欢迎来到庸叔的印度npc国际外卖平台！！");
        System.out.println("如果你是indiaNpc请按:1,如果你是买家，请按:2");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num == 1) {
            while (true) {
                System.out.println("如果你还没有注册，请按:1");
                System.out.println("如果你已经注册，请按:2登录");
                System.out.println("如果你想退出，请按:3");
                Scanner n = new Scanner(System.in);
                int number = n.nextInt();
                switch (number) {
                    case 1://注册
                        SignUp signUp = new SignUp();
                        signUp.signUp(fileName);
                        break;
                    case 2:               //登录
                        Login login = new Login();
                        if (login.login(fileName)) {
                            while (true) {
                                System.out.println("如果你想增加菜品，请输入:1  如果你想删除，请菜品输入:2");
                                System.out.println("如果你想查询所有菜品，请输入:3  如果你想改你的菜品，请输入:4");
                                System.out.println("按其他键退出！");
                                Scanner t = new Scanner(System.in);
                                int choice = t.nextInt();
                                switch (choice) {
                                    case 1:                            //增

                                    case 2:                           //删

                                    case 3:                           //查

                                    case 4:                            //改


                                    default:
                                        System.exit(0);
                                }


                            }

                        } else {            //登录失败
                            System.out.println("111");
                        }
                        break;


                    case 3:               //退出
                        System.exit(0);

                }


            }


        } else if (num == 2) {                //买家
            while (true) {

            }

        }


    }


}