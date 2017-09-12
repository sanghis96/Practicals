import java.rmi.*;   
import java.rmi.server.*;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 
@SuppressWarnings("serial")
public class Bank extends UnicastRemoteObject implements BankInterface {
	
	public Bank() throws RemoteException {}
	
	public ArrayList<BankAccount> getInfoAll() throws RemoteException {
		ArrayList<BankAccount> arrBank = new ArrayList<BankAccount>();
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ds","root","tiger");
	    	Statement stmt = con.createStatement();
	    	ResultSet res = stmt.executeQuery("select * from bank");
	    	while(res.next()) {
	    		BankAccount account = new BankAccount();
		    	account.setAccNo(res.getInt(1));
		    	account.setName(res.getString(2));
		    	account.setBalance(res.getInt(3));
		    	arrBank.add(account);
	    	}
	    	res.close();
	    	stmt.close();
	    	con.close();
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return arrBank;
	}
	
	public BankAccount getInfo(int accountNumber) throws RemoteException {
		BankAccount account = new BankAccount();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ds","root","tiger");
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from bank where accountid=" + accountNumber);
			res.next();
			account.setAccNo(res.getInt(1));
	    	account.setName(res.getString(2));
	    	account.setBalance(res.getInt(3));
	    	res.close();
	    	stmt.close();
	    	con.close();
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
		return account;
	}
	
	public boolean insert(int acc, String name, int bal) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ds","root","tiger");
			Statement stmt1 = con.createStatement( );
			ResultSet res = stmt1.executeQuery("select * from bank where accountid=" + acc);
			if(res.next())
				return false;
			PreparedStatement stmt2 = con.prepareStatement("insert into bank values(?,?,?)"); 
			stmt2.setInt(1, acc);
			stmt2.setString(2, name);
			stmt2.setInt(3, bal);
			stmt2.execute();
			res.close();
	    	stmt1.close();
	    	stmt2.close();
	    	con.close();
		} catch (SQLException ex) {
			Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
		}
		return true;
	}
	
	public boolean update(int acc, String name, int bal) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ds","root","tiger");
			Statement stmt1 = con.createStatement( );
			ResultSet res = stmt1.executeQuery("select * from bank where accountid=" + acc);
			if(!res.next())
				return false;
			PreparedStatement stmt2 = con.prepareStatement("update bank set name=?,balance=? where accountid=?");
			stmt2.setString(1, name);
			stmt2.setInt(2, bal);
			stmt2.setInt(3, acc);
			stmt2.execute();
			res.close();
	    	stmt1.close();
	    	stmt2.close();
	    	con.close();
		} catch (SQLException ex) {
			Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
		}
		return true;
	}
	
	public boolean delete(int acc) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ds","root","tiger");
			Statement stmt = con.createStatement( );
			ResultSet res = stmt.executeQuery("select * from bank where accountid=" + acc);
			if(!res.next())
				return false;
			stmt.execute("delete from bank where accountid=" + acc);
	    	res.close();
	    	stmt.close();
	    	con.close();
		} catch (SQLException ex) {
			Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
		}
		return true;
	}
}
