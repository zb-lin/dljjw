package pers.lzb.platform;

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
            menu.setPrice(str[1]);
            menu.setFood(str[2]);
            array.add(menu);
        }
        br.close();
    }
}
