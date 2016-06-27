/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author sy
 */
public class OnlineShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ShopImpl myShop = new ShopImpl();
        myShop.addFlowersToShop();
        System.out.println("How much money you have?");
        double money = -1;
        while (money == -1) {
            try {
                money = Double.parseDouble(br.readLine());
            } catch (NumberFormatException исключение) {
                System.out.println("Use digital numbers only");
            }
        }
        
        System.out.println("Hello client");

        myShop.printAvailableFlowers();

        boolean inShop = true;
        while (inShop) {
            //logic

            System.out.print("Choose flower:");

            boolean success = false;
            while (!success) {
                try {
                    int number = Integer.parseInt(br.readLine());
                    myShop.addFlowerToBouquet(number);
                    success = true;

                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("Dont use higher number than you see");
                } catch (NumberFormatException exe) {
                    System.out.println("Dont use such high number");
                }
            }

            myShop.printFlowerBouquet();
            System.out.print("Are you done ?(y/n)");
            String yn = br.readLine();
            if (yn.equals("y")) {
                boolean ready = myShop.buyBouquet(money);
                inShop = !ready; //after buy
            }
            if (inShop) {
                System.out.print("Are you going to leave the shop without flowers ?(y/n)");
                yn = br.readLine();
                if (yn.equals("y")) {
                    inShop = false; //after buy
                } else {
                    myShop.clearBucket();
                }
            }

//            System.out.println("Chosed: "+number);
        }

        System.out.println("Have a nice day!/ Заповядайте пак!");
    }

}
