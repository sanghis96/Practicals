package internals;

import java.io.*;
public class Prac18
{
public static void main(String args[])throws IOException
 {
 	BufferedReader o=new BufferedReader(new InputStreamReader(System.in));
    int x[][]={
	          {0,1,2,3,0,0,0,0,0,0},
	          {0,0,0,0,4,0,0,0,0,0},
	          {0,0,0,0,4,3,0,0,0,0},
	          {0,0,0,0,2,1,0,0,0,0},
	          {0,0,0,0,0,0,6,7,2,0},
	          {0,0,0,0,0,0,4,2,3,0},
	          {0,0,0,0,0,0,0,0,0,1},
	          {0,0,0,0,0,0,0,0,0,2},
	          {0,0,0,0,0,0,0,0,0,3},
	          {0,0,0,0,0,0,0,0,0,0}
		      };
    int i,j,c,a;
	int s[]=new int[20];
	int p[]=new int[20];
	int temp[]=new int[20];
     for(i=0;i<10;i++)
      {
       s[i]=0;
       temp[i]=0;
       p[i]=0;
      }
System.out.println("\n\nProgram for MultiStage Graph\n\n");
System.out.println("Select Any one Method\n");
System.out.println("1. Forward Method\n");
System.out.println("2. Backward Method\n\t");
a=Integer.parseInt(o.readLine());
switch(a)
{
case 1:
for(i=9;i>=0;i--)
{
 c=0;
 for(j=0;j<=9;j++)
 {
  if(x[i][j]!=0)
  {
   if(c==0)
   {
    s[i]=s[j]+x[i][j];
    p[i]=j;
    c=1;
   }
   else
   {
    temp[i]=s[j]+x[i][j];
    if(temp[i]<s[i])
    {
     s[i]=s[j]+x[i][j];
     p[i]=j;
    }
   }
  }
 }
}
 System.out.println("\nSource  Cost  Parent");
 for(i=9;i>=0;i--)
 {
  System.out.print("\n  "+i);
  System.out.print(" \t   "+s[i]);
  System.out.print(" \t   "+p[i]);
 }
 System.out.println("\n\n");
 System.out.println("\n\nOptimal Path:\n\t");
 i=p[0];
 System.out.print("0-->"+i);
 while(i!=9)
 {
  i=p[i];
  System.out.print("-->"+i);
 }
break;
case 2:
 for(j=0;j<=9;j++)
 {
 c=0;
 for(i=0;i<=9;i++)
 {
  if(x[i][j]!=0)
  {
   if(c==0)
   {
    s[j]=s[i]+x[i][j];
    p[j]=i;
    c=1;
   }
   else
   {
    temp[j]=s[i]+x[i][j];
    if(temp[j]<s[j])
    {
     s[j]=s[i]+x[i][j];
     p[j]=i;
    }
   }
  }
 }
 }
 System.out.println("\nSource  Cost   Parent");
 for(i=0;i<=9;i++)
 {
  System.out.print("\n  "+i);
  System.out.print(" \t   "+s[i]);
  System.out.print(" \t   "+p[i]);
 }
System.out.println("\n\n");
System.out.println("\n\nOptimal Path:\n\t");
 i=p[9];
 System.out.print("9-->"+i);
 while(i!=0)
 {
  i=p[i];
  System.out.print("-->"+i);
 }
  break;
}
}
}