import java.util.*;

public class Graph
{
	private int size;
	private Vertex [] graph;

	public Graph(int s)
	{
		size=s;
		graph = new Vertex[size];
		for(int i=0; i<s; i++)
		{
			graph[i]=new Vertex();
		}
	}
	//insert edge for current graph
	public void insertEdge(int vnum,int connectedTo, int weigh)
	{
		graph[vnum].edges = new Edge(connectedTo, weigh, graph[vnum].edges);
	}
	
	//returns an array of longest paths to all of the other vertices 
	//given a start vertex
	public int [] longestPath(int start)
	{
		//setup the fringe (using boolean/int array combo for simplicity)
		boolean done[] = new boolean[size];
		done[start]=true;
		int fringe [] = new int[size];

		//initialize fringe to negative infinity 
		for(int i=0; i<size; i++)
		{
			fringe[i]=Integer.MIN_VALUE;
		}

		//set the distances for all neighbors of the start value 
		for(Edge e = graph[start].edges; e!=null; e=e.next)
		{
			fringe[e.verNum]=e.len;
		}
		
		//printFringe(done,fringe);
		while(!isFringeEmpty(done,fringe, false))
		{
			//printFringe(done,fringe);
			int max= getMax(done,fringe);

			done[max]=true;
			for(Edge e = graph[max].edges; e!=null; e=e.next)
			{
				//System.out.println("["+min+"] Adding neighbor "+e.verNum+" len: "+e.len);
				int n = e.verNum;
				int l = e.len;
		
				if(fringe[n] < fringe[max]+l)
					fringe[n] = fringe[max]+l;
				
				//printFringe(done,fringe);
			}
		}
		return fringe;
	}


	//returns an array with shortest distances to all the 
	//other vertices
	public int [] shortestPath(int start)
	{
		//setup the fringe (using boolean/int array combo for simplicity)
		boolean done[] = new boolean[size];
		done[start]=true;
		int fringe [] = new int[size];

		//set all distances to positive infinity
		for(int i=0; i<size; i++)
		{
			fringe[i]=Integer.MAX_VALUE;
		}

		//set the distances for all neighbors of the start value 
		for(Edge e = graph[start].edges; e!=null; e=e.next)
		{
			fringe[e.verNum]=e.len;
		}
		
		//printFringe(done,fringe);
		while(!isFringeEmpty(done,fringe, true))
		{
			//printFringe(done,fringe);
			int min= getMin(done,fringe);

			done[min]=true;
			for(Edge e = graph[min].edges; e!=null; e=e.next)
			{
				//System.out.println("["+min+"] Adding neighbor "+e.verNum+" len: "+e.len);
				int n = e.verNum;
				int l = e.len;

				if(fringe[n] > fringe[min]+l)
					fringe[n] = fringe[min]+l;
				//printFringe(done,fringe);
			}
		}
		return fringe;

	}
	//debeug method to see inside of fringe 
	private void printFringe(boolean [] done, int [] fringe)
	{
		for(int i=0; i<size; i++)
		{
			System.out.print("["+i+"|"+done[i]+"|"+fringe[i]+"]--");
		}
		System.out.println();

	}
	//gets the minimum value from the fringe, utilized in SHORTEST path
	public int getMin(boolean [] done, int [] fringe)
	{
		int min = 0;
		for(int i=0; i<size; i++)
		{
			if(!done[i])
			{
				if(fringe[i]<fringe[min])
					min=i;
			}
		}
		return min;
	}
	//gets the maximum value from the fringe, utilized in LONGEST path
	public int getMax(boolean [] done, int [] fringe)
	{
		int max = 0;
		for(int i=0; i<size; i++)
		{
			if(!done[i])
			{
				if(fringe[i]>fringe[max])
					max=i;
			}
		}
		return max;
	}
	//determine whether to keep going with the algorithm by checking if the 
	//fringe is empty (the shortPath flag is used to determine whether this 
	//funcion is being used by the shortestPath or longestPath function
	public boolean isFringeEmpty(boolean [] done, int [] fringe, boolean shortPath)
	{
		for(int i=0; i<size; i++)
		{
			if(!done[i])
			{
				if(shortPath)
				{
					if(fringe[i] != Integer.MAX_VALUE)
						return false;
				}
				else
				{
					if(fringe[i] != Integer.MIN_VALUE)
						return false;
				}
			}
		}
		return true;
	}
	//depth first traversal of the graph structure 
	public void dfs()
	{
		boolean [] visited = new boolean[size];
		for(int i=0; i<size; i++)
		{
			if(!visited[i])
				dfs(visited,i);
		}
	}
	//helper function for the dfs traversal
	private void dfs(boolean [] visited, int v)
	{
		visited[v]=true;
		System.out.println("visiting: "+v);

		for(Edge e= graph[v].edges; e!=null;e=e.next)
		{
			if(!visited[e.verNum])
				dfs(visited, e.verNum);
		}
	}
        //bread first traversal of graph
	public void bfs()
	{
                boolean [] visited = new boolean[size];
                for(int i = 0; i<size; i++) {
                    if (!visited[i])
                        bfs(visited, i);
                }
	}
        //helper of bfs
        private void bfs(boolean [] visited, int vnum) {
	    Queue<Integer> myList = new LinkedList<Integer>();

            myList.add(vnum);
            while (myList.peek() != null) {    
                int v = myList.remove();
                
                // do not need to check edges of an already visited 
                // node since visiting implies that it was dequeued
                // and went past this if statement already hence
                // the edges of a visited node are already in the queue
                if (!visited[v]) {
                    visited[v] = true;
                    System.out.println("visiting: "+v);
                    for(Edge e = graph[v].edges; e!=null; e = e.next) {
                        if (!visited[e.verNum]) {
                            myList.add(e.verNum);
                        }
                    }

                }

            }
        }

	//simple way to see structure of the graph
	public void printGraph()
	{
		for(int i=0; i<size; i++)
		{
			Edge temp = graph[i].edges;
			String out = "|"+i+"|: ";
			while(temp != null)
			{
				out += "|"+temp.verNum+" len:"+temp.len+"|-->";
				temp = temp.next;
			}
			System.out.println(out);
		}

	}

}
