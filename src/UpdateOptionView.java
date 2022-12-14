import java.awt.*;
import javax.swing.*;
public class UpdateOptionView {
     private JFrame jf;
    private JPanel jp1, jp2, jp3, jp;
    private JTextField jtcat;
    private JButton jbok;
    private JLabel jltxt;
    public UpdateOptionView(){
        jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp = new JPanel();
        jtcat = new JTextField(20);
        jbok = new JButton("OK");
        jltxt = new JLabel("Edit Category Name");
        
        jp1.add(jltxt);
        jp2.add(jtcat);
        jp3.add(jbok);
        
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
        jbok.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jltxt.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        
        jbok.setForeground(Color.WHITE);
        jltxt.setForeground(new Color(28, 64, 121));
        //backgroundcolor
        jp1.setBackground(new Color(255, 204, 0));
        jp2.setBackground(new Color(255, 204, 0));
        jp3.setBackground(new Color(255, 204, 0));
        jf.setBackground(new Color(255, 204, 0));
        jbok.setBackground(new Color(28, 64, 121));
    }
//       public static void main(String[] args) {
//        new UpdateOptionView();
//    }

    public JFrame getJf() {
        return jf;
    }

    public JTextField getJtcat() {
        return jtcat;
    }

    public JButton getJbok() {
        return jbok;
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

    public void setJbok(JButton jbok) {
        this.jbok = jbok;
    }

    public void setJltxt(JLabel jltxt) {
        this.jltxt = jltxt;
    }
    
}
