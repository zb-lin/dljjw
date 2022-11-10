package pers.lzb.platform.major.trunk.administrator;

import pers.lzb.platform.npc.trunk.NpcDatabase;

import java.io.IOException;

public class AdministratorViewFood {
    /**
     * 管理员查看菜品
     *
     * @author lzb
     */
    public void administratorViewFood() throws IOException {
        NpcDatabase.npcDatabase(3, "1", null, null, null);
    }
}
