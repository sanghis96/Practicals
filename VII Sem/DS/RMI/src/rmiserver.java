import java.rmi.Naming;

public class rmiserver {
	public static void main(String[] args) throws Exception {
		try {
			two twox = new two();
			Naming.rebind("add", twox);
		} catch(Exception e) {
			System.out.println("Exception: "+e);
		}
	}
}