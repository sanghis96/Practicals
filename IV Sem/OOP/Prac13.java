import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class rgPage extends JFrame
{
    public rgPage()
    {
        super("Registration Page");
        setLayout(new BorderLayout());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,300);
        JPanel jp1 = new JPanel(new GridLayout(4,2,5,5));
        JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel name = new JLabel("Name:");
        JLabel uName = new JLabel("Username:");
        JLabel passwd = new JLabel("Password:");
        JLabel mobNo = new JLabel("Mobile No.:");
        final JTextField jtf1 = new JTextField();
        final JTextField jtf2 = new JTextField();
        final JPasswordField jpf = new JPasswordField();
        final JTextField jtf3 = (JTextField)jpf;
        final JTextField jtf4 = new JTextField();
        
        jp1.add(name);
        jp1.add(jtf1);
        jp1.add(uName);
        jp1.add(jtf2);
        jp1.add(passwd);
        jp1.add(jtf3);
        jp1.add(mobNo);
        jp1.add(jtf4);
        add(jp1,BorderLayout.CENTER);
        final JButton jb = new JButton("Sign UP");
        jp2.add(jb);
        add(jp2,BorderLayout.PAGE_END);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(e.getSource()==jb)
                    {
                    	DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:\\Users\\SAMARTH\\Desktop\\user.txt"));
                    	dos.writeUTF(jtf1.getText());
                    	dos.writeUTF(jtf2.getText());
                    	dos.writeUTF(jtf3.getText());
                    	dos.writeUTF(jtf4.getText());
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(rgPage.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(rgPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null,"Sign UP Successful");
            }
        });
    }
}

public class Practical13 
{
	public static void main(String[] args) 
	{
		new rgPage();
	}
}