
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.FactoryConfigurationError;

public class UserView {

    private JFrame jf;
    private JPanel jp, jphead, jphback, jphtext, jpleft,  jpright,  jpbill;
    private JButton jbback;
    private JLabel jlhtext;
    private JTextArea jtabill;
    
    public UserView() {
        jf = new JFrame("User page");
        jphead = new JPanel();
        jphback = new JPanel();
        jphtext = new JPanel();
        jp = new JPanel();
        jpleft = new JPanel();
        jpright = new JPanel();
        jpbill= new JPanel();
        jbback = new JButton("Back");
        jlhtext = new JLabel("HOM-KLIN-NGERN");
        
        jtabill = new JTextArea(28, 43);
        JScrollPane jspbill = new JScrollPane(jtabill, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jf.setLayout(new BorderLayout());
        // head
        jphead.setLayout(new BorderLayout());
        jphtext.add(jlhtext);
        jphback.add(jbback);
        jphead.add(jphtext, BorderLayout.NORTH);
//        jphead.add(jphback, BorderLayout.NORTH);
        //lower
        jp.setLayout(new GridLayout(1,2));
        //left qr code
        
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
        jpright.setBackground(Color.white);
        jpleft.setBackground(new Color(28, 64, 121));
        jphead.setBackground(new Color(255, 204, 0));
        jphback.setBackground(new Color(255, 204, 0));
        jphtext.setBackground(new Color(255, 204, 0));
        
        // set ColorFont

        
       // set Font
        jlhtext.setFont(new Font("browallia new", Font.BOLD, 30));
        jbback.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
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
    
    
}
