#include <iostream>
#include <math.h>
#include <GL/glut.h>
#include<GL/samarth.h>

using namespace std;

Point window[4];

void mid(Point line[2])
{
    double yl,yr,xb,xt,m;
	int xl=window[0].x, xr=window[3].x, yb=window[0].y, yt=window[3].y;
	int p1code[4],p2code[4];
	if(line[0].x <= xl)
		p1code[0] = 1;
	else
		p1code[0] = 0;
	if(line[0].x >= xr)
		p1code[1] = 1;
	else
		p1code[1] = 0;
	if(line[0].y <= yb)
		p1code[2] = 1;
	else
		p1code[2] = 0;
	if(line[0].y >= yt)
		p1code[3] = 1;
	else
		p1code[3] = 0;
	if(line[1].x <= xl)
		p2code[0] = 1;
	else
		p2code[0] = 0;
	if(line[1].x >= xr)
		p2code[1] = 1;
	else
		p2code[1] = 0;
	if(line[1].y <= yb)
		p2code[2] = 1;
	else
		p2code[2] = 0;
	if(line[1].y >= yt)
		p2code[3] = 1;
	else
		p2code[3] = 0;
	
	//Check Visibility
	if(p1code[0]==0 && p1code[1]==0 && p1code[2]==0 && p1code[3]==0 && p2code[0]==0 && p2code[1]==0 && p2code[2]==0 && p2code[3]==0)
		cout<<"\n\nCompletly visible. No intersection points!!!";
	else if(p1code[0]==p2code[0] && p1code[1]==p2code[1] && p1code[2]==p2code[2] && p1code[3]==p2code[3])
		cout<<"\n\nCompletly invisible. No intersection points!!!";
	else
	{
		cout<<"\n\nPartialy Visible";
		
		//finding the intersection
		m = (line[1].y-line[0].y)/(line[1].x-line[0].x);
		//left edge
		yl = (m*(xl-line[0].x))+line[0].y;
		//right edge
		yr = (m*(xr-line[0].x))+line[0].y;
		//bottom edge
		xb = ((yb-line[0].y)/m)+(line[0].x);
		//top edge
		xt = ((yt-line[0].y)/m)+(line[0].x);

		Point newLine[2];
		if((yl<window[2].y && yl>window[0].y) && (yr<window[2].y && yr>window[0].y))
		{
			newLine[0].x = xl;
			newLine[0].y = yl;
			newLine[1].x = xr;
			newLine[1].y = yr;
		
		}
		if((yl<window[2].y && yl>window[0].y) && (xb<window[2].x && xb>window[0].x))
		{
			newLine[0].x = xl;
			newLine[0].y = yl;
			newLine[1].x = xb;
			newLine[1].y = yb;
		}
		if((yl<window[2].y && yl>window[0].y) && (xt<window[2].x && xt>window[0].x))
		{
			newLine[0].x = xl;
			newLine[0].y = yl;
			newLine[1].x = xt;
			newLine[1].y = yt;
		}
		if((yr<window[2].y && yr>window[0].y) && (xb<window[2].x && xb>window[0].x))
		{
			newLine[0].x = xr;
			newLine[0].y = yr;
			newLine[1].x = xb;
			newLine[1].y = yb;
		}
		if((yr<window[2].y && yr>window[0].y) && (xt<200 && xt>window[0].x))
		{
			newLine[0].x = xr;
			newLine[0].y = yr;
			newLine[1].x = xt;
			newLine[1].y = yt;
		}
		if((xb<window[2].x && xb>window[0].x) && (xt<window[2].x && xt>window[0].x))
		{
			newLine[0].x = xb;
			newLine[0].y = yb;
			newLine[1].x = xt;
			newLine[1].y = yt;
		}
		cout<<"\nIntersection points: "<<newLine[0].x<<" "<<newLine[0].y<<"    "<<newLine[1].x<<" "<<newLine[1].y;

		Point temp1[4], temp2[2];
		Transformation t;
		t.translate(4, window, temp1, 250, 200);
		t.translate(2, newLine, temp2, 250, 200);
		
		glColor3f(0.0,0.0,0.0);//black
		glBegin(GL_POINTS);
		for(int i=0; i<4; i++)
		{
			dda l;
			l.line(temp1[i].x,temp1[i].y,temp1[(i+1)%4].x,temp1[(i+1)%4].y);	
		}
		glEnd();
		glFlush();

		glColor3f(0.0,0.0,0.0);//black
		glBegin(GL_POINTS);
		dda l;
		l.line(temp2[0].x, temp2[0].y, temp2[1].x, temp2[1].y);
		glEnd();
		glFlush();
	}
}

void Clipping(void)
{	
	glClear(GL_COLOR_BUFFER_BIT);
	glColor3f(0.0,0.0,0.0);//black
	glBegin(GL_POINTS);
	for(int i=0; i<4; i++)
	{
		dda l;
		l.line(window[i].x,window[i].y,window[(i+1)%4].x,window[(i+1)%4].y);	
	}
	glEnd();
	glFlush();

	Point line[2];
    cout<<"Enter x & y coordinates of p1:";
    cin>>line[0].x>>line[0].y;
    cout<<"Enter x & y coordinates of p2:";
    cin>>line[1].x>>line[1].y;
    glColor3f(0.0,0.0,0.0);//black
	glBegin(GL_POINTS);
	dda l;
	l.line(line[0].x, line[0].y, line[1].x, line[1].y);
	glEnd();
	glFlush();

	mid(line);
}
void Init()
{
    glClearColor(1.0,1.0,1.0,0);
    glColor3f(1.0,0.0,0.0); // red
    glViewport(0 , 0 , 640 , 480);// Set the vieport for viewing with lower left corner & Width & height
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluOrtho2D(0 , 640 , 0 , 480);
}
int main(int argc, char **argv)
{
	glutInit(&argc,argv);
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowSize(640,480);
	glutInitWindowPosition(0,0);
	glutCreateWindow("Clipping");
	Init();

	cout<<"Enter the co-ordinates of Window:-\n";
	for(int i=0; i<4; i++)
		cin>>window[i].x>>window[i].y;

	glutDisplayFunc(Clipping);
	glutMainLoop(); // Enters the Glut event processing loop
	return 0;
}