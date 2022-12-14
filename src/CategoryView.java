
import java.awt.*;
import javax.swing.*;

public class CategoryView {

    private JFrame jf;
    private JPanel jphead, jpleft, jp1, jp2, jp3, jp4, jpright, jpbig, jpback;
    private JComboBox cb;
    private JButton jbdot, jbadd, jbup, jbdel, jbback;
    private JTextField jtname, jtprice;
    private JTable table;
    private JLabel jltext, jlname, jlprice;

    public CategoryView() {
        jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jphead = new JPanel();
        jpback = new JPanel();
        jpleft = new JPanel();
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jpright = new JPanel();
//        jpright1 = new JPanel();
        jpbig = new JPanel();
        cb = new JComboBox();
        jbdot = new JButton("...");
        jbadd = new JButton("Add");
        jbup = new JButton("Update");
        jbdel = new JButton("Delete");
        jbback = new JButton("BACK");
        jtname = new JTextField(20);
        jtprice = new JTextField(20);
        jltext = new JLabel("HOM-KLIN-NGERN");
        jlname = new JLabel("Name ");
        jlprice = new JLabel("Price ");
        //left
        cb.addItem("Drink");
        jp1.add(cb);
        jp1.add(jbdot);
        jp2.add(jlname);
        jp2.add(jtname);
        jp3.add(jlprice);
        jp3.add(jtprice);
        jp4.add(jbadd);
        jp4.add(jbup);
        jp4.add(jbdel);
        jpleft.setLayout(new GridLayout(6, 1));
        jpleft.add(jp1);
        jpleft.add(jp2);
        jpleft.add(jp3);
        jpleft.add(jp4);
        //head
        jphead.setLayout(new BorderLayout());
        jphead.add(jltext, BorderLayout.WEST);
        jpback.add(jbback);
        jphead.add(jpback, BorderLayout.EAST);
        //right 
        jpright.setLayout(new BoxLayout(jpright, BoxLayout.Y_AXIS));
        String[] columnNames = {"Menu", "Price"};
        Object[][] data = {{"Soup", "45"}, {"Coca - cola", "20"}};
        table = new JTable(data, columnNames);
        jpright.add(table.getTableHeader(), BorderLayout.PAGE_START);
        jpright.add(table);

        //big frame
        table.setShowGrid(false);
        table.setRowHeight(25);
//        jpright1.setLayout(new GridLayout());
//        jpright1.add(jpright);

        jpbig.setLayout(new GridLayout(1, 2));
        jpbig.add(jpleft);
        jpbig.add(jpright);
        jf.add(jphead, BorderLayout.NORTH);
        jf.add(jpbig);

        jf.setSize(820, 550);
        jf.setVisible(false);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);

        // background color
        jphead.setBackground(new Color(28, 64, 121));
        jpback.setBackground(new Color(28, 64, 121));
        table.getTableHeader().setBackground(new Color(28, 64, 121));
        table.setBackground(new Color(28, 64, 121));
        jpright.setBackground(new Color(28, 64, 121));
        jbback.setBackground(Color.WHITE);
        jpbig.setBackground(Color.WHITE);
        jpleft.setBackground(Color.WHITE);
        jp1.setBackground(Color.WHITE);
        jp2.setBackground(Color.WHITE);
        jp3.setBackground(Color.WHITE);
        jp4.setBackground(Color.WHITE);

        cb.setBackground(new Color(255, 204, 0));
        jbadd.setBackground(new Color(255, 204, 0));
        jbup.setBackground(new Color(255, 204, 0));
        jbdel.setBackground(new Color(255, 204, 0));
        jbdot.setBackground(new Color(255, 204, 0));

        //font color
        table.getTableHeader().setForeground(Color.WHITE);
        table.setForeground(Color.WHITE);
        jltext.setForeground(new Color(255, 204, 0));

        jltext.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
        jbback.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        table.getTableHeader().setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        table.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        cb.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jlname.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jlprice.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jbdot.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jbadd.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jbup.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jbdel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
    }

    public JFrame getJf() {
        return jf;
    }

    public JButton getJbback() {
        return jbback;
    }

    public JLabel getJltext() {
        return jltext;
    }

    
    
}