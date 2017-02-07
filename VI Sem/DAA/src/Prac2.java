import java.util.Scanner;

class Players
{
	int playerNo, rating;
	String name;
	void add(String name, int no, int rating)
	{
		this.name = name;
		playerNo = no;
		this.rating = rating;
	}
}

class Prac2 
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		//  Initialization
		System.out.print("Enter no of Players: ");
		int noOfPlayers = sc.nextInt();
		Players p[] = new Players[noOfPlayers]; 
		System.out.println("\nEnter details of players:-");
		for(int i=0; i<noOfPlayers; i++)
		{
			p[i] = new Players();
			System.out.print("\nPlayer " + (i+1) + " Name: ");
			String name = sc.next();
			System.out.print("Player " + (i+1) + " No: ");
			int no = sc.nextInt();
			System.out.print("Player " + (i+1) + " Rating: ");
			int rating = sc.nextInt();
			p[i].add(name, no, rating);
		}
		
		//	Sort using merge sort according to Player's rating
		sort(p);
		
		//  Balanced distribution of Players into two teams
		System.out.println("\n\tTeam 1\t\t\t\tTeam 2");
		System.out.println("Name\tPlyerNo\tRating\t\tName\tPlyerNo\tRating");
		for(int i=0; i<noOfPlayers; i+=2)
		{
			System.out.print(p[i].name + "\t" + p[i].playerNo + "\t" + p[i].rating + "\t\t");
			System.out.print(p[i+1].name + "\t" + p[i+1].playerNo + "\t" + p[i+1].rating);
			System.out.println();
		}
		
		//	Unbalanced distribution of Players into two teams
		System.out.println("\n\tTeam 1\t\t\t\tTeam 2");
		System.out.println("Name\tPlyerNo\tRating\t\tName\tPlyerNo\tRating");
		for(int i=0; i<noOfPlayers/2; i++)
		{
			System.out.print(p[i].name + "\t" + p[i].playerNo + "\t" + p[i].rating + "\t\t");
			System.out.print(p[i+noOfPlayers/2].name + "\t" + p[i+noOfPlayers/2].playerNo + "\t" + p[i+noOfPlayers/2].rating);
			System.out.println();
		}
		sc.close();
	}
	public static void sort(Players[] list)
	{
		if(list.length >1)
		{
			Players[] firstHalf = new Players[list.length/2];
			System.arraycopy(list, 0, firstHalf, 0, list.length/2);
			sort(firstHalf);
			int secondHalfLength = list.length - list.length/2;
			Players[] secondHalf = new Players[secondHalfLength];
			System.arraycopy(list, list.length/2, secondHalf, 0, secondHalfLength);
			sort(secondHalf);
			Players temp[] = sortMerge(firstHalf,secondHalf);
			System.arraycopy(temp, 0, list, 0, temp.length);		
		}
	}
	private static Players[] sortMerge(Players list1[], Players list2[])
	{
		Players[] temp = new Players[list1.length + list2.length];
		int i=0, j=0, k=0;
		while(i<list1.length && j<list2.length)
			if(list1[i].rating < list2[j].rating)
				temp[k++] = list1[i++];
			else
				temp[k++] = list2[j++];
		while(i < list1.length)
			temp[k++] = list1[i++];
		while(j < list2.length)
			temp[k++] = list2[j++];
		return temp;
	}
}
