import java.io.*;
import java.util.*;
/**
 * Extract customer data from txt file.
 *
 * @author Hasanulanuar
 * @version 29/6/2022
 */
public class CustomerData
{
    //Gets customer data through txt file, returns an array
    public static LinkedList<CustomerInformation> getCustData() throws IOException {
        String[] custData = new BufferedReader(new FileReader("customerData.txt")).lines().toArray(String[]::new);
        
        LinkedList<CustomerInformation> tempCustomerList = new LinkedList<>();
        //Loop to go through text file input
        for (String text : custData) {
            StringTokenizer st = new StringTokenizer(text, ";");
            //Declaring variable for each data
            String custId = st.nextToken();
            String custIc = st.nextToken();
            int counterPaid = Integer.parseInt(st.nextToken());
            String itemId = st.nextToken();
            String itemName = st.nextToken();
            double itemPrice = Integer.parseInt(st.nextToken());
            String datePurchase = st.nextToken();
            
            CustomerInformation ci = new CustomerInformation(custId, custIc, counterPaid, null);
            ItemInformation i = new ItemInformation(ci, itemId, itemName, datePurchase, itemPrice);
            ci.setItem(i);

            tempCustomerList.add(ci);
        }//End of for loop

        return tempCustomerList;
    }//End of linkedlist
}//End of class
