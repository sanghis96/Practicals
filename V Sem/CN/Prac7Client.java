package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientMain 
{
	private static String msgFrmClient;
	private static String msgFrmServer;
    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws UnknownHostException, IOException 
    {
    	Socket socket;
    	while(true)
        {
    		socket = new Socket("localhost",6666);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            System.out.print("Client2: ");
            msgFrmClient = sc.nextLine();
            dos.writeInt(2);
            dos.writeUTF(msgFrmClient);
            msgFrmServer = dis.readUTF();
            System.out.println("Server: " + msgFrmServer);
            if(msgFrmClient.equals("bye"))
            	break;
        }
    	socket.close();    		
    }
}
