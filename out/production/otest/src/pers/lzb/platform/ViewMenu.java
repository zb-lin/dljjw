package pers.lzb.platform;

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewMenu {
    public void viewMenu(String foodFileName) throws IOException {
<<<<<<< HEAD
        Read read = new Read();
        ArrayList<Menu> array;
        array=read.read(foodFileName);

=======
        ArrayList<Menu> array = new ArrayList<>();
        ReadMenu readMenu = new ReadMenu();
        readMenu.readMenu(foodFileName, array);
>>>>>>> 913256cc50054b46235986208786b218c86e5f2f
        for (int i = 0; i < array.size(); ++i) {
            System.out.println(array.get(i).getShopName() + " " + array.get(i).getFood() + " " + array.get(i).getPrice());
        }
    }
}
