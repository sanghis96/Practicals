import java.util.*;

public class hammingCode 
{
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
    	System.out.print("Enetr Data bits: ");
    	String dataBits = sc.next();
    	System.out.print("Enetr  the message at receiver side: ");
    	String atReciever = sc.next();
        int len = atReciever.length();
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
}