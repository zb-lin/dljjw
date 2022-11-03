package pers.lzb.platform;

public class Menu {
    private String shopName;
    private String foodOne;
    private String foodTwo;

    private String priceOne;
    private String priceTwo;


    public Menu() {

    }

    public Menu(String shopName,String foodOne, String foodTwo, String priceOne, String priceTwo) {
        this.shopName = shopName;
        this.foodOne = foodOne;
        this.foodTwo = foodTwo;
        this.priceOne = priceOne;
        this.priceTwo = priceTwo;
    }
    public void setShopName(String shopName){
        this.shopName=shopName;
    }
    public  String getShopName(){
        return shopName;
    }

    public void setFoodOne(String foodOne) {
        this.foodOne = foodOne;
    }

    public String getFoodOne() {
        return foodOne;
    }


    public void setFoodTwo(String foodTwo) {
        this.foodTwo = foodTwo;
    }

    public String getFoodTwo() {
        return foodTwo;
    }


    public void setPriceOne(String priceOne) {
        this.priceOne = priceOne;
    }
    public String getPriceOne() {
        return priceOne;
    }


    public void setPriceTwo(String priceTwo) {
        this.priceTwo = priceTwo;
    }

    public String getPriceTwo() {
        return priceTwo;
    }

}
