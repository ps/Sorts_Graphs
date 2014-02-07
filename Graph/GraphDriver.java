public class GraphDriver
{
	public static void main(String [] args)
	{
		//create the graph
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
		//print out a text visual to see the structure fo the graph
		myg.printGraph();

		System.out.println();

		System.out.println("Depth-first traversal");
		myg.dfs();
		System.out.println();

		System.out.println("Breadth-first traversal");
		myg.bfs();
		System.out.println();

		//get shortest path to all vertices
		int [] distA = myg.shortestPath(0);
		for(int i=1; i<distA.length; i++)
		{
			System.out.println("Shortest distance 0-->"+i+": "+distA[i]);
		}
		
		//get longest path to all vertices
		int [] distA3 = myg.longestPath(0);
		System.out.println();
		for(int i=1; i<distA3.length; i++)
		{
			System.out.println("Longest distance 0-->"+i+": "+distA3[i]);
		}
	}
}
