public class HashTable
{
	private Node [] values;
	private int tHold;
	private int numVals;

	public HashTable()
	{
		values = new Node[10];
		for(int i=0; i<values.length; i++)
		{
			values[i]=null;
		}
		tHold=2;
		numVals=0;
	}

	public void insert(int num)
	{
		numVals++;
		if(tHold < ((double)numVals)/((double)values.length))
		{
			rehash();
			System.out.println("Rehash!");
		}
		int index = hash(num);
		placeNode(index,num);
	}
	private void rehash()
	{
		Node temp [] = values;
		values = new Node[temp.length*2];
		for(int i=0; i<values.length; i++)
		{
			values[i]=null;
		}
		for(int i=0; i<temp.length; i++)
		{
			Node j = temp[i];
			while(j!=null)
			{
				insert(j.data);
				j=j.next;
			}
		}

	}
	private void placeNode(int index, int num)
	{
		Node temp = new Node();
		temp.data=num;
		temp.next=null;
		
		if(values[index]==null)
		{
			values[index]=temp;
		}
		else
		{
			temp.next = values[index];
			values[index]=temp;
		}
	}

	private int hash(int num)
	{
		return num % values.length;
	}
	public String toString()
	{
		String out = "";
		for(int i=0; i<values.length; i++)
		{
			out += i+": ";
			Node j = values[i];
			while(j!=null)
			{
				out += j.data + " -> ";
				j=j.next;
			}
			out += "\n";
		}
		return out;
	}

}
