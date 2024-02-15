package User_GUI;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import App.App_User;
import dao.EmployeeDAO;
import entity.Employee;

import java.awt.SystemColor;
import java.awt.event.MouseMotionAdapter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

public class Profile extends JInternalFrame {
	
	private JComponent Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarca =null;
	private static final long serialVersionUID = 1L;
	private JPanel panel;
//	private int xx, xy;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblFullName;
	private JLabel lblNewLabel_3;
	private JLabel lblEthnicity;
	private JLabel lblExit;
	private JSeparator separator_2;
	private JLabel lblNewLabel_4;
	private JSeparator separator_3;
	private JLabel lblNewLabel_5;
	private JLabel lblGender;
	private JSeparator separator_4;
	private JLabel lblNewLabel_6;
	private JLabel lblAddress;
	private JSeparator separator_5;
	private JLabel lblNewLabel_7;
	private JLabel lblSalary;
	private JSeparator separator_6;
	private JLabel lblNewLabel_8;
	private JLabel lblSupervisor;
	private JSeparator separator_7;
	private JLabel lblNewLabel_9;
	private JLabel lblDepartment;
	private JSeparator separator_8;
	private JLabel lblNewLabel_10;
	private JLabel lblEducation;
	private JSeparator separator_9;
	private JLabel lblNewLabel_11;
	private JLabel lblPosition;
	private JLabel lblNewLabel_12;
	private JLabel lblLevel;
	private JLabel lblNewLabel_13;
	private JPanel panel_2;
	private JLabel lblBack;
	Profile pro;
	App_User app;
	private JLabel lblDate;
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}




	/**
	 * Create the frame.
	 */
	public void quit() {
		Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
		DimensionBarca =Barca.getPreferredSize();
		Barca.setSize(0,0);
		Barca.setPreferredSize(new Dimension(0,0));
		repaint();
	}
	public Profile() {
		getContentPane().addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				thisContentPaneMousePressed(e);
//			}
		});
		getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseDragged(MouseEvent e) {
//				thisContentPaneMouseDragged(e);
//			}
		});
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		quit();
		setBounds(100, 100, 1180, 664);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 1180, 68);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("PERSONAL INFORMATION");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 1180, 57);
		panel.add(lblNewLabel);
		
		lblExit = new JLabel("<html>\r\n\t<p style=\"font-size: 24px;color:white\">&#10006;</p>\r\n</html>");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblExitMouseClicked(e);
			}
		});
		lblExit.setBounds(1134, 0, 46, 27);
		panel.add(lblExit);
		
		lblNewLabel_13 = new JLabel("B.Y.D's Management System");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_13.setBackground(Color.WHITE);
		lblNewLabel_13.setBounds(0, 50, 1180, 18);
		panel.add(lblNewLabel_13);
		
		panel_2 = new JPanel();
		panel_2.setBounds(518, 45, 140, 4);
		panel.add(panel_2);
		
		lblBack = new JLabel("");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblBackMouseClicked(e);
			}
		});
		lblBack.setIcon(new ImageIcon("C:\\Users\\luong\\eclipse-workspace\\project-hk2\\images\\icons8-back-arrow-48.png"));
		lblBack.setBounds(0, 0, 58, 68);
		panel.add(lblBack);
		
		panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(357, 90, 471, 547);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		separator = new JSeparator();
		separator.setForeground(new Color(192, 192, 192));
		separator.setBounds(10, 76, 451, 2);
		panel_1.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(new Color(192, 192, 192));
		separator_1.setBounds(10, 123, 451, 2);
		panel_1.add(separator_1);
		
		lblNewLabel_1 = new JLabel("Personal Information");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 163, 29);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Full Name ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(10, 51, 163, 14);
		panel_1.add(lblNewLabel_2);
		
		lblFullName = new JLabel("");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFullName.setBounds(236, 51, 225, 14);
		panel_1.add(lblFullName);
		
		lblNewLabel_3 = new JLabel("Ethnicity");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 98, 163, 14);
		panel_1.add(lblNewLabel_3);
		
		lblEthnicity = new JLabel("");
		lblEthnicity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEthnicity.setBounds(236, 99, 225, 14);
		panel_1.add(lblEthnicity);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.LIGHT_GRAY);
		separator_2.setBounds(10, 170, 451, 2);
		panel_1.add(separator_2);
		
		lblNewLabel_4 = new JLabel("Date of birth");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(10, 145, 153, 14);
		panel_1.add(lblNewLabel_4);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(Color.LIGHT_GRAY);
		separator_3.setBounds(10, 217, 451, 2);
		panel_1.add(separator_3);
		
		lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(10, 192, 153, 14);
		panel_1.add(lblNewLabel_5);
		
		lblGender = new JLabel("");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGender.setBounds(236, 193, 225, 14);
		panel_1.add(lblGender);
		
		separator_4 = new JSeparator();
		separator_4.setForeground(Color.LIGHT_GRAY);
		separator_4.setBounds(10, 264, 451, 2);
		panel_1.add(separator_4);
		
		lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(10, 239, 153, 14);
		panel_1.add(lblNewLabel_6);
		
		lblAddress = new JLabel("");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddress.setBounds(236, 239, 225, 14);
		panel_1.add(lblAddress);
		
		separator_5 = new JSeparator();
		separator_5.setForeground(Color.LIGHT_GRAY);
		separator_5.setBounds(10, 311, 451, 2);
		panel_1.add(separator_5);
		
		lblNewLabel_7 = new JLabel("Salary");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(10, 287, 153, 14);
		panel_1.add(lblNewLabel_7);
		
		lblSalary = new JLabel("");
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSalary.setBounds(236, 286, 225, 14);
		panel_1.add(lblSalary);
		
		separator_6 = new JSeparator();
		separator_6.setForeground(Color.LIGHT_GRAY);
		separator_6.setBounds(10, 358, 451, 2);
		panel_1.add(separator_6);
		
		lblNewLabel_8 = new JLabel("Supervisor ID");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(10, 333, 153, 14);
		panel_1.add(lblNewLabel_8);
		
		lblSupervisor = new JLabel("");
		lblSupervisor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSupervisor.setBounds(236, 333, 225, 14);
		panel_1.add(lblSupervisor);
		
		separator_7 = new JSeparator();
		separator_7.setForeground(Color.LIGHT_GRAY);
		separator_7.setBounds(10, 405, 451, 2);
		panel_1.add(separator_7);
		
		lblNewLabel_9 = new JLabel("Department");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(10, 380, 153, 14);
		panel_1.add(lblNewLabel_9);
		
		lblDepartment = new JLabel("");
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDepartment.setBounds(236, 380, 225, 14);
		panel_1.add(lblDepartment);
		
		separator_8 = new JSeparator();
		separator_8.setForeground(Color.LIGHT_GRAY);
		separator_8.setBounds(10, 452, 451, 2);
		panel_1.add(separator_8);
		
		lblNewLabel_10 = new JLabel("Education");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_10.setBounds(10, 427, 153, 14);
		panel_1.add(lblNewLabel_10);
		
		lblEducation = new JLabel("");
		lblEducation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEducation.setBounds(236, 427, 225, 14);
		panel_1.add(lblEducation);
		
		separator_9 = new JSeparator();
		separator_9.setForeground(Color.LIGHT_GRAY);
		separator_9.setBounds(10, 499, 451, 2);
		panel_1.add(separator_9);
		
		lblNewLabel_11 = new JLabel("Position");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_11.setBounds(10, 474, 153, 14);
		panel_1.add(lblNewLabel_11);
		
		lblPosition = new JLabel("");
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPosition.setBounds(236, 475, 225, 14);
		panel_1.add(lblPosition);
		
		lblNewLabel_12 = new JLabel("Level");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_12.setBounds(10, 521, 153, 14);
		panel_1.add(lblNewLabel_12);
		
		lblLevel = new JLabel("");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLevel.setBounds(236, 522, 225, 14);
		panel_1.add(lblLevel);
		
		lblDate = new JLabel("");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(236, 146, 225, 14);
		panel_1.add(lblDate);
		loadData();
	}
	protected void lblBackMouseClicked(MouseEvent e) {
		App_User appus = new App_User();
		appus.setLocationRelativeTo(null);
		appus.setUndecorated(true);
		appus.setVisible(true);
	    this.setVisible(false);
	}
//	protected void thisContentPaneMouseDragged(MouseEvent e) {
//		int x = e.getXOnScreen();
//        int y = e.getYOnScreen();
//        Profile.this.setLocation(x - xx, y - xy);
//	}
//	protected void thisContentPaneMousePressed(MouseEvent e) {
//		xx = e.getX();
//        xy = e.getY();
//	}
	protected void lblExitMouseClicked(MouseEvent e) {
		System.exit(0);
	}
	
	public void loadData() {
		EmployeeDAO dao = new EmployeeDAO();
		Employee emp = dao.getUserById(UserLogin.getUserId());
		
		if(emp!= null) {
			lblFullName.setText(emp.getFull_name());
			lblEthnicity.setText(emp.getEthnicity());
			try {
			    // Định dạng LocalDate sang String với mẫu phù hợp
			    String formattedDate = emp.getDate_of_birth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			    // Thiết lập text cho JLabel
			    lblDate.setText(formattedDate);
			  } catch (Exception e) {
			    e.printStackTrace();
			}
			lblGender.setText(emp.getGender());
			lblAddress.setText(emp.getAddress());
			lblSalary.setText(emp.getSalary_level());
		}else {
			
		}
		
	}
}
