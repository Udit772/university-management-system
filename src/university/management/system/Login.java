package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login ,cancel;
    JTextField tfusername,tfpassword;
    Login(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel username = new JLabel("Username");
        username.setBounds(40, 20, 100,20);
        add(username);

        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150,20);
        add(tfusername);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100,20);
        add(password);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150,20);
        add( tfpassword);

        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setForeground(Color.white);
        login.setFont(new Font("Thoma", Font.BOLD, 15));
        login.addActionListener(this);
        login.setBackground(Color.BLACK);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Thoma", Font.BOLD, 15));
        cancel.setBackground(Color.BLACK);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0, 200,200);
        add(image);


        setSize(600, 300);
        setLocation(500,250);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            String user =   tfusername.getText();
            String pass = tfpassword.getText();

            String query = "select * from login where username='"+user+"' and password='"+pass+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()){
                    setVisible(false);
                    new Project();
                } else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    setVisible(true);
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }else if(e.getSource() == cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }

}
