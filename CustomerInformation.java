import java.util.*;

public class CustomerInformation implements Comparable {
	// Declare variable
	private String custId;
	private String custIc;
	private int counterPaid;
	private ItemInformation item;

	// Normal constructor
	public CustomerInformation(){}

	// Argument Constructor
	public CustomerInformation(String custId, String custIc, int counterPaid, ItemInformation item) {
		this.custId = custId;
		this.custIc = custIc;
		this.counterPaid = counterPaid;
		this.item = item;
	}
	
	// Accessor
	public String getCustId() {return custId;}
	public String getCustIc() {return custIc;}
	public int getCounterPaid() {return counterPaid;}
	public ItemInformation getItem() {return item;}

	// Mutator
	public void setCustomerId(String custId) {this.custId = custId;}
	public void setCustomerIc(String custIc) {this.custIc = custIc;}
	public void setCounterPaid(int n) {counterPaid = n;}
	public void setItem(ItemInformation item) {this.item = item;}
	
	@Override 
	//Determines whether an element is an instance of CustomerInformation or equal
	public boolean equals(Object o) {
		if (!(o instanceof CustomerInformation)) return false;
		return ((CustomerInformation) o).custId.equals(this.custId);
	}

	@Override public int hashCode() {
		return Objects.hash(custId);
	}

	@Override 
	//Compares an element
	public int compareTo(Object o) {
		if (!(o instanceof CustomerInformation)) return 0;
		CustomerInformation other = (CustomerInformation) o;
		
		if (other.equals(this)) return 0;
		return this.custId.compareTo(other.custId);
	}

	//toString method
	public String toString() {
		return  custId; 
	}
}
