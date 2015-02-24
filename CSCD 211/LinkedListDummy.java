
public class LinkedListDummy
{
	private class Node
	{
		public int value;
		public Node next;

		public Node(int aValue)
		{
			this.value = aValue;
		}
	}

	private Node head;
	private int size;

	public LinkedListDummy()
	{
		this.head = new Node(0);  // Different here...
	}

	public void add(int value)  //  Note no special case...
	{
		Node newNode = new Node(value);

		Node curr = head;
		while (curr.next != null)
		{
			curr = curr.next;
		}
		curr.next = newNode;

		size++;
	}

	public void add(int index, int value)
	{
		if (index >= 0 && index <= size)
		{
			Node newNode = new Node(value);
			if(index == 0)  //  Still a special case...
			{
				newNode.next = head.next;  //  Different here...
				head.next = newNode;	
			}
			else
			{
				Node prev = find(index - 1);
				newNode.next = prev.next;
				prev.next = newNode;
			}
			size++;
		}
		else
		{
			throw new IndexOutOfBoundsException("List index error on add (out of range): " + index);
		}
	}

	private Node find(int index)
	{
		Node curr = head.next;  //  Different here...
		for (int skip = 0; skip < index; skip++)
		{
			curr = curr.next;
		}

		return curr;
	}


	public void delete(int index)
	{
		if (index >= 0 && index < size)
		{
			if(index == 0)
			{
				head.next = head.next.next;  // Different here...
			}
			else
			{
				Node prev = find(index - 1);
				Node curr = prev.next;
				prev.next = curr.next;
			}
			size--;
		}
		else
		{
			throw new IndexOutOfBoundsException("List index error on add (out of range): " + index);
		}
	}

	public int getItem(int index)
	{
		if (index >= 0 && index < size)
		{
			Node curr = find(index);
			return curr.value;
		}
		else
		{
			throw new IndexOutOfBoundsException("List index error on add (out of range): " + index);
		}
	}

	public void setItem(int index, int aValue)
	{
		if (index >= 0 && index < size)
		{
			Node curr = find(index);
			curr.value = aValue;		
		}
		else
		{
			throw new IndexOutOfBoundsException("List index error on add (out of range): " + index);
		}
	}

	public String toString()
	{
		String s = "";
		for(Node curr = head.next; curr != null; curr = curr.next)
		{
			s = s + curr.value + " ";
		}
		return s;
	}
}
