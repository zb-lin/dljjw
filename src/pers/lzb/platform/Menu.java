package pers.lzb.platform;

public class Menu {
    private String shopName;
    private String foodOne;
    private String priceOne;

    public Menu() {
    }

    //    public Menu(String shopName, String foodOne, String priceOne) {
//
//       this.shopName = shopName;
//        this.foodOne = foodOne;
//        this.priceOne = priceOne;
//    }
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setFoodOne(String foodOne) {
        this.foodOne = foodOne;
    }

    public String getFoodOne() {
        return foodOne;
    }

    public void setPriceOne(String priceOne) {
        this.priceOne = priceOne;
    }

    public String getPriceOne() {
        return priceOne;
    }


}