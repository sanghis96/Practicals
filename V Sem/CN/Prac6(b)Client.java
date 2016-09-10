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
		BufferedImage img = ImageIO.read(new File("C:\\Users\\cse\\Pictures\\Screenshots\\Screenshot (7).png"));
		ImageIO.write(img,"png",s.getOutputStream());
		DataOutputStream d= new DataOutputStream(s.getOutputStream());
		d.writeUTF("\nHi server");
		s.close();
	}
}
