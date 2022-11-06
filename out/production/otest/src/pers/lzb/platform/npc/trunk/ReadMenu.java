package pers.lzb.platform.npc.trunk;


import java.io.*;
import java.util.*;

public class ReadMenu {
    public void readMenu(String foodFilmName, ArrayList<Menu> array) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(foodFilmName));
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.isEmpty()) {
                String[] str = line.split("阿斯达多所大所");
                Menu menu = new Menu();

                menu.setShopName(str[0]);

                menu.setFood(str[1]);

                menu.setPrice(str[2]);
                array.add(menu);
            }


        }
        br.close();
    }
}
