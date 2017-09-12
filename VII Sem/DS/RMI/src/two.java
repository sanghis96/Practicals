import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class two extends UnicastRemoteObject implements one {
	
	private static final long serialVersionUID = 1L;
	
	public two() throws RemoteException{}
	
	@Override
	public int[][] Matadd(int a[][],int b[][],int n,int m) throws RemoteException {
		int c[][] = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				c[i][j] = a[i][j] + b[i][j];
		return c;
	}
	
	@Override
	public int[][] Matsub(int a[][], int b[][],int n,int m) throws RemoteException {
		int c[][] = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				c[i][j] = a[i][j] - b[i][j];
		return c;
	}
	
	@Override
	public int[][] Matmul(int a[][], int b[][],int n,int m,int o) throws RemoteException {
		int c[][] = new int[n][o];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				for (int k = 0; k < o; k++)
					c[i][j] = c[i][j] + a[i][k] * b[k][j];
		return c;
	}
	
	@Override
	public int[][] Mattrans(int a[][],int m,int n) throws RemoteException {
		int c[][] = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				c[i][j] = a[j][i];
		return c;
	}
}