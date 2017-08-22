
import java.util.Scanner;

public class LamportClock
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter delay: ");
        int delay = sc.nextInt();
        
        System.out.print("\nEnter no of process: ");
        int noOfProcess = sc.nextInt();
        
        int maxEvents = 0;
        System.out.println("\nEnter no of events in each process:-");
        int noOfEvents[] = new int[noOfProcess];
        for(int i=0; i<noOfProcess; i++)
        {
            System.out.print("Enter no of events in " + (i+1) + " process: ");
            noOfEvents[i] = sc.nextInt();
            if(noOfEvents[i] > maxEvents)
                maxEvents = noOfEvents[i];
        }
        
        System.out.println("\nEnter no of HBR's: ");
        int noOfHBR = sc.nextInt();
        int hbr[][] = new int[noOfHBR][4];
        for(int i=0; i<noOfHBR; i++)
        {
            /* 	Input for HBR's
             * 	Taking Sending Process(SP) Sending Event(SE)
             * 	Taking Receiving Process(RP) Receiving Event(RE)
             */
        	System.out.println("\nEnter SP SE RP RE of " + (i+1) + " HBR:- ");
            for(int j=0; j<4; j++)
                hbr[i][j] = sc.nextInt() - 1;
        }
        
        int[][] result = new int[noOfProcess][maxEvents];
        
        /* 	Implementing IR1:
         * 	increment each event from previous event by delay.
         */
        for(int i=0; i<noOfProcess; i++)
        {
            result[i][0] = 0;
            for(int j=1; j<noOfEvents[i]; j++)
                result[i][j] = result[i][j-1] + delay;
        }    
            
        
        /* 	Implementing IR2:
         * 	if sending event time stamp + delay is
         * 	maximum than receiving event time stamp
         * 	then reinitialize with the maximum value.
         */
        for(int i=0; i<noOfHBR; i++)
        {
            if(result[hbr[i][0]][hbr[i][1]]+delay > result[hbr[i][2]][hbr[i][3]])
                result[hbr[i][2]][hbr[i][3]] = result[hbr[i][0]][hbr[i][1]]+delay;
            for(int j=hbr[i][3]+1; j<maxEvents; j++)
                result[hbr[i][2]][j] = result[hbr[i][2]][j-1] + delay;
        }
        
        //Showing output:-
        for(int i=0; i<noOfProcess; i++)
        {
            System.out.print("\nP" + (i+1) + ": ");
            for(int j=0; j<noOfEvents[i]; j++)
                System.out.print(result[i][j]+1 + " ");
        }   
        
        sc.close();
    }
}
