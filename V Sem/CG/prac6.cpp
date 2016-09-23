#include <iostream>
#include <math.h>
#include <GL/glut.h>

void mid(int x1,int y1,int x2, int y2)
{
    double yl,yr,xb,xt,m;
	int xl=100,xr=200,yb=100,yt=200;
	int p1[4],p2[4];
	if(x1<xl)
		p1[0]=1;
	if(x1>xr)
		p1[1]=1;
	if(y1<yb)
		p1[2]=1;
	if(y1>yt)
		p1[3]=1;
	if(x2<xl)
		p2[0]=1;
	if(x2>xr)
		p2[1]=1;
	if(y2<yb)
		p2[2]=1;
	if(y2>yt)
		p2[3]=1;
	
	//finding the intersection
	m=(y2-y1)/(x2-x1);
	//left edge
	yl=(m*(xl-x1))+y1;
	//right edge
	yr=(m*(xr-x1))+y1;
	//bottom edge
	xb=((yb-y1)/m)+(x1);
	//top edge
	xt=((yt-y1)/m)+(x1);
	
	double a,b,c,d;
	if((yl<200 && yl>100) && (yr<200 && yr>100))
	{
		
		a = xl;
		b = yl;
		c = xr;
		d = yr;
		
	}
	if((yl<200 && yl>100) && (xb<200 && xb>100))
	{
		a = xl;
		b = yl;
		c = xb;
		d = yb;
	}
	if((yl<200 && yl>100) && (xt<200 && xt>100))
	{
		a = xl;
		b = yl;
		c = xt;
		d = yt;
	}
	if((yr<200 && yr>100) && (xb<200 && xb>100))
	{
		a = xr;
		b = yr;
		c = xb;
		d = yb;
	}
	
	if((yr<200 && yr>100) && (xt<200 && xt>100))
	{
		a = xr;
		b = yr;
		c = xt;
		d = yt;
	}

	if((xb<200 && xb>100) && (xt<200 && xt>100))
	{
		a = xb;
		b = yb;
		c = xt;
		d = yt;
	}
		
		
	glColor3f(0.0f, 0.0f, 0.0f); 
    glBegin(GL_LINE_LOOP);
    glVertex2d(300,300);
    glVertex2d(400,300);
    glVertex2d(400,400);
    glVertex2d(300,400);
    glEnd();
	
	glBegin(GL_LINES);
		glVertex2d(a+200,b+200);
		glVertex2d(c+200,d+200);
    glEnd();
	glFlush();

	
}



void Clipping(void)
{
    int x1,y1,x2,y2;
    printf("Enter x & y coordinates of p1:");
    scanf("%d %d",&x1,&y1);
    printf("Enter x & y coordinates of p2:");
    scanf("%d %d",&x2,&y2);
	
	glClear(GL_COLOR_BUFFER_BIT);
	glColor3f(0.0f, 0.0f, 0.0f); 
    glBegin(GL_LINE_LOOP);
    glVertex2d(100,100);
    glVertex2d(200,100);
    glVertex2d(200,200);
    glVertex2d(100,200);
    glEnd();

    glBegin(GL_LINES);
    glVertex2d(x1,y1);
    glVertex2d(x2,y2);
    glEnd();
	glFlush();

	mid(x1, y1, x2, y2);
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
	glutDisplayFunc(Clipping);
	glutMainLoop(); // Enters the Glut event processing loop
	return 0;
}
