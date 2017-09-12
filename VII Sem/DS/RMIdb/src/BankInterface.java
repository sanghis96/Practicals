import java.rmi.*;
import java.util.*;

public interface BankInterface extends Remote	{
	
	public ArrayList<BankAccount> getInfoAll() throws RemoteException;
	public BankAccount getInfo(int accountNumber) throws RemoteException;
	public boolean insert(int acc,String name,int bal) throws RemoteException;
	public boolean update(int acc,String name,int bal) throws RemoteException;
	public boolean delete(int acc) throws RemoteException;
}
