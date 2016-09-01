#include<stdio.h>
#define MAX 20

void main()
{
	int seq[MAX];
	int hs,j,s,temp,i,a,x=0,end,noreq,prev;

//Input from console
	printf("Enter the total number of cylinders :");
	scanf("%d",&end);
	printf("Enter no. of elements in queue pendinng request :");
	scanf("%d",&noreq);
	printf("Enter the queue pending request:-\n");
	for(i=1;i<=noreq;i++)
		scanf("%d",&seq[i]);
	printf("\nEnter the start cylinder :");
	scanf("%d",&hs);
	printf("\nEnter the previous cylinder :");
	scanf("%d",&prev);

//As per algorithm of CScan	
	seq[0]=0;
	seq[noreq+1]=end-1;
	
//Sorting pending request Queue
	for(i=0;i<=noreq+1;i++)
	{
		for(j=i+1;j<=noreq+1;j++)
		{
			if(seq[i]>seq[j])
			{
				temp=seq[i];
				seq[i]=seq[j];
				seq[j]=temp;
			}
		}
	}

//For Forward directon
	if(prev<hs)
	{
		for(i=0;i<=noreq;i++)
			if(seq[i]>hs)
			{
				a=i;
				break;
			}
		printf("\n %d->",hs);
		s=hs;
		for(i=a;i<=noreq+1;i++)
		{
			x+=(seq[i]-s);
			printf("%d->",seq[i]);
			s=seq[i];
		}	
		x+=seq[noreq+1];
		s=0;
		for(i=0;i<a;i++)
		{
			x+=(seq[i]-s);
			printf("%d->",seq[i]);
			s=seq[i];
		}
	}

//For Backward Direction
	else if(prev>hs)
	{
		for(i=0;i<=noreq;i++)
			if(seq[i]<hs)
				a=i;
		printf("\n %d->",hs);
		s=hs;
		for(i=a;i>=0;i--)
		{
			x+=(s-seq[i]);
			printf("%d->",seq[i]);
			s=seq[i];
		}
		x+=seq[noreq+1]-s;
		s=seq[noreq+1];
		for(i=noreq+1;i>a;i--)
		{
			x+=(s-seq[i]);
			printf("%d->",seq[i]);
			s=seq[i];
		}
	}

//Print total Head Movement
	printf("\nTotal head movement : %d\n\n",x);

}
