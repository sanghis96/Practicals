import java.sql.*;
import java.util.Scanner;

public class procedureDemo {

	private static Connection connect;
	//private static Statement stmt;
	private static CallableStatement cstmt;
	//private static ResultSet rs;
	//private static DatabaseMetaData dbmd;
	//private static ResultSetMetaData rsmd;

	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/oot","root","tiger");		
			//stmt = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			cstmt = connect.prepareCall("{call updStudent(?)}");
		}catch(Exception ex){	ex.printStackTrace();	}
		
		try{
			System.out.print("Enter no of students to add: ");
			int n = sc.nextInt();
			System.out.println("\nEnter details:-");
			for(int i=0; i<n; i++)
			{
				System.out.print("Enter Name of " + (i+1) + " student: ");
				String name = sc.next();
				cstmt.setString(2, name);
				System.out.print("Enter CGPA of " + (i+1) + " student: ");
				float cgpa = sc.nextFloat();
				cstmt.setFloat(3, cgpa);
				cstmt.execute();				
			}
			connect.close();
		}catch(Exception ex){	System.out.println("Error in printing");ex.printStackTrace();	}
		sc.close();
	}

}