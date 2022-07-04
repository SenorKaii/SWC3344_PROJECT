public class ItemInformation {
    private CustomerInformation ci;
    private String itemId, itemName, datePurchase;
    private double itemPrice;
    
    public ItemInformation(CustomerInformation ci, String itemId, String itemName, String datePurchase, double itemPrice){
        this.ci = ci;
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.datePurchase = datePurchase;
    }
    
    //public String getCustId() {return ci.custId;}
    //public String getCustIc() {return ci.custIc;}
    //public boolean isCounterPaid() {return ci.counterPaid;}

    public String getItemID() {return itemId;}
    public String getItemName() {return itemName;}
    public String getDatePurchase() {return datePurchase;}
    public double getItemPrice(){return itemPrice;}
    public CustomerInformation getCustomer() {return ci;}
    
    public void setCounterPaid(int n) {ci.setCounterPaid(n);}
    
     public String toString(){
        return "Item Information "
            + "\nItem ID: " + itemId 
            + "\nItem name: " + itemName 
            + "\nTotal price: " + itemPrice 
            + "\nDate of purchase: " + datePurchase;
    }
}

