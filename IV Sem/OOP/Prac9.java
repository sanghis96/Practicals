import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class item 
{
    private final String itemName;
    private final long rate;
    private final int quantity;
    item(String itemName,long rate,int quantity)
    {
        this.itemName=itemName;
        this.quantity=quantity;
        this.rate=rate;
    }
    void display()
    {	System.out.print(itemName + "\t\t" + rate + "\t" + quantity);    }
    long getRate()
    {   return rate;    }
    int getQuantity()
    {   return quantity;    }
}

public class Practical9 
{
	public static void main(String[] args) 
	{
        	int c=1;
        	long total;
        	ArrayList<ArrayList<item>> ArrBill = new ArrayList<>();
        	Scanner sc = new Scanner(System.in);
        	System.out.print("Enter the Number of bills:");
        	int m = sc.nextInt();
        	for(int i=0;i<m;i++)
        	{ 
        		System.out.println("\nBILL"+(i+1));
            		ArrayList<item> Arritem = new ArrayList<>();
            		c=1;
            		while(c==1)
            		{
                		System.out.print("Enter name of the item:");
                		String n = sc.next();
                		System.out.print("Enter rate of the item:");
                		long r = sc.nextLong();
                		System.out.print("Enter Quantity of the item:");
                		int q = sc.nextInt();
                		item it = new item(n,r,q);
                		Arritem.add(it);
                		System.out.print("Add More items? (1-YES/0-NO)");
                		c = sc.nextInt();
            		}
            		ArrBill.add(Arritem);
        	}
        	int count=1;
        	Iterator<ArrayList<item>> itr=ArrBill.iterator();
        	while(itr.hasNext())
        	{
        		total=0;
        		ArrayList<item> i1= itr.next();
            		Iterator<item> itr1 =i1.iterator();
            		System.out.println("\n\tBILL"+count);
            		System.out.println("Item Name\tRate\tQuantity");
            		while(itr1.hasNext())
            		{
            			item s=itr1.next();
                		total +=s.getRate()*s.getQuantity();
                		s.display();
                		System.out.println("\t:"+s.getRate()*s.getQuantity());                    
            		}
           	 	count++;
            		System.out.println("------------------------------------");
            		System.out.println("Total Amount is\t\t\t:"+total);
        	}
	}
}