
import java.awt.*;
import javax.swing.*;

public class LoginView {

    private JFrame jf;
    private JLabel jlimg, jluser, jlpass, jlname;
    private JTextField jtuser;
    private JPasswordField jpass;
    private JButton jbsign, jblogin;
    private ImageIcon img;
    private JPanel jp, jpgroupt, jpgroups, jpleft, jplefti, jpright, jprightgu, jprightgp, jprightlower, jprightgbt, jprighttop, jpleftn, jpnorth, jpsouth, jpcenter;
    private JCheckBox jcheckb;

    public LoginView() {
        jf = new JFrame("Login page");
        img = new ImageIcon("icon_food1.png");
        jlimg = new JLabel(img);
        jluser = new JLabel("Username");
        jlpass = new JLabel("Password");
        jlname = new JLabel("HOM KLIN NGERN");
        jtuser = new JTextField(15);
        jpass = new JPasswordField(15);
        jbsign = new JButton("Sign up");
        jblogin = new JButton("Login");
        jp = new JPanel();
        jpleft = new JPanel();
        jplefti = new JPanel();
        jpright = new JPanel();
        jprightgu = new JPanel();
        jpgroupt = new JPanel();
        jpgroups = new JPanel();
        jprightgp = new JPanel();
        jprightlower = new JPanel();
        jprightgbt = new JPanel();
        jprighttop = new JPanel();
        jpleftn = new JPanel();
        jpnorth = new JPanel();
        jpsouth = new JPanel();
        jpcenter = new JPanel();
        jcheckb = new JCheckBox("Remember me?");
        jf.setLayout(new  GridLayout(1, 1));
        //name
        jprighttop.add(jlname);
        //left sign up
        jpleft.setLayout(new BorderLayout());
        jpleftn.add(jlname);
        jplefti.add(jlimg);
        jpleft.add(jpleftn, BorderLayout.NORTH);
        jpleft.add(jplefti, BorderLayout.SOUTH);
        jpgroupt.add(jpleft);
        jpright.setLayout(new GridLayout(5, 1));
        // enter username
        jprightgu.setLayout(new BorderLayout());
        jprightgu.add(jluser, BorderLayout.NORTH);
        jprightgu.add(jtuser, BorderLayout.CENTER);
        // enter password
        jprightgp.setLayout(new BorderLayout());
        jprightgp.add(jlpass, BorderLayout.NORTH);
        jprightgp.add(jpass, BorderLayout.CENTER);
        // button
        jprightgbt.setLayout(new FlowLayout());
        jprightgbt.add(jblogin);
        jprightgbt.add(jbsign);
        // check member
        jprightlower.add(jcheckb);
        //ทำให้อยู่อันเดียวกัน
        jpright.add(jprightgu);
        jpright.add(jprightgp);
        jpright.add(jprightgbt);
        jpright.add(jprightlower);
        jpgroups.add(jpright);
        //
        jpcenter.add(jpgroupt);
        jpcenter.add(jpgroups);
        //แบ่งกึ่งกลาง
        jf.add(jpnorth);
        jf.add(jpcenter);
        jf.add(jpsouth);
        jf.setSize(720, 400);
//        jf.pack();
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
         //ฟ้อนต์
        jlname.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        jluser.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
        jlpass.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
        jbsign.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
        jblogin.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
        jcheckb.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
        jtuser.setFont(new Font("browallia new", Font.BOLD, 18));
        jpass.setFont(new Font("browallia new", Font.BOLD, 18));
        //ปรับสีพื้นหลัง
        jf.getContentPane().setBackground(Color.red);
        jp.setBackground(new Color(255, 204, 0));
        jplefti.setBackground(new Color(255, 204, 0));
        jpleftn.setBackground(new Color(255, 204, 0));
        jprightgbt.setBackground(new Color(255, 204, 0));
        jprightlower.setBackground(new Color(255, 204, 0));
        jprightgp.setBackground(new Color(255, 204, 0));
        jprightgu.setBackground(new Color(255, 204, 0));
        jprighttop.setBackground(new Color(255, 204, 0));
        jcheckb.setBackground(new Color(255, 204, 0));
        jpnorth.setBackground(new Color(255, 204, 0));
        jpcenter.setBackground(new Color(255, 204, 0));
        jpsouth.setBackground(new Color(255, 204, 0));
        jpgroups.setBackground(new Color(255, 204, 0));
        jpgroupt.setBackground(new Color(255, 204, 0));
        jpright.setBackground(new Color(255, 204, 0));
        //ปรับสีฟ้อนต์
        jlpass.setForeground(new Color(28, 64, 121));
        jluser.setForeground(new Color(28, 64, 121));
        jlname.setForeground(new Color(28, 64, 121));
        jbsign.setForeground(Color.white);
        jblogin.setForeground(Color.white);
        //ปรับสีปุ่ม
        jbsign.setBackground(new Color(28, 64, 121));
        jblogin.setBackground(new Color(28, 64, 121));
        jbsign.setOpaque(true);
        jblogin.setOpaque(true);
        //ปรับสี JTextField
        jtuser.setBackground(new Color(255, 251, 235));
        jpass.setBackground(new Color(255, 251, 235));
    }

    public JFrame getJf() {
        return jf;
    }

    public JTextField getJtuser() {
        return jtuser;
    }

    public JPasswordField getJpass() {
        return jpass;
    }

    public JButton getJbsign() {
        return jbsign;
    }

    public JButton getJblogin() {
        return jblogin;
    }

    public JCheckBox getJcheckb() {
        return jcheckb;
    }
    
    
    
}
