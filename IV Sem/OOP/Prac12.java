import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class calculator extends JFrame implements ActionListener
{
	private JTextField jtfArea = new JTextField();
	private JButton jb1 = new JButton("1");
	private JButton jb2 = new JButton("2");
	private JButton jb3 = new JButton("3");
	private JButton jb4 = new JButton("4");
	private JButton jb5 = new JButton("5");
	private JButton jb6 = new JButton("6");
	private JButton jb7 = new JButton("7");
	private JButton jb8 = new JButton("8");
	private JButton jb9 = new JButton("9");
	private JButton jb0 = new JButton("0");
	private JButton jbAdd = new JButton("+");
	private JButton jbSub = new JButton("-");
	private JButton jbMul = new JButton("x");
	private char divSymbol = 247;
	private JButton jbDiv = new JButton("" + divSymbol);
	private JButton jbEq = new JButton("=");
	private JButton jbDot = new JButton(".");
	
	double num1,num2,result;
	int op;
	String msg = new String();
	
	public calculator()
	{
		JPanel jpKeys = new JPanel(new GridLayout(4,4,5,5));
		jpKeys.add(jb1);
		jpKeys.add(jb2);
		jpKeys.add(jb3);
		jpKeys.add(jbDiv);
		jpKeys.add(jb4);
		jpKeys.add(jb5);
		jpKeys.add(jb6);
		jpKeys.add(jbMul);
		jpKeys.add(jb7);
		jpKeys.add(jb8);
		jpKeys.add(jb9);
		jpKeys.add(jbSub);
		jpKeys.add(jb0);
		jpKeys.add(jbDot);
		jpKeys.add(jbEq);
		jpKeys.add(jbAdd);
		
		add(jtfArea,BorderLayout.NORTH);
		add(jpKeys);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		jb7.addActionListener(this);
		jb8.addActionListener(this);
		jb9.addActionListener(this);
		jb0.addActionListener(this);
		jbAdd.addActionListener(this);
		jbSub.addActionListener(this);
		jbMul.addActionListener(this);
		jbDiv.addActionListener(this);
		jbDot.addActionListener(this);
		jbEq.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		try{
		if(e.getSource() == jb1)
			msg += "1";
		else if(e.getSource() == jb2)
			msg += "2";
		else if(e.getSource() == jb3)
			msg += "3";
		else if(e.getSource() == jb4)
			msg += "4";
		else if(e.getSource() == jb5)
			msg += "5";
		else if(e.getSource() == jb6)
			msg += "6";
		else if(e.getSource() == jb7)
			msg += "7";
		else if(e.getSource() == jb8)
			msg += "8";
		else if(e.getSource() == jb9)
			msg += "9";
		else if(e.getSource() == jb0)
			msg += "0";
		else if(e.getSource() == jbDot)
			msg += ".";
		jtfArea.setText("" + msg);
		if(e.getSource() == jbAdd)
		{	
			num1 = Double.parseDouble(jtfArea.getText());
			op = 1;
			jtfArea.setText(" + ");
			msg = "";
		}
		else if(e.getSource() == jbSub)
		{	
			num1 = Double.parseDouble(jtfArea.getText());
			op = 2;
			jtfArea.setText(" - ");
			msg = "";
		}
		else if(e.getSource() == jbMul)
		{	
			num1 = Double.parseDouble(jtfArea.getText());
			op = 3;
			jtfArea.setText(" x ");
			msg = "";
		}
		else if(e.getSource() == jbDiv)
		{	
			num1 = Double.parseDouble(jtfArea.getText());
			op = 4;
			jtfArea.setText(" / ");
			msg = "";
		}
		if(e.getSource() == jbEq)
		{	
			num2 = Double.parseDouble(jtfArea.getText());
			switch(op)
			{
				case 1: result = num1 + num2;
						break;
				case 2: result = num1 - num2;
						break;
				case 3: result = num1 * num2;
						break;
				case 4: if(num2 == 0.0)
							JOptionPane.showMessageDialog(null, "Error ! ! !");
						result = num1 / num2;
						break;
			}
			jtfArea.setText("" + result);
			msg = "";
		}
		}catch(Exception ex)
		{	JOptionPane.showMessageDialog(null,"ERORR.... ");	}
	}
}

public class Practical12
{ 
	public static void main(String[] args)
	{
		 calculator calci = new calculator();
		 calci.setTitle("CALCULATOR");
		 calci.setLocationRelativeTo(null);
		 calci.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 calci.pack();
		 calci.setVisible(true);
    }
}