public class HeapSort
{
	public static void main(String [] args)
	{
		int data [] = {40,25,10,13,10,5,2,6,8,5};
		printArray(data);
		hsort(data);
		printArray(data);

	}
	public static void hsort(int data [])
	{
		//build a maximum heap yo 
		buildheap(data);

		//exchange last with first positions 
		//and recreate the maxheap. continue 
		//till the loop reaches the beginning 
		//of the array and thus end up with 
		//a sorted array
		int n = data.length-1;
		for(int i=n; i>0; i--)
		{
			int temp = data[0];
			data[0]=data[i];
			data[i]=temp;
			n--;
			maxheap(data,0,n);
		}
	}
	public static void buildheap(int data[])
	{
		//start at 'size/2' because that is the last 'parent' node 
		//in the array. if you go past size/2 then only child nodes
		//remiain or subtrees that are not heaps 
		int size = data.length-1;
		for(int i=size/2; i>=0; i--)
		{
			maxheap(data,i,size);
		}
	}
	public static void maxheap(int data[], int par, int size)
	{
		//determine which one is the largest:
		//the parent, left child, or right child 
		int left = 2*par;
		int right = 2*par+1;
		int largest;
		if(left<=size && data[left]>data[par])
			largest=left;
		else
			largest=par;
		if(right<=size && data[right]>data[largest])
			largest=right;

		//if largest is not the parent exchange and 
		//keep on sifting down the 'old' parent recursively
		if(largest != par)
		{
			int temp = data[largest];
			data[largest]=data[par];
			data[par]=temp;
			maxheap(data, largest, size);
		}
	}
	public static void printArray(int [] values)
	{
		String out = "";
		for(int i=0; i<values.length; i++)
		{
			out += values[i] + ", ";
		}
		System.out.println(out);
	}

}
