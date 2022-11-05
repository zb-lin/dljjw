package pers.lzb.platform;

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewMenu {
    public void viewMenu(String foodFileName) throws IOException {
        Read read = new Read();
        ArrayList<Menu> array;
        array=read.read(foodFileName);

        for (int i = 0; i < array.size(); ++i) {
            System.out.println(array.get(i).getShopName() + " " + array.get(i).getFood() + " " + array.get(i).getPrice());
        }
    }
}
