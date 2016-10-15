#include <iostream>
#include <GL/glut.h>

void threeD(void)
{
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // Clear color and depth buffers
	glMatrixMode(GL_MODELVIEW); 
	//glutWireSphere(5,5,15);
	//glutWireCone(2,3,15,15);
	glBegin(GL_POLYGON);                
      
		// Top face 
      glColor3f(0.0f, 1.0f, 0.0f);     // Green
      glVertex3f( 1.0f, 1.0f, -1.0f);
      glVertex3f(-1.0f, 1.0f, -1.0f);
      glVertex3f(-1.0f, 1.0f,  1.0f);
      glVertex3f( 1.0f, 1.0f,  1.0f);
	  glEnd();
	  glBegin(GL_POLYGON);   
      
	  // Bottom face 
      glColor3f(1.0f, 0.5f, 0.0f);     // Orange
      glVertex3f( 1.0f, -1.0f,  1.0f);
      glVertex3f(-1.0f, -1.0f,  1.0f);
      glVertex3f(-1.0f, -1.0f, -1.0f);
      glVertex3f( 1.0f, -1.0f, -1.0f);
      glEnd();
      glBegin(GL_POLYGON);   
      
	  // Front face  
      glColor3f(1.0f, 0.0f, 0.0f);     // Red
      glVertex3f( 1.0f,  1.0f, 1.0f);
      glVertex3f(-1.0f,  1.0f, 1.0f);
      glVertex3f(-1.0f, -1.0f, 1.0f);
      glVertex3f( 1.0f, -1.0f, 1.0f);
      glEnd();
	  glBegin(GL_POLYGON);   
      
	  // Back face 
      glColor3f(1.0f, 1.0f, 0.0f);     // Yellow
      glVertex3f( 1.0f, -1.0f, -1.0f);
      glVertex3f(-1.0f, -1.0f, -1.0f);
      glVertex3f(-1.0f,  1.0f, -1.0f);
      glVertex3f( 1.0f,  1.0f, -1.0f);
      glEnd();
	  glBegin(GL_POLYGON);   
      
	  // Left face 
      glColor3f(0.0f, 0.0f, 1.0f);     // Blue
      glVertex3f(-1.0f,  1.0f,  1.0f);
      glVertex3f(-1.0f,  1.0f, -1.0f);
      glVertex3f(-1.0f, -1.0f, -1.0f);
      glVertex3f(-1.0f, -1.0f,  1.0f);
      glEnd();
	  glBegin(GL_POLYGON);   
      
	  // Right face 
      glColor3f(1.0f, 0.0f, 1.0f);     // Magenta
      glVertex3f(1.0f,  1.0f, -1.0f);
      glVertex3f(1.0f,  1.0f,  1.0f);
      glVertex3f(1.0f, -1.0f,  1.0f);
      glVertex3f(1.0f, -1.0f, -1.0f);
      glEnd();
	  glFlush();//Forces Execution
}

void Init()
{ 
    glClearColor(1.0,1.0,1.0,0); 
    glColor3f(1.0,0.0,0.0); // red
    glViewport(0 , 0 , 640 , 480);// Set the vieport for viewing with lower left corner & Width & height
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
	int ch;
    printf("Menu:-\n1.Ortho\n2.Perspective\nEnter your choice:");
    scanf("%d",&ch);
    switch(ch)
    {
		case 1:
			glOrtho(-10,10,-10,10,-10,10);
			glRotatef(120.0,1.0,0.0,0.0);
			break;
		case 2:
			gluPerspective(80.0,1.0,1.0, 0.0);
			gluLookAt(1.0, 2.0, 3.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0);
			glRotatef(150.0,1.0,1.0,1.0);
			break;
	}
}

int main(int argc, char **argv)
{
	glutInit(&argc,argv);
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowSize(640,480);
	glutInitWindowPosition(0,0);
	glutCreateWindow("3-D");
	Init();
	
	glutDisplayFunc(threeD);
	glutMainLoop(); // Enters the Glut event processing loop
	return 0;
}