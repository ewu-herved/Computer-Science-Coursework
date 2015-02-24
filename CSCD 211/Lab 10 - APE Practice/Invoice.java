   import java.util.*;

   public class Invoice extends Transaction
   {
   //  Add a true/false variable - 'isPaid'...
     
	   protected boolean isPaid;
      protected String items = "";      
      protected String inventory = "";     
   
   //  Add an Explicit Value Constructor.
	//   Parameters: int tranID, int customer, boolean paid
  	//   Note 'tranID' is private to the Item class
 
 
   public Invoice(int tranID, int customer, boolean paid) {
      
      super(tranID,customer);
      isPaid = paid;
   }
 
 
   
   //  Add an 'addItem' method here.
	//   The method creates a new InvoiceItem object and adds it to the ArrayList
	//    inherited from the Transaction class.
	//   Parameters: int itemID, String desc, double price, int qty, int ounces

   protected InvoiceItem addItem(int itemID, String desc, double price, int qty, int ounces) {
   
      InvoiceItem temp = new InvoiceItem(itemID, desc, price, qty, ounces);
      
      items += "\n\tItem: " + itemID + " - " + desc + " Quantity: " + qty + ", Cost: + " 
                         + price * qty + " Ounces: " + ounces;
      
      inventory += temp.changeInventory();
      
      return temp;
   }
   




   //  Override toString here.
   //   Return value must include 'tranID' from Transaction, 'isPaid' 
	//   and listing of InvoiceItems...
   //   See example output in output.txt.

   @Override
   public String toString() {

      return "\nInvoice#: " + super.toString() +
	          "\n\tCustomer: " + participantID + " Paid: " + isPaid + 
             items +
             "\n" + inventory;

   }
}