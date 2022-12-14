
import java.awt.*;
import javax.swing.*;

public class LoginView {

    private JFrame jf;
    private JLabel jlsign, jlimg, jluser, jlpass, jlname;
    private JTextField jtuser;
    private JPasswordField jpass;
    private JButton jbsign, jblogin;
    private ImageIcon img;
    private JPanel jp, jpgroup, jpleft, jplefts, jplefti, jpright, jprightgu, jprightgp, jprightlower, jprightgbt, jprighttop, jpleftn;
    private JCheckBox jcheckb;

    public LoginView() {
        jf = new JFrame();
        img = new ImageIcon("icon_noodle.png");
        jlimg = new JLabel(img);
        jlsign= new JLabel("Login...");
        jluser = new JLabel("Username");
        jlpass = new JLabel("Password");
        jlname = new JLabel("HOM KLIN NGERN");
        jtuser = new JTextField(20);
        jpass = new JPasswordField(20);
        jbsign = new JButton("Sign up");
        jblogin = new JButton("Login");
        jp = new JPanel();
        jpleft = new JPanel();
        jplefts = new JPanel();
        jplefti = new JPanel();
        jpright = new JPanel();
        jprightgu = new JPanel();
        jpgroup = new JPanel();
        jprightgp = new JPanel();
        jprightlower = new JPanel();
        jprightgbt = new JPanel();
        jprighttop = new JPanel();
        jpleftn = new JPanel();
         jcheckb = new JCheckBox("Remember me?");
        //name
        jprighttop.add(jlname);
        jp.setLayout(new GridLayout(1, 2));
        //left sign up
        jpleft.setLayout(new BorderLayout());
        jpleftn.add(jlname);
        jplefts.add(jlsign);
        jplefti.add(jlimg);
        jpleft.add(jpleftn, BorderLayout.NORTH);
        jpleft.add(jplefti, BorderLayout.CENTER);
        jpleft.add(jplefts, BorderLayout.SOUTH);
        jp.add(jpleft);
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
        //ฟ้อนต์
        jlsign.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jlname.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jluser.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
        jlpass.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
        jbsign.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
        jblogin.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
         jcheckb.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
        //ปรับสีพื้นหลัง
        jplefti.setBackground(new Color(255, 204, 0));
        jpleftn.setBackground(new Color(255, 204, 0));
        jplefts.setBackground(new Color(255, 204, 0));
        jprightgbt.setBackground(new Color(255, 204, 0));
        jprightlower.setBackground(new Color(255, 204, 0));
        jprightgp.setBackground(new Color(255, 204, 0));
        jprightgu.setBackground(new Color(255, 204, 0));
        jprighttop.setBackground(new Color(255, 204, 0));
        jcheckb.setBackground(new Color(255, 204, 0));
        
        //ปรับสีฟ้อนต์
        jlsign.setForeground(Color.black);
        jlpass.setForeground(new Color(28, 64, 121));
        jluser.setForeground(new Color(28, 64, 121));
        jlname.setForeground(new Color(28, 64, 121));
        jlsign.setForeground(new Color(28, 64, 121));
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
        jprightlower.add(jcheckb);
        jpright.add(jprighttop);
        jpright.add(jprightgu);
        jpright.add(jprightgp);
        jpright.add(jprightgbt);
        jpright.add(jprightlower);
        jp.add(jpright);
        jpgroup.add(jp, BorderLayout.CENTER);
        jf.add(jp);
//        jf.setSize(720, 470);
        jf.pack();
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

    public JFrame getJf() {
        return jf;
    }

    public void setJf(JFrame jf) {
        this.jf = jf;
    }

    public JLabel getJlsign() {
        return jlsign;
    }

    public void setJlsign(JLabel jlsign) {
        this.jlsign = jlsign;
    }

    public JLabel getJlimg() {
        return jlimg;
    }

    public void setJlimg(JLabel jlimg) {
        this.jlimg = jlimg;
    }

    public JLabel getJluser() {
        return jluser;
    }

    public void setJluser(JLabel jluser) {
        this.jluser = jluser;
    }

    public JLabel getJlpass() {
        return jlpass;
    }

    public void setJlpass(JLabel jlpass) {
        this.jlpass = jlpass;
    }

    public JLabel getJlname() {
        return jlname;
    }

    public void setJlname(JLabel jlname) {
        this.jlname = jlname;
    }

    public JTextField getJtuser() {
        return jtuser;
    }

    public void setJtuser(JTextField jtuser) {
        this.jtuser = jtuser;
    }

    public JPasswordField getJpass() {
        return jpass;
    }

    public void setJpass(JPasswordField jpass) {
        this.jpass = jpass;
    }

    public JButton getJbsign() {
        return jbsign;
    }

    public void setJbsign(JButton jbsign) {
        this.jbsign = jbsign;
    }

    public JButton getJblogin() {
        return jblogin;
    }

    public void setJblogin(JButton jblogin) {
        this.jblogin = jblogin;
    }

    public ImageIcon getImg() {
        return img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    public JPanel getJp() {
        return jp;
    }

    public void setJp(JPanel jp) {
        this.jp = jp;
    }

    public JPanel getJpgroup() {
        return jpgroup;
    }

    public void setJpgroup(JPanel jpgroup) {
        this.jpgroup = jpgroup;
    }

    public JPanel getJpleft() {
        return jpleft;
    }

    public void setJpleft(JPanel jpleft) {
        this.jpleft = jpleft;
    }

    public JPanel getJplefts() {
        return jplefts;
    }

    public void setJplefts(JPanel jplefts) {
        this.jplefts = jplefts;
    }

    public JPanel getJplefti() {
        return jplefti;
    }

    public void setJplefti(JPanel jplefti) {
        this.jplefti = jplefti;
    }

    public JPanel getJpright() {
        return jpright;
    }

    public void setJpright(JPanel jpright) {
        this.jpright = jpright;
    }

    public JPanel getJprightgu() {
        return jprightgu;
    }

    public void setJprightgu(JPanel jprightgu) {
        this.jprightgu = jprightgu;
    }

    public JPanel getJprightgp() {
        return jprightgp;
    }

    public void setJprightgp(JPanel jprightgp) {
        this.jprightgp = jprightgp;
    }

    public JPanel getJprightlower() {
        return jprightlower;
    }

    public void setJprightlower(JPanel jprightlower) {
        this.jprightlower = jprightlower;
    }

    public JPanel getJprightgbt() {
        return jprightgbt;
    }

    public void setJprightgbt(JPanel jprightgbt) {
        this.jprightgbt = jprightgbt;
    }

    public JPanel getJprighttop() {
        return jprighttop;
    }

    public void setJprighttop(JPanel jprighttop) {
        this.jprighttop = jprighttop;
    }

    public JPanel getJpleftn() {
        return jpleftn;
    }

    public void setJpleftn(JPanel jpleftn) {
        this.jpleftn = jpleftn;
    }

    public JCheckBox getJcheckb() {
        return jcheckb;
    }

    public void setJcheckb(JCheckBox jcheckb) {
        this.jcheckb = jcheckb;
    }

    public static void main(String[] args) {
        new LoginView();
    }

}
