#include <iostream>
#include <math.h>
#include <GL/glut.h>
using namespace std;

bool checkinside(int, int);
void seed(int, int);

int X1[100],Y1[100],n,i,j,inside,sx,sy,cnt=0;
unsigned char pixel[3];
bool ins;

void edge();

int sign(double x)
{
    if(x==0)
        return 0;
    else if(x<0)
        return -1;
    else
        return 1;
}


void dda(void)
{
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(1.0f, 0.0f, 0.0f);
    float x,y,dx,dy,len;
    for(j=0;j<n;j++)
    {
        if(abs(X1[j+1]-X1[j])>abs(Y1[j+1]-Y1[j+1]))
            len=abs(X1[j+1]-X1[j]);
        else
            len=abs(Y1[j+1]-Y1[j]);
        dx=(X1[j+1]-X1[j])/len;
        dy=(Y1[j+1]-Y1[j])/len;
        x=X1[j]+0.5*sign(dx);
        y=Y1[j]+0.5*sign(dy);
        int i=1;
        glBegin(GL_POINTS);
        while(i<=len)
        {
            glVertex2d(x,y);
            cout<<x<<","<<y<<endl;
            x=x+dx;
            y=y+dy;
            i=i+1;
        }
        glEnd();
    }
    glFlush();
    cout<<"Enter the coordinates of seed pixel:";
    cin>>sx>>sy;
    ins=checkinside(sx,sy);
    if(ins==true)
    {
        cout<<"The seed pixel is inside";
        seed(sx,sy);
    }
    else
    {
        cout<<"The seed pixel is not inside";
        glFlush();
    }
}

bool checkinside(int a, int b)
{
    bool z;
    for (int i = a; i >= 0; i--) {
        glReadPixels(i, b, 1, 1, GL_RGB, GL_UNSIGNED_BYTE, pixel);
        int r = (int)pixel[0], g= (int)pixel[1], b = (int)pixel[2];
        if (r == 255 && g == 0 && b == 0) {
            cnt++;
        }
    }
    if (cnt % 2 != 0)
        z=true;
    else
        z=false;
    
    return z;
}

void Init()
{
    glClearColor(1.0,1.0,1.0,0);
    glColor3f(1.0,0.0,0.0); // Red
    glViewport(0 , 0 , 640 , 480);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluOrtho2D(0 , 640 , 0 , 480);
}

void seed(int x, int y)
{
    glColor3f(0.0, 1.0, 0.0); //Green
    glBegin(GL_POINTS);
    glVertex2d(x, y);
    glEnd();
    glReadPixels(x + 1, y, 1, 1, GL_RGB, GL_UNSIGNED_BYTE, pixel);
    int r = (int)pixel[0], g = (int)pixel[1], b = (int)pixel[2];
    if( (r == 255 && g == 255 && b== 255)){
        seed(x + 1, y);
    }
    /*glReadPixels(x+1, y+1, 1, 1, GL_RGB, GL_UNSIGNED_BYTE, pixel);
    r = (int)pixel[0], g = (int)pixel[1], b = (int)pixel[2];
    if ((r == 255 && g == 255 && b == 255)) {
        seed(x+1, y+1);
    }*/
    glReadPixels(x, y + 1, 1, 1, GL_RGB, GL_UNSIGNED_BYTE, pixel);
    r = (int)pixel[0], g = (int)pixel[1], b = (int)pixel[2];
    if ((r == 255 && g == 255 && b == 255)) {
        seed(x, y + 1);
    }/*
    glReadPixels(x-1, y + 1, 1, 1, GL_RGB, GL_UNSIGNED_BYTE, pixel);
    r = (int)pixel[0], g = (int)pixel[1], b = (int)pixel[2];
    if ((r == 255 && g == 255 && b == 255)) {
        seed(x-1, y + 1);
    }*/
    glReadPixels(x-1, y, 1, 1, GL_RGB, GL_UNSIGNED_BYTE, pixel);
    r = (int)pixel[0], g = (int)pixel[1], b = (int)pixel[2];
    if ((r == 255 && g == 255 && b == 255)) {
            seed(x-1, y);
    }/*
    glReadPixels(x-1, y - 1, 1, 1, GL_RGB, GL_UNSIGNED_BYTE, pixel);
    r = (int)pixel[0], g = (int)pixel[1], b = (int)pixel[2];
    if ((r == 255 && g == 255 && b == 255)) {
        seed(x-1, y - 1);
    }*/
    glReadPixels(x, y-1, 1, 1, GL_RGB, GL_UNSIGNED_BYTE, pixel);
    r = (int)pixel[0], g = (int)pixel[1], b = (int)pixel[2];
    if ((r == 255 && g == 255 && b == 255)) {
        seed(x, y - 1);
    }/*
    glReadPixels(x+1, y - 1, 1, 1, GL_RGB, GL_UNSIGNED_BYTE, pixel);
    r = (int)pixel[0], g = (int)pixel[1], b = (int)pixel[2];
    if ((r == 255 && g == 255 && b == 255)) {
        seed(x+1, y - 1);
    }*/
}


int main(int argc, char **argv)
{
    glutInit(&argc,argv);
    glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
    glutInitWindowSize(640,480);
    glutInitWindowPosition(0,0);
    glutCreateWindow("Seed Fill Algorithm");
    Init();
    cout<<"No. of sides in polygon:";
    cin>>n;
    for(i=0;i<=n;i++)
    {
        if(i==n)
        {
            X1[i]=X1[0];
            Y1[i]=Y1[0];
        }
        else
        {
            cout<<"Enter coordinates (x,y):";
            cin>>X1[i]>>Y1[i];
        }
        glutDisplayFunc(dda);
    }
    glutMainLoop();
    return 0;
}