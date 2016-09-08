package prac6;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Prac6 
{
    public static void main(String[] args) throws UnknownHostException 
    {
        InetAddress a = InetAddress.getByName("www.google.com");
        System.out.println("Host name is: " + a.getHostName());
        System.out.println("Host address is: " + a.getHostAddress());
        
        InetAddress b = InetAddress.getLocalHost();
        System.out.println("Local Host is: " + b);
    }
}
