package quicksort;

public class QuickSort
{
    private static int quickSort(int[] a, int left, int right)
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
         for(int k=0; k<a.length; k++)
            System.out.print(a[k] + "  ");
        System.out.println();
        return j;
    }
    private static void Quick(int[] a)
    {
        int pivote = quickSort(a, 0, a.length-1);
        quickSort(a, 0, pivote-1);
        quickSort(a, pivote+1, a.length-1);
        Quick(a);
    }
    
    public static void main(String[] args)
    {
        int[] array = {8,3,25,6,10,17,1,2,18,5};
        Quick(array);
        for(int i=0; i<array.length; i++)
            System.out.print(array[i] + "  ");
        System.out.println();
    }
}