package internals;

public class Prac4
{
	public static void main(String[] args)
	{
		int[] array = {8,3,25,6,10,17,1,2,18,5};
		sort(array);
	}
	public static void sort(int[] list)
	{
		if(list.length >1)
		{
			int[] firstHalf = new int[list.length/2];
			System.arraycopy(list, 0, firstHalf, 0, list.length/2);
			sort(firstHalf);
			int secondHalfLength = list.length - list.length/2;
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(list, list.length/2, secondHalf, 0, secondHalfLength);
			sort(secondHalf);
			int temp[] = sortMerge(firstHalf,secondHalf);
			System.arraycopy(temp, 0, list, 0, temp.length);

			for(int i=0 ;i<list.length; i++)
				System.out.print(list[i] + "  ");
			System.out.println();
		}
	}
	private static int[] sortMerge(int list1[], int list2[])
	{
		int[] temp = new int[list1.length + list2.length];
		int i=0, j=0, k=0;
		while(i<list1.length && j<list2.length)
			if(list1[i] < list2[j])
				temp[k++] = list1[i++];
			else
				temp[k++] = list2[j++];
		while(i < list1.length)
			temp[k++] = list1[i++];
		while(j < list2.length)
			temp[k++] = list2[j++];
		return temp;
	}
}
