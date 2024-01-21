package Gui ;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

public class Manage_Departments extends JFrame {

    private static final long serialVersionUID = 1L;
    private static Manage_Departments instance ;
    private JPanel contentPane;
    private JScrollPane scrollPane;
    private JTable table;
    private JTextField txtid;
    private JTextField txtfullname;
    private JCheckBox chkgender;
    private JDateChooser dateChooser;
    private JTextField textSearch;
    private JButton btnUpdate;
    private JButton btnInsert;
    private JButton btnDelete;
    private JButton btnFirst;
    private JButton btnPrevious;
    private JButton btnNext;
    private JButton btnLast;
    private JComboBox comboBox;
    private JTextField txtPage;
    private JLabel lblTotal;
    private JLabel lblStatus;
    private JLabel lblPicture;
    private JButton btnChoose;
    private String fileName = null;
    private String fileOld = null;
    private String dirNew = null;
    private String dirOld = null;
    private JPanel panel;
    private JPanel panel_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Manage_Departments frame = new Manage_Departments();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public static Manage_Departments getInstance() {
        if (instance == null) {
            instance = new Manage_Departments();
        }
        return instance;
    }
    public Manage_Departments() {
        setTitle("Manage_Departments");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 895, 586);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(15, 75, 527, 306);

        txtid = new JTextField();
        txtid.setBounds(595, 323, 103, 36);
        txtid.setBorder(new TitledBorder(null, "id:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
        txtid.setColumns(10);

        txtfullname = new JTextField();
        txtfullname.setBounds(718, 323, 103, 36);
        txtfullname.setColumns(10);
        txtfullname.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "fullname:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));

        chkgender = new JCheckBox("gender");
        chkgender.setBounds(595, 373, 73, 23);
        chkgender.setHorizontalAlignment(SwingConstants.CENTER);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(710, 373, 111, 42);
        dateChooser.setDateFormatString("yyyy-MM-dd");
        dateChooser.setDate(new java.util.Date());
        dateChooser.setBorder(new TitledBorder(null, "Dob:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));

        textSearch = new JTextField();
        textSearch.setBounds(15, 28, 121, 36);
        textSearch.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 64)));
        textSearch.setColumns(10);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(247, 24, 89, 36);

        btnInsert = new JButton("Insert");
        btnInsert.setBounds(154, 24, 83, 38);
        btnDelete = new JButton("Delete");
        btnDelete.setBounds(345, 25, 78, 36);

        btnFirst = new JButton("First");
        btnFirst.setBounds(15, 392, 53, 23);

        btnPrevious = new JButton("Previous");
        btnPrevious.setBounds(74, 392, 84, 23);

        btnNext = new JButton("Next");
        btnNext.setBounds(392, 392, 84, 23);

        btnLast = new JButton("Last");
        btnLast.setBounds(482, 392, 60, 23);

        comboBox = new JComboBox();
        comboBox.setBounds(168, 393, 214, 20);
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"10", "15", "20", "30"}));

        txtPage = new JTextField();
        txtPage.setBounds(219, 421, 113, 24);
        txtPage.setText("1");
        txtPage.setHorizontalAlignment(SwingConstants.CENTER);
        txtPage.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(128, 128, 0)));
        txtPage.setColumns(10);

        lblTotal = new JLabel("count: 0");
        lblTotal.setBounds(454, 421, 88, 14);
        lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);

        lblStatus = new JLabel("Page 1 of 10");
        lblStatus.setBounds(487, 446, 55, 14);

        lblPicture = new JLabel("");
        lblPicture.setBounds(595, 75, 226, 233);
        lblPicture.setBackground(new Color(0, 0, 255));
        lblPicture.setOpaque(true);

        btnChoose = new JButton("Choose Picture");
        btnChoose.setBounds(595, 40, 226, 23);

        table = new JTable();
        table.setAutoCreateRowSorter(true);

        scrollPane.setViewportView(table);
        contentPane.setLayout(null);
        contentPane.add(textSearch);
        contentPane.add(btnInsert);
        contentPane.add(btnUpdate);
        contentPane.add(btnDelete);
        contentPane.add(btnChoose);
        contentPane.add(scrollPane);
        contentPane.add(btnFirst);
        contentPane.add(btnPrevious);
        contentPane.add(comboBox);
        contentPane.add(btnNext);
        contentPane.add(btnLast);
        contentPane.add(lblPicture);
        contentPane.add(txtid);
        contentPane.add(txtfullname);
        contentPane.add(chkgender);
        contentPane.add(dateChooser);
        contentPane.add(lblStatus);
        contentPane.add(txtPage);
        contentPane.add(lblTotal);

        panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(577, 28, 265, 423);
        contentPane.add(panel);

        panel_1 = new JPanel();
        panel_1.setBackground(new Color(192, 192, 192));
        panel_1.setBounds(15, 386, 527, 84);
        contentPane.add(panel_1);
    }

    
    
    
    // ... (Các phương thức và sự kiện khác)
  }
