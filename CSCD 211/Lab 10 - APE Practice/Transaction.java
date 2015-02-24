import java.util.*;
/*  Modify this source code in the space indicated only!
 *
 *  Implement the Comparable interface in this class (see below)...
 */  

 
public abstract class Transaction implements Comparable <Transaction> // <--  Your code goes here
{
	// Note the tranID variable is private - do not change
	private   int  tranID;
	protected int  participantID;
	protected Date tranDate;
	protected ArrayList<Item> items;
	
	public Transaction(int tranID, int participantID)
	{
		this.tranID = tranID;
		this.participantID = participantID;
		this.tranDate = Calendar.getInstance().getTime();
		items = new ArrayList<Item>();
	}

	protected final ArrayList<Item> getItems()
	{
		return this.items;
	}
   
   
   /*  Implement the Comparable interface here.
	 *  Sort first by participantID and if the participantID's are the
	 *  same, sort by tranID.
	 */
	 
	 //  Your code goes here...
	 
    @Override
	 public int compareTo(Transaction tran)
    {    
      
      if (this.participantID - tran.participantID == 0) {
         return this.tranID - tran.tranID;
      }
      
      return this.participantID - tran.participantID;
    }

	   
	
	
	
	
	@Override
	public String toString()
	{
		return tranID + ", Date: " + tranDate;
	}
	
}
