//  Tester class.  Do not change anything in this class.

/*  Tasks for the data abstraction section:
 *   - Add code to the 'Transaction' class to implement the Comparable interface
 *   - Complete the InvoiceItem and Invoice classes
 *      (See comments in the InvoiceItem.java and Invoice.java)
 *  See also the Item.java class and expected output in output.txt
 *  Note your output will vary slightly for the data stamp - hh:mm:ss
 */
import java.util.*;
public class Tester
{
	public static void main(String[] args)
	{
		Transaction[] trans = new Transaction[4];
		PO po;
		Invoice iv;
		
		po = new PO(101, 502, "Pending");
		po.addItem(42, "Lumia 900", 425.00, 2, 1.50);
		trans[3] = po;
		
		po = new PO(102, 501, "Approved");
		po.addItem(24, "Lumia 300", 433.00, 2, 2.0);
		po.addItem(86, "iPhone 4S", 721.50, 1, 1.75);
		trans[2] = po;
		
		iv = new Invoice(201, 902, false);
		iv.addItem(1255, "Samsung Flash", 125.00, 2, 5);
		iv.addItem(198, "HTC m7", 533.00, 1, 4);
		trans[1] = iv;
		
		iv = new Invoice(202, 901, true);
		iv.addItem(681, "Lumia 822", 470.50, 3, 4);
		iv.addItem(199, "HTC One", 389.00, 1, 5);
		iv.addItem(1255, "Samsung Flash", 125.00, 2, 3);
		trans[0] = iv;
		
		//  This call to Arrays.sort will require implementation of the
		//  Comparable interface in the Transaction class...
		Arrays.sort(trans);
		
		for (Transaction t : trans)
		{
			//  Show formatted PO's and invoices...
			System.out.println(t);
			
			//  Process inventory...
			for (Item i : t.getItems())
			{
				System.out.println("\t" + i.changeInventory());
			}
		}
	}
}
