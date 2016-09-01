#include <stdlib.h>
#include<stdio.h>
int req[100][100],allocation[100][100],need[100][100],available[100],finish[100];
int n,r;
void input();
void output();
void calculate();
int main()
{
int i,j;

	input();
	output();
	calculate();
		return 0;
	}
		void input()
			{
				int i,j;
				printf("\nEnter the no of Processes:\n");
				scanf("%d",&n);
				printf("Enter the no of resource instances:\t");
				scanf("%d",&r);
				printf("\nEnter the req Matrix:\n");
				for(i=0;i<n;i++)
					{	
						for(j=0;j<r;j++)
							{
								scanf("%d",&req[i][j]);
							}
					}
				printf("Enter the allocation Matrix:\n");
				for(i=0;i<n;i++)
					{
						for(j=0;j<r;j++)
							{
								scanf("%d",&allocation[i][j]);
							}
					}
				printf("Enter the availableable Resources:\n");
				for(j=0;j<r;j++)
					{
						scanf("%d",&available[j]);
					}
			}
		void output()
			{
				int i,j;
				printf("Process\tallocationation     req\t\tavailableable\t");
			for(i=0;i<n;i++)
				{printf(" ");
					printf("\nP%d\t   ",i+1);
			for(j=0;j<r;j++)
				{
					printf("%d ",allocation[i][j]);
				}
printf("\t");
printf("\t");
			for(j=0;j<r;j++)
				{
					printf("%d ",req[i][j]);
				}
printf("\t");
printf("\t");
			if(i==0)
				{
					for(j=0;j<r;j++)
						printf("%d ",available[j]);
				}
			}
		}
	void calculate()
		{
			int temp,need[100][100],flag=1,k,c1=0,d=0;
			int dead[100];
			int safe[100];
			int i,j;
			for(i=0;i<n;i++)
				{
					finish[i]=0;
				}

while(flag)
{
		flag=0;
		  for(i=0;i<n;i++)
			{
			int c=0;
			for(j=0;j<r;j++)
				{
				if((finish[i]==0)&&(req[i][j]<=available[j]))
					{
 						 c++;
			if(c==r)
				{
					for(k=0;k<r;k++)
						{
							available[k]+=allocation[i][j];
							finish[i]=1;
							flag=1;
 						     }

if(finish[i]==1)
{
i=n;
}
       }
}
}
  }
 }
 j=0;
 flag=0;
		 for(i=0;i<n;i++)
 			{
			if(finish[i]==0)
				{
					dead[j]=i;
					d++;
					j++;
					flag=1;
				}
			}
			if(flag==1)
				{
					printf("\n\nSystem is in Deadlock and the Deadlock process are\n");
				for(i=0;i<d;i++)
					{

						printf("P%d\t",dead[i]);
					}
			}
else
{
printf("\nNo Deadlock Occur");
}
}


