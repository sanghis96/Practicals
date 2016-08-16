#include <iostream>
#include <math.h>
#include <glut.h>
using namespace std;

int X1,Y1,X2,Y2;
float x,y,dx,dy,len,p,q;
int s1,s2,inter,e;

int sign(double x)
{
    if(x==0)
        return 0;
    else if(x<0)
        return -1;
    else
        return 1;
}

void ddasimple(void)
{
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(1.0f, 0.0f, 0.0f); 
    int i=1;
    glBegin(GL_POINTS);
    while(i<=len)
    {
        glVertex2d(x,y);
        x=x+dx;
        y=y+dy;
        i=i+1;
    }
    glEnd();
    glFlush();
}

void ddadotted(void)
{
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(1.0f, 0.0f, 0.0f); 
    int i=1;
    glBegin(GL_POINTS);
    while(i<=len)
    {
        if(i%2==0)
            glVertex2d(x,y);
        x=x+dx;
        y=y+dy;
        i=i+1;
    }
    glEnd();
    glFlush();
}

void ddadashed(void)
{
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(1.0f, 0.0f, 0.0f); 
    int i=1;
    glBegin(GL_POINTS);
    while(i<=len)
    {
        if(i%7!=0)
            glVertex2d(x,y);
        x=x+dx;
        y=y+dy;
        i=i+1;
    }
    glEnd();
    glFlush();
}

void ddathick(void)
{
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(1.0f, 0.0f, 0.0f); 
    int i=1;
    glBegin(GL_POINTS);
    while(i<=len)
    {        
        glVertex2d(x,y);
        p=y+1;
        q=y-1;
        glVertex2d(x,p);
        glVertex2d(x,q);
        x=x+dx;
        y=y+dy;
        i=i+1;
    }
    glEnd();
    glFlush();
}

void brsimple(void)
{
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(0.0f, 1.0f, 0.0f);
    for(int i=1;i<=dx;i++)
    {
        glBegin(GL_POINTS);
        glVertex2d(x,y);
        while(e>0)
        {
            if(inter==1)
                x=x+s1;
            else
                y=y+s2;
            e=e-(2*dx);
        }
        if(inter==1)
            y=y+s2;
        else
            x=x+s1;
        e=e+(2*dy);
    }
    glEnd();
    glFlush();
}

void brdotted(void)
{
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(0.0f, 1.0f, 0.0f);
    for(int i=1;i<=dx;i++)
    {
        glBegin(GL_POINTS);
        if(i%2==0)
            glVertex2d(x,y);
        while(e>0)
        {
            if(inter==1)
                x=x+s1;
            else
                y=y+s2;
            e=e-2*dx;
        }
        if(inter==1)
            y=y+s2;
        else
            x=x+s1;
        e=e+2*dy;
    }
    glEnd();
    glFlush();
}

void brdashed(void)
{
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(0.0f, 1.0f, 0.0f);
    for(int i=1;i<=dx;i++)
    {
        glBegin(GL_POINTS);
        if(i%7!=0)
            glVertex2d(x,y);
        glEnd();
        while(e>0)
        {
            if(inter==1)
                x=x+s1;
            else
                y=y+s2;
            e=e-2*dx;
        }
        if(inter==1)
            y=y+s2;
        else
            x=x+s1;
        e=e+2*dy;
    }
    glFlush();
}
void brthick(void)
{
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(0.0f, 1.0f, 0.0f);
    for(int i=1;i<=dx;i++)
    {
        p=y+1;
        q=y-1;
        glBegin(GL_POINTS);
        glVertex2d(x,y);
        glVertex2d(x,p);
        glVertex2d(x,q);
        glEnd();
        while(e>0)
        {
            if(inter==1)
                x=x+s1;
            else
                y=y+s2;
            e=e-2*dx;
        }
        if(inter==1)
            y=y+s2;
        else
            x=x+s1;
        e=e+2*dy;
    }
    glFlush();
}

void Init()
{ 
    glClearColor(1.0,1.0,1.0,0); 
    glColor3f(1.0,0.0,0.0); // red
    glViewport(0 , 0 , 640 , 480);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluOrtho2D(0 , 640 , 0 , 480);
}

int main(int argc, char **argv)
{
    int choice1,choice2;
    glutInit(&argc,argv); 
    glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB); 
    glutInitWindowSize(640,480); 
    glutInitWindowPosition(0,0);
    cout<<"Choose Algorithm:-\n";
    cout<<"1.DDA   2.Bresenhams"<<endl<<": ";
    cin>>choice1;
    cout<<"\n1.Simple Line   2. Dotted Line   3.Dashed Line   4.Thick Line"<<endl<<": ";
    cin>>choice2;
    cout<<"\nEnter (x1,y1):-"<<endl;
    cin>>X1>>Y1;
    cout<<"\nEnter (x2,y2):-"<<endl;
    cin>>X2>>Y2;
    switch(choice1)
    {
        case 1:    glutCreateWindow("DDA");
                Init();
                if(abs(X2-X1) > abs(Y2-Y1))
                    len = abs(X2-X1);
                else
                    len = abs(Y2-Y1);
                dx = (X2-X1)/len;
                dy = (Y2-Y1)/len;
                x = X1+0.5*sign(dx);
                y = Y1+0.5*sign(dy);
                switch(choice2)
                {
                    case 1:    glutDisplayFunc(ddasimple); 
                            break;
                    case 2:    glutDisplayFunc(ddadotted); 
                            break;
                    case 3:    glutDisplayFunc(ddadashed);
                            break;
                    case 4:    glutDisplayFunc(ddathick);
                            break;
                    default:cout<<"\n\n\tWrong Choice !!!";
                }
                break;
        case 2:    glutCreateWindow("Bresenham");
                Init();
                x = X1;
                y = Y1;
                dx = abs(X2-X1);
                dy = abs(Y2-Y1);
                s1 = sign(X2-X1);
                s2 = sign(Y2-Y1);
                if(dy > dx)
                {
                    inter = 1;
                    int temp = dx;
                    dx = dy;
                    dy = temp;
                }
                else
                    inter = 0;
                e = 2*dy-dx;
                switch(choice2)
                {
                    case 1:    glutDisplayFunc(brsimple); 
                            break;
                    case 2:    glutDisplayFunc(brdotted); 
                            break;
                    case 3:    glutDisplayFunc(brdashed);
                            break;
                    case 4:    glutDisplayFunc(brthick);
                            break;
                    default:cout<<"\n\n\tWrong Choice !!!";
                }
                break;
        default:exit(0);
    }
    glutMainLoop();
    return 0;
}