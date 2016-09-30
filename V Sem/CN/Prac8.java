import java.util.*;

public class ShortestPath
{
	private static int V;
	private static Scanner sc;
	
	int minDistance(int dist[], Boolean sptSet[])
	{
		int min = Integer.MAX_VALUE, min_index=-1;
		for(int v=0; v<V; v++)
			if (sptSet[v] == false && dist[v] <= min)
			{
				min = dist[v];
				min_index = v;
			}
		return min_index;
	}
	
	void printPath(int[] path, int src, int des)
	{
		if(des == src)
			return;
		printPath(path, src, path[des]);
		System.out.print(des + " ");
	}
	
	void dijkstra(int graph[][], int src, int des)
	{
		int path[] = new int[V];
		int dist[] = new int[V];
		
		Boolean sptSet[] = new Boolean[V];
		
		for (int i = 0; i < V; i++)
		{
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		
		dist[src] = 0;
		
		for (int i=0; i<V-1; i++)
		{
			int u = minDistance(dist, sptSet);
			sptSet[u] = true;
			for (int v = 0; v < V; v++)
				if (!sptSet[v] && graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v])
				{
					dist[v] = dist[u] + graph[u][v];
					path[v] = u;
            	}
		}
		
		System.out.println("Minimum cost is " + dist[des]);
		
		System.out.print("\nPath is " + src + " ");
		printPath(path, src, des);
     
    }
	
	public static void main (String[] args)
	{
		sc = new Scanner(System.in);
		System.out.print("Enetr no. of Nodes: ");
		V = sc.nextInt();
		int graph[][] = new int[V][V];
		System.out.println("Eneter the adjacency Metrix:-");
		for(int i=0; i<V; i++)
			for(int j=0; j<V; j++)
				graph[i][j] = sc.nextInt();
		System.out.print("\nEnter the Source node: ");
		int src = sc.nextInt();
		System.out.print("Enter the Destination node: ");
		int des = sc.nextInt();
		ShortestPath t = new ShortestPath();
		t.dijkstra(graph, src, des);
	}
}