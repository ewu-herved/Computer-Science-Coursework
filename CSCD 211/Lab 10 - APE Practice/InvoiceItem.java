
   public class InvoiceItem extends Item
   {
    
   //  Add variable 'ouncesPerUnit' as an int...

   protected int ouncesPerUnit;

   
   //  Add constructor.  
   //   Parameters are: int itemID, String description, double price, int quantityOrdered, int ouncesPerUnit

   public InvoiceItem(int itemID, String description, double price, int quantityOrdered, int ouncesPerUnit) {
      
      super(itemID, description, price, quantityOrdered);
      this.ouncesPerUnit = ouncesPerUnit;
   }


   
   //  Add 'changeInventory' method...
	//   The method creates a String that reports the processing that would take place.
	//   See example output in output.txt

   protected String changeInventory() {
   
      return "\n\tInventory has been relieved for " + description + " by " + quantity;
   }


   
   
   //  Override 'toString' method here.
	//   Return 'toString' from Item class plus the ounces per unit...

   @Override
   public String toString() {
   
      return "\tItem: " + itemID + " - " + description +
				" Quantity: " + quantity + ", Cost: " + unitPrice * quantity + "Ounces: " + ouncesPerUnit;
   }

   
   
   }
