//package Slip24B;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class slip24B extends JFrame implements ActionListener
{
        JButton b1;
        JLabel l1, l2, l3, l4;
        JTextField t1, t2, t3, t4;
        String q,url,user,pass;
        PreparedStatement pst;
        Connection con;
        Container c;
        Font f;
        public slip24B() {
            try {
                b1 = new JButton("Store data");
                l1 = new JLabel("Enter the college id : ");
                l2 = new JLabel("Enter the college name : ");
                l3 = new JLabel("Enter the college address : ");
                l4 = new JLabel("Enter the year : ");
                t1 = new JTextField(15);
                t2 = new JTextField(15);
                t3 = new JTextField(15);
                t4 = new JTextField(15);
                c = getContentPane();
                f = new Font("Arial", Font.BOLD, 20);
                c.setFont(f);
                setFont(f);
                c.add(l1);
                c.add(t1);
                c.add(l2);
                c.add(t2);
                c.add(l3);
                c.add(t3);
                c.add(l4);
                c.add(t4);
                c.add(b1);
                b1.addActionListener(this);
                setSize(500, 500);
                setVisible(true);
                setLayout(new GridLayout(5, 2));
                Class.forName("com.mysql.cj.jdbc.Driver");
                url = "jdbc:mysql://localhost:3306/mydatabase";
                user = "root";
                pass = "matsumoto";
                con = DriverManager.getConnection(url, user, pass);
                q = "insert into college values (?,?,?,?)";
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        public void actionPerformed (ActionEvent a)
        {
            try
            {
                int id = Integer.parseInt(t1.getText());
                String nm = t2.getText();
                String add = t3.getText();
                int yr = Integer.parseInt(t4.getText());
                pst = con.prepareStatement(q);
                pst.setInt(1,id);
                pst.setString(2,nm);
                pst.setString(3,add);
                pst.setInt(4,yr);
                pst.executeUpdate();
                if(a.getSource()==b1)
                {
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                }
            }
            catch (Exception e1)
            {
                System.out.println(e1.getMessage());
            }
        }
    public static void main(String[] args) throws Exception
    {
        slip24B ob = new slip24B();
    }
}
