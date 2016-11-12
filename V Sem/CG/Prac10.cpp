#include<stdio.h>
#include<stdio.h>
#include<conio.h>
void main()
{
	int a[8][8]={{160 , 160  , 160  , 160  , 160 ,  255, 255 , 255},
	{ 160 , 160 ,  160  , 160 ,  160 ,  255,  255 , 255},
	{255 , 255  , 255  , 255  , 255  ,  2,2,2},
	{255 , 255,255 ,  255  , 255 ,   2   ,   2   ,   2},
	{255 , 255,255 ,  255  , 255 ,   2   ,   2   ,   2},
	{255 , 255,255 ,  255  , 255 ,   2   ,   2   ,   2},
	{160 , 160 ,  160  , 160 ,  160  , 255,  255 , 255},
	{255 , 255,255 ,  255  , 255 ,   2   ,   2   ,   2}

};
	int res[100];
	int k=0;
	int i,j,temp,s=0,cnt=0,cnt2=0;
	float r=0.0;
	for(i=0;i<8;i++)
	{
		for(j=0;j<8;j++)
		{
			s+=a[i][j];
		}
	}
	s=s/64;
	for(i=0;i<8;i++)
	{
		printf("\n");
		for(j=0;j<8;j++)
		{
			a[i][j]=a[i][j]-s;
			printf("  %d",a[i][j]);
		}
	}
	printf("\n\n");
	i=j=0;
	res[k++]=a[i][j];
	printf("%d",a[i][j]);
	while(true)
	{
		j++;
		while(j!=0)
		{
			i++;
			j--;
			res[k++]=a[i][j];
			printf(" %d ",a[i][j]);
		}
		i++;
		if(i>=8)
		{
			i--;
			break;
			
		}
		res[k++]=a[i][j];
		printf(" %d ",a[i][j]);
		while(i!=0)
		{
			i--;
			j++;
			res[k++]=a[i][j];
			printf(" %d",a[i][j]);
		}

	}
	while(true)
	{
		j++;
		res[k++]=a[i][j];
		printf(" %d",a[i][j]);
		while(j!=7)
		{
			i--;
			j++;
			res[k++]=a[i][j];
			printf(" %d",a[i][j]);
		}
		i++;
		if(i>=8)
		{
			break;
		}
		res[k++]=a[i][j];
		printf(" %d",a[i][j]);
		while(i!=7)
		{
			i++;
			j--;
			res[k++]=a[i][j];
			printf(" %d",a[i][j]);

		}
	}
	printf("\n\n");
	i=0;
	while(true)
	{
		cnt=1;
		temp=res[i];
		
		i++;
		while(res[i]==temp)
		{
			
			i++;
			cnt++;
		}
		if(i>=63)
			break;
		cnt2=cnt2+1;

		printf(" %d %d   ",temp,cnt);
	}
	cnt2=cnt2*2;
printf("\n no of integers in reduced matrix  are  %d",cnt2);
r=(float(64 -cnt2)/64)*100;
printf("\n compression percentage is %f ",r);
getch();
}