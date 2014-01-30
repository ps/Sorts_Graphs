public class QuickSort
{
	public static void main(String [] args)
	{
		int data [] = {4,67,5,2,32,100,22,2,6};
		printArray(data);
		quickSort(data,0,data.length-1);
		printArray(data);

	}
	public static void quickSort(int data [], int left, int right)
	{
		//assign the left and right positions
		int i=left;
		int j=right;

		//get the pivot from the middle value
		int pivot = data[(left+right)/2];

		//advance as long as i and j do not cross each other
		while(i<=j)
		{
			//advance towards the right as long as the pivot is greater
			while(data[i]<pivot)
				i++;

			//advance towards the left as long as the pivot is smaller
			while(data[j]>pivot)
				j--;

			//if i is less than or equal to j then there were values 
			//found that can be swapped so swap them 
			if(i<=j)
			{
				int temp = data[i];
				data[i]=data[j];
				data[j]=temp;
				i++;
				j--;
			}
		}
		//recursively sort the left side 
		if(left<j)
			quickSort(data,left,j);

		//recursively sort the right side 
		if(i<right)
			quickSort(data,i,right);
	}
	//debug function for printing 
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
