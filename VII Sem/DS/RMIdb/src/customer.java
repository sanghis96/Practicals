import java.rmi.*;
import java.net.*;
import java.util.*;

public class customer {
	
	public static void main(String args[]) {
		try {
			BankInterface bankObj = (BankInterface) Naming.lookup("rmi://localhost/j");
			Scanner sc = new Scanner(System.in);
			boolean flag = true;
			do {
				System.out.println("\n\nMenu:-");
				System.out.println("1.Display All");
				System.out.println("2.Display Account Details");
				System.out.println("3.Create New Account");
				System.out.println("4.Update Account Details");
				System.out.println("5.Delete Account");
				System.out.println("6.Exit");
				System.out.print("Enter your choice: ");
				int ch = sc.nextInt();
				int ano,bal;
				String nm;
				switch(ch)
				{
					case 1:	ArrayList<BankAccount> arrbank1 = bankObj.getInfoAll();
							Iterator<BankAccount> it1 = arrbank1.iterator();
							System.out.println("\nAcc. No.\tAccount Holder Name\tBalance");
							while(it1.hasNext()) {
								BankAccount account = it1.next();
								System.out.println(account.getAccNo() + "\t\t" + account.getName() + "\t\t\t" + account.getBalance());
							}
							break;
					case 2:	System.out.print("Enter account number: ");
							ano = sc.nextInt();
							BankAccount account;
							account = bankObj.getInfo(ano);
							if(account.getAccNo() == 0)
								System.out.println("\n\t\tAccount does not exist !!!");
							else {
								System.out.println("\nAccount Number: " + account.getAccNo());
								System.out.println("Account Holder Name: " + account.getName());
								System.out.println("Account Balance: " + account.getBalance());
							}
							break;
					case 3:	System.out.println("\nInsertion...");
							System.out.print("Enter account no: ");
							ano = sc.nextInt();
							System.out.print("Enter name: ");
							nm = sc.next();
							System.out.println("Enter balance: ");
							bal = sc.nextInt();
							if(bankObj.insert(ano, nm, bal))
								System.out.println("\n\t\tInserted");
							else
								System.out.println("\n\t\tAccount already exist !!!");
							break;
					case 4:	System.out.println("\nUpdation...");
							System.out.print("Enter account no: ");
							ano = sc.nextInt();
							System.out.print("Enter name: ");
							nm = sc.next();
							System.out.print("Enter balance: ");
							bal = sc.nextInt();
							if(bankObj.update(ano, nm, bal))
								System.out.println("\n\t\tUpdated");
							else
								System.out.println("\n\t\tAccount does not exist !!!");
							break;
					case 5:	System.out.print("Enter account number: ");
							ano=sc.nextInt();
							if(bankObj.delete(ano))
								System.out.println("\n\t\tDeleted");
							else
								System.out.println("\n\t\tAccount does not exist !!!");
							break;
					case 6:	flag = false;
							break;
					default:System.out.println("\n\n\tInvalid choice !!!");
				}
			}while(flag);
			System.out.println("\n\t\tBahar aa gaye ....");
			sc.close();
		} catch(NotBoundException e) {
			e.printStackTrace();
		} catch(RemoteException e) {
			e.printStackTrace();
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}
	}
}   