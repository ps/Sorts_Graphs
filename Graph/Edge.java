public class Edge
{
	public int verNum;
	public int len;
	public Edge next;

	public Edge(int vnum, int weigh, Edge e)
	{
		verNum=vnum;
		len=weigh;
		next=e;
	}
}
