import java.util.Scanner;

class employee
{
	int empId;
	String empName;
	employee(int id,String name)
	{
		empId = id;
		empName = name;
	}	
}

interface taxable 
{	double calculateTax();	}

class permanent extends employee implements taxable
{
	double salary;
	permanent(int id,String name,double sal)
	{
		super(id,name);
		salary = sal+additionalEarning();
		
	}
	double additionalEarning()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter amount if any Additional Earning:");
		double addSal = sc.nextDouble();
		return addSal;
	}
	public double calculateTax()
	{
		if(salary >= 100000 && salary < 500000)
			return (salary * 0.1);
		if(salary >= 500000)
			return (salary * 0.2);
		return 0.0;
	}
	void display()
	{
		System.out.println("\nEmp ID\tEmp Name\tTax\tTotal Salary");
		System.out.println(empId + "\t" + empName + "\t\t" + calculateTax() + "\t" + (salary+calculateTax()));
	}
}

class hourlyEmployee extends employee
{
	int hoursWorked;
	double ratePerHour;
	hourlyEmployee(int id,String name,int hw, double rph)
	{
		super(id,name);
		hoursWorked = hw;
		ratePerHour = rph;
	}
	double calculateSalary()
	{	return (hoursWorked * ratePerHour);	}
	void display()
	{
		System.out.println("\nEmp ID\tEmp Name\tSalary");
		System.out.println(empId + "\t" + empName + "\t\t" + calculateSalary());
	}
}

public class Practical4 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Employee ID :");
		int id = scan.nextInt();
		System.out.print("Enter Employee Name :");
		String name = scan.next();
		System.out.print("Press 1 or 2 for Permanent or Hourly Employee respectively :");
		int choice = scan.nextInt();
		switch(choice)
		{
			case 1:	System.out.print("Enter Salary :");
				double sal = scan.nextDouble();
				permanent ob1 = new permanent(id,name,sal);
				ob1.display();
				break;
			case 2:	System.out.print("Enter Hours Worked :");
				int hw = scan.nextInt();
				System.out.print("Enter Rate Per Hours :");
				double rph = scan.nextDouble();
			       	hourlyEmployee ob2 = new hourlyEmployee(id,name,hw,rph);
			       	ob2.display();
			       	break;
			default:System.out.println("\t\tWrong choice ! ! !");
		}
	}
}