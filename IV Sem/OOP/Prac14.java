import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class rgPage extends JFrame implements ActionListener 
{
	final JTextField jtf1 = new JTextField();
    	final JTextField jtf2 = new JTextField();
    	final JPasswordField jpf = new JPasswordField();
    	final JTextField jtf3 = (JTextField)jpf;
    	final JTextField jtf4 = new JTextField();
    	final JButton jb = new JButton("Sign UP");
    
    	private Connection connect;
	private Statement stmt;
	
	public rgPage()
    	{
        	JPanel jp1 = new JPanel(new GridLayout(4,2,5,5));
        	jp1.add(new JLabel("Name:"));
        	jp1.add(jtf1);
        	jp1.add(new JLabel("Username:"));
        	jp1.add(jtf2);
        	jp1.add(new JLabel("Password:"));
        	jp1.add(jtf3);
        	jp1.add(new JLabel("Mobile No.:"));
        	jp1.add(jtf4);
        
        	JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        	jp2.add(jb);
        
        	add(jp1,BorderLayout.CENTER);
        	add(jp2,BorderLayout.PAGE_END);
        
        	initializeDB();
        
        	jb.addActionListener(this);
            
    	}
	void initializeDB()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:6957/samdata","root","tiger");		
			stmt = connect.createStatement();
		}catch(Exception ex){	ex.printStackTrace();	}
	}
	public void actionPerformed(ActionEvent e) 
	{
        try{
        	stmt.executeQuery("insert into practical14 values (\"" + jtf1.getText() + "\",\"" + jtf2.getText() + "\",\"" + jtf3.getText() + "\",\"" + jtf4.getText() + "\")");
		connect.close();
		JOptionPane.showMessageDialog(null,"Sign UP Successful");
	}catch(Exception ex){	System.out.println("Error in printing");ex.printStackTrace();	}
    }
}
public class Practical14
{
	public static void main(String[] args) throws SQLException, ClassNotFoundException 
	{
		rgPage frm = new rgPage();
		frm.setTitle("Registration Page");
        	frm.setSize(400,300);
        	frm.setLocationRelativeTo(null);
        	frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	frm.setVisible(true);
	}
}