package pers.lzb.platform;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.SimpleTimeZone;


public class Order {
    public void order(String foodFileName) throws IOException {

        ArrayList<Menu> array = new ArrayList<>();
        ReadMenu readMenu = new ReadMenu();
        readMenu.readMenu(foodFileName, array);

        Calendar nowTime = Calendar.getInstance();

        float sum = 0;

        while (true) {
            Scanner sc =new Scanner(System.in);
            System.out.println("请输入你要的店家！！");
            String shopName = sc.nextLine();

            System.out.println("请输入你要的菜！");
            Scanner scan = new Scanner(System.in);
            String foodName = scan.nextLine();

            boolean flag = true;
            for (int i = 0; i < array.size(); ++i) {
                if (shopName.equals(array.get(i).getShopName())) {
                    if (foodName.equals(array.get(i).getFood())) {
                        flag = false;
                    }
                }
            }
            if (flag) {
                System.out.println("你要的菜不存在！");
            }


            for (int i = 0; i < array.size(); ++i) {
                if (shopName.equals(array.get(i).getShopName())) {
                    if (foodName.equals(array.get(i).getFood())) {
                        sum = sum + Float.parseFloat(array.get(i).getPrice());
                    }
                }
            }
            System.out.println("如果你点餐完毕，请按:1");
            int num = sc.nextInt();
            if (num == 1) {
                break;
            }
        }
        System.out.println("谢谢惠顾,一共是" + sum + "元");
        System.out.println("请填写您的外卖地址！");
        Scanner scanner = new Scanner(System.in);
        String address = scanner.nextLine();
        if(address.equals("印度")||address.equals("india")||address.equals("India")){
            System.out.println("商家正在备餐！");
            nowTime.add(Calendar.MINUTE,30);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("预计送达时间:"+sdf.format(nowTime.getTime()));
        }else{
            System.out.println("商家正在备餐！");
            nowTime.add(Calendar.YEAR,1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("预计送达时间:"+sdf.format(nowTime.getTime()));
            System.out.println("感觉太晚就按:1启用飞机运输！！");
            Scanner sca = new Scanner(System.in);
            int num = sca.nextInt();
            if(num == 1 ){
                System.out.println("你被骗了！");
            }
        }
    }
}
