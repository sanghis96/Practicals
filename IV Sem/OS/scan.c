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
	
//Sorting the pending request Queue
	for(i=0;i<=noreq+1;i++)
		for(j=i+1;j<=noreq+1;j++)
			if(seq[i]>seq[j])
			{
				temp=seq[i];
				seq[i]=seq[j];
				seq[j]=temp;
			}

//For Forward direction
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
		for(i=a-1;i>0;i--)
		{
			x+=(s-seq[i]);
			printf("%d->",seq[i]);
			s=seq[i];
		}
	}

//For Backward direction
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
		for(i=a+1;i<=noreq;i++)
		{
			x+=(seq[i]-s);
			printf("%d->",seq[i]);
			s=seq[i];
		}
	}

//Print total head moment
	printf("\nTotal head movement : %d\n\n",x);

}
