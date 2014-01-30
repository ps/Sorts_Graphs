public class Runner
{
	public static void main(String [] args)
	{
		HashTable my = new HashTable();
		my.insert(6);
		my.insert(58);
		my.insert(100);
		for(int i=0; i<30; i++)
		{
			int num = (int)(Math.random()*50);
			my.insert(num);
		}
		System.out.println(my.toString());
	}
}
