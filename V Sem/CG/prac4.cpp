#include<math.h>
#include<iostream>
#include<GL/glut.h>
#include<stdio.h>
int X1, Y1, X2, Y2 , ch,ch2,s1,s2,ic,p,inside,j;
float dx,dx1,dy1, dy, x, l,y,q,r,s,temp,e;
int i = 1;
using namespace std;
int ver[10][2];
unsigned int pixel[3];
void edgeflag();

void Init()
{
	glClearColor(1.0, 1.0, 1.0, 0);
	glColor3f(1.0, 0.0, 0.0); // red
	glViewport(0, 0, 640, 480);// Set the vieWport for viewing with lower left corner & Width & height
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluOrtho2D(0, 640, 0, 480);
}

void poly()
{
	glClear(GL_COLOR_BUFFER_BIT);
	glColor3f(1.0f, 0.0f, 0.0f); 
	for(p=0;p<ch-1;p++)
	{
		X1=ver[p][0];
		Y1=ver[p][1];
		X2=ver[p+1][0];
		Y2=ver[p+1][1];
	float x,y,dx,dy,len;
	if(abs(X2-X1)>abs(Y2-Y1))
		len=abs(X2-X1);
	else
		len=abs(Y2-Y1);
	dx=(X2-X1)/len;
	dy=(Y2-Y1)/len;
	x=X1+0.5;
	y=Y1+0.5;
	int i=1;
	glBegin(GL_POINTS);
	while(i<=len)
	{
		glVertex2d(x,y);
		x=x+dx;
		y=y+dy;
		i=i+1;
	}}
	X1=ver[ch-1][0];
		Y1=ver[ch-1][1];
	X2=ver[0][0];
	Y2=ver[0][1];
	float x,y,dx,dy,len;
	if(abs(X2-X1)>abs(Y2-Y1))
		len=abs(X2-X1);
	else
		len=abs(Y2-Y1);
	dx=(X2-X1)/len;
	dy=(Y2-Y1)/len;
	x=X1+0.5;
	y=Y1+0.5;
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
	
	edgeflag();
	
}
void edgeflag()
{
	for(i=0;i<480;i++)
	{
		inside=0;
		for(j=200;j<640;j++)
		{
			glReadPixels(j,i,1,1,GL_RGB,GL_UNSIGNED_BYTE,pixel);
			if(pixel[0]==255 && pixel[1]==0 && pixel[2]==0)
			{
				if(inside==0)
					inside=1;
				else
					inside=0;	
			}

			if(inside==1)
			{
				glColor3f(0.0f, 0.0f, 1.0f);
				glBegin(GL_POINTS);
				glVertex2d(j,i);
					glEnd();
			}
		}

		
	}
		glFlush();
}

int main(int argc, char **argv)
{
	glutInit(&argc, argv);
	cout<<"Enter the no of vertices: ";
	cin>>ch;
	for(p=0;p<ch;p++)
	{
		cout<<"Enter the "<<p+1<<" point: ";
		cin>>ver[p][0]>>ver[p][1];
	}
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowSize(640, 480);
	glutInitWindowPosition(0, 0);
	glutCreateWindow("Edge Flag");
	Init();
	glutDisplayFunc(poly);
	glutMainLoop();
	return 0;
}
