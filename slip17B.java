
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class slip17B extends JFrame implements ActionListener
{
    JLabel l1;
    JTextField t1;
    JPanel p1,p2;
    JButton b1,b2,b3;
    Connection con;
    Statement st;
    String q;
    public slip17B() throws Exception
    {
        try
        {
            l1 = new JLabel("Enter the query : ");
            t1 = new JTextField(20);
            p1 = new JPanel();
            p2 = new JPanel();
            b1 = new JButton("Create table");
            b2 = new JButton("Alter table");
            b3 = new JButton("Drop table");
            Container c = getContentPane();
            p1.add(l1); p1.add(t1);
            p2.add(b1);p2.add(b2);p2.add(b3);
            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            Font f = new Font("Arial",Font.BOLD,20);
            setFont(f);
            p1.setFont(f);
            p2.setFont(f);
            c.add(p1);
            c.add(p2);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setSize(500,500);
            setLayout(new GridLayout(2,1));
            setVisible(true);
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","matsumoto");
            st = con.createStatement();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            if(e.getSource()==b1)
            {
                q = t1.getText();
                st.executeUpdate(q);
                t1.setText("Table created successfully");
            }
            if(e.getSource()==b2)
            {
                q = t1.getText();
                st.executeUpdate(q);
                t1.setText("Table altered successfully");
            }
            if(e.getSource()==b3)
            {
                q = t1.getText();
                st.executeUpdate(q);
                t1.setText("Table dropped successfully");
            }
        }
        catch(Exception e1)
        {
            System.out.println(e1.getMessage());
        }
    }
    public static void main(String[] args) throws Exception
    {
        slip17B ob = new slip17B();
    }
}
