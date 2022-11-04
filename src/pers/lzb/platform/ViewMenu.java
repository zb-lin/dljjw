package pers.lzb.platform;

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewMenu {
    public void viewMenu(String foodFileName) throws IOException {
        ArrayList<Menu> array = new ArrayList<>();
        ReadMenu readMenu = new ReadMenu();
        readMenu.readMenu(foodFileName, array);
        for (int i = 0; i < array.size(); ++i) {
            System.out.println(array.get(i).getShopName() + " " + array.get(i).getFood() + " " + array.get(i).getPrice());
        }
    }
}
