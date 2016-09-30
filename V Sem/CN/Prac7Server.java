package server;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServerMain
{
        private static ServerSocket serverSocket;

		public static void main(String[] args) throws IOException
	{
            serverSocket = new ServerSocket(6666);
            while(true)
	    {
                Socket socket = serverSocket.accept();
                serverThread thread = new serverThread(socket);
                thread.start();
            }
    	}
}

class serverThread extends Thread
{
	private final DataInputStream dis;
        private final DataOutputStream dos;
        private static final Scanner sc = new Scanner(System.in);
	private String msgFrmClient;
	private String msgFrmServer;
	private final Socket socket;
        
        serverThread(Socket ss) throws IOException
        {
            socket = ss;
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
        }
        
	@Override
    	public void run()
    	{		
            try {
                while(true)
                {
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
                dis.close();
                dos.close();
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(serverThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}