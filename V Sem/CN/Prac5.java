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
    	int[] poly = new int[polyLen];
    	for(int i=0; i<polyLen; i++)
    		poly[i] = Integer.parseInt(""+polyBits.charAt(i));
    	System.out.print("Rough CRC code: ");
    	for(int i=0; i<dataLen+polyLen-1; i++)
    		System.out.print(CRC[i]);
    	int[] rem = new int[dataLen+polyLen-1];
    	rem = divide(CRC,poly,dataLen+polyLen-1,polyLen);
    	System.out.print("\nCRC code is: ");
    	for(int i=0; i<dataLen+polyLen-1; i++)
    	{
    		CRC[i] ^= rem[i];
    		System.out.print(CRC[i]);
    	}
    	System.out.print("\nEnetr the CRC code at receiver side: ");
    	String atReciever = sc.next();
    	int[] recv = new int[atReciever.length()];
    	int recvLen = atReciever.length();
    	for(int i=0; i<recvLen; i++)
    		recv[i] = Integer.parseInt(""+atReciever.charAt(i));
    	rem = divide(recv,poly,recvLen,polyLen);
    	int flag = 0;
    	for(int i=0; i<recvLen; i++)
    		if(rem[i] == 1)
    		{
    			flag = 1;
    			break;
    		}
    	if(flag ==1)
    		System.out.println("Error in message");
    	else
    		System.out.println("No error in message");
    }
    private static int[] divide(int[] div, int[] divisor, int divLen, int divisorLen)
    {
    	int[] rem = new int[divLen];
    	for(int i=0; i<divLen; i++)
    		rem[i] = div[i];
    	int curr = 0;
    	while(true)
    	{
    		for(int i=0; i<divisorLen; i++)
    			if(rem[curr+i] == divisor[i])
    				rem[curr+i] = 0;
    			else
    				rem[curr+i] = 1;
    		while(rem[curr] != 1 && curr<divLen-1)
    			curr++;
    		if(divLen-curr < divisorLen)
    			break;
    	}
    	return rem;
    }
}