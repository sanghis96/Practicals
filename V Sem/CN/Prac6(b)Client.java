package client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain 
{
	public static void main(String[] args) throws UnknownHostException, IOException 
	{
		Socket s = new Socket("localhost",6666);
		DataOutputStream d= new DataOutputStream(s.getOutputStream());
		d.writeUTF("\nHi server");
		s.close();
	}
}
