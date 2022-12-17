
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.FactoryConfigurationError;

public class UserView {

    private JFrame jf;
    private JPanel jp, jphead, jphback, jphtext, jpleft,  jpright,  jpbill, jpleftn, jpleftc, jplefts;
    private JButton jbback;
    private JLabel jlhtext, jlname, jllower, jlimg;
    private JTextArea jtabill;
    private ImageIcon img;
    
    public UserView() {
        jf = new JFrame("User page");
        img = new ImageIcon("icon_qrcode.png");
        jlimg = new JLabel(img);
        jphead = new JPanel();
        jphback = new JPanel();
        jphtext = new JPanel(); 
        jp = new JPanel();
        jpleft = new JPanel();
        jpright = new JPanel();
        jpbill = new JPanel();
        jpleftn = new JPanel();
        jpleftc = new JPanel();
        jplefts = new JPanel();
        jbback = new JButton("Back");
        jlhtext = new JLabel("HOM-KLIN-NGERN");
        jlname = new JLabel("SCAN TO PAY");
        jllower = new JLabel("Thank you for using the service");
       
        
        jtabill = new JTextArea(28, 42);
        JScrollPane jspbill = new JScrollPane(jtabill, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jf.setLayout(new BorderLayout());
        // head
        jphead.setLayout(new BorderLayout());
        jphtext.add(jlhtext);
        jphback.add(jbback);
        jphead.add(jphtext, BorderLayout.WEST);
        jphead.add(jphback, BorderLayout.EAST);
        //lower
        jp.setLayout(new GridLayout(1,2));
        //left qr code
        jpleft.setLayout(new BorderLayout());
        jpleft.add(jpleftn, BorderLayout.NORTH);
        jpleft.add(jpleftc, BorderLayout.CENTER);
        jpleft.add(jplefts, BorderLayout.SOUTH);
        jpleftn.add(jlname);
        jpleftc.add(jlimg);
        jplefts.add(jllower);
        //right bill
        jpbill.add(jspbill);
        jpright.add(jpbill);
        
        
        jp.add(jpleft);
        jp.add(jpright);
        jf.add(jphead, BorderLayout.NORTH);
        jf.add(jp, BorderLayout.CENTER);
        jf.setVisible(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(820, 550);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        
        //se tBackground
        jpright.setBackground(new Color(255, 204, 0));
        jpleftn.setBackground(new Color(255, 204, 0));
        jpleftc.setBackground(new Color(255, 204, 0));
        jplefts.setBackground(new Color(255, 204, 0));
        jphead.setBackground(new Color(28, 64, 121));
        jphback.setBackground(new Color(28, 64, 121));
        jphtext.setBackground(new Color(28, 64, 121));
        jbback.setBackground(Color.WHITE);
        
        // set ColorFont
        jlhtext.setForeground(new Color(255, 204, 0));
        
       // set Font
        jlhtext.setFont(new Font("browallia new", Font.BOLD, 30));
        jbback.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jlname.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
        jllower.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
    }

    public static void main(String[] args) {
        new UserView();
    }

    public JFrame getJf() {
        return jf;
    }

    public void setJf(JFrame jf) {
        this.jf = jf;
    }

    public JButton getJbback() {
        return jbback;
    }

    public void setJbback(JButton jbback) {
        this.jbback = jbback;
    }

    public JLabel getJlhtext() {
        return jlhtext;
    }

    public void setJlhtext(JLabel jlhtext) {
        this.jlhtext = jlhtext;
    }
    
    
}
