class Gen<T extends Number>
{
	T[] nums;
	Gen(T ob[])
	{
		nums = ob;
	}
	double average()
	{
		double sum = 0.0;
		for(T ob:nums)
		{ 
			sum += ob.doubleValue();
		}
		sum = sum/nums.length;
		return sum;
	}
	boolean compare(Gen<?> ob)
	{
		if(average() == ob.average())
			return true;
		else
			return false;
	}
}

class Gen2
{
    static <T,V extends T> boolean IsIn(T x,V[] arr)
    {
        int flag=0;
        for(int i=0;i<arr.length;i++)
            if(arr[i]==x)
            {
            	flag=1;
                break;
            }
        if(flag==1)
            return true;
        else
            return false;
    }
}

public class Practical8 
{
    public static void main(String[] args) 
	{
		Integer[] a = {1,2,3,4};
		Gen<Integer> iob = new Gen<Integer>(a);
		System.out.println("Average = " + iob.average());
		
		Double[] a1 = {1.0,2.0,4.0,5.0};
		Gen<Double> iob2 = new Gen<Double>(a1);
		System.out.println("Average = " + iob2.average());
		
		if(iob.compare(iob2))
			System.out.println("Average is same");
		else
			System.out.println("Average is different");
		
		int num = 5;
	        if(Gen2.IsIn(num,a))
			System.out.println("Num is present in Array");
        	else
            		System.out.println("Num not present");
	}
}