#include<stdio.h>
 #include<sys/types.h>
 #include<sys/file.h>
 #define MAX 5

 void main()
 {
     struct process{
         int at,bt,bto,flag, wt,tat,num;
     }x[MAX];
     int i, y=0,current=0,n,j,total=0,temp=0,qt,numb=1,min=1; 
     float avgw=0, avgt=0;
     printf("TIME QUANTUM:  ");
     scanf("%d",&qt);
     printf("NO OF PROCESS: ");
     scanf("%d",&n);
     //inputting
     for(i=0;i<n;i++)
     {
         printf("Arrival time for P%d: ", i+1);
         scanf("%d",&x[i].at);
         printf("Burst time for P%d: ", i+1);
         scanf("%d",&x[i].bto);x[i].bt=x[i].bto;
         x[i].flag=0;
         total+=x[i].bt;
         x[i].wt=x[i].tat=0;
     }
     //scheduling algo round robin
     for(i=0;i<n;i++)
     {
         for(j=0;j<n;j++)
         {
             if(x[j].at==y)
             {
                 x[j].num=numb++;
             }
         }
         y++;
     }
     
     while(current<total)
     {   
         for(j=0;j<n;j++)//calculating current process to be executed
         {
             if((x[j].at<=current)&&(x[j].num==min)&&(x[j].flag!=1))
             {
                     temp=j;
             }
         }
         printf("|%d| P%d ", current,temp+1);//printing process
         x[temp].wt=x[temp].wt+current-x[temp].tat-x[temp].at;
         if(x[temp].bt>qt)
         {
             current+=qt;
             x[temp].bt-=qt;
         }
         else if(x[temp].bt<=qt)
         {
             current=current+x[temp].bt;
             x[temp].bt=0;
             x[temp].flag=1;
         }
         x[temp].tat=current-x[temp].at;
         if(min==5)
             min=1;
         else
             min++;
     }
     printf("|%d|\n", current);
     //printing
     printf("|PROCESS\t|ARRIVAL TIME\t|BURST TIME\t|WAITING TIME\t|TURNAROUND TIME\n");
     for(i=0;i<n;i++)
     {
         printf("| P%d\t\t| %d\t\t|  %d\t\t|  %d\t\t|  %d\t\t\n",i+1,x[i].at,x[i].bto,x[i].wt,x[i].tat);
         avgw+=x[i].wt;
         avgt+=x[i].tat;
     }
     printf("\nAVERAGE WAITING TIME: %f\n", avgw/n); 
     printf("AVERAGE TURN AROUND TIME: %f\n", avgt/n); 
 }