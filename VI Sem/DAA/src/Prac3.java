import java.util.Scanner;

class Prac3
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of Jobs: ");
		int n = sc.nextInt();
		int[] P = new int[n+1];
		int[] D = new int[n+1];
		int[] J = new int[n+1];
		System.out.println("Enter Job's Profit and Deadline:-");
		for(int i=1; i<=n; i++)
		{
			System.out.print("Job " + i + ": ");
			P[i] = sc.nextInt();
			D[i] = sc.nextInt();
		}
		
		for(int i=1; i<=n; i++)
			for(int j=1; j<=n; j++)
				if(P[i] < P[j])
				{
					D[j] += D[i];
					D[i] = D[j] - D[i];
					D[j] -= D[i];
					P[j] += P[i];
					P[i] = P[j] - P[i];
					P[j] -= P[i];
				}
		
		D[0] = J[0] = 0;
		J[1] = 1;
		int k = 1;
		for(int i=2; i<=n; i++)
		{
			int r = k;
			while((D[J[r]] > D[i]) && (D[J[r]] != r))
				r--;
			if(D[J[r]] <= D[i] && D[i] > r)
			{
				for(int q=k; q>=r+1; q--)
					J[q+1] = J[q];
				J[r+1] = i;
				k++;
			}
		}
		
		for(int i=1; i<=k; i++)
			System.out.println(J[i]);
		sc.close();
	}
}
