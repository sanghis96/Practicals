#include<stdio.h>

void main()
{
	int n,hs,req,i,j,x=0,s,cpos,min,set;
	
//Input from Console
	printf("\nEnter no of cylinders :");
	scanf("%d",&n);
	printf("Enter total pending requests in queue :");
	scanf("%d",&req);
	int served[req];
	int q[10];
	printf("Enter requests :-\n");
	for(i=0;i<req;i++)
	{
		scanf("%d",&q[i]);
		served[i]=0;
	}
	printf("Enter current head position :");
	scanf("%d",&hs);

//Calculate momvement and print graph
	cpos = hs;
	printf("%d->",hs);
	for(i=0;i<req;i++)
	{
		min=999999;
		for(j=0;j<req;j++)
		{
			s=cpos-q[j];
			if(s<0)
				s*=-1;
			if(s<min && served[j]==0)
			{
				min=s;
				set=j;
			}
		}
		served[set]=1;
		if(cpos>q[set])
		{
			x+=cpos-q[set];
			cpos=q[set];
		}
		else
		{
			x+=q[set]-cpos;
			cpos=q[set];
		}
		printf("%d->",q[set]);		
	}

//Print total Head movement
	printf("\nTotal head movement :%d\n\n",x);
}
