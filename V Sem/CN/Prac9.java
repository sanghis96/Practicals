package prac9;

import java.util.*;

public class Prac9 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of Packets: ");
        int n = sc.nextInt();
        int[] size = new int[n];
        for(int i=0; i<n; i++)
        {
            size[i] = (int)(Math.random()*10)*5;
            System.out.println("Size of pckt " + (i+1) + " is " + size[i]);
        }
        int rate = 8;
        int bucket_size = 30;
        int total_bytes = 0;
        int time = 0;
        int i=0;
        while(true)
        {
            if(size[i] > bucket_size)
                i++;
            time++;
            if(size[i] <= rate)
                i++;
            else
                size[i] -= rate;
            total_bytes += rate;
            if(i == n-1)
                break;  
        }
        System.out.println("Total time required: " + time);
        System.out.println("Total bytes required: " + total_bytes);
    }
}
