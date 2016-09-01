Non-preemptive SJF

#include<stdio.h>

#include<stdlib.h>

struct process

{ 

int at,bt,wt,tat,rt;

char pn[2];

};

void main()

{ 

int n,i,min=999,c=0,mp,sumrt=0;

float awt=0,atat=0,ttat=0,twt=0;

struct process p[5];

printf("\nenter the number of process: "); 

scanf("%d",&n); 

for(i=0;i<n;i++) 

{ 

printf("\nenter the process name: "); 

scanf("%s",&p[i].pn);

printf("\nenter the arrival time: "); 

scanf("%d",&p[i].at);

printf("\nenter the burst time: ");

scanf("%d",&p[i].bt); 

printf("\n"); 

p[i].wt=0; 

p[i].tat=0; 

p[i].rt=p[i].bt;

}

    for(i=0;i<n;i++)

    {

        sumrt+=p[i].rt;

    }

        while(sumrt!=0) 

{

         min=999; 

for(i=0;i<n;i++)

{ 

if((p[i].bt<=min)&&(p[i].at<=c)&&(p[i].rt!=0)) 

{ 

mp=i;

min=p[i].bt;

} 

} 

p[mp].wt=c-p[mp].at; 

c=c+p[mp].bt;

p[mp].rt-=p[mp].bt;

p[mp].tat=c-p[mp].at; 

for(i=0;i<n;i++)

{ 

if((mp!=i)&&p[i].rt!=0)

{

p[i].wt+=p[mp].bt; 

} 

} 

sumrt=0; 

for(i=0;i<n;i++)

{ 

sumrt+=p[i].rt;

        } 

} 

printf("\n--------------------------------------"); 

for(i=0;i<n;i++) 

{ 

twt+=p[i].wt;

ttat+=p[i].tat;

} 

awt=twt/n; 

atat=ttat/n;

printf("\n                     NON-PREMPTIVE SJF                       ");

printf("\n----------------------------------------------------------------------"); 

printf("\nprocess | arrival time | burst time | waiting time | turn around 

time|"); 

printf("\n----------------------------------------------------------------------"); 

for(i=0;i<n;i++) 

{ 

printf("\n  %s    |     %d       |    %d      |     %d       |       %d        

|",p[i].pn,p[i].at,p[i].bt,p[i].wt,p[i].tat);

} 

printf("\n----------------------------------------------------------------------"); 

printf("\n\naverage waiting time: %f\naverage turn around time: 

%f\n",awt,atat);

}