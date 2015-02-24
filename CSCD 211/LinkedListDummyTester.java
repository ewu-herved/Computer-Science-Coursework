
public class LinkedListDummyTester
{
	public static void main(String[] args)
	{
		
		LinkedListDummy myList = new LinkedListDummy();
		
		myList.add(68);
		
		System.out.println(myList.getItem(0));
		
		myList.setItem(0, 89);
		System.out.println(myList);
		
		myList.add(42);
		myList.add(11);
		myList.add(25);
		myList.add(10);
		myList.add(49);
		
		System.out.println(myList);
		
		myList.add(2, 22);
		System.out.println(myList);
		
		myList.add(-1, 1111);
		System.out.println(myList);
		
		myList.delete(7);
		System.out.println(myList);
		

		
	}
}
