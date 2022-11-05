package pers.lzb.platform.buyer;

import pers.lzb.platform.major.tools.Read;
import pers.lzb.platform.npc.trunk.Menu;

import java.io.*;

import java.util.ArrayList;

public class ViewMenu {
    public void viewMenu(String foodFileName) throws IOException {
        Read read = new Read();
        ArrayList<Menu> array;
        array = read.read(foodFileName);

        for (int i = 0; i < array.size(); ++i) {
            System.out.println(array.get(i).getShopName() + " " + array.get(i).getFood() + " " + array.get(i).getPrice());
        }
    }
}
