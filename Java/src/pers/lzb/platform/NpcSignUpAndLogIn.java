package pers.lzb.platform;

import java.util.*;

import java.util.Scanner;

public class NpcSignUpAndLogIn {
    static String npcName;
    static String npcPassword;
    static HashMap<String, String> hashMap = new HashMap<String, String>();

    public static void signUp() {                  //注册
        System.out.println("请输入你的名字！");     //输入名字
        Scanner name = new Scanner(System.in);
        npcName = name.nextLine();

        System.out.println("请输入你的密码");       //输入密码
        Scanner passage = new Scanner(System.in);
        npcPassword = passage.nextLine();

        hashMap.put(npcName, npcPassword);  //将名字和密码添进哈希表
        System.out.println("注册完毕！");
    }

    public static int logIn() {             //登录
        System.out.println("请输入你的名字！");
        Scanner name = new Scanner(System.in);
        npcName = name.nextLine();

        System.out.println("请输入你的密码！");
        Scanner passage = new Scanner(System.in);
        npcPassword = passage.nextLine();

        String temp = hashMap.getOrDefault(npcName, "你还没有注册！请先注册！");
        if(temp == "你还没有注册！请先注册！"){
            System.exit(0);
        }
        if (temp.equals(npcPassword)) {
            System.out.println("密码正确！请开始你的奇妙之旅！");
            return 1;
        } else {
            System.out.println("密码错误！请再输一遍！");
            return 0;
        }

    }


    public static void main(String[] args) {
//        if (hashMap.isEmpty()) {
            System.out.println("欢迎您，你是我们的第一个npc,请先注册！");
            signUp();
//        }

            System.out.println("如果你还想注册，请输入:1,否则请输入:2");

            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            while (num == 1){
                    signUp();
                System.out.println("如果你还想注册，请输入:1,否则请输入:2");
                Scanner temp = new Scanner(System.in);
                 num = temp.nextInt();
            }
            if (logIn() == 1){             //登录成功

                }else{                         //登录失败
                    System.out.println("你还有一次机会！");
                    if(logIn() == 1){

                    }else{
                        System.exit(0);
                    }
                }
    }

}


