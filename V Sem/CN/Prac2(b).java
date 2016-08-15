import java.util.*;

public class ByteStuff 
{
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        String msg;
        System.out.print("Enter Message: ");
        msg = sc.next();
        int len = msg.length();
        int i = 0;
        while(i < len)
        	if((msg.charAt(i)=='e'||msg.charAt(i)=='E') && (msg.charAt(i+1)=='s'||msg.charAt(i+1)=='S') && (msg.charAt(i+2)=='c'||msg.charAt(i+2)=='C'))
        	{
        		System.out.print(" ESC ESC ");
        		i += 3;
        	}
        	else
        	{
        		System.out.print(msg.charAt(i));
        		i++;
        	}
    }
}