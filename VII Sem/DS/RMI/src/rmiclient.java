import java.rmi.Naming;
import java.util.Scanner;

public class rmiclient {
	public static void main(String[] args) throws Exception {
		try {
			one onex = (one)Naming.lookup("rmi://localhost/add");
			int c[][] = new int[10][10];
			System.out.println("Menu :-");
			System.out.println("1.Matrix Addition\n2.Matrix Subtraction\n3.Matrix Multiplication\n4.Matrix Transpose");
			System.out.print("Enter your choice: ");
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();
			switch(ch)
			{
				case 1: System.out.print("Enter number of rows: ");
						int rows = sc.nextInt();
						System.out.print("Enter number of columns: ");
						int columns = sc.nextInt();
						int[][] a = new int[rows][columns];
						int[][] b = new int[rows][columns];
						c = new int[rows][columns];
						System.out.println("Enter the first matrix:- ");
						for (int i = 0; i < rows; i++)
							for (int j = 0; j < columns; j++)
								a[i][j] = sc.nextInt();
						System.out.println("Matrix 1:");
						for (int i = 0; i < rows; i++) {
							for (int j = 0; j < columns; j++)
								System.out.print(a[i][j] + " ");
							System.out.println();
						}
						System.out.println("Enter the second matrix:- ");
						for (int i = 0; i < rows; i++)
							for (int j = 0; j < columns; j++)
								b[i][j] = sc.nextInt();
						System.out.println("Matrix 2:");
						for (int i = 0; i < rows; i++) {
							for (int j = 0; j < columns; j++)
								System.out.print(b[i][j] + " ");
							System.out.println();
						}
						c = onex.Matadd(a,b,rows,columns);
						break;
				case 2: System.out.print("Enter number of rows: ");
						rows = sc.nextInt();
						System.out.print("Enter number of columns: ");
						columns = sc.nextInt();
						a = new int[rows][columns];
						b = new int[rows][columns];
						c= new int[rows][columns];
						System.out.println("Enter the first matrix:- ");
						for (int i = 0; i < rows; i++)
							for (int j = 0; j < columns; j++)
								a[i][j] = sc.nextInt();
						System.out.println("Matrix 1:");
						for (int i = 0; i < rows; i++) {
							for (int j = 0; j < columns; j++)
								System.out.print(a[i][j] + " ");
							System.out.println();
						}
						System.out.println("Enter the second matrix:- ");
						for (int i = 0; i < rows; i++)
							for (int j = 0; j < columns; j++)
								b[i][j] = sc.nextInt();
						System.out.println("Matrix 2:");
						for (int i = 0; i < rows; i++) {
							for (int j = 0; j < columns; j++)
								System.out.print(b[i][j] + " ");
							System.out.println();
						}
						c = onex.Matsub(a,b,rows,columns);
						break;
				case 3: System.out.print("Enter number of rows(Matrix 1): ");
						int rows1 = sc.nextInt();
						System.out.print("Enter number of columns(Matrix 1): ");
						int columns1 = sc.nextInt();
						System.out.print("Enter number of rows(Matrix 2): ");
						int rows2 = sc.nextInt();
						System.out.print("Enter number of columns(Matrix 2): ");
						int columns2 = sc.nextInt();
						if(columns1 == rows2){
							a = new int[rows1][columns1];
							b = new int[rows2][columns2];
							c= new int[rows1][columns2];
							System.out.println("Enter the first matrix:- ");
							for (int i = 0; i < rows1; i++)
								for (int j = 0; j < columns1; j++)
									a[i][j] = sc.nextInt();
							System.out.println("Matrix 1:");
							for (int i = 0; i < rows1; i++) {
								for (int j = 0; j < columns1; j++)
									System.out.print(a[i][j] + " ");
								System.out.println();
							}
							System.out.println("Enter the second matrix:- ");
							for (int i = 0; i < rows2; i++)
								for (int j = 0; j < columns2; j++)
									b[i][j] = sc.nextInt();
							System.out.println("Matrix 2:");
							for (int i = 0; i < rows2; i++) {
								for (int j = 0; j < columns2; j++)
									System.out.print(b[i][j] + " ");
								System.out.println();
							}
							c = onex.Matmul(a,b,rows1,columns1,columns2);
						} else {
							System.out.println("Cannot be multiplied !!!");
						}
						break;
				case 4: System.out.print("Enter number of rows: ");
						rows = sc.nextInt();
						System.out.print("Enter number of columns: ");
						columns = sc.nextInt();
						a = new int[rows][columns];
						c= new int[rows][columns];
						System.out.println("Enter the matrix:- ");
						for (int i = 0; i < rows; i++)
							for (int j = 0; j < columns; j++)
								a[i][j] = sc.nextInt();
						System.out.println("Matrix:");
						for (int i = 0; i < rows; i++) {
							for (int j = 0; j < columns; j++)
								System.out.print(a[i][j] + " ");
							System.out.println();
						}
						c = onex.Mattrans(a,rows,columns);
						break;
			}
			System.out.println("Result:");
			for (int i = 0; i < c.length; i++) {
				for (int j = 0; j < c[i].length; j++)
					System.out.print(c[i][j] + " ");
				System.out.println();
			}
			sc.close();
		} catch(Exception e) {
			System.out.println("Exception: "+e);
		}
	}
}