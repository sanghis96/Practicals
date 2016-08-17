import java.util.Scanner;

class point 
{
    int x,y;
    point(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    void display(String s)
    {  System.out.println("Co-ordinates of point " + s + " is " + x + "," + y);   }
}

abstract class figure
{
    abstract void display();
    abstract void length();
    Scanner scan = new Scanner(System.in);
    double len;
}

abstract class open extends figure
{    }

class line extends open
{
    point p1;
    point p2;
    line(int x1,int y1,int x2,int y2)
    {  
        p1 = new point(x1,y1);
        p2 = new point(x2,y2);
    }
    @Override
    void length()
    {   len = Math.sqrt(Math.pow((p2.x-p1.x),2) + Math.pow((p2.y-p1.y),2));   }
    @Override
    void display()
    {
        p1.display("p1");
        p2.display("p2");
        System.out.println("Length of line = " + len);
    }
}

abstract class close extends figure
{
    double ar;
    abstract void area();
}
class polygon extends close
{
    int n;
    double s;
    void setdata()
    {
        System.out.print("Enter length of a side:");
        s = scan.nextDouble();
        System.out.print("Enter number of sides:");
        n = scan.nextInt();
    }
    @Override
    void area()
    {   ar = ((s*s*n)/(2*java.lang.Math.tan(180/n)));   }
    @Override
    void length()
    {   len = n * s;   }
    @Override
    void display()
    {
        System.out.println("Number of sides = " + n);
        System.out.println("Length of sides = " + s);
        System.out.println("Area of polygon = " + ar);
        System.out.println("Perimeter of polygon = " + len);
    }
}
class ecllipse extends close
{
    final double PI = 3.1416; 
    double a,b;
    void setdata()
    {
        System.out.print("Enter major radius:");
        a = scan.nextDouble();
        System.out.print("Enter minor radius:");
        b = scan.nextDouble();
    }
    @Override
    void area()
    {    ar = PI * a * b;   }
    @Override
    void length()
    {   len = 2 * PI * (a+b);   }
    @Override
    void display()
    {
        System.out.println("Major radius = " + a);
        System.out.println("Minor radius = " + b);
        System.out.println("Area of ecllipse = " + ar);
        System.out.println("Perimeter of ecllipse = " + len);
    }
}


public class Practical6 
{    
    public static void main(String[] args) 
    {
    	open ob1;
    	line l1 = new line(2,1,1,2);
        ob1 = l1;
        ob1.length();
        ob1.display();
        
        close ob2;
        polygon poly = new polygon();
        poly.setdata();
        ob2 = poly;
        ob2.length();
        ob2.area();
        ob2.display();
        ecllipse ec = new ecllipse();
        ec.setdata();
        ob2 = ec;
        ob2.length();
        ob2.area();
        ob2.display();
    }
}