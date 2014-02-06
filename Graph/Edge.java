public class Edge
{
	//vertex this edge connects to
	public int verNum;
	//edge weight
	public int len;
	public Edge next;

	public Edge(int vnum, int weigh, Edge e)
	{
		verNum=vnum;
		len=weigh;
		next=e;
	}
}
