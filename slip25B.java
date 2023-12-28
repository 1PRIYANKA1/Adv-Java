//package Slip25B;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class slip25B extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JTextField t1,t2,t3;
    JButton b1,b2,b3,b4;
    ResultSet rs;
    Connection con;
    Statement st;
    JPanel p1,p2;
    Container c;
    String q,url,uname,pwd;
    public slip25B()
    {
        try
        {
            l1 = new JLabel("College id : ");
            l2 = new JLabel("College name : ");
            l3 = new JLabel("College address : ");
            t1 = new JTextField(20);
            t2 = new JTextField(20);
            t3 = new JTextField(20);
            b1 = new JButton("moveFirst");
            b2 = new JButton("moveNext");
            b3 = new JButton("movePrevious");
            b4 = new JButton("moveLast");
            p1 = new JPanel();
            p2 = new JPanel();
            c = getContentPane();
            Font f = new Font("Arial",Font.BOLD,20);
            p1.add(l1);p1.add(t1);
            p1.add(l2);p1.add(t2);
            p1.add(l3);p1.add(t3);
            p2.add(b1);p2.add(b2);p2.add(b3);p2.add(b4);
            p1.setFont(f);
            p2.setFont(f);
            setFont(f);
            p1.setLayout(new GridLayout(3,2));
            p2.setLayout(new GridLayout(1,4));
            c.add(p1);
            c.add(p2);
            setLayout(new GridLayout(2,1));
            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            b4.addActionListener(this);
            setSize(400,400);
            setVisible(true);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Class.forName("com.mysql.cj.jdbc.Driver");
            url = "jdbc:mysql://localhost:3306/mydatabase";
            uname ="root";
            pwd = "matsumoto";
            con = DriverManager.getConnection(url,uname,pwd);
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            q = "select * from college";
            rs = st.executeQuery(q);
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
                rs.first();
                t1.setText(Integer.toString(rs.getInt(1)));
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(2));
            }
            if(e.getSource()==b2)
            {
                rs.next();
                t1.setText(Integer.toString(rs.getInt(1)));
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(2));
            }
            if(e.getSource()==b3)
            {
                rs.previous();
                t1.setText(Integer.toString(rs.getInt(1)));
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(2));
            }
            if(e.getSource()==b4)
            {
                rs.last();
                t1.setText(Integer.toString(rs.getInt(1)));
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(2));
            }
        }
        catch (Exception e1)
        {
            System.out.println(e1.getMessage());
        }
    }
    public static void main(String[] args)
    {
        slip25B ob = new slip25B();
    }
}
