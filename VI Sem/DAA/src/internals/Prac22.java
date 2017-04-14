package internals;

import java.util.Scanner;

public class Prac22
{
	private static int n;
	private static int[] array;
	private static int m;
	private static int[] x;
	private static void SOS(int s, int k, int r)
	{
		x[k] = 1;
		if(s+array[k] == m)
		{
			System.out.print("< ");
			for(int i=0; i<n; i++)
				System.out.print(x[i] + ", ");
			System.out.println(">");
		}
		else if(s+array[k]+array[k+1] <= m)
			SOS(s+array[k], k+1, r-array[k]);
		if((s+r-array[k] >= m) && (s+array[k+1] <= m))
		{
			x[k] = 0;
			SOS(s, k+1, r-array[k]);
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of elements: ");
		n = sc.nextInt();
		int r = 0;
		array = new int[n];
		System.out.println("Enter elements in the array:-");
		for(int i=0; i<n; i++)
		{
			array[i] = sc.nextInt();
			r += array[i];
		}
		System.out.print("Enter value of m: ");
		m = sc.nextInt();
		x = new int[n];
		
		SOS(0,0,r);
		
		sc.close();
	}
}
