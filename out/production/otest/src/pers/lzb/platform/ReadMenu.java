package pers.lzb.platform;
import java.io.*;
import java.util.*;

public class ReadMenu {
    public void readMenu(String foodFilmName, ArrayList<Menu> array) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(foodFilmName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] str = line.split(",");
            Menu menu = new Menu();  //报错在Account在加一个就行
            menu.setFoodOne(str[0]);
//            menu.setPriceOne(str[1]);
//            menu.setFoodTwo(str[2]);
//            menu.setPriceTwo(str[3]);
            array.add(menu);
        }
        br.close();
    }
}
