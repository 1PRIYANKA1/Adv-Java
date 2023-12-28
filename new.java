import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class JDBCcollege extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3,t4;
    JButton b1;
    Connection con;
    PreparedStatement pst;
    String q;
    public JDBCcollege()
    {
        try{
        l1=new JLabel("enter college id");
        l2=new JLabel("enter college name");
        l3=new JLabel("enter collge address");
        l4=new JLabel("enter the year");
        b1=new JButton("click to save");
        t1=new JTextField(15);
        t2=new JTextField(15);
        t3=new JTextField(15);
        t4=new JTextField(15);
        Font f =new Font("Arial",Font.BOLD,20);
        Container c=getContentPane();
        c.add(l1);c.add(t1);
        c.add(l2);c.add(t2);
        c.add(l3);c.add(t3);
        c.add(l4);c.add(t4);
        c.add(b1);
        c.setFont(f);
        setSize(500,500);
        setLayout(new GridLayout(5,2));
        setVisible(true);
        b1.addActionListener(this);
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url= "jdbc:mysql://localhost:3306/priyanka1";
        String uname="root";
        String pwd="28priyanka2002";
        con=DriverManager. getConnection(url,uname,pwd);
        q="insert into college values(?,?,?,?)";
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            int id=Integer.parseInt(t1.getText());
            String nm=t2.getText();
            String add=t3.getText();
            int year=Integer.parseInt(t4.getText());
            pst=con.prepareStatement(q);
            pst.setInt(1, id);
            pst.setString(2, nm);
            pst.setString(3, add);
            pst.setInt(4, year);
            pst.executeUpdate();
        }
        catch(Exception e1)
        {
            System.out.println("error "+e1.getMessage());
        }
    }
    public static void main(String[] args) throws Exception {
        JDBCcollege obj= new JDBCcollege();
    }
}