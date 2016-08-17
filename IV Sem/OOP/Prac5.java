import java.util.Date;

class user
{
    String username;
    String password;
    long login;
    static int count;
    user(String username,String pass,long login)
    {
        this.username=username;
        password=pass;
        this.login=login;
        count++;
    }
    static long loggedinseconds(long login)
    {
    	long logout = new Date().getTime();
        return(logout-login);
    }
    static void displaycount()
    {
        System.out.println(+count);
    }
    void display()
    {
        System.out.println("Username:" + username + "\tLog in time:" + login + "\tCounter:" + count);
    }
    void loggedinseconds()
    {
        long logout = new Date().getTime();
    }
}
public class Practical5
{
	public static void main(String[] args)
	{
		user ob1 = new user("CSE","rcoem",23);
		ob1.loggedinseconds();
		ob1.display();
		
		user ob2 = new user("buer","@test",8);
		ob2.loggedinseconds();
		ob2.display();
		
		user.displaycount();
	}
}
