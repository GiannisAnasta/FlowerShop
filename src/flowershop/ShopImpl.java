/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

/**
 *
 * @author sy
 */
public class ShopImpl {

    private Flower[] flowerInShop;
    private Flower[] flowerToBouquet = new Flower[0];

    public void addFlowersToShop() {

        flowerInShop = new Flower[10];
       
        for (int i = 0; i < 10; i++) {
            Flower f = new Flower();// declaration

            f.setPrice(i + 5.64);
            f.setColor(getIntBasedColor(i));
            f.setSort(getIntBasedSort(i));
            flowerInShop[i] = f;// added to array
        }

    }

    public void printAvailableFlowers() {
        System.out.println("All The Available Flowers");
        System.out.println("============================");
        for (int i = 0; i < flowerInShop.length; i++) {
            System.out.println("number of flower: " + i);
            System.out.println("sort: " + flowerInShop[i].getSort());
            System.out.println("price: " + flowerInShop[i].getPrice());
            System.out.println("color: " + flowerInShop[i].getColor());
            System.out.println("\n\n");
        }
    }

    private String getIntBasedColor(int i) {
        String redcolor = "red";
        String bluecolor = "blue";
        String whitecolor = "white";
        String yellowcolor = "yellow";

        if (i < 2) {
            return redcolor;
        }
        if (i < 5) {
            return bluecolor;
        }
        if (i < 7) {
            return whitecolor;
        }
        return yellowcolor;

    }

    private String getIntBasedSort(int i) {
        String rosesort = "Rose";
        String anthuriumsort = "Anthurium";
        String dandelionsort = "Dandelion";

        if (i % 2 == 0) {
            return rosesort;
        }

        if (i % 3 > 1) {
            return anthuriumsort;
        }
        return dandelionsort;

    }

    public void addFlowerToBouquet(int number) {
        Flower[] newBouquet = new Flower[flowerToBouquet.length + 1];

        for (int i = 0; i < flowerToBouquet.length; i++) {
            {
                newBouquet[i] = flowerToBouquet[i];
            }
        }
        
        newBouquet[flowerToBouquet.length ] = flowerInShop[number];
        

        flowerToBouquet = newBouquet;

    }
    
    public void printFlowerBouquet(){
    System.out.println("My Bouquet is:");
    for (int i = 0; i < flowerToBouquet.length; i++) {
            System.out.println("number: " + i);
            System.out.println("sort: " + flowerToBouquet[i].getSort());
            System.out.println("price: " + flowerToBouquet[i].getPrice());
            System.out.println("color: " + flowerToBouquet[i].getColor());
            System.out.println("\n\n");
    
    
   
    }
    }
    
    
    public boolean buyBouquet(double money){
          System.out.println("i will buy.");
           double summary=0;
            for (int i = 0; i < flowerToBouquet.length; i++)
             summary +=flowerToBouquet[i].getPrice();
            if (money<summary) 
        System.out.println("You dont have enough money!");
           return money>=summary;
            
    }
    
    public void clearBucket(){
     flowerToBouquet = new Flower[0];
        
        
    }
    
    
    
}
