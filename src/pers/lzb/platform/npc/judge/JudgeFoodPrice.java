package pers.lzb.platform.npc.judge;

public class JudgeFoodPrice {
    /**
     * 判断价格是否为整数
     *
     * @param price 价格
     * @return 是否为整数
     * @author lzb
     */
    public boolean judgeFoodPrice(String price) {

        for (int i = 0; i < price.length(); ++i) {
            int ch = price.charAt(i);
            if (ch < 48 || ch > 57) {  // 使用ACSII判断
                return true;
            }
        }
        return false;
    }
}