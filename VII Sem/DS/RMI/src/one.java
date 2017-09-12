import java.rmi.*;

public interface one extends Remote {
	
	public int[][] Matadd(int a[][],int b[][],int n,int m) throws RemoteException;
	public int[][] Matsub(int a[][], int b[][],int n,int m) throws RemoteException;
	public int[][] Matmul(int a[][], int b[][],int n,int m,int o) throws RemoteException;
	public int[][] Mattrans(int c[][],int m,int n) throws RemoteException;
}