import java.awt.*;
import javax.swing.*;
public class HomeView {
    private JFrame jf;
    private JPanel jphead, jphtext, jpicon, jptext1, jptext2, jpgrouptext, jphback;
    private JButton jbcashier, jbmenu, jbback;
    private JLabel jlhname, jlcashier, jlmenu;
    
    public HomeView(){
        jf = new JFrame("Menu");
        
        jphead = new JPanel();
        jphback  = new JPanel();
        jphtext = new JPanel();
        jpicon = new JPanel();
        jptext1 = new JPanel();
        jptext2 = new JPanel();
        jpgrouptext = new JPanel();
        
        
        ImageIcon imgcashier = new ImageIcon("cashier.png");
        ImageIcon imgmenu = new ImageIcon("menu.png");
        jbcashier = new JButton(imgcashier);
        jbmenu = new JButton(imgmenu);
        jbback = new JButton("BACK");
        
        jlhname = new JLabel("HOM-KLIN-NGERN");
        jlcashier = new JLabel("CASHIER");
        jlmenu = new JLabel("EDIT MENU");
                 
        // head
        jphead.setLayout(new BorderLayout());
        jphtext.add(jlhname);
         jphback.add(jbback);
        jphead.add(jphtext, BorderLayout.WEST);
        jphead.add(jphback, BorderLayout.EAST);
       
        
        // button select menu/cashier
        jpicon.setLayout(new FlowLayout());
        jpicon.add(jbcashier);
        jpicon.add(jbmenu);
        
        // text cashier/menu
        jptext1.setLayout(new FlowLayout());
        jptext1.add(jlcashier);
        
        jptext2.setLayout(new FlowLayout());
        jptext2.add(jlmenu);
        
        jpgrouptext.setLayout(new GridLayout(1,2));
        jpgrouptext.add(jptext1);
        jpgrouptext.add(jptext2);
        
        //background
        jphead.setBackground(new Color(28, 64, 121));
        jphtext.setBackground(new Color(28, 64, 121));
        jphback.setBackground(new Color(28, 64, 121));
        jbback.setBackground(Color.WHITE);
        
        jbcashier.setBackground(new Color(255, 204, 0));
        jbmenu.setBackground(new Color(255, 204, 0));
        
        jpicon.setBackground(Color.white);
        jpgrouptext.setBackground(Color.white);
        jptext1.setBackground(Color.white);
        jptext2.setBackground(Color.white);
        
        // Font
        jlhname.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
        jlcashier.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        jlmenu.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        jbback.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        
        // Font color
        jlhname.setForeground(new Color(255, 204, 0));
        jlcashier.setForeground(Color.BLACK);
        jlmenu.setForeground(Color.BLACK);
        
        jf.add(jphead, BorderLayout.NORTH);
        jf.add(jpicon, BorderLayout.CENTER);
        jf.add(jpgrouptext, BorderLayout.SOUTH);
        jf.setVisible(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(720, 400);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        
    }
    public static void main(String[] args) {
        new HomeView();
    }

    public JFrame getJf() {
        return jf;
    }

    public void setJf(JFrame jf) {
        this.jf = jf;
    }

    public JPanel getJphead() {
        return jphead;
    }

    public void setJphead(JPanel jphead) {
        this.jphead = jphead;
    }

    public JPanel getJphtext() {
        return jphtext;
    }

    public void setJphtext(JPanel jphtext) {
        this.jphtext = jphtext;
    }

    public JPanel getJpicon() {
        return jpicon;
    }

    public void setJpicon(JPanel jpicon) {
        this.jpicon = jpicon;
    }

    public JPanel getJptext1() {
        return jptext1;
    }

    public void setJptext1(JPanel jptext1) {
        this.jptext1 = jptext1;
    }

    public JPanel getJptext2() {
        return jptext2;
    }

    public void setJptext2(JPanel jptext2) {
        this.jptext2 = jptext2;
    }

    public JPanel getJpgrouptext() {
        return jpgrouptext;
    }

    public void setJpgrouptext(JPanel jpgrouptext) {
        this.jpgrouptext = jpgrouptext;
    }

    public JButton getJbcashier() {
        return jbcashier;
    }

    public void setJbcashier(JButton jbcashier) {
        this.jbcashier = jbcashier;
    }

    public JButton getJbmenu() {
        return jbmenu;
    }

    public void setJbmenu(JButton jbmenu) {
        this.jbmenu = jbmenu;
    }

    public JLabel getJlhname() {
        return jlhname;
    }

    public void setJlhname(JLabel jlhname) {
        this.jlhname = jlhname;
    }

    public JLabel getJlcashier() {
        return jlcashier;
    }

    public void setJlcashier(JLabel jlcashier) {
        this.jlcashier = jlcashier;
    }

    public JLabel getJlmenu() {
        return jlmenu;
    }

    public void setJlmenu(JLabel jlmenu) {
        this.jlmenu = jlmenu;
    }

    public JButton getJbback() {
        return jbback;
    }

    public void setJbback(JButton jbback) {
        this.jbback = jbback;
    }
    
    
}