import java.awt.*;
import javax.swing.*;
public class OptionView {
     private JFrame jf;
    private JPanel jp1, jp2, jp3, jp;
    private JButton jbnew, jbup, jbdel;
    public OptionView(){
        jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp = new JPanel();
        jbnew = new JButton("NEW");
        jbup = new JButton("UPDATE");
        jbdel = new JButton("DELETE");
        
        jp1.add(jbnew);
        jp2.add(jbup);
        jp3.add(jbdel);
        
        jp.setLayout(new GridLayout(3,1));
        jp.add(jp1);
        jp.add(jp2);
        jp.add(jp3);
        
        jf.add(jp);
        jf.setVisible(false);
        jf.setSize(300, 200);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        
        //font
        jbnew.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jbup.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jbdel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
                
        jbnew.setForeground(Color.WHITE);
        jbup.setForeground(Color.WHITE);
        jbdel.setForeground(Color.WHITE);
        //backgroundcolor
        jp1.setBackground(new Color(255, 204, 0));
        jp2.setBackground(new Color(255, 204, 0));
        jp3.setBackground(new Color(255, 204, 0));
        jf.setBackground(new Color(255, 204, 0));
        
        jbnew.setBackground(new Color(28, 64, 121));
        jbup.setBackground(new Color(28, 64, 121));
        jbdel.setBackground(new Color(28, 64, 121));
        
    }
//       public static void main(String[] args) {
//        new OptionView();
//    }

    public JFrame getJf() {
        return jf;
    }

    public JButton getJbnew() {
        return jbnew;
    }

    public JButton getJbup() {
        return jbup;
    }

    public JButton getJbdel() {
        return jbdel;
    }

    
}
