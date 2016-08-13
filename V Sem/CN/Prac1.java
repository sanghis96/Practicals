import java.util.*;

public class Prac1 
{
    static String a,c,d,en1="",en2="";
    static int len,i,j;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        System.out.print("Enter your message: ");
        a = sc.nextLine();
        len = a.length();
        i = 0;
        while(i<len)
        {
            if(i%2 == 0)
                en1 += a.charAt(i);
            else
                en2 += a.charAt(i);
            i++;
        }
        System.out.println("Encrypted Message: " + en1 + en2);
        System.out.print("After Decryption: ");
        
        int len1 = en1.length();
        int len2 = en2.length();
        for(i=0; i<len2; i++)
        {
            System.out.print(en1.charAt(i));
            System.out.print(en2.charAt(i));
        }
        if(i!=len1)
            System.out.print(en1.charAt(i));
        System.out.println();
    }
}
