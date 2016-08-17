class Shape 
{
    int perimeter(int a)
    {
        return (4*a);
    }
    float perimeter(float r)
    {
        return (float)(2*3.14*r); 
    }
    int perimeter(int l,int b)
    {
        return (2*(l+b));
    }
    int perimeter(int a,int b,int c)
    {
        return (a+b+c);
    }
}

public class Practical1 
{
	public static void main(String[] args) 
	{
		Shape ob = new Shape(); 
        	System.out.println("Perimeter of SQUARE :" + ob.perimeter(4));
        	System.out.println("Perimeter of CIRCLE :" + ob.perimeter(3.5f));
        	System.out.println("Perimeter of RECTANGLE :" + ob.perimeter(6,2));
        	System.out.println("Perimeter of TRIANGLE :" + ob.perimeter(2,3,5));
	}

}
