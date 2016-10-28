#include <GL/glut.h>
#include <GL/gl.h>
#include <GL/glu.h>

int window;

float rtri = 0.0f;
float rquad = 0.0f;

float ballX = -0.5f;
float ballY = 0.0f;
float ballZ = 0.0f;

void drawBall(void) 
{
        glColor3f(1.0, 1.0, 0.0);
        glTranslatef(ballX,ballY,ballZ);
        glutSolidSphere (0.3, 200, 200);
        glTranslatef(ballX+1.5,ballY,ballZ);
        glutSolidSphere (0.3, 200, 200);
}

void DrawGLScene()
{
  glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
  glLoadIdentity();

  glTranslatef(rtri,0.0f,-6.0f);
  
  glBegin(GL_POLYGON);
  glColor3f(1.0f,0.0f,0.0f);
  glVertex3f(-1.0f, 1.0f, 0.0f);
  glVertex3f(0.4f, 1.0f, 0.0f);
  glVertex3f(1.0f, 0.4f, 0.0f);
  glVertex3f( 1.0f,0.0f, 0.0f);
  glVertex3f(-1.0f,0.0f, 0.0f); 

  glEnd();
  drawBall();
 
  rtri += 0.005f;                    // Increase The Rotation Variable For The Triangle
  if(rtri>2)
      rtri = -2.0f;
  rquad -= 15.0f;                    // Decrease The Rotation Variable For The Quad

  // swap the buffers to display, since double buffering is used.
  glutSwapBuffers();
}


void keyPressed(unsigned char key, int x, int y) 
{
    if (key == 'q') 
    { 
		glutDestroyWindow(window);
		exit(0);                  
    }
}

void InitGL(int Width, int Height)         
{
  glClearColor(0.0f, 0.0f, 0.0f, 0.0f);     
  glClearDepth(1.0);
  glDepthFunc(GL_LESS);
  glEnable(GL_DEPTH_TEST);
  glShadeModel(GL_SMOOTH);

  glMatrixMode(GL_PROJECTION);
  glLoadIdentity(); 

  gluPerspective(45.0f,(GLfloat)Width/(GLfloat)Height,0.1f,100.0f);  

  glMatrixMode(GL_MODELVIEW);
}

int main(int argc, char **argv) 
{  
  glutInit(&argc, argv);
  glutInitDisplayMode(GLUT_RGBA | GLUT_DOUBLE | GLUT_ALPHA | GLUT_DEPTH);
  glutInitWindowSize(640, 480);
  glutInitWindowPosition(0, 0);
  window = glutCreateWindow("Moving Car");
  glutDisplayFunc(&DrawGLScene);
  glutIdleFunc(&DrawGLScene);
  glutKeyboardFunc(&keyPressed);
  InitGL(640, 480);
  glutMainLoop();
  return 1;
}