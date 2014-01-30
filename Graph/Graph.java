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
	public void insertEdge(int vnum,int connectedTo, int weigh)
	{
		graph[vnum].edges = new Edge(connectedTo, weigh, graph[vnum].edges);
	}
	public int [] shortestPath(int start, boolean getM)
	{
		//setup the fringe (using boolean/int array combo for simplicity)
		boolean done[] = new boolean[size];
		done[start]=true;
		int fringe [] = new int[size];
		for(int i=0; i<size; i++)
		{
			if(getM)
				fringe[i]=Integer.MAX_VALUE;
			else
				fringe[i]=Integer.MIN_VALUE;
		}

		//set the distances for all neighbors of the start value 
		for(Edge e = graph[start].edges; e!=null; e=e.next)
		{
			//System.out.println("["+start+"] Adding neighbor "+e.verNum+" len: "+e.len);
			fringe[e.verNum]=e.len;
		}
		
		//printFringe(done,fringe);
		while(!isFringeEmpty(done,fringe, getM))
		{
			//printFringe(done,fringe);
			int min=0;
			if(getM)
				min = getMin(done,fringe);
			else
				min = getMax(done,fringe);
			//System.out.println("Got min/max to be 'done': "+min);

			done[min]=true;
			for(Edge e = graph[min].edges; e!=null; e=e.next)
			{
				//System.out.println("["+min+"] Adding neighbor "+e.verNum+" len: "+e.len);
				int n = e.verNum;
				int l = e.len;
				if(getM)
				{
					if(fringe[n] > fringe[min]+l)
						fringe[n] = fringe[min]+l;
				}
				else
				{
					if(fringe[n] < fringe[min]+l)
						fringe[n] = fringe[min]+l;
				}
				//printFringe(done,fringe);
			}
		}
		return fringe;

	}
	private void printFringe(boolean [] done, int [] fringe)
	{
		for(int i=0; i<size; i++)
		{
			System.out.print("["+i+"|"+done[i]+"|"+fringe[i]+"]--");
		}
		System.out.println();

	}
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
	public boolean isFringeEmpty(boolean [] done, int [] fringe, boolean getM)
	{
		for(int i=0; i<size; i++)
		{
			if(!done[i])
			{
				if(getM)
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
	public void dfs()
	{
		boolean [] visited = new boolean[size];
		for(int i=0; i<size; i++)
		{
			if(!visited[i])
				dfs(visited,i);
		}
	}
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
