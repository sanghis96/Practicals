package internals;

public class Prac23
{
	static int n = 5;
	static int m = 3;
	static int[] x = new int[n];
	static int[][] G = {
		{0,1,0,1,0},
		{1,0,1,0,1},
		{0,1,0,1,1},
		{1,0,1,0,1},
		{0,1,1,1,0}
	};
	public static void main(String[] args)
	{
		for(int i=0; i<n; i++)
			x[i] = 0;
		System.out.println("\nAll possible colored graph pattern in given connected Graph:-");
		mColoring(0);
	}
	private static void mColoring(int k)
	{
		while(true)
		{
			nextValue(k);
			if(x[k] == 0)
				return;
			if(k == n-1)
			{
				System.out.print("\n[ ");
				for(int i=0; i<n; i++)
					System.out.print(x[i] + " ");
				System.out.print("]");
			}
			else
				mColoring(k+1);
		}
	}
	private static void nextValue(int k)
	{
		while(true)
		{
			x[k] = (x[k]+1)%(m+1);
			if(x[k] == 0)
				return;
			int j;
			for(j=0; j<n; j++)
				if(G[k][j]!=0 && x[j]==x[k])
					break;
			if(j == n)
				return;
		}
	}
}