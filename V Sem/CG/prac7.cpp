#include<iostream>
#include<math.h>
#include<GL/glut.h>
#include<math.h>

using namespace std;

class Point
{
	public:
		int x,y;
	public:
		Point()
		{	x = 0;	y = 0;	}
		Point(int a, int b)
		{	x = a;	y = b;	}
};

class dda
{
	int sign(float f)
	{
		if(f==0)
			return f;
		else if(f>0)
			return 1;
		else
			return -1;
	}
   public:
	dda(){}	

	void line(int X1, int Y1, int X2, int Y2)
	{
		float len, Dx, Dy, X, Y;
		if(abs(X2-X1) >= abs(Y2-Y1))
			len = abs(X2-X1);
		else
			len = abs(Y2-Y1);
		Dx = (X2-X1)/len;
		Dy = (Y2-Y1)/len;
		X = X1+(0.5*sign(Dx));
		Y = Y1+(0.5*sign(Dy));
		for(int i=0; i<len; i++)
		{
			glColor3f(0.0f,0.0f,0.0f);
			glBegin(GL_POINTS);
			glVertex2d(X,Y);
			glEnd();
			glFlush();
			X += Dx;
			Y += Dy;
		}
	}

	void polygon(int n, Point obj[])
	{
		glColor3f(0.0,0.0,1.0);//blue
		glBegin(GL_POINTS);
		for(int i=0; i<n; i++)
			line(obj[i].x,obj[i].y,obj[(i+1)%n].x,obj[(i+1)%n].y);
		glEnd();
		glFlush();
	}
};

class Transformation
{
	public:
	Transformation(){}

	void translate(int n, Point obj[], Point img[], int Tx, int Ty)
	{
		int T[3][3] = {{1,0,0},{0,1,0},{Tx,Ty,1}};
		int object[10][3];
		for(int i=0; i<n; i++)
		{
			object[i][0] = obj[i].x;
			object[i][1] = obj[i].y;
			object[i][2] = 1;
		}
		int result[10][3];
		for(int i=0; i<n; i++)
			for(int j=0; j<3; j++)
			{
				result[i][j] = 0;
				for(int k=0; k<3; k++)
					result[i][j] += object[i][k]*T[k][j];
				if(j==0)
					img[i].x = result[i][j];
				if(j==1)
					img[i].y = result[i][j];
			}
	}
	void scale(int n, Point obj[], Point img[], int Sx, int Sy)
	{
		float T[3][3] = {{Sx,0,0},{0,Sy,0},{0,0,1}};
		int object[10][3];
		for(int i=0; i<n; i++)
		{
			object[i][0] = obj[i].x;
			object[i][1] = obj[i].y;
			object[i][2] = 1;
		}
		float result[10][3];
		for(int i=0; i<n; i++)
			for(int j=0; j<3; j++)
			{
				result[i][j] = 0;
				for(int k=0; k<3; k++)
					result[i][j] += object[i][k]*T[k][j];
				if(j==0)
					img[i].x = result[i][j];
				if(j==1)
					img[i].y = result[i][j];
			}
	}
	void reflect(int n, Point obj[], Point img[], int ch)
	{
		int T[3][3] = {{0,0,0},{0,0,0},{0,0,1}};;
		switch(ch)
		{
		case 1:T[0][0] = 1;
				T[1][1] = -1;
				break;
		case 2:T[0][0] = -1;
				T[1][1] = 1;
				break;
		case 3:T[0][1] = 1;
				T[1][0] = 1;
				break;
		case 4:T[0][1] = -1;
				T[1][0] = -1;
				break;
		case 5:T[0][0] = -1;
				T[1][1] = -1;
				break;
		}
		int object[10][3];
		for(int i=0; i<n; i++)
		{
			object[i][0] = obj[i].x;
			object[i][1] = obj[i].y;
			object[i][2] = 1;
		}
		int result[10][3];
		for(int i=0; i<n; i++)
			for(int j=0; j<3; j++)
			{
				result[i][j] = 0;
				for(int k=0; k<3; k++)
					result[i][j] += object[i][k]*T[k][j];
				if(j==0)
					img[i].x = result[i][j];
				if(j==1)
					img[i].y = result[i][j];
			}
	}
	void rotate(int n, Point obj[], Point img[], float angle, int ch)
	{
		angle *= 0.0175;
		//float cos = cos(angle), sin = sin(angle);
		float T[3][3] = {{cos(angle),sin(angle),0},{sin(angle),cos(angle),0},{0,0,1}};
		if(ch == 1)
			T[0][1] *= -1;
		if(ch == 2)
			T[1][0] *= -1;
		int object[10][3];
		for(int i=0; i<n; i++)
		{
			object[i][0] = obj[i].x;
			object[i][1] = obj[i].y;
			object[i][2] = 1;
		}
		float result[10][3];
		for(int i=0; i<n; i++)
			for(int j=0; j<3; j++)
			{
				result[i][j] = 0;
				for(int k=0; k<3; k++)
					result[i][j] += object[i][k]*T[k][j];
				if(j==0)
					img[i].x = result[i][j];
				if(j==1)
					img[i].y = result[i][j];
			}
	}
	void shear(int n, Point obj[], Point img[], int sh, int ch)
	{
		int T[3][3] = {{1,0,0},{0,1,0},{0,0,1}};
		if(ch == 1)
			T[0][1] = sh;
		if(ch == 2)
			T[1][0] = sh;
		
		int object[10][3];
		for(int i=0; i<n; i++)
		{
			object[i][0] = obj[i].x;
			object[i][1] = obj[i].y;
			object[i][2] = 1;
		}
		int result[10][3];
		for(int i=0; i<n; i++)
			for(int j=0; j<3; j++)
			{
				result[i][j] = 0;
				for(int k=0; k<3; k++)
					result[i][j] += object[i][k]*T[k][j];
				if(j==0)
					img[i].x = result[i][j];
				if(j==1)
					img[i].y = result[i][j];
			}
	}
};

Point obj[10];
int n,I,i,minx,maxx,temp,p,x,y,cnt,flag;
int ch;

void draw(void)
{
	glClear(GL_COLOR_BUFFER_BIT);
	glColor3f(0.0,0.0,0.0);//black
	glBegin(GL_POINTS);
	Bresenhans X_axis, Y_axis;
	X_axis.line(0, 240, 640, 240);	
	Y_axis.line(320, 0, 320, 480);
	glEnd();
	glFlush();

	Point newObj[10];
	cout<<"Enter the number of vertices of polygon: ";
	cin>>n;
	for(i=0; i<n; i++)
	{
		cout<<"Enter the "<<i+1<<" point: ";
		cin>>obj[i].x;
		newObj[i].x = obj[i].x + 320;
		cin>>obj[i].y;
		newObj[i].y = obj[i].y + 240;
	}

	glColor3f(1.0,0.0,0.0);//red
	glBegin(GL_POINTS);
	dda poly;
	poly.polygon(n, newObj);	
	glEnd();
	glFlush();

	Transformation t;
	Point img[10];

	cout<<"\nMenu:-"<<endl;
	cout<<"1.Translation"<<endl;
	cout<<"2.Scaling"<<endl;
	cout<<"3.Reflection about X-axis"<<endl;
	cout<<"4.Rotation"<<endl;
	cout<<"5.Shearing"<<endl;
	cout<<"Enter your choice: ";
	cin>> ch;
	switch(ch)
	{
	case 1: int Tx, Ty;
			cout<<"\nEnter translating factors(Tx, Ty):";
			cin>>Tx>>Ty;
			t.translate(n, obj, img, Tx, Ty);
			break;

	case 2: int Sx, Sy;
			cout<<"\nEnter scaling factors(Sx, Sy):";
			cin>>Sx>>Sy;
			t.scale(n, obj, img, Sx, Sy);
			break;

	case 3: int axis;
			cout<<"\nEnter the choice of Axis:-"<<endl;
			cout<<"1.about X-axis"<<endl;
			cout<<"2.about Y-axis"<<endl;
			cout<<"3.about Y = X"<<endl;
			cout<<"4.about Y = -X"<<endl;
			cout<<"5.about Origin"<<endl;
			cout<<"Enter your choice: ";
			cin>> axis;
			t.reflect(n, obj, img, axis);
			break;

	case 4: float angle;
			int rt;
			cout<<"\nEnter the choice for Rotation:-"<<endl;
			cout<<"1.Clockwise"<<endl;
			cout<<"2.Anti-clockwise"<<endl;
			cout<<"Enter your choice: ";
			cin>> rt;
			cout<<"\nEnter the angle:";
			cin>>angle;
			t.rotate(n, obj, img, angle, rt);
			break;

	case 5: int sh;
			cout<<"\nEnter the choice for Shearing:-"<<endl;
			cout<<"1.X-shearing"<<endl;
			cout<<"2.Y-shearing"<<endl;
			cout<<"Enter your choice: ";
			cin>> sh;
			int she;
			cout<<"Enter shearing factor:";
			cin>>she;
			t.shear(n, obj, img, she, sh);
			break;
	default:cout<<"\n\n\tWrong Choice!!!";
	}

	//glClear(GL_COLOR_BUFFER_BIT);
	glColor3f(0.0,1.0,0.0);//blue
	glBegin(GL_POINTS);
	for(i=0; i<n; i++)
	{
		img[i].x += 320;
		img[i].y += 240;
	}
	poly.polygon(n, img);	
	glEnd();
	glFlush();
	
}
void Init()
{
	glClearColor(1.0,1.0,1.0,0); 
	glColor3f(1.0,0.0,0.0);
	glViewport(0,0,640,480);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluOrtho2D(0,640,0,480);
}

int main(int argc, char **argv)
{
	glutInit(&argc,argv); 
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB); 
	glutInitWindowSize(640,480); 
	glutInitWindowPosition(0,0); 
	glutCreateWindow("Transpose");
	Init();
	glutDisplayFunc(draw);
	glutMainLoop();
	return 0;
}