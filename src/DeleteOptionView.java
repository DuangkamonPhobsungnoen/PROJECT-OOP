import java.awt.*;
import javax.swing.*;
public class DeleteOptionView {
    private JFrame jf;
    private JPanel jp1, jp2, jp3, jp;
    private JTextField jtcat;
    private JButton jbyes, jbno;
    private JLabel jltxt;
    public DeleteOptionView(){
        jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp = new JPanel();
        jtcat = new JTextField(20);
        jbyes = new JButton("YES");
        jbno = new JButton("NO");
        jltxt = new JLabel("Delete This Category");
        
        jp1.add(jltxt);
        jp2.add(jbyes);
        jp2.add(jbno);
        
        jp.setLayout(new GridLayout(2,1));
        jp.add(jp1);
        jp.add(jp2);
        
        jf.add(jp);
        jf.setVisible(false);
        jf.setSize(300, 200);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        
        //font
        jbyes.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jbno.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jltxt.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        
        jbyes.setForeground(Color.WHITE);
        jbno.setForeground(Color.WHITE);
        jltxt.setForeground(new Color(28, 64, 121));
        //backgroundcolor
        jp1.setBackground(new Color(255, 204, 0));
        jp2.setBackground(new Color(255, 204, 0));
        jp3.setBackground(new Color(255, 204, 0));
        jf.setBackground(new Color(255, 204, 0));
        jbyes.setBackground(new Color(28, 64, 121));
        jbno.setBackground(new Color(28, 64, 121));
    }
//       public static void main(String[] args) {
//        new DeleteOptionView();
//    }

    public JFrame getJf() {
        return jf;
    }

    public JTextField getJtcat() {
        return jtcat;
    }

    public JButton getJbyes() {
        return jbyes;
    }

    public JButton getJbno() {
        return jbno;
    }

    public JLabel getJltxt() {
        return jltxt;
    }

    public void setJf(JFrame jf) {
        this.jf = jf;
    }

    public void setJtcat(JTextField jtcat) {
        this.jtcat = jtcat;
    }

    public void setJbyes(JButton jbyes) {
        this.jbyes = jbyes;
    }

    public void setJbno(JButton jbno) {
        this.jbno = jbno;
    }

    public void setJltxt(JLabel jltxt) {
        this.jltxt = jltxt;
    }
    
}
