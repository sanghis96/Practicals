import java.util.Scanner;

class lcsMatrix
{
	public int value;
	public char dir;
}

public class Prac8
{
	public static String input;
	public static String input2;
	public static lcsMatrix[][] matrix;
	public static int n;
	public static int count = 0;
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter input string : ");
		input = scan.next();
		input2 = new StringBuilder(input).reverse().toString();
		
		n = input.length() + 1;
		
		matrix = new lcsMatrix[n][n];
		
		lcs();
		
		/*
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
				System.out.print(matrix[i][j].value + "/" + matrix[i][j].dir + " ");
			System.out.print("\n");
		}
		*/
		
		System.out.print("Longest palindromic subsequence : ");
		print_lcs(n-1,n-1);
		System.out.println(" of Length = " + count);
		scan.close();
	}
	
	public static void lcs()
	{
		lcsMatrix m;
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(i==0 || j==0)
				{
					m = new lcsMatrix();
					m.value = 0;
					m.dir = 'H';
					matrix[i][j] = m;
				}
				else
				{
					m = new lcsMatrix();
					if(input.charAt(i-1) != input2.charAt(j-1))
					{
						m.value = Math.max(matrix[i-1][j].value, matrix[i][j-1].value);
						if(matrix[i-1][j].value >= matrix[i][j-1].value)
							m.dir = 'U';
						else
							m.dir = 'S';
						matrix[i][j] = m;
					}
					else
					{
						m.value = matrix[i-1][j-1].value + 1;
						m.dir = 'D';
						matrix[i][j] = m;
					}
				}
			}
		}
	}
	private static void print_lcs(int i, int j)
	{
		if(i==0 || j==0)
			return;
		if(matrix[i][j].dir == 'D')
		{
			print_lcs(i-1,j-1);
			System.out.print(input.charAt(i-1));
			count++;
		}
		else
		{
			if(matrix[i][j].dir == 'U')
				print_lcs(i-1,j);
			else
				print_lcs(i,j-1);
		}
	}
}