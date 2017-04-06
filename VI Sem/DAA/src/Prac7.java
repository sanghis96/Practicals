import java.util.Scanner;

class Matrix
{
	int dist;
	int back;
}

public class Prac7
{
	public static final int TERMINATION_CONDITION = 999;
	public static final int DIAGONAL = 998;
	public static final int LEFT = 997;
	public static final int UP = 996;
	public static final int NO_CHANGE = 995;
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the two strings :\nString A : ");
		String stringA = scan.next();
		System.out.print("String B : ");
		String stringB = scan.next();
		
		int nA = stringA.length();
		int nB = stringB.length();
		
		Matrix[][] minEditDist = new Matrix[nA+1][nB+1];
		
		Matrix matrix = new Matrix();
		
		matrix.dist = 0;
		matrix.back = TERMINATION_CONDITION;
		minEditDist[0][0] = matrix;
		
		for(int i=1; i<=nA; i++)
		{
			matrix = new Matrix();
			matrix.dist = i;
			matrix.back = TERMINATION_CONDITION;
			minEditDist[i][0] = matrix;
		}
		for(int i=1; i<=nB; i++)
		{
			matrix = new Matrix();
			matrix.dist = i;
			matrix.back = TERMINATION_CONDITION;
			minEditDist[0][i] = matrix;
		}
		
		for(int i=1; i<=nA; i++)
		{
			for(int j=1; j<=nB; j++)
			{
				matrix = new Matrix();
				if(stringA.charAt(i-1) == stringB.charAt(j-1))
					matrix = minimum((minEditDist[i-1][j].dist+1),(minEditDist[i][j-1].dist+1),(minEditDist[i-1][j-1].dist),1);
				else
					matrix = minimum((minEditDist[i-1][j].dist+1),(minEditDist[i][j-1].dist+1),(minEditDist[i-1][j-1].dist+1),0);
				minEditDist[i][j] = matrix;
			}
		}
		
		int minDist = minEditDist[nA][nB].dist;
		
		int i=nA;
		int j=nB;
		while(minEditDist[i][j].back != TERMINATION_CONDITION)
		{
			if(minEditDist[i][j].back == UP)
			{
				i--;
				System.out.println("DELETION");
			}
			else if(minEditDist[i][j].back == LEFT)
			{
				j--;
				System.out.println("INSERTION");
			}
			else if(minEditDist[i][j].back == DIAGONAL)
			{
				i--;
				j--;
				System.out.println("SUBSTITUTION");
				minDist++;
			}
			else if(minEditDist[i][j].back == NO_CHANGE)
			{
				i--;
				j--;
			}
		}
		System.out.println("Minimum Edit Distance : " + minDist);
		scan.close();
	}
	
	public static Matrix minimum(int a, int b, int c, int flag)
	{
		Matrix d = new Matrix();
		d.dist = a;
		d.back = UP;
		if(d.dist>b)
		{
			d.dist = b;
			d.back = LEFT;
		}
		if(d.dist>c)
		{
			d.dist = c;
			if(flag == 0)
				d.back = DIAGONAL;
			else
				d.back = NO_CHANGE;
		}
		return d;
	}
}