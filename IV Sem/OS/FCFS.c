#include<stdio.h>
#include<math.h>
#define MAX 20

void main()
{
	int seq[MAX];
	int hs,s,i,x=0,end,noreq;

//Input from console
	printf("Enter the total number of cylinders :");
	scanf("%d",&end);
	printf("Enter no. of elements in queue pendinng request(MAX 20) :");
	scanf("%d",&noreq);
	printf("Enter the queue pending request:-\n");
	for(i=1;i<=noreq;i++)
		scanf("%d",&seq[i]);
	printf("\nEnter the start cylinder :");
	scanf("%d",&hs);
	
//Calculate total head movement
	s=hs;
	printf("%d->",hs);
	for(i=1;i<=noreq;i++)
	{
		x+=fabs(s-seq[i]);
		printf("%d->",seq[i]);
		s=seq[i];
	}

//Print total head moment
	printf("\nTotal head movement : %d\n\n",x);

}
