import java.sql.*;

public class JDBCsample {

	private static Connection connect;
	private static Statement stmt;
	private static ResultSet rs;
	private static DatabaseMetaData dbmd;
	private static ResultSetMetaData rsmd;

	
	public static void main(String[] args) 
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/oot","root","tiger");		
			stmt = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			dbmd = connect.getMetaData();
			System.out.println(dbmd.getCatalogTerm());
		}catch(Exception ex){	ex.printStackTrace();	}
		
		try{
			rs = stmt.executeQuery("select * from student");
			rsmd = rs.getMetaData();
			System.out.println(rsmd.getTableName(1));
			while(rs.next())
			{
				rs.updateDouble(3, 8.0);
				rs.updateRow();
			}
			connect.close();
		}catch(Exception ex){	System.out.println("Error in printing");ex.printStackTrace();	}
	}

}