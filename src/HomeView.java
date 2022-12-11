
import javax.swing.*;


public class HomeView {
    private JFrame jf;
    public HomeView() {
        jf = new JFrame();
        jf.setSize(720, 470);
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
    
    public static void main(String[] args) {
        new HomeView();
    }
}
