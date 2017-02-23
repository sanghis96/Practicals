
public class Prac5
{
	static int n = 8;
	static int[] x = new int[n];
	static int[][] G = {
		{0,1,1,0,0,0,1,0},
		{1,0,1,0,0,0,0,1},
		{1,1,0,1,0,0,0,0},
		{0,0,1,0,1,0,0,0},
		{0,0,0,1,0,1,0,0},
		{0,0,0,0,1,0,1,0},
		{1,0,0,0,0,1,0,1},
		{0,1,0,0,0,0,1,0}
	};
	public static void main(String[] args)
	{
		for(int i=0; i<n; i++)
			x[i] = 0;
		System.out.println("\nAll Hamilton Cycles present in given connected Graph:-");
		Hamiltonian(1);
	}
	private static void Hamiltonian(int k)
	{
		while(true)
		{
			nextValue(k);
			if(x[k] == 0)
				return;
			if(k == n-1)
			{
				System.out.println();
				for(int i=0; i<n; i++)
					System.out.print(x[i]+1 + " --> ");
				System.out.print("1\n");
			}
			else
				Hamiltonian(k+1);
		}
	}
	private static void nextValue(int k)
	{
		while(true)
		{
			x[k] = (x[k]+1)%(n);
			if(x[k] == 0)
				return;
			if(G[x[k-1]][x[k]] != 0)
			{
				int j;
				for(j=1; j<k; j++)
					if(x[j] == x[k])
						break;
				if(j == k)
					if((k<n-1) || ((k==n-1) && G[x[n-1]][x[0]]!=0))
						return;
			}
		}
	}
}
