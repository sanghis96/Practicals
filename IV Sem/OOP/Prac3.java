import java.time.*;
import java.util.Scanner;

class College
{
    String ClgName,Location,PrincipalName;
    void display()
    {
        System.out.println("College Name : " + ClgName);
        System.out.println("College Location : " + Location);
        System.out.println("Principal Name : " + PrincipalName);
    }
}

class Department extends College
{
    String DeptName,HODName;
    void display()
    {
        super.display();
        System.out.println("Department Name : " + DeptName);
        System.out.println("HOD Name : " + HODName);
    }
}

class Person extends Department
{
    String Name;
    int dd,mm,yy;
    void CalcAge()
    {
        LocalDate dob = LocalDate.of(yy, mm, dd);
        LocalDate today = LocalDate.now();
        Period p = Period.between(dob, today);
        System.out.println("Age: " + p.getYears() + " Years " + p.getMonths() + " Months " + p.getDays() + " Days");
    }
    void display()
    {
        super.display();
        System.out.println("Person Name : " + Name);
        CalcAge();
    }
}

class Student extends Person
{
    double marks;
    char CalcGrade()
    {
        double avg=marks/5;
        if(avg>=90)
           return 'A';
        else if(avg>=80 && avg<90)
            return 'B';
        else if(avg>=65 && avg<80)
            return 'C';
        else if(avg>=50 && avg<65)
            return 'D';
        else if(avg>=33 && avg<50)
            return 'E';
        else
            return 'F';
    }
}

class Staff extends Person
{
    double Salary;
    double ComputeTax()
    {
        if(Salary>=300000.00)
            return (Salary-(0.1)*Salary);
        else if(Salary>=200000.00 && Salary<300000.00)
            return (Salary-(0.075)*Salary);
        else if(Salary>=100000.00 && Salary<200000.00)
            return (Salary-(0.05)*Salary);
        else
            return Salary;
    }
}

public class Practical3 
{
	private static Scanner sc;

	public static void main(String[] args) 
	{
		sc = new Scanner(System.in);
        
		Staff ob1 = new Staff();
        	Student ob2 = new Student();
        
		System.out.println("Enter data for Staff Member:-");
        	System.out.print("Enter College Name:");
        	ob1.ClgName = sc.next();
        	System.out.print("Enter College Location:");
        	ob1.Location = sc.next();
        	System.out.print("Enter Principal Name:");
	        ob1.PrincipalName = sc.next();
        	System.out.print("Enter Department Name:");
        	ob1.DeptName = sc.next();
        	System.out.print("Enter HOD Name:");
        	ob1.HODName = sc.next();
        	System.out.print("Enter Person Name:");
        	ob1.Name = sc.next();
        	System.out.println("Enter Date of Birth:-");
        	System.out.print("Enter Date:");
        	ob1.dd = sc.nextInt();
        	System.out.print("Enter Month:");
        	ob1.mm = sc.nextInt();
        	System.out.print("Enter Year:");
        	ob1.yy = sc.nextInt();
        	System.out.print("Enter Salary:");
        	ob1.Salary = sc.nextDouble();

	        System.out.println("Enter data for Student:-");
        	System.out.print("Enter College Name:");
        	ob2.ClgName = sc.next();
        	System.out.print("Enter College Location:");
        	ob2.Location = sc.next();
        	System.out.print("Enter Principal Name:");
        	ob2.PrincipalName = sc.next();
        	System.out.print("Enter Department Name:");
        	ob2.DeptName = sc.next();
        	System.out.print("Enter HOD Name:");
        	ob2.HODName = sc.next();
        	System.out.print("Enter Person Name:");
        	ob2.Name = sc.next();
        	System.out.println("Enter Date of Birth:-");
        	System.out.print("Enter Date:");
        	ob2.dd = sc.nextInt();
        	System.out.print("Enter Month:");
        	ob2.mm = sc.nextInt();
        	System.out.print("Enter Year:");
        	ob2.yy = sc.nextInt();
        	System.out.print("Enter Marks(out of 500):");
        	ob2.marks = sc.nextDouble();

        	System.out.println("");
        	System.out.println("Data of Staff member:-");
        	ob1.display();
        	System.out.println("Salary : " + ob1.ComputeTax());

        	System.out.println("");
        	System.out.println("Data of Student:-");
        	ob2.display();
        	System.out.println("Grade : " + ob2.CalcGrade());

	}
}