package charcount;

import java.util.*;
public class Charcount 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Data: ");
        String data = sc.next();
        int len = data.length();
        int count = 1;
        int i=0,j;
        while(i<len)
        {
            int bits = Integer.parseInt(""+data.charAt(i));
            if(bits == 0)
            {
                i++;
                continue;
            }
            System.out.print("Frame" + count + ":");
            for(j=0; j<bits&&i<len; j++,i++)
                System.out.print(data.charAt(i));
            System.out.println();
            count++;
        }
        
    }
}
