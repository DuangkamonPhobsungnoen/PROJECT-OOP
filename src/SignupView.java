
import java.awt.*;
import javax.swing.*;

public class SignupView {

    private JFrame jf;
    private JLabel jlsign, jlname, jlimg, jluser, jlpass, jlcpass, jlnameh ;
    private JTextField jtuser, jtname;
    private JPasswordField jpass, jcpass;
    private JButton jbregis, jbb;
    private ImageIcon img;
    private JPanel jp, jpgroup, jpleft, jpleftn,  jplefts, jplefti, jprightgbt, jpright ;
    private JPanel gap1, gap2, gap3;
    private JPanel jp1, jp2, jp3, jp4;

    public SignupView() {
        jf = new JFrame("Signup page");
        img = new ImageIcon("icon_username.png");
        jlnameh = new JLabel("Restaurant Name");
        jlname = new JLabel("HOM KLIN NGERN");
        jlimg = new JLabel(img);
        jluser = new JLabel("Username");
        jlpass = new JLabel("Password");
        jlcpass = new JLabel("Confirm Password");
        jlsign = new JLabel("Sign up...");
        jtuser = new JTextField();
        jtname = new JTextField();
        jpass = new JPasswordField();
        jcpass = new JPasswordField();
        jbregis = new JButton("Register");
        jbb = new JButton("Back");
        jp = new JPanel();
        jpleft = new JPanel();       
        jpgroup = new JPanel();
        jpleftn = new JPanel();
        jplefti = new JPanel();
        jplefts = new JPanel();
        
        jprightgbt = new JPanel();
        jpright = new JPanel();
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        gap1 = new JPanel();
        gap2 = new JPanel();
        gap3 = new JPanel();
        
        //left sign up
        jpleft.setLayout(new GridLayout(2,1));       
        jpleftn.add(jlname);     
        jplefti.add(jlimg);
        jpleft.setLayout(new BorderLayout());
        jpleft.add(jpleftn, BorderLayout.NORTH);
        jpleft.add(jplefti, BorderLayout.CENTER);
        
        
        
        //textfield
        jp1.setLayout(new BorderLayout());
        jp2.setLayout(new BorderLayout());
        jp3.setLayout(new BorderLayout());
        jp4.setLayout(new BorderLayout());
        jp1.add(jtname);
        jp2.add(jtuser);
        jp3.add(jpass);
        jp4.add(jcpass);
        jtname.setPreferredSize(new Dimension(200,30));
        jtuser.setPreferredSize(new Dimension(200,30));
        jpass.setPreferredSize(new Dimension(200,30));
        jcpass.setPreferredSize(new Dimension(200,30));
         //button
        jprightgbt.add(jbb);
        jprightgbt.add(jbregis);
        //right 
        jpright.setLayout(new GridLayout(9,1));
        jpright.add(jlnameh);
        jpright.add(jp1);
        jpright.add(jluser);
        jpright.add(jp2);
        jpright.add(jlpass);
        jpright.add(jp3);
        jpright.add(jlcpass);
        jpright.add(jp4);
        
        jp.setLayout(new GridLayout(1, 2, 50, 0));
        jp.add(jpleft);
        jp.add(jpright);
        jpright.add( jprightgbt);                
      
        jpgroup.add(jp);
        jf.add(jpgroup);
        jf.setSize(720, 400);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        //ฟ้อนต์
        jlsign.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jlname.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        jlnameh.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jluser.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jlpass.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jlcpass.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jbb.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jbregis.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        
        jtname.setFont(new Font("browallia new", Font.BOLD, 15));
        jtuser.setFont(new Font("browallia new", Font.BOLD, 15));
        jpass.setFont(new Font("browallia new", Font.BOLD, 15));
        jcpass.setFont(new Font("browallia new", Font.BOLD, 15));
        //ปรับสีพื้นหลัง
         jf.getContentPane().setBackground(new Color(255, 204, 0));
        jpleftn.setBackground(new Color(255, 204, 0));
        jpleft.setBackground(new Color(255, 204, 0));
        jplefti.setBackground(new Color(255, 204, 0));
        jplefts.setBackground(new Color(255, 204, 0));
        jprightgbt.setBackground(new Color(255, 204, 0));
        jpright.setBackground(new Color(255, 204, 0));
        jpgroup.setBackground(new Color(255, 204, 0));
        jp.setBackground(new Color(255, 204, 0));
       
        jp1.setBackground(new Color(255, 204, 0));
        jp2.setBackground(new Color(255, 204, 0));
        jp3.setBackground(new Color(255, 204, 0));
        jp4.setBackground(new Color(255, 204, 0));
        jlnameh.setBackground(new Color(255, 204, 0));
        jluser.setBackground(new Color(255, 204, 0));
        jlpass.setBackground(new Color(255, 204, 0));
        jlcpass.setBackground(new Color(255, 204, 0));
        
        //ปรับสีปุ่ม
        jbb.setBackground(new Color(28, 64, 121));
        jbregis.setBackground(new Color(28, 64, 121));
        //ปรับสีฟ้อนต์
        jlsign.setForeground(new Color(28, 64, 121));
        jlcpass.setForeground(new Color(28, 64, 121));
        jlname.setForeground(new Color(28, 64, 121));
        jlnameh.setForeground(new Color(28, 64, 121));
        jlpass.setForeground(new Color(28, 64, 121));
        jluser.setForeground(new Color(28, 64, 121));
        jbb.setForeground(Color.white);
        jbregis.setForeground(Color.white);
        //ปรับสี JTextField
        jtname.setBackground(new Color(255, 251, 235));
        jtuser.setBackground(new Color(255, 251, 235));
        jpass.setBackground(new Color(255, 251, 235));
        jcpass.setBackground(new Color(255, 251, 235));
     
    }

    public JFrame getJf() {
        return jf;
    }

    public JLabel getJlsign() {
        return jlsign;
    }

    public JLabel getJlname() {
        return jlname;
    }

    public JLabel getJlimg() {
        return jlimg;
    }

    public JLabel getJluser() {
        return jluser;
    }

    public JLabel getJlpass() {
        return jlpass;
    }

    public JLabel getJlcpass() {
        return jlcpass;
    }

    public JLabel getJlnameh() {
        return jlnameh;
    }

    public JTextField getJtuser() {
        return jtuser;
    }

    public JTextField getJtname() {
        return jtname;
    }

    public JPasswordField getJpass() {
        return jpass;
    }

    public JPasswordField getJcpass() {
        return jcpass;
    }

    public JButton getJbregis() {
        return jbregis;
    }

    public JButton getJbb() {
        return jbb;
    }

    public ImageIcon getImg() {
        return img;
    }

    public JPanel getJpleft() {
        return jpleft;
    }

    public JPanel getJplefti() {
        return jplefti;
    }

   
    
    public static void main(String[] args) {
        new SignupView();
    }

}
