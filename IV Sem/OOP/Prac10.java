import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class employee 
{
    private String name;
    private int Id;
    private int salary;
    employee(String name,int Id,int salary)
    {
        this.name = name;
        this.Id = Id;
        this.salary = salary;
    }
    void display()
    {	System.out.print(name + "," + Id + "," + salary);    }
    int getSalary()
    {   return salary;    }
}

class emp1 implements Comparator<employee>
{
	public int compare(employee o1, employee o2) 
    	{
       		if(o1.getSalary()> o2.getSalary())
    	   		return 1;
       		if(o1.getSalary()< o2.getSalary())
    	   		return -1;
       		return 0;
    	}
}
public class Practical10 
{
	public static void main(String[] args) 
	{
		TreeSet<employee> ts = new TreeSet<>(new emp1());
	    
		ts.add(new employee("Emp1",101,2000));
		ts.add(new employee("Emp2",102,5000));
	    	ts.add(new employee("Emp3",103,10000));
	    	ts.add(new employee("Emp4",104,3000));
	    	ts.add(new employee("Emp5",105,4000));
	    	ts.add(new employee("Emp6",106,6000));
	    
	    	Iterator<employee> itr = ts.iterator();
	    	System.out.println("Employee Data(Name,Id,Salary)");
	    	while(itr.hasNext())
	    	{
	    		employee e = itr.next();
	    		System.out.print("<");
	    		e.display();
	    		System.out.print("> ");
	    	}
	}
}