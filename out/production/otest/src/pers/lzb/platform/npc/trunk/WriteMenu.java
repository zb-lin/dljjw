package pers.lzb.platform.npc.trunk;


import java.io.*;

import java.util.ArrayList;

public class WriteMenu {
    public void writeMenu(String foodFileName, ArrayList<Menu> array) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(foodFileName));
        for (int i = 0; i < array.size(); ++i) {
            Menu menu = array.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(menu.getShopName() + "阿斯达多所大所" + menu.getFood() + "阿斯达多所大所" + menu.getPrice());
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }


}
