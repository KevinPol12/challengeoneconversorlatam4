package logic;

public class Moneda {

    private String name;
    private double valuePerDollar;
    private double valueFromDollar;
    private int index;
    private String symbol;
    
    public Moneda(String name,double valuePerDollar,int index,String symbol){
    	this.name = name;
    	this.valuePerDollar=valuePerDollar;
    	this.valueFromDollar=1/valuePerDollar; //reverse
    	this.index=index;
    	this.symbol=symbol;
    }
    
    public int getIndex() {
		return index;
	}

	public String getSymbol() {
		return symbol;
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
    
    @Override
    public String toString() {
    	return this.name;
    }
    
    
    

}// End class
