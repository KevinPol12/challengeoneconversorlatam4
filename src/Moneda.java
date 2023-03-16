
public class Moneda {

    private String name;
    private double valuePerDollar;
    private double valueFromDollar;
    
    public Moneda(String name,double valuePerDollar){
        this.name = name;
        this.valuePerDollar=valuePerDollar;
        this.valueFromDollar=1/valuePerDollar; //reverse
    }

    public String getName() {
        return name;
    }

    public double getValuePerDollar() {
        return valuePerDollar;
    }

    public double getValueFromDollar() {
        return valueFromDollar;
    }
    
    
    

}// End class
