package pers.lzb.platform;

import java.util.Scanner;

import static pers.lzb.platform.business.Business;
import static pers.lzb.platform.npcFood.NpcFood;

public class Choice {




    public static void choice(){
        System.out.println("如果你是因地安npc，请输入:1,如果你想点外卖,请输入:2");
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        if(n == 1){
            NpcFood();                   //因地安npc
        }else if(n == 2){
            Business();                           //买家
        }else{
            System.out.println("你是隔壁的卧底吧！再见！");
            System.exit(0);
        }

    }





}
