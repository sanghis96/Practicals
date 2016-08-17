class Chopstick 
{
    private boolean avail;
    public Chopstick()
    {
        avail = true;
    }
    synchronized void pickUp(int id)
    {
        while(!avail)
        {
            System.out.println("Philosopher " + id + " is waiting for chopstik");
            try{
                wait();
            } catch (InterruptedException ex){
                System.out.println(ex);
            }            
        }
        avail=false;
    }
    synchronized void putDown()
    {
        avail=true;
        notify();
    }
}

class Philosopher extends Thread
{
    private int id;
    Chopstick left,right;
    public Philosopher(int id, Chopstick left, Chopstick right) 
    {   	
        this.id = id;
        this.left = left;
        this.right = right;
    }
    public void eat()
    {
        left.pickUp(id);
        right.pickUp(id);
        System.out.println("Philoaopher " + id + " is eating");
    }
    public void think()
    {
        left.putDown();
        right.putDown();
        System.out.println("Philosopher " + id + " is thinking");
    }
    public void run()
    {
        eat();
        try{
            Thread.sleep(2000);            
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        think();        
    }
}

public class Practical11 
{
    public static void main(String[] args) 
    {
    	Chopstick[] chops = new Chopstick[5];
        Philosopher[] phil = new Philosopher[5];
        for (int i=0 ; i<5 ; i++) 
            chops[i] = new Chopstick();
        for (int i = 0; i < 5; i++) 
        {
            phil[i] = new Philosopher(i+1, chops[i], chops[(i+1)%5]);
            phil[i].start();
        }
    }
}