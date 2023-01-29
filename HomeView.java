import java.awt.*;
import javax.swing.*;
public class HomeView {
    private JFrame jf;
    private JPanel jphead, jphtext, jpicon1, jpicon2, jptext1, jptext2, jpgrouptext, jphback, jpgroupicon;
    private JButton jbcashier, jbmenu, jbback;
    private JLabel jlhname, jlcashier, jlmenu;
    
    public HomeView(){
        jf = new JFrame("Home page");
        
        jphead = new JPanel();
        jphback  = new JPanel();
        jphtext = new JPanel();
        jpicon1 = new JPanel();
        jpicon2 = new JPanel();
        jptext1 = new JPanel();
        jptext2 = new JPanel();
        jpgrouptext = new JPanel();
        jpgroupicon = new JPanel();
        
        
        ImageIcon imgcashier = new ImageIcon("cashier.png");
        ImageIcon imgmenu = new ImageIcon("menu.png");
        jbcashier = new JButton(imgcashier);
        jbmenu = new JButton(imgmenu);
        jbback = new JButton("BACK");
        
        jlhname = new JLabel("HOM-KLIN-NGERN");
        jlcashier = new JLabel("                           CASHIER");
        jlmenu = new JLabel("                EDIT MENU");
                 
        // head
        jphead.setLayout(new BorderLayout());
        jphtext.add(jlhname);
         jphback.add(jbback);
        jphead.add(jphtext, BorderLayout.WEST);
        jphead.add(jphback, BorderLayout.EAST);
       
        
        // button select menu/cashier
//        jpimg1.add(jbcashier);
//        jpimg2.add(jbmenu);
        jpicon1.setLayout(new FlowLayout(0, 15, 30));
        jpicon1.add(jbcashier);
        jpicon2.setLayout(new FlowLayout());
        jpicon2.add(jbmenu);
        
        jpgroupicon.add(jpicon1);
        jpgroupicon.add(jpicon2);
        
        // text cashier/menu
        jptext1.add(jlcashier);
        jptext2.add(jlmenu);
        
        jpgrouptext.setLayout(new FlowLayout(0,0, 26));
        jpgrouptext.add(jptext1);
        jpgrouptext.add(jptext2);
        
        //background
        jphead.setBackground(new Color(28, 64, 121));
        jphtext.setBackground(new Color(28, 64, 121));
        jphback.setBackground(new Color(28, 64, 121));
        jbback.setBackground(Color.WHITE);
        
        jbcashier.setBackground(new Color(255, 204, 0));
        jbmenu.setBackground(new Color(255, 204, 0));
        
        jpicon1.setBackground(Color.white);
        jpicon2.setBackground(Color.white);
        jpgrouptext.setBackground(Color.white);
        jpgroupicon.setBackground(Color.white);
        jptext1.setBackground(Color.white);
        jptext2.setBackground(Color.white);
//        jpimg1.setBackground(Color.white);
//        jpimg2.setBackground(Color.white);
        
        // Font
        jlhname.setFont(new Font("browallia new", Font.BOLD, 30));
        jlcashier.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
        jlmenu.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
        jbback.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        
        // Font color
        jlhname.setForeground(new Color(255, 204, 0));
        jlcashier.setForeground(Color.BLACK);
        jlmenu.setForeground(Color.BLACK);
        
        jf.add(jphead, BorderLayout.NORTH);
        jf.add(jpgroupicon, BorderLayout.CENTER);
        jf.add(jpgrouptext, BorderLayout.SOUTH);
        jf.setVisible(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(720, 400);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        
    }

    public JFrame getJf() {
        return jf;
    }

    public JButton getJbcashier() {
        return jbcashier;
    }

    public JButton getJbmenu() {
        return jbmenu;
    }

    public JButton getJbback() {
        return jbback;
    }

    public JLabel getJlhname() {
        return jlhname;
    }
    
    
    
}