package pers.lzb.platform.npc.trunk;

import pers.lzb.platform.npc.trunk.Menu;

import java.io.*;
import java.util.*;

public class ReadMenu {
    public void readMenu(String foodFilmName, ArrayList<Menu> array) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(foodFilmName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] str = line.split(" ");
            Menu menu = new Menu();
            menu.setShopName(str[0]);
            menu.setFood(str[1]);
            menu.setPrice(str[2]);

            array.add(menu);
        }
        br.close();
    }
}
