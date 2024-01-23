package App;

import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import App.MainJframe ;
import Gui.Employees_Information;
import Gui.Manage_Departments;
import Gui.Acounts;
import Gui.Atiendances;
import Gui.Basic_Salary;
import Gui.Educattions;
import Gui.Job_Position;
import Gui.Page5;
import Gui.Page6;
import Gui.Patientrooms;
import Gui.Work_Schedules;

import javax.swing.JSeparator;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;

public class MainJframe extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JMenuBar menuBar;
	private JMenu mnMenu1 ;
	private JMenuItem mntmPage1;
	private JMenuItem mntmCloseJf1;
	private JSeparator separator;
	private JMenuItem mntmPage2;
	private JSeparator separator_1;
	private JMenuItem mntmPage3;
	private JSeparator separator_2;
	private JMenuItem mntmPage4;
	private JMenuItem mntmEDUCATIONS;
	private JMenuItem mntmPatienrooms;
	private JSeparator separator_6;
	private JSeparator separator_7;
	private JSeparator separator_8;
	private JMenuItem mntmAtiendances;
	private JMenuItem mntmAcounts;
	private JSeparator separator_5;
	private JMenuItem mntmWork_Schedules;
    

    public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	MainJframe frame = new MainJframe();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainJframe() {
    	setTitle("B.Y.D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 556, 361);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Tạo thanh menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Thêm mục "File" vào thanh menu
        JMenu mnMenu1 = new JMenu("Menu 1");
        menuBar.add(mnMenu1);
        
        JMenuItem mntmEmployees = new JMenuItem("Employees Information");
        mntmEmployees.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mntmPage1ActionPerformed(e);
        	}
        });
        mnMenu1.add(mntmEmployees);
        
        JSeparator separator_2 = new JSeparator();
        mnMenu1.add(separator_2);
        
        JMenuItem mntmDepartments = new JMenuItem("Manage Departments");
        mntmDepartments.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mntmPage2ActionPerformed(e);
        	}
        });
        mnMenu1.add(mntmDepartments);
        
        JSeparator separator_3 = new JSeparator();
        mnMenu1.add(separator_3);
        
        JMenuItem mntmSALARIES = new JMenuItem("Basic Salary");
        mntmSALARIES.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mntmPage3ActionPerformed(e);
        	}
        });
        mnMenu1.add(mntmSALARIES);
        
        JSeparator separator_4 = new JSeparator();
        mnMenu1.add(separator_4);
        
        JMenuItem mntmPOSITIONS = new JMenuItem("Job Position");
        mntmPOSITIONS.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mntmPage4ActionPerformed(e);
        	}
        });
        mnMenu1.add(mntmPOSITIONS);
        
        separator_6 = new JSeparator();
        mnMenu1.add(separator_6);
        
        mntmEDUCATIONS = new JMenuItem("Educattions");
        mntmEDUCATIONS.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mntmEDUCATIONSActionPerformed(e);
        	}
        });
        mnMenu1.add(mntmEDUCATIONS);
        
        separator_7 = new JSeparator();
        mnMenu1.add(separator_7);
        
        mntmPatienrooms = new JMenuItem("Patientrooms");
        mntmPatienrooms.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mntmPatienroomsActionPerformed(e);
        	}
        });
        mnMenu1.add(mntmPatienrooms);
        
        JSeparator separator_9 = new JSeparator();
        mnMenu1.add(separator_9);
        
        mntmWork_Schedules = new JMenuItem("Work_Schedules");
        mntmWork_Schedules.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mntmWork_SchedulesActionPerformed(e);
        	}
        });
        mnMenu1.add(mntmWork_Schedules);
        
        JSeparator separator_10 = new JSeparator();
        mnMenu1.add(separator_10);
        
        mntmAtiendances = new JMenuItem("Atiendances");
        mntmAtiendances.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mntmAtiendancesActionPerformed(e);
        	}
        });
        mnMenu1.add(mntmAtiendances);
        
        separator_5 = new JSeparator();
        mnMenu1.add(separator_5);
        
        mntmAcounts = new JMenuItem("Acounts");
        mntmAcounts.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mntmAcountsActionPerformed(e);
        	}
        });
        mnMenu1.add(mntmAcounts);
        
        separator_8 = new JSeparator();
        mnMenu1.add(separator_8);

        JMenuItem exitItem = new JMenuItem("Exit");
        mnMenu1.add(exitItem);
        
        JMenu mnMenu2 = new JMenu("Menu 2");
        mnMenu2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mnMenu2ActionPerformed(e);
        	}
        });
        menuBar.add(mnMenu2);
        
        JMenuItem mntmPage5 = new JMenuItem("Page 5");
        mntmPage5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mntmPage5ActionPerformed(e);
        	}
        });
        mnMenu2.add(mntmPage5);
        
        JMenu mnMenu3 = new JMenu("Menu 3");
        mnMenu3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mnMenu3ActionPerformed(e);
        	}
        });
        menuBar.add(mnMenu3);
        
        JMenuItem mntmPage6 = new JMenuItem("Page 6");
        mntmPage6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mntmPage6ActionPerformed(e);
        	}
        });
        mnMenu3.add(mntmPage6);

        // Xử lý sự kiện khi nhấn nút Exit
        exitItem.addActionListener(e -> {
            // Thực hiện các thao tác khi nhấn Exit
            System.out.println("Exit selected");
            System.exit(0); // Thoát ứng dụng
        });
    }

	protected void mntmPage1ActionPerformed(ActionEvent e) {
		Employees_Information page1 = new Employees_Information().getInstance();
		if(!page1.isVisible()) {
			page1.setVisible(true);
			contentPane.add(page1);
		}
	}
	protected void mntmPage2ActionPerformed(ActionEvent e) {
		Manage_Departments page2 = new Manage_Departments().getInstance();
		if(!page2.isVisible()) {
			page2.setVisible(true);
			contentPane.add(page2);
		}
	}
	protected void mntmPage3ActionPerformed(ActionEvent e) {
		Basic_Salary page3 = new Basic_Salary().getInstance();
		if(!page3.isVisible()) {
			page3.setVisible(true);
			contentPane.add(page3);
		}
	}
	protected void mntmPage4ActionPerformed(ActionEvent e) {
		Job_Position page4 = new Job_Position().getInstance();
		if(!page4.isVisible()) {
			page4.setVisible(true);
			contentPane.add(page4);
		}
	}
	protected void mnMenu2ActionPerformed(ActionEvent e) {

	}
	protected void mnMenu3ActionPerformed(ActionEvent e) {

	}
	protected void mntmPage5ActionPerformed(ActionEvent e) {
		Page5 page5 = new Page5().getInstance();
		if(!page5.isVisible()) {
			page5.setVisible(true);
			contentPane.add(page5);
		}
	}
	protected void mntmPage6ActionPerformed(ActionEvent e) {
		Page6 page6 = new Page6().getInstance();
		if(!page6.isVisible()) {
			page6.setVisible(true);
			contentPane.add(page6);
		}
	}
	protected void mntmEDUCATIONSActionPerformed(ActionEvent e) {
		Educattions educattions = new Educattions().getInstance();
		if(!educattions.isVisible()) {
			educattions.setVisible(true);
			contentPane.add(educattions);
		}
	}
	protected void mntmPatienroomsActionPerformed(ActionEvent e) {
		Patientrooms patienrooms = new Patientrooms().getInstance();
		if(!patienrooms.isVisible()) {
			patienrooms.setVisible(true);
			contentPane.add(patienrooms);
		}
	}
	protected void mntmWork_SchedulesActionPerformed(ActionEvent e) {
		Work_Schedules work_schedules = new Work_Schedules().getInstance();
		if(!work_schedules.isVisible()) {
			work_schedules.setVisible(true);
			contentPane.add(work_schedules);
		}
	}
	protected void mntmAtiendancesActionPerformed(ActionEvent e) {
		Atiendances atiendances = new Atiendances().getInstance();
		if(!atiendances.isVisible()) {
			atiendances.setVisible(true);
			contentPane.add(atiendances);
		}
	}
	protected void mntmAcountsActionPerformed(ActionEvent e) {
		Acounts acounts = new Acounts().getInstance();
		if(!acounts.isVisible()) {
			acounts.setVisible(true);
			contentPane.add(acounts);
		}
	}
	
}
