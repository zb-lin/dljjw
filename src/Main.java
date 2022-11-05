import pers.lzb.platform.major.trunk.Start;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        String fileName = "data.txt";                     //文件路径
        String foodFileName = "foodData.txt";

        System.out.println("欢迎来到庸叔的印度npc国际外卖平台！！");
<<<<<<< HEAD
        Start start = new Start();
        start.start(fileName, foodFileName);
=======
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

                            while (true) {
                                System.out.println("如果你想增加菜品，请输入:1  如果你想删除菜品，请输入:2");
                                System.out.println("如果你想查询所有菜品，请输入:3  如果你想改你信息或菜品，请输入:4");
                                System.out.println("按其他键退出！");
                                int choice = sc.nextInt();
                                switch (choice) {
                                    case 1:                            //增
                                        AddFood addFood = new AddFood();
                                        addFood.addFood(foodFileName);
                                        break;
                                    case 2:                           //删
                                        DeleteFood deleteFood = new DeleteFood();
                                        deleteFood.deleteFood(foodFileName);
                                        break;
                                    case 3:                           //查
                                        FindFood findFood = new FindFood();
                                        findFood.findFood(foodFileName);
                                        break;
                                    case 4:                            //改
                                        ChangeFood changeFood = new ChangeFood();
                                        changeFood.changeFood(foodFileName);
                                        break;
                                    default:
                                        System.exit(0);
                                }
                            }
                        } else if (num == 2) {                     //买家
                            System.out.println("请看菜单！！");
                            System.out.println("店名 菜名 价格");
                            ViewMenu viewMenu = new ViewMenu();  //看菜单
                            viewMenu.viewMenu(foodFileName);
                            Order order = new Order();           //点餐
                            order.order(foodFileName);
                        }
                    } else {            //登录失败
                        System.out.println("登录失败！");
                        break;
                    }
                case 3:               //退出
                    System.exit(0);
            }
        }
>>>>>>> 913256cc50054b46235986208786b218c86e5f2f
    }
}