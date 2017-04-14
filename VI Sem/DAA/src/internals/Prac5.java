package internals;

class Prac5
{
    private static void QuickSort(int[] list)
    {	quickSort(list, 0, list.length-1);	}
    private static void quickSort(int[] list, int first, int last)
    {
    	if(first < last)
		{
			int pivote = partition(list, first, last);

			for(int i=0; i<list.length; i++)
	            System.out.print(list[i] + "  ");
	        System.out.println();
			
			quickSort(list, first, pivote-1);
			quickSort(list, pivote+1, last);
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
        int[] array = {8,3,25,6,10,17,1,2,18,5};
        QuickSort(array);
        for(int i=0; i<array.length; i++)
            System.out.print(array[i] + "  ");
        System.out.println();
    }
}