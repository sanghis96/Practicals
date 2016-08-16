#include <iostream>
#include <math.h>
#include <glut.h>
using namespace std;

int a,b,r,deli,del,deld,c,d;

 void setpixel(int a,int b)
 {   glPointSize(5);
     glColor3f(1.0f, 0.0f, 0.0f);
     glBegin(GL_POINTS);
     glVertex2d(a+c,b+d);
     glVertex2d(-a+c,b+d);
     glVertex2d(-a+c,-b+d);
     glVertex2d(a+c,-b+d);
     glEnd();
     glFlush();
 }

void mh()
{
    a++;
    deli = deli+(2*a)+1;
}
 
void md()
{
    a++;
    b--;
    deli = deli+(2*a)-(2*b)+2;
}

void mv()
{
    b--;
    deli = deli-(2*b)+1;
}

void circle()
{
    glClear(GL_COLOR_BUFFER_BIT);
    a = 0;
    b = r;
    deli = 2*(1-r);
    while(b >= 0)
    { 
        setpixel(a,b);
        if(deli < 0)
        {
            del = (2*deli)+(2*b)-1; 
            if(del <= 0)
                mh();
            else
                md();
        }
        else if(deli > 0)
        {
            deld = (2*deli)-(2*a)-1;
            if(deld <= 0)
                md();
            else
                mv();
        }
        else
            md();
    }
}

void Init()
{ 
    glClearColor(1.0,1.0,1.0,0); 
    glColor3f(1.0,0.0,0.0); 
    glViewport(0 , 0 , 640 , 480);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluOrtho2D(0 , 640 , 0 , 480);
}

int main(int argc, char **argv)
{
    glutInit(&argc,argv); 
    glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB); 
    cout<<"Enter the center co-ordinates:-\n";
    cin>>c>>d;
    cout<<"\nEnter the radius of circle: ";
    cin>>r;
    
    glutInitWindowSize(640,480);
    glutInitWindowPosition(0,0);
    glutCreateWindow("CIRCLE");
    Init();
    glutDisplayFunc(circle); 
    glutMainLoop(); // Enters the Glut event processing loop
    return 0;
}