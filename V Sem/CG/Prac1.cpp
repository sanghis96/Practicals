#include <iostream>
#include <math.h>
#include <GL/glut.h>
using namespace std;

void Primitives(void)
{
	glClear(GL_COLOR_BUFFER_BIT);/ Clears Memory Buffer, Indicates Buffer currently enabled for buffer writing

	glBegin(GL_POINTS); 
	glVertex2d(0,0);
	glVertex2d(100,100);
	glVertex2d(200,200);
	glVertex2d(400,400);
	glVertex2d(500,320);
	glVertex2d(200,400);
	glEnd();

	glColor3f(0.0f, 1.0f, 0.0f); // green 
	glBegin(GL_LINES); 
	glVertex2d(0,0);
	glVertex2d(100,100);
	glVertex2d(200,200);
	glVertex2d(400,400);
	glVertex2d(500,320);
	glVertex2d(200,400);
	glEnd(); 

	glColor3f(0.0f, 0.0f, 1.0f); // blue 
	glBegin(GL_TRIANGLES); 
	glVertex2d(0,0);
	glVertex2d(100,100);
	glVertex2d(200,150);
	glVertex2d(400,300);
	glVertex2d(500,320);
	glVertex2d(200,400);
	glEnd();

	glFlush();/ Forces Execution
}

void Init()
{ 
	glClearColor(1.0,1.0,1.0,0); 
	glColor3f(1.0,0.0,0.0); // red
	glViewport(0 , 0 , 640 , 480);/ Set the vieport for viewing with lower left corner & Width & height
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
	glutCreateWindow("Primitives");
	Init();
	glutDisplayFunc(Primitives); 
	glutMainLoop(); / Enters the Glut event processing loop
	return 0;
}