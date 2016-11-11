import java.util.*;

public class FairWeightageQueueing
{
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
    	int i=0, j=0, k=0, count=1;
        String[] rts = new String[3];
        int[] time = new int[3];
        
        System.out.print("Enter total no. of packets: ");
        int tot = sc.nextInt();
        
        Random rd = new Random();
        
        int n1 = rd.nextInt(tot);
        System.out.println(n1);
        int[] r1 = new int[n1];
        int n2 = rd.nextInt(tot-n1);
        System.out.println(n2);
        int[] r2 = new int[n2];
        int n3 = tot-n1-n2;
        System.out.println(n3);
        int[] r3 = new int[n3];
        
        for(i=0; i<n1; i++)
            r1[i] = i+1;
        for(j=0; j<n2; j++,i++)
            r2[j] = i+1;
        for(j=0; j<n3; j++,i++)
            r3[j] = i+1;
        
        for(i=0,j=0,k=0; i<tot; i++,k++)
        {
            if(k<r1.length-1)
            {
                int r1n = r1[k];
                System.out.print(" " + r1n);
                count++;
            }
            else if(k==r1.length-1)
            {
                int r1n = r1[k];
                System.out.print(" " + r1n);
                rts[j] = "R1";
                time[j] = count;
                j++;
                count++;
            }
            
            if(k<r2.length-1)
            {
                int r2n = r2[k];
                System.out.print(" " + r2n);
                count++;
            }
            else if(k==r2.length-1)
            {
                int r2n = r2[k];
                System.out.print(" " + r2n);
                rts[j] = "R2";
                time[j] = count;
                j++;
                count++;
            }            
            
            if(k<r3.length-1)
            {
                int r3n = r3[k];
                System.out.print(" " + r3n);
                count++;
            }
            else if(k==r3.length-1)
            {
                int r3n = r3[k];
                System.out.print(" " + r3n);
                rts[j] = "r3";
                time[j] = count;
                j++;
                count++;
            }    
        }
        
        System.out.println("\nRouter\tTime");
        for(i=0;i<3;i++)
            System.out.println(" " + rts[i] + "\t" + time[i]);
    }
}