package internals;

import java.util.Scanner;

public class Prac7
{

    double weight[];
    double benefit[];
    double ratio[];
    double W;

    Prac7()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of items in the store: ");
        int nItems = scan.nextInt();
        System.out.println("Enter the (weight and benefit) of items: ");
        weight = new double[nItems];
        benefit = new double[nItems];
        ratio = new double[nItems];

        for (int i = 0; i < nItems; ++i) {
            weight[i] = scan.nextDouble();
            benefit[i] = scan.nextDouble();
            ratio[i] = benefit[i] / weight[i]; 
        }

        System.out.println("Enter the weight of the knapsack: ");
        W = scan.nextDouble();
        scan.close();
        
    }

    int getNext() {
        double highest = 0;
        int index = -1;
        for (int i = 0; i < benefit.length; ++i) {
            if (ratio[i] > highest) {
                highest = ratio[i];
                index = i;
            }
        } 
        return index;
    }

    void fill() {
        double cW = 0; //current weight
        double cB = 0; //current benefit 

        System.out.print("\nItems considered: ");
        while (cW < W) {
            int item = getNext();        //next highest ratio
            if (item == -1) {
                //No items left
                break;
            }

            System.out.print((item+1)+" ");
            if (cW + weight[item] <= W) {
                cW += weight[item];
                cB += benefit[item];
                //mark as used for the getNext() (ratio) function
                ratio[item] = 0;
            } else {
                cB += (ratio[item] * (W - cW));
                cW += (W - cW);
                break;  //the knapsack is full
            }
        }
        System.out.println("\nMax Benefit = " + cB + ", Max Weight = " + cW);
    }

    public static void main(String[] args) {
        Prac7 fk = new Prac7();
        fk.fill();
    }
}