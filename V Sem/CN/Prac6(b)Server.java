package server;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;

public class ServerMain 
{
	private static ServerSocket s;

	public static void main(String[] args) throws IOException 
	{
		s = new ServerSocket(6666);
		Socket s1 = s.accept();

	    DataInputStream d1 = new DataInputStream(s1.getInputStream());
	    String ss = (String)d1.readUTF();System.out.println("Hello client" + ss);
	    

	    //BufferedImage img = ImageIO.read(s1.getInputStream());
	    //File file = new File("D:abc.png");
	    //ImageIO.write(img,"png", file);
	}
}