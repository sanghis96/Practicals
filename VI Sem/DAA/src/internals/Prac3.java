package internals;

class numbers
{	
	int min, max;
	numbers()
	{
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
	}
}

public class Prac3
{
	private static int[] array = {8,3,25,6,10,17,1,2,18,5};
	private static void MinMax(int i, int j, numbers n)
	{
		if(i == j)
			n.min = n.max = array[i];
		else if(i == j-1)
		{
			if(array[i] < array[j])
			{
				n.min = array[i];
				n.max = array[j];
			}
			else
			{
				n.min = array[j];
				n.max = array[i];
			}
		}
		else
		{
			int mid = (i+j)/2;
			numbers n1 = new numbers();
			MinMax(i, mid, n);
			MinMax(mid+1, j, n1);
			
			// Combine the solution
			if(n1.min < n.min)
				n.min = n1.min;
			if(n1.max > n.max)
				n.max = n1.max;
		}
	}
	public static void main(String[] args)
	{
    	numbers n = new numbers();
    	MinMax(0, array.length-1, n);
    	System.out.println("Minimum value: " + n.min);
    	System.out.println("Maximum value: " + n.max);
	}
}
