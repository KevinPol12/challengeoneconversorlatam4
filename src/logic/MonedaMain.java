package logic;

import java.util.Scanner;

public class MonedaMain {

    public static void main(String[] args) {

        int initCoin = 0;
        int finalCoin = 0;
        double amount = 0;
        int end = 1;

        Scanner input = new Scanner(System.in);
        Converter converter = new Converter();

        converter.greetUser();

        do {
            System.out.println("Please pick the initial currency type: ");

            converter.printCoinOptions();

            initCoin = input.nextInt() - 1;

            System.out.println("Please enter the amount to convert: ");

            amount = input.nextDouble();

            System.out.println("Please pick the final currency to convert it to: ");

            converter.printCoinOptions();

            finalCoin = input.nextInt() - 1;

            converter.convertAndPrint(initCoin, amount, finalCoin);

            System.out.println("Press 1 to continue or 0 to terminate: ");

            end = input.nextInt();
            
        } while (end == 1);
        
        System.out.println("Thanks for using our services.");

    }//End main

}// End class
