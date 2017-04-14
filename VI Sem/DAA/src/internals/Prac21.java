package internals;

import java.util.Scanner;

public class Prac21
{
	private static int n;
	private static int[] x;
	private static void NQueen(int k, int n)
	{
		for(int i=0; i<n; i++)
		{
			if(place(k,i))
			{
				x[k] = i;
				if(k == n-1)
				{
					System.out.print("< ");
					for(int j=0; j<n; j++)
						System.out.print(x[j]+1 + ", ");
					System.out.println(">");
				}
				else
					NQueen(k+1, n);
			}
		}
	}
	private static boolean place(int k, int i)
	{
		for(int j=0; j<k; j++)
			if((x[j]==i) || (Math.abs(x[j]-i)==Math.abs(j-k)))
				return false;
		return true;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of QUEENS: ");
		n = sc.nextInt();
		x = new int[n];
				
		NQueen(0,n);
		
		sc.close();
	}
}
