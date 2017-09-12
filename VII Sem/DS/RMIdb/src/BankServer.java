import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class BankServer {
	public static void main(String args[]) throws Exception {
		LocateRegistry.createRegistry(1099);
		Bank bankobj= new Bank();
		Naming.bind("j", bankobj);
		System.out.println("Server is ready for remote invocations by client");
	}
}
