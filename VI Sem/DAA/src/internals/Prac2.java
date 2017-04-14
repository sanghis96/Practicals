package internals;

import java.util.Scanner;

class Prac2
{
    static int k;
    private static void kSmallest(int[] list, int first, int last)
    {
    	if(first <= last)
		{
			int pivote = partition(list, first, last);
			if(pivote == k)
			{
				System.out.println("\nThe " + k+1 + "th smallest element is " + list[pivote]);
				return;
			}
			else if(pivote > k)
				kSmallest(list, first, pivote-1);
			else
				kSmallest(list, pivote+1, last);
		}
    }
    private static int partition(int[] a, int left, int right)
    {
        int pivot = left;
        int i=left+1, j=right;
        while(i < j)
        {
            while(a[i] < a[pivot])
                i++;
            while(a[j] > a[pivot])
                j--;
            if(i < j)
            {
                a[i] += a[j];
                a[j] = a[i] - a[j];
                a[i] -= a[j];
            }
        }
        if(j!=left && i!=right)
        {
            a[pivot] += a[j];
            a[j] = a[pivot] - a[j];
            a[pivot] -= a[j];
        }
        return j;
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
    	int[] array = {8,3,25,6,10,17,1,2,18,5};
        System.out.print("Enter the value of k: ");
        k = sc.nextInt()-1;
        if(k >= array.length || k < 0)
        	System.out.println("Please enter the valid value of K!");
        else
        	kSmallest(array, 0 , array.length-1);
        sc.close();
    }
}