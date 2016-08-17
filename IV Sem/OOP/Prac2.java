class fraction 
{
    int N,D;
    float deci;
    fraction()
    {
        N=0;
        D=0;
        deci=0.0f;
    }
    fraction(int x,int y)
    {   
        N=x;
        D=y;
        deci=(float) x/y;
    }
    void add(fraction ob1,fraction ob2)
    {
        N=(ob2.D*ob1.N)+(ob1.D*ob2.N);
        D=ob1.D*ob2.D;
    }
    void sub(fraction ob1,fraction ob2)
    {
        N=(ob2.D*ob1.N)-(ob1.D*ob2.N);
        D=ob1.D*ob2.D;
    }
    void display()
    {
        System.out.println(" "+N+" ");
        System.out.println("---");
        System.out.println(" "+D+" ");
    }
    void compare(fraction f)
    {
        if(deci==f.deci)
           System.out.println("Both the fractions are same");
        if(deci>f.deci)
           System.out.println("First fraction is greater");
        if(deci<f.deci)
           System.out.println("Second fraction is greater");
    }
    void reduce()
    {
        int i,hcf=0;
        for(i=1;i<(N<D?D:N);i++)   
		if(N%i==0 && D%i==0)
			hcf=i;
        N/=hcf;
        D/=hcf;    
    }
}
public class Practical2 
{
	public static void main(String[] args) 
	{
		fraction f1 = new fraction(3,6);
        	System.out.println("First Fraction is:-");
        	f1.display();
        	f1.reduce();
        	f1.display();
        	fraction f2 = new fraction(2,5);
        	System.out.println("Second Fraction is:-");
        	f2.display();
        	f2.reduce();
        	f2.display();
        	f1.compare(f2);
        	fraction f3 = new fraction();
        	f3.add(f1,f2);
        	System.out.println("Addition of Fractions is:-");
        	f3.display();
        	f3.sub(f1,f2);
        	System.out.println("Subtraction of Fractions is:-");
        	f3.display();
	}
}
