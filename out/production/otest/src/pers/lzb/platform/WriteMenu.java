package pers.lzb.platform;

import java.io.*;

import java.util.ArrayList;

public class WriteMenu {
    public static void writeMenu(String foodFileName, ArrayList<Menu> array) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(foodFileName));
        for (int i = 0; i < array.size(); ++i) {
            Menu menu = array.get(i);
            StringBuilder sb = new StringBuilder();  //！！
            sb.append(menu.getID() + " " + menu.getShopName() + " " + menu.getFoodOne() + " " + menu.getPriceOne());
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();

        }
        bw.close();
    }


}
