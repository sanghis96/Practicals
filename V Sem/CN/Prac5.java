import java.util.*;

public class CRC 
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
    }	
}
