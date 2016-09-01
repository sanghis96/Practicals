#include<stdio.h>
struct process
{
    char pname[5];
    int at,bt,rt,wt,tat,pri,flag[10],to;
}p[10];
void main()
{
    int n,i,j,min,tot_time=0,time=0,q;
    printf("\nEnter the number of processes(max 10):");
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        printf("\nEnter name of process-%d:",i+1);
        scanf("%s",p[i].pname);
        printf("Enter arrival time:");
        scanf("%d",&p[i].at);
        printf("Enter burst time:");
        scanf("%d",&p[i].bt);
        printf("Enter the priority:");
        scanf("%d",&p[i].pri);
        p[i].rt=p[i].bt;
        p[i].wt-=p[i].at;
        p[i].tat-=p[i].at;
        tot_time+=p[i].bt;
        p[i].flag[i]=0;
        p[i].to=0;
    }
	printf("\n");
    while(time<tot_time)
    {
        min=99;
        for(i=0;i<n;i++)
        {
            if((p[i].at<=time)&&(min>p[i].pri)&&(p[i].flag[i]==0))
            {
                min=p[i].pri;
                q=i;
            }
        }
                p[q].wt+=time-p[q].tat;
                time++;
                p[q].to++;
                p[q].tat=time-p[q].at;             
                if(p[q].to==p[q].bt)
                    p[q].flag[q]=1;
                printf("|%s|",p[q].pname);
     }
     printf("\n\nName\t|A.T\t|B.T\t|pri\t|W.T\t|T.A.T\t|");
     for(i=0;i<n;i++)
     {
        printf("\n%s\t|",p[i].pname);
        printf("%d\t|",p[i].at);
        printf("%d\t|",p[i].bt);
        printf("%d\t|",p[i].pri);
        printf("%d\t|",p[i].wt);
        printf("%d\t|",p[i].tat);
     }
     printf("\n\n");
} 
