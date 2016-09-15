package server;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServerMain 
{
	public static void main(String[] args)
	{
		serverThread thread = new serverThread();
		thread.start();
    }
}

class serverThread extends Thread
{
	private static final Scanner sc = new Scanner(System.in);
	private String msgFrmClient;
	private String msgFrmServer;
	
	@Override
    public void run()
    {
        ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(6666);
			Socket socket;
	        while(true)
	        {
	        	socket = serverSocket.accept();
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				int client = dis.readInt();
	            msgFrmClient = dis.readUTF();
	            System.out.println("Client" + client + ": " + msgFrmClient);
	            msgFrmServer = "";
	            System.out.print("Server: ");
	            if(msgFrmClient.equals("bye"))
	            {
	            	System.out.println("Ok tata Client" + client);
	            	break;
	            }
	            else
	            {
	            	msgFrmServer = sc.nextLine();
		            dos.writeUTF(msgFrmServer);
	            }   
	        }
	        serverSocket.close();
		} catch (IOException ex) {
            Logger.getLogger(serverThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
