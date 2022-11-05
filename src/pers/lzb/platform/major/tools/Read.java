package pers.lzb.platform.major.tools;

import pers.lzb.platform.npc.trunk.ReadMenu;
import pers.lzb.platform.npc.trunk.Menu;

import java.io.IOException;
import java.util.ArrayList;

public class Read {
    public ArrayList<Menu> read(String foodFileName) throws IOException {
        ArrayList<Menu> array = new ArrayList<>();
        ReadMenu readMenu = new ReadMenu();
        readMenu.readMenu(foodFileName, array);
        return array;
    }

}
