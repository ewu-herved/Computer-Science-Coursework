
//  Item class - do not change anything in this class
 
public abstract class Item
{
	protected int itemID;
	protected String description;
	protected double unitPrice;
	protected int quantity;
	
	public Item(int itemID, String description, double unitPrice, int quantity)
	{
		this.itemID = itemID;
		this.description = description;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	protected abstract String changeInventory();
	
	@Override
	public String toString()
	{
		return "\tItem: " + itemID + " - " + description +
				" Quantity: " + quantity + ", Cost: " + unitPrice * quantity;
	}

}