public class InsertionSort
{
	public static void main(String [] args)
	{
		int [] values = {100,6,4,5,400,9,12,1,4,56,1,2,0};
		printArray(values);
		insertionSort(values);
		printArray(values);
	}
	public static void insertionSort(int [] data)
	{
		//go through the data array and 'place' elements into corresponding positions
		for(int i=1; i<data.length; i++)
		{
			//starting at position i, move forward to find
			//the correct position of the ith element
			for(int j=i; j>0; j--)
			{
				//the element in front is larger
				//so swap them
				if(data[j]<data[j-1])
				{
					int temp = data[j];
					data[j]=data[j-1];
					data[j-1]=temp;
				}
				else
				{
					//the element in front is smaller or
					//equal to the current element so break 
					//because the right position has been found
					//and the next element in the array can now be 
					//taken in order to find its correct sorted
					//position
					break;
				}
			}

		}
	}

	//debugging function to print out array
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
