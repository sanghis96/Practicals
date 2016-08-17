import java.util.Scanner;

class EmpException extends Exception
{
    private String i;
    EmpException()
    {   i = "000";    }
    EmpException(String i)
    {   this.i = i;    }
    @Override
    public String toString()
    {   return ("Exception: Value " + i + " Exception occured");    }
}
class Employee 
{
    String id,name;
    void getdata()
    {
        try 
        {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter Employee ID:");
            id = scan.next();
            System.out.print("Enter Employee Name:");
            name = scan.next();
            if(id.length() > 5)
                throw new EmpException(id);
            else
            {
                String dep = id.substring(0,2);
                int ID = Integer.parseInt(id.substring(2,4));
                if((dep.compareToIgnoreCase("cs")==0 || dep.compareToIgnoreCase("IT")==0 || dep.compareToIgnoreCase("ec")==0) && (ID>0 && ID<51))
                {
                    System.out.println("Employee Id: " + id);
                    System.out.println("Employee Name: " + name);
                    System.out.println("\n");
                }
                else
                    throw new EmpException(id);
            }
        }
        catch(EmpException e)
        {   System.out.println("Exception caught\n" + e);        }
    }
}
public class Practical7 
{
	public static void main(String[] args) 
	{
		Employee e1 = new Employee();
	        Employee e2 = new Employee();
        	Employee e3 = new Employee();
        	e1.getdata();
        	e2.getdata();
        	e3.getdata();
	}
}