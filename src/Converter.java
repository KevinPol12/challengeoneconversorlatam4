
import java.util.ArrayList;

public class Converter {
;

    private ArrayList<Moneda> monedas = new ArrayList<>();

    public Converter() {

        Moneda moneda0 = new Moneda("USD", 1);
        Moneda moneda1 = new Moneda("HNL", 24.5);
        Moneda moneda2 = new Moneda("Yuan", 6.91);
        monedas.add(moneda0);
        monedas.add(moneda1);
        monedas.add(moneda2);

    }
    
    public void greetUser(){
        System.out.println("Welcome to the currency exchange calculator.");
    }
    

    public void convertAndPrint(int initCoin, double amount, int finalCoin) {
        double dollarAmount = 0;
        double goalCoinAmount = 0;
        double convertionRateToDollar= monedas.get(finalCoin).getValuePerDollar();
        double convertionRateFromDollar= monedas.get(initCoin).getValueFromDollar();
        String goalName= monedas.get(finalCoin).getName();
        String initName= monedas.get(initCoin).getName();
        
        System.out.printf("You want to convert %.2f %s to %s currency.\n",amount,
                            initName,goalName);
        
        if (initCoin == 0) {
            dollarAmount = amount;
            goalCoinAmount = dollarAmount * convertionRateToDollar;
            System.out.println("The amount in " + goalName + " is " + goalCoinAmount);

        } else if (initCoin != 0) {
            dollarAmount = amount * convertionRateFromDollar;
            goalCoinAmount = dollarAmount * convertionRateToDollar;
            System.out.println("The amount in " + goalName + " is " + goalCoinAmount);
        } else {
            System.out.println("Not applicable");
        }

    }//End convertAndPrint

public void printCoinOptions() {
        int pos = 1; //For internal processing we will use the usual from 0 arraycounter 
        //but to display the options to the user we will start from 1.
        for (Moneda moneda : monedas) {
            System.out.println(pos + "." + moneda.getName());
            pos++;
        }
    }

}// End class
