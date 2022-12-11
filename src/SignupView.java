
import java.awt.*;
import javax.swing.*;

public class SignupView {

    private JFrame jf;
    private JLabel jlsign, jlname, jlimg, jluser, jlpass, jlcpass, jlnameh ;
    private JTextField jtuser, jtname;
    private JPasswordField jpass, jcpass;
    private JButton jbregis, jbb;
    private ImageIcon img;
    private JPanel jp, jpgroup, jpleft, jplefts, jplefti, jpright, jprightgn, jprightgu, jprightgp, jprightgcp, jprightgbt,jpleftn;

    public SignupView() {
        jf = new JFrame();
        img = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Project_oop\\src\\icon_noodle.png");
        jlnameh = new JLabel("Name");
        jlname = new JLabel("HOM KLIN NGERN");
        jlimg = new JLabel(img);
        jluser = new JLabel("Username");
        jlpass = new JLabel("Password");
        jlcpass = new JLabel("Confirm Password");
        jlsign = new JLabel("Sign up...");
        jtuser = new JTextField(20);
        jtname = new JTextField(20);
        jpass = new JPasswordField(20);
        jcpass = new JPasswordField(20);
        jbregis = new JButton("Register");
        jbb = new JButton("Back");
        jp = new JPanel();
        jpleft = new JPanel();
        jplefts = new JPanel();
        jplefti = new JPanel();
        jpright = new JPanel();
        jprightgn = new JPanel();
        jprightgu = new JPanel();
        jpgroup = new JPanel();
        jprightgp = new JPanel();
        jprightgcp = new JPanel();
        jprightgbt = new JPanel();
        jpleftn = new JPanel();
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
        //right enter name
        jpright.setLayout(new GridLayout(5, 1));
        jprightgn.setLayout(new BorderLayout());
        jprightgn.add(jlnameh, BorderLayout.NORTH);
        jprightgn.add(jtname, BorderLayout.CENTER);
        // enter username
        jprightgu.setLayout(new BorderLayout());
        jprightgu.add(jluser, BorderLayout.NORTH);
        jprightgu.add(jtuser, BorderLayout.CENTER);
        // enter password
        jprightgp.setLayout(new BorderLayout());
        jprightgp.add(jlpass, BorderLayout.NORTH);
        jprightgp.add(jpass, BorderLayout.CENTER);
        // enter confirm password
        jprightgcp.setLayout(new BorderLayout());
        jprightgcp.add(jlcpass, BorderLayout.NORTH);
        jprightgcp.add(jcpass, BorderLayout.CENTER);
        // button
        jprightgbt.setLayout(new FlowLayout());
        jprightgbt.add(jbb);
        jprightgbt.add(jbregis);
        //ฟ้อนต์
        jlsign.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jlname.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jlnameh.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
        jluser.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
        jlpass.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
        jlcpass.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
        jbb.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
        jbregis.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
        //ปรับสีพื้นหลัง
        jpleftn.setBackground(new Color(255, 204, 0));
        jplefti.setBackground(new Color(255, 204, 0));
        jplefts.setBackground(new Color(255, 204, 0));
        jprightgbt.setBackground(new Color(255, 204, 0));
        jprightgcp.setBackground(new Color(255, 204, 0));
        jprightgn.setBackground(new Color(255, 204, 0));
        jprightgp.setBackground(new Color(255, 204, 0));
        jprightgu.setBackground(new Color(255, 204, 0));
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
        jpright.add(jprightgn);
        jpright.add(jprightgu);
        jpright.add(jprightgp);
        jpright.add(jprightgcp);
        jpright.add(jprightgbt);
        jp.add(jpright);
        jpgroup.add(jp, BorderLayout.CENTER);
        jf.add(jp);
//        jf.setSize(720, 470);
        jf.pack();
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(false);
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

    public JLabel getJlname() {
        return jlname;
    }

    public void setJlname(JLabel jlname) {
        this.jlname = jlname;
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

    public JLabel getJlcpass() {
        return jlcpass;
    }

    public void setJlcpass(JLabel jlcpass) {
        this.jlcpass = jlcpass;
    }

    public JTextField getJtuser() {
        return jtuser;
    }

    public void setJtuser(JTextField jtuser) {
        this.jtuser = jtuser;
    }

    public JTextField getJtname() {
        return jtname;
    }

    public void setJtname(JTextField jtname) {
        this.jtname = jtname;
    }

    public JPasswordField getJpass() {
        return jpass;
    }

    public void setJpass(JPasswordField jpass) {
        this.jpass = jpass;
    }

    public JPasswordField getJcpass() {
        return jcpass;
    }

    public void setJcpass(JPasswordField jcpass) {
        this.jcpass = jcpass;
    }

    public JButton getJbregis() {
        return jbregis;
    }

    public void setJbregis(JButton jbregis) {
        this.jbregis = jbregis;
    }

    public JButton getJbb() {
        return jbb;
    }

    public void setJbb(JButton jbb) {
        this.jbb = jbb;
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

    public JPanel getJprightgn() {
        return jprightgn;
    }

    public void setJprightgn(JPanel jprightgn) {
        this.jprightgn = jprightgn;
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

    public JPanel getJprightgcp() {
        return jprightgcp;
    }

    public void setJprightgcp(JPanel jprightgcp) {
        this.jprightgcp = jprightgcp;
    }

    public JPanel getJprightgbt() {
        return jprightgbt;
    }

    public void setJprightgbt(JPanel jprightgbt) {
        this.jprightgbt = jprightgbt;
    }
    
    
    public static void main(String[] args) {
        new SignupView();
    }

}
