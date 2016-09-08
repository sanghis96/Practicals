import java.util.*;

public class demo 
{
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
    	System.out.print("Enetr Data bits: ");
    	String dataBits = sc.next();
    	int dataLen = dataBits.length();
    	System.out.print("Enetr Polynomial bits: ");
    	String polyBits = sc.next();
    	int polyLen = polyBits.length();
    	int[] CRC = new int[dataLen+polyLen-1];
    	for(int i=0; i<dataLen; i++)
    		CRC[i] = Integer.parseInt(""+dataBits.charAt(i));
    	for(int i=0; i<polyLen-1; i++)
    		CRC[dataLen+i] = 0;	
    	System.out.print("Rough CRC code: ");
    	for(int i=0; i<dataLen+polyLen-1; i++)
    		System.out.print(CRC[i]);
    	
    	System.out.print("Enetr  the CRC code at receiver side: ");
    	String atReciever = sc.next();
    	int[] hamCode = new int[len];
    	for(int i=0,j=0,k=0; i<len; i++)
    	    if(i == Math.pow(2, j)-1)
    	    {    hamCode[i] = 0;   j++;    }
    	    else
    	        hamCode[i] = Integer.parseInt(""+dataBits.charAt(k++));
    	for(int i=0,j=0; i<len; i+=(int)Math.pow(2,j++))
    	{
    	    int count = 0;
    	    for(int k=i; k<len; k+=i+1)
    	        for(int l=0; l<i+1&&k<len; l++)
    	            if(hamCode[k++] == 1)
    	                count++;
    	    if(count%2 == 0)
    	        hamCode[i] = 0;
    	    else
    	        hamCode[i] = 1;
    	}
    	int errorBit = 0;
    	for(int i=0; i<len; i++)
    	    if(hamCode[i] != Integer.parseInt(""+atReciever.charAt(i)))
    	    {
    	    	errorBit = i+1;
    	    	break;
    	    }
    	System.out.println("Error is in bit number " + errorBit);

    	}
    	private static void divide(int[] div, int[] divisor, int divLen, int divisorLen)
    	{
    	int[] rem = new int[divisorLen];

    	}
    }	
}
