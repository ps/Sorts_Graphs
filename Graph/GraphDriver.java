public class GraphDriver
{
	public static void main(String [] args)
	{
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		Graph myg = new Graph(7);
		myg.insertEdge(0,1,5);
		myg.insertEdge(0,2,10);
		myg.insertEdge(1,4,3);
		myg.insertEdge(1,3,6);
		myg.insertEdge(3,5,5);
		myg.insertEdge(4,2,2);
		myg.insertEdge(4,3,2);
		myg.insertEdge(4,6,2);
		myg.insertEdge(6,5,2);
		myg.printGraph();
		myg.dfs();
		System.out.println();
		//System.out.println("Shortest distance from 0-->5[12]: "+myg.shortestPath(0,5));
		//System.out.println("Shortest distance from 0-->3[10]: "+myg.shortestPath(0,3));

		//get shortest path 
		int [] distA = myg.shortestPath(0,true);
		for(int i=1; i<distA.length; i++)
		{
			System.out.println("Shortest distance 0-->"+i+": "+distA[i]);
		}
		
		//get longest path 
		int [] distA2 = myg.shortestPath(0,false);
		System.out.println();
		for(int i=1; i<distA2.length; i++)
		{
			System.out.println("Longest distance 0-->"+i+": "+distA2[i]);
		}
	}
}
