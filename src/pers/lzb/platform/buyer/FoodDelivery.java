package pers.lzb.platform.buyer;

import pers.lzb.platform.major.tools.Print;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class FoodDelivery {
    /**
     * 送餐服务
     *
     * @author lzb
     */
    public void foodDelivery() throws IOException {
        Calendar nowTime = Calendar.getInstance();  // 得到当前时间
        Scanner sc = new Scanner(System.in);
        Print print = new Print();
        print.print("请填写您的外卖地址！");

        String address = sc.nextLine();
        if (address.equals("印度") || address.equals("india") || address.equals("India")) {  // 送到本国比较快
            print.note("买家来自 " + address);
            print.print("商家正在备餐！");
            nowTime.add(Calendar.MINUTE, 30);  // 当前时间加30分钟
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 转换时间格式
            print.print("预计送达时间:" + sdf.format(nowTime.getTime()));
        } else {  // 送到外国比较慢
            print.note("买家来自 " + address);
            print.print("商家正在备餐！");
            nowTime.add(Calendar.YEAR, 1);  // 当前时间加1小时
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 转换时间格式
            print.print("预计送达时间:" + sdf.format(nowTime.getTime()));
            sc.nextLine();  // 吞掉一个回车,避免后续地址输入回车
        }
    }
}
