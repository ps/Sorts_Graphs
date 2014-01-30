public class Mergesort
{
	public static void main(String [] args)
	{
		int [] values = {100,6,4,5,400,9,12,1,4,56,1,2,0};
		printArray(values);
		mergesort(values,0,values.length-1);
		printArray(values);
	}

	//this method is used to recursively create split an array into smaller parts
	public static void mergesort(int [] data, int low, int high)
	{
		if(low < high)
		{
			int middle = (low+high)/2;
			
			//split left side
			mergesort(data, low, middle);

			//split right side 
			mergesort(data, middle+1, high);

			//merge/actually sort the array
			merge(data, low, middle, high);
		}
	}

	//code responsible for sorting the provided section of an array
	public static void merge(int [] data, int low, int mid, int high)
	{
		//temporary array used to store sorted elements
		int [] temp = new int[data.length];
		
		//indicates start of left side of split up array
		int left = low;

		//indicated right side
		int right = mid+1;

		//used for determining the index where the smallest element will be copied
		int curPos = low;

		//continue as long as the indicies are within their own section
		while(left <= mid && right<=high)
		{
			//pick the smallest element from either
			//the left or right section to be 
			//put into the temp array
			if(data[left]<data[right])
			{
				temp[curPos] = data[left];
				left++;
			}
			else
			{
				temp[curPos] = data[right];
				right++;
			}
			curPos++;
		}

		//if there are still elements in the left section
		//copy them over into the temp array
		//
		//do the same check for the right
		if(left <= mid)
		{
			while(left <= mid)
			{
				temp[curPos]=data[left];
				left++;
				curPos++;
			}
		}
		else if(right <=high)
		{
			while(right <=high)
			{
				temp[curPos]=data[right];
				right++;
				curPos++;
			}
		}

		//copy over data from temp array into the actual array and be done!
		for(int i=low; i<=high; i++)
		{
			data[i]=temp[i];
		}
	}

	//method for just printing out the array for testing purposes
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
