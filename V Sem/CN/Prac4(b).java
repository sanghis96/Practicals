import java.util.*;

public class burstError 
{
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
    	System.out.print("Enetr the number of Hamming codes: ");
    	int n = sc.nextInt();
    	System.out.println("Enter all the Hamming codes at receiver side:-");
    	String[] atReciever = new String[n];
    	for(int i=0; i<n; i++)
    		atReciever[i] = sc.next();
    	int[] errorBits = new int[n];
    	int min=Integer.MAX_VALUE, max=0;
    	for(int x=0; x<n; x++)
        {
        	errorBits[x] = 0;
    		int len = atReciever[x].length();
        	int[] hamCode = new int[len];
        	for(int i=0,k=0; i<len; i++)
        		hamCode[i] = Integer.parseInt(""+atReciever[x].charAt(k++));
        	for(int i=0,j=0; i<len; i+=(int)Math.pow(2,j++))
            {
                int count = 0;
                for(int k=i; k<len; k+=i+1)
                    for(int l=0; l<i+1&&k<len; l++)
                        if(hamCode[k++] == 1)
                            count++;
                if(count%2 == 1)
                    errorBits[x] += i+1;
            }
        	if(errorBits[x] > max)
        		max = errorBits[x];
        	if(errorBits[x]<min && errorBits[x]>0)
        		min = errorBits[x];
        }
    	System.out.println();
    	System.out.print("The burst error is at: ");
        for(int x=min; x<=max; x++)
        	System.out.print(x + " ");
    }   
}