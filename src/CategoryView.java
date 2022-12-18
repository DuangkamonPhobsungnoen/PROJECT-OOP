
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CategoryView {

    private JFrame jf;
    private JPanel jphead, jpleft, jp1, jp2, jp3, jp4, jpright, jpbig, jpback, jpgap, jpgap1, jpgap2,  jpgap3, jpbig1, jptxt1, jptxt2;
    private JComboBox cb;
    private JButton jbdot, jbadd, jbup, jbdel, jbback, jbmenu;
    private JTextField jtname, jtprice;
    private JTable table;
    private JLabel jltext, jlname, jlprice;

    public CategoryView() {
        jf = new JFrame("Category page");
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
        jpbig1 = new JPanel();
        jpgap = new JPanel();
        jpgap1 = new JPanel();
        jpgap2 = new JPanel();
        jpgap3 = new JPanel();
        jptxt1 = new JPanel();
        jptxt2 = new JPanel();
        cb = new JComboBox();
        jbdot = new JButton("...");
        jbmenu = new JButton("GET MENU");
        jbadd = new JButton("Add");
        jbup = new JButton("Update");
        jbdel = new JButton("Delete");
        jbback = new JButton("BACK");
        jtname = new JTextField(20);
        jtprice = new JTextField(20);
        jltext = new JLabel("HOM-KLIN-NGERN");
        jlname = new JLabel("Name ");
        jlprice = new JLabel("Price ");
//        cb.setSelectedItem("Category");

        //text field
        jtname.setPreferredSize(new Dimension(200,30));
        jtprice.setPreferredSize(new Dimension(200,30));
        jptxt1.setLayout(new BorderLayout());
        jptxt2.setLayout(new BorderLayout());
        jptxt1.add(jtname);
        jptxt2.add(jtprice);
        //button 
        cb.setFocusable(false);
        jbdot.setFocusable(false);
        jbadd.setFocusable(false);
        jbup.setFocusable(false);
        jbdel.setFocusable(false);
        jbback.setFocusable(false);
        jbmenu.setFocusable(false);
        

        //left
        jp1.add(cb);
        jp1.add(jbmenu);
        jp1.add(jbdot);
        jp2.add(jlname);
        jp2.add(jptxt1);
        jp3.add(jlprice);
        jp3.add(jptxt2);
        jp4.add(jbadd);
        jp4.add(jbup);
        jp4.add(jbdel);
        jpleft.setLayout(new GridLayout(6, 1));
        jpleft.add(jpgap1);
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
        Object[][] data = {};
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            } // à¸„à¸³à¸ªà¸±à¹ˆà¸‡à¸—à¸µà¹ˆà¸—à¸³à¹ƒà¸«à¹‰à¹à¸à¹‰à¹„à¸‚à¸•à¸²à¸£à¸²à¸‡à¹„à¸¡à¹ˆà¹„à¸”à¹‰
        };
        table = new JTable(tableModel);
        jpright.add(table.getTableHeader(), BorderLayout.PAGE_START);
        jpright.add(table);

        //big frame
        table.setShowGrid(false);
        table.setRowHeight(25);

        jpbig.setLayout(new GridLayout(1, 2));
        jpbig.add(jpleft);
        jpbig.add(jpright);
        //addgap
        jpbig1.setLayout(new BorderLayout());
        jpbig1.add(jpgap, BorderLayout.NORTH);
        jpbig1.add(jpgap2, BorderLayout.EAST);
        jpbig1.add(jpgap3, BorderLayout.SOUTH);
        jpbig1.add(jpbig);
        
        jf.add(jphead, BorderLayout.NORTH);
        jf.add(jpbig1);

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
        jpgap.setBackground(Color.WHITE);
        jpgap1.setBackground(Color.WHITE);
        jpgap2.setBackground(Color.WHITE);
        jpgap3.setBackground(Color.WHITE);
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
        jbmenu.setBackground(new Color(255, 204, 0));

        //font color
        table.getTableHeader().setForeground(Color.WHITE);
        table.setForeground(Color.WHITE);
        jltext.setForeground(new Color(255, 204, 0));
        
        cb.setFont(new Font("browallia new", Font.BOLD, 15));
        jltext.setFont(new Font("browallia new", Font.BOLD, 30));
        jtname.setFont(new Font("browallia new", Font.BOLD, 15));
        jtprice.setFont(new Font("browallia new", Font.BOLD, 15));
        cb.setFont(new Font("browallia new", Font.BOLD, 15));
        jbback.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        table.getTableHeader().setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        table.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jlname.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jlprice.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jbdot.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jbadd.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jbup.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jbdel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        jbmenu.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
         table.setFont(new Font("browallia new", Font.BOLD, 18));
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

    public JComboBox getCb() {
        return cb;
    }

    public JButton getJbdot() {
        return jbdot;
    }

    public JButton getJbadd() {
        return jbadd;
    }

    public JButton getJbup() {
        return jbup;
    }

    public JButton getJbdel() {
        return jbdel;
}

    public JTextField getJtname() {
        return jtname;
    }
    
    public JButton getJbmenu() {
        return jbmenu;
    }

    public JTextField getJtprice() {
        return jtprice;
    }

    public JTable getTable() {
        return table;
    }
    
}
