package pers.lzb.platform;

import java.io.*;

import java.util.ArrayList;

public class WriteMenu {
    public void writeMenu(String foodFileName, ArrayList<Menu> array) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(foodFileName));
        for (Menu menu : array) {
            bw.write(
                    menu.getID() + " " + menu.getShopName() + " " + menu.getFoodOne() + " " + menu.getPriceOne());
            bw.newLine();
            bw.flush();

        }
        bw.close();
    }


}
