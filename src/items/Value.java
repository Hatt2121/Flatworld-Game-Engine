package items;

public class Value {
	
	public double value;
	
	public Currency currency;
	
	public Value(double value, Currency currency) {
		this.currency = currency;
		this.value = value;
	}
}
