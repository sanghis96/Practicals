
public class Prac4
{
	public static void main(String[] args)
	{
		int cost[][] = {
	        {0,50,10,999,45,999},
	        {999,0,15,999,10,999},
	        {20,999,0,15,999,999},
	        {999,20,999,0,35,999},
	        {999,999,999,30,0,999},
	        {999,999,999,3,999,0}
		};
		int v=0, i, costt=0;
	    int[] dist = new int[10];
	    int[] visited = new int[10];
	    int[] near = {0,0,0,0,0,0};
	    int n = 6;
	    
	    for(i=0;i<n;i++)
	    {
	        visited[i] = 0;
	        dist[i] = cost[v][i];
	    }    
	    System.out.println("U 0  1  2  3  4  5");
	    System.out.println(""+dist[0]+" "+dist[1]+" "+dist[2]+" "+dist[3]+" "+dist[4]+" "+dist[5]);
	    visited[v] = 1;
	    String a = "0  ";
	    for(int num=2; num<=n-1; num++)
	    {   
	    	int u=0;
	        int min=999;
	        for(int x=0;x<n;x++)
	        { 
	            if(dist[x]<min && visited[x]==0)
	            {
	                u = x;
	                min = dist[x];
	            }
	        }
	        visited[u]=1;
	        a = a + u + "  ";
	        for(int w =0; w<n; w++)
	        {
	            if(dist[w]>dist[u]+cost[u][w] && visited[w]==0)
	            {   
	                dist[w] = dist[u]+cost[u][w];
	                near[w] = u;
	            }
	        }
	        System.out.println(u+dist[0]+" "+dist[1]+" "+dist[2]+" "+dist[3]+" "+dist[4]+" "+dist[5]);
	    }
        System.out.println("\nPath: " + a);
        for(i=0;i<n;i++)
        {
            if(dist[i]!=999)
            {
                costt=costt+dist[i];
            }
        }
        System.out.println("\nTotal Cost:"+costt);
	}
}