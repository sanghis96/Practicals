import java.util.Scanner;

class Jobs
{
	int jobNo, profit, deadline;
	Jobs(){}
	Jobs(int no, int p, int d)
	{
		jobNo = no;
		profit = p;
		deadline = d;
	}
}

class Prac3
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of Jobs: ");
		int n = sc.nextInt();
		Jobs[] jobs = new Jobs[n+1];
		System.out.println("Enter Job's Profit and Deadline:-");
		for(int i=1; i<=n; i++)
		{
			System.out.print("Job " + i + ": ");
			int P = sc.nextInt();
			int D = sc.nextInt();
			jobs[i] = new Jobs(i, P, D);
		}
		
		for(int i=1; i<=n; i++)
			for(int j=1; j<=n; j++)
				if(jobs[i].profit > jobs[j].profit)
				{
					Jobs temp = new Jobs();
					temp = jobs[i];
					jobs[i] = jobs[j];
					jobs[j] = temp;
				}
		
		System.out.println("\nAfter Sorting according to profit:-");
		System.out.print("Job No  : ");
		for(int i=1; i<=n; i++)
			System.out.print(jobs[i].jobNo + "\t");
		System.out.print("\nProfit  : ");
		for(int i=1; i<=n; i++)
			System.out.print(jobs[i].profit + "\t");
		System.out.print("\nDeadline: ");
		for(int i=1; i<=n; i++)
			System.out.print(jobs[i].deadline + "\t");
		
		int[] J = new int[n+1];
		jobs[0] = new Jobs();
		jobs[0].deadline = J[0] = 0;
		J[1] = 1;
		int k = 1;
		for(int i=2; i<=n; i++)
		{
			int r = k;
			while((jobs[J[r]].deadline > jobs[i].deadline) && (jobs[J[r]].deadline != r))
				r--;
			if((jobs[J[r]].deadline <= jobs[i].deadline) && (jobs[i].deadline > r))
			{
				for(int q=k; q>=r+1; q--)
					J[q+1] = J[q];
				J[r+1] = i;
				k++;
			}
		}
		
		int totalProfit = 0;
		System.out.print("\n\nJob sequence: ");
		for(int i=1; i<=k; i++)
		{
			System.out.print("J" + jobs[J[i]].jobNo + "  ");
			totalProfit += jobs[J[i]].profit;
		}
		System.out.println("\n\nTotal Profit: " + totalProfit);
		sc.close();
	}
}