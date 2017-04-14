package internals;

import java.util.Scanner;

public class Prac20
{
	private static int n;
	private static int[][] M;
	private static int[][] S;
	private static void MCM(int[] p)
	{
		M = new int[n+1][n+1];
		S = new int[n+1][n+1];
		for(int i=1; i<=n; i++)
			M[i][i] = 0;
		for(int l=2; l<=n; l++)
		{
			for(int i=1; i<=n-l+1; i++)
			{
				int j = i+l-1;
				M[i][j] = Integer.MAX_VALUE;
				for(int k=i; k<=j-1; k++)
				{
					int temp = M[i][k] + M[k+1][j] + p[i-1]*p[k]*p[j];
					if(M[i][j] > temp)
					{
						M[i][j] = temp;
						S[i][j] = k;
					}
				}
			}
		}
	}
	private static void print(int i, int j)
	{
		if(i == j)
			System.out.print("M" + i);
		else
		{
			System.out.print("(");
			print(i, S[i][j]);
			print(S[i][j]+1, j);
			System.out.print(")");
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of matrices: ");
		n = sc.nextInt();
		int[] p = new int[n+1];
		System.out.println("Enter orders of matrices:-");
		for(int i=0; i<=n; i++)
			p[i] = sc.nextInt();
		
		MCM(p);
		print(1, n);
		
		sc.close();
	}
}
