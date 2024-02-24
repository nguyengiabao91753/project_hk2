package App;

import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.awt.Image;


import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Gui.Manage_Departments;

import Gui.EmployeeForm;
import Gui.Job_Position;
import Gui.Statistical;
import Gui.Accounts;
import Gui.Atiendances;

import Gui.Work_Schedules;
import User_GUI.UserLogin;
import crud.AddDepartment;
import crud.Addaccount;
import crud.Addemployee;
import dao.EmployeeDAO;
import entity.Employee;

import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;	

import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextArea;



public class App_Admin extends JFrame {
	EmployeeForm femp ;
	Manage_Departments dep;
	Job_Position Pos ;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelLateral;
	private JPanel panelTop;
	public JDesktopPane desktopPane;
	private JLabel lblMenu;
	private JLabel lblClose;
	private int xx ,xy;
	private JButton btnEmployee;
	private JButton btnAccount;
	private JButton btnWorkSchedule;
	private JButton btnAttendence;
	private JButton btnDepartment;
	private JPanel panelEmp;
	private JPanel panelAcc;
	private JPanel panelWork;
	private JPanel panelAtt;
	private JPanel panelDepart;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	Work_Schedules work;
	Atiendances attendance;
	private JButton btnPosition;
	private JPanel panelPos;
	Accounts acc;
	Addemployee aemp;
	Statistical sta;
	private JLabel lblName;

	private JPanel panelhello;
	private JLabel lblHello;
	private JLabel lblPicture;
	private JLabel lblPattern;
	private JTextArea txtrtext;
	private JLabel lblMail;
	private JLabel lblWish;
	private JPanel panel_1;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (!AdminLogin.isLoggedIn()) {
			            JOptionPane.showMessageDialog(null, "Please log in first.");
			        }else {
					App_Admin frame = new App_Admin();
					frame.setLocationRelativeTo(null);
					frame.setUndecorated(true);
					frame.setVisible(true);
			        }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public void EsconderBotones() {
		
		btnEmployee.setBounds(10, 105, 187, 37);
		btnEmployee.setText("");
		btnAccount.setBounds(10, 150, 187, 37);
		btnAccount.setText("");
		btnWorkSchedule.setBounds(10, 195, 187, 37);
		btnWorkSchedule.setText("");
		btnAttendence.setBounds(10, 240, 187, 37);
		btnAttendence.setText("");
		btnDepartment.setBounds(10, 285, 187, 37);
		btnDepartment.setText("");
		btnPosition.setBounds(10, 330, 187, 37);
		btnPosition.setText("");
	}
	
	public void mostarBotones() {
		btnEmployee.setBounds(10, 105, 187, 37);
		btnEmployee.setText("Employee");
		btnAccount.setBounds(10, 150, 187, 37);
		btnAccount.setText("Acount");
		btnWorkSchedule.setBounds(10, 195, 187, 37);
		btnWorkSchedule.setText("Work Schedule");
		btnAttendence.setBounds(10, 240, 187, 37);
		btnAttendence.setText("Attendance");
		btnDepartment.setBounds(10, 285, 187, 37);
		btnDepartment.setText("Department");
		btnPosition.setBounds(10, 330, 187, 37);
		btnPosition.setText("Position");	
	}
	
	public void opensidebar() {
		panelLateral.setBounds(0,0,219,663);
		panelTop.setBounds(223, 0, 957, 37);
		desktopPane.setBounds(223,37,957,627);
		panelhello.setBounds(0, 0, 957, 626);
		lblClose.setBounds(901, 7, 46, 20);
		mostarBotones();
	}
	
	public void hidehello() {
		JInternalFrame[] frames = desktopPane.getAllFrames();
	      if(frames != null) {
	    	  lblPicture.setVisible(false);
				lblHello.setVisible(false);
				lblName.setVisible(false);
				lblPattern.setVisible(false);
				txtrtext.setVisible(false);
				txtrtext.setVisible(false);
				lblMail.setVisible(false);
				lblWish.setVisible(false);
				panel_1.setVisible(false);
	      }
	}
	
	public App_Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1180, 664);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				contentPaneMousePressed(e);
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				contentPaneMouseDragged(e);
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelLateral = new JPanel();
		panelLateral.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));



		panelLateral.setBackground(Color.WHITE);
		panelLateral.setBounds(10,0,219,663);
		contentPane.add(panelLateral);
		
		btnEmployee = new JButton("\tEmployee");
		btnEmployee.setBounds(10, 105, 187, 37);
		btnEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEmployeeMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEmployeeMouseExited(e);
			}
		});
		btnEmployee.setIcon(new ImageIcon("images\\icons8-employee-24.png"));
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEmployeeActionPerformed(e);
			}
		});
		btnEmployee.setHorizontalAlignment(SwingConstants.LEFT);
		btnEmployee.setFocusPainted(false);
		btnEmployee.setBorderPainted(false);
		btnEmployee.setBackground(Color.WHITE);
		
		btnAccount = new JButton("Account");
		btnAccount.setBounds(10, 150, 187, 37);
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAccountActionPerformed(e);
			}
		});
		btnAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAccountMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAccountMouseExited(e);
			}
		});
		btnAccount.setIcon(new ImageIcon("images\\icons8-employee-24 (1).png"));
		btnAccount.setHorizontalAlignment(SwingConstants.LEFT);
		btnAccount.setFocusPainted(false);
		btnAccount.setBorderPainted(false);
		btnAccount.setBackground(Color.WHITE);
		
		btnWorkSchedule = new JButton("Work Schedule");
		btnWorkSchedule.setBounds(10, 195, 187, 37);
		btnWorkSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnWorkScheduleActionPerformed(e);
			}
		});
		btnWorkSchedule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnWorkScheduleMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnWorkScheduleMouseExited(e);
			}
		});
		btnWorkSchedule.setIcon(new ImageIcon("images\\icons8-schedule-26.png"));
		btnWorkSchedule.setHorizontalAlignment(SwingConstants.LEFT);
		btnWorkSchedule.setFocusPainted(false);
		btnWorkSchedule.setBorderPainted(false);
		btnWorkSchedule.setBackground(Color.WHITE);
		
		btnAttendence = new JButton("Attendance");
		btnAttendence.setBounds(10, 240, 187, 37);
		btnAttendence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAttendenceActionPerformed(e);
			}
		});
		btnAttendence.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAttendenceMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAttendenceMouseExited(e);
			}
		});
		btnAttendence.setIcon(new ImageIcon("images\\icons8-attendance-25.png"));
		btnAttendence.setHorizontalAlignment(SwingConstants.LEFT);
		btnAttendence.setFocusPainted(false);
		btnAttendence.setBorderPainted(false);
		btnAttendence.setBackground(Color.WHITE);
		
		btnDepartment = new JButton("Department");
		btnDepartment.setBounds(10, 285, 187, 37);
		btnDepartment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDepartmentMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDepartmentMouseExited(e);
			}
		});
		btnDepartment.setIcon(new ImageIcon("images\\icons8-hospital-24.png"));
		btnDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDepartmentActionPerformed(e);
			}
		});
		btnDepartment.setHorizontalAlignment(SwingConstants.LEFT);
		btnDepartment.setFocusPainted(false);
		btnDepartment.setBorderPainted(false);
		btnDepartment.setBackground(Color.WHITE);
		
		panelEmp = new JPanel();
		panelEmp.setBounds(199, 105, 9, 37);
		panelEmp.setVisible(false);
		panelEmp.setBackground(new Color(102, 0, 255));
		
		panelAcc = new JPanel();
		panelAcc.setBounds(199, 150, 9, 37);
		panelAcc.setVisible(false);
		panelAcc.setBackground(new Color(102, 0, 255));
		
		panelWork = new JPanel();
		panelWork.setBounds(199, 195, 9, 37);
		panelWork.setVisible(false);
		panelWork.setBackground(new Color(102, 0, 255));
		
		panelAtt = new JPanel();
		panelAtt.setBounds(199, 240, 9, 37);
		panelAtt.setVisible(false);
		panelAtt.setBackground(new Color(102, 0, 255));
		
		panelDepart = new JPanel();
		panelDepart.setBounds(199, 285, 9, 37);
		panelDepart.setVisible(false);
		panelDepart.setBackground(new Color(102, 0, 255));
		panelLateral.setLayout(null);
		panelLateral.add(btnEmployee);
		panelLateral.add(btnAccount);
		panelLateral.add(btnWorkSchedule);
		panelLateral.add(btnAttendence);
		panelLateral.add(btnDepartment);
		panelLateral.add(panelEmp);
		panelLateral.add(panelAcc);
		panelLateral.add(panelWork);
		panelLateral.add(panelAtt);
		panelLateral.add(panelDepart);
		panel = new JPanel();
		panel.setBounds(78, 72, 117, 4);
		panelLateral.add(panel);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("images\\icons8-hospital-48.png"));
		lblNewLabel.setBounds(5, 11, 50, 50);
		panelLateral.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("B.Y.D");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(70, 24, 46, 14);
		panelLateral.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Mangement System");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(80, 47, 120, 14);
		panelLateral.add(lblNewLabel_2);
		
		btnPosition = new JButton("Position");
		btnPosition.setIcon(new ImageIcon("images\\icons8-position-24.png"));
		btnPosition.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPositionMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPositionMouseExited(e);
			}
		});
		btnPosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPositionActionPerformed(e);
			}
		});
		btnPosition.setHorizontalAlignment(SwingConstants.LEFT);
		btnPosition.setFocusPainted(false);
		btnPosition.setBorderPainted(false);
		btnPosition.setBackground(Color.WHITE);
		btnPosition.setBounds(10, 330, 187, 37);
		panelLateral.add(btnPosition);
		
		panelPos = new JPanel();
		panelPos.setVisible(false);
		panelPos.setBackground(new Color(102, 0, 255));
		panelPos.setBounds(199, 330, 9, 37);
		panelLateral.add(panelPos);
		panelPos.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelTop = new JPanel();
		panelTop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelTop.setBackground(new Color(102, 0, 255));
		panelTop.setBounds(223, 0, 957, 37);
		contentPane.add(panelTop);
		panelTop.setLayout(null);

		
		lblMenu = new JLabel("<html>\r\n\t<p style=\"font-size:24;color: white\">&#9776;</p>\r\r\n</html>");
		lblMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMenuMouseClicked(e);
			}
		});
		lblMenu.setBounds(13, 8, 46, 22);
		panelTop.add(lblMenu);
		
		lblClose = new JLabel("<html>\r\n\t<p style=\"font-size: 24px;color:white\">&#10006;</p>\r\n</html>");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblClose(e);
			}
		});
		lblClose.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblClose.setBounds(901, 7, 46, 20);
		panelTop.add(lblClose);
		
		desktopPane = new JDesktopPane();
		desktopPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		desktopPane.setBounds(223, 48, 957, 626);
		desktopPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		desktopPane.setBounds(223, 37, 957, 626);
		contentPane.add(desktopPane);
		
		panelhello = new JPanel();
		panelhello.setBackground(new Color(248, 248, 255));
		panelhello.setBounds(0, 0, 957, 626);
		desktopPane.add(panelhello);
		panelhello.setLayout(null);
		
		lblHello = new JLabel("HELLO,");
		lblHello.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		lblHello.setFont(new Font("STKaiti", Font.BOLD, 26));
		lblHello.setBounds(106, 49, 99, 72);
		panelhello.add(lblHello);
		
		lblName = new JLabel("BAO NGUYEN");
		lblName.setForeground(new Color(51, 102, 255));
		lblName.setFont(new Font("STKaiti", Font.BOLD, 26));
		lblName.setBounds(215, 49, 218, 72);
		panelhello.add(lblName);
		
		lblPicture = new JLabel("");
		lblPicture.setHorizontalAlignment(SwingConstants.CENTER);
		lblPicture.setIcon(new ImageIcon("images\\icons8-boss-100.png"));
		lblPicture.setBounds(701, 39, 210, 219);
		panelhello.add(lblPicture);
		
		lblPattern = new JLabel("");
		lblPattern.setIcon(new ImageIcon("images\\icons8-confetti-64.png"));
		lblPattern.setHorizontalAlignment(SwingConstants.CENTER);
		lblPattern.setBounds(10, 21, 107, 100);
		panelhello.add(lblPattern);
		
		lblMail = new JLabel(" bydcompany@system.com");
		lblMail.setForeground(new Color(0, 102, 255));
		lblMail.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblMail.setBounds(316, 176, 230, 26);
		panelhello.add(lblMail);
		
		txtrtext = new JTextArea();
		txtrtext.setBackground(new Color(248, 248, 255));
		txtrtext.setForeground(SystemColor.textInactiveText);
		txtrtext.setFont(new Font("Monospaced", Font.PLAIN, 19));
		txtrtext.setLineWrap(true);
		txtrtext.setWrapStyleWord(true);
		txtrtext.setText("Welcome to the information management system of B.Y.D.\nIf any errors or issues occur during your work, please report them to us via this email:");
		txtrtext.setRows(2);
		txtrtext.setBounds(29, 121, 685, 82);
		panelhello.add(txtrtext);
		
		lblWish = new JLabel("Wishing you a productive day!");
		lblWish.setFont(new Font("STZhongsong", Font.PLAIN, 19));
		lblWish.setBounds(37, 203, 327, 49);
		panelhello.add(lblWish);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(0, 540, 957, 86);
		panelhello.add(panel_1);
		loadAdminInfo();
	}
	
	private void loadAdminInfo() {
		EmployeeDAO dao = new EmployeeDAO();
		Employee emp = dao.getUserById(AdminLogin.getAdminId());
		lblName.setText(emp.getFull_name());
		ImageIcon icon = new ImageIcon(emp.getPicture());
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(lblPicture.getWidth(), lblPicture.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        lblPicture.setIcon(scaledIcon);
	}
	
	public void openWorkSchedule() {
		JInternalFrame[] frames = desktopPane.getAllFrames();
        for (JInternalFrame frame : frames) {
            frame.doDefaultCloseAction();
        }
		if(work == null || work.isClosed()) {
			work = new Work_Schedules();
			work.setBounds(0,0,957,626);
			desktopPane.add(work);
			work.setApp(this);
			work.show();
		}
	}
	public void openDepart() {
		JInternalFrame[] frames = desktopPane.getAllFrames();
        for (JInternalFrame frame : frames) {
            frame.doDefaultCloseAction();
        }
		if(dep == null || dep.isClosed()) {
			dep = new Manage_Departments() ;
			dep.setBounds(0,0,957,626);
			desktopPane.add(dep);
			dep.setApp(this);
			dep.show();
		}
	}	public void openPos() {
		JInternalFrame[] frames = desktopPane.getAllFrames();
        for (JInternalFrame frame : frames) {
            frame.doDefaultCloseAction();
        }
        if(Pos == null || Pos.isClosed()) {
        	Pos = new Job_Position();
        	Pos.setBounds(0, 0,957,626);
        	desktopPane.add(Pos);
        	Pos.setApp(this);
        	Pos.show();
        }
	}
	public void openAttendance() {
		JInternalFrame[] frames = desktopPane.getAllFrames();
        for (JInternalFrame frame : frames) {
            frame.doDefaultCloseAction();
        }
		if(attendance == null || attendance.isClosed()) {
			attendance = new Atiendances();
			attendance.setBounds(0,0,957,626);
			
			desktopPane.add(attendance);
			attendance.show();
		}
	}
	
	public void openStatistical() {
		JInternalFrame[] frames = desktopPane.getAllFrames();
        for (JInternalFrame frame : frames) {
            frame.doDefaultCloseAction();
        }
        if(sta == null || sta.isClosed()) {
        	sta = new Statistical();
        	sta.setBounds(0,0,957,626);
        	
        	desktopPane.add(sta);
        	sta.show();
        }
	}
	
	protected void lblClose(MouseEvent e) {
		System.exit(0);
	}
	
	protected void contentPaneMouseDragged(MouseEvent e) {
		int x = e.getXOnScreen();
        int y = e.getYOnScreen();
        App_Admin.this.setLocation(x - xx, y - xy);
	}
	
	protected void contentPaneMousePressed(MouseEvent e) {
		xx = e.getX();
        xy = e.getY();
	}
	protected void btnDepartmentActionPerformed(ActionEvent e) {
		try {
			if(btnDepartment.isVisible() == true) {
		
				panelEmp.setVisible(false);
				panelAcc.setVisible(false);
				panelAtt.setVisible(false);
				panelDepart.setVisible(true);
				panelWork.setVisible(false);
				panelPos.setVisible(false);
			}
			opensidebar();
			openDepart();
			hidehello();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	protected void btnEmployeeActionPerformed(ActionEvent e) {
		try {
			if(btnEmployee.isVisible() == true) {
				
				panelEmp.setVisible(true);
				panelAcc.setVisible(false);
				panelAtt.setVisible(false);
				panelDepart.setVisible(false);
				
				panelWork.setVisible(false);
				panelPos.setVisible(false);
			}
			opensidebar();
			loadEmployeeForm();
			hidehello();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	protected void btnEmployeeMouseEntered(MouseEvent e) {
		btnEmployee.setBackground(new Color(106,90,205));
		btnEmployee.setForeground(Color.white);
	}
	protected void btnEmployeeMouseExited(MouseEvent e) {
		btnEmployee.setBackground(Color.white);
		btnEmployee.setForeground(Color.black);
	}
	protected void btnAccountMouseEntered(MouseEvent e) {
		btnAccount.setBackground(new Color(106,90,205));
		btnAccount.setForeground(Color.white);
	}
	protected void btnAccountMouseExited(MouseEvent e) {
		btnAccount.setBackground(Color.white);
		btnAccount.setForeground(Color.black);
	}
	protected void btnWorkScheduleMouseEntered(MouseEvent e) {
		btnWorkSchedule.setBackground(new Color(106,90,205));
		btnWorkSchedule.setForeground(Color.white);
	}
	protected void btnWorkScheduleMouseExited(MouseEvent e) {
		btnWorkSchedule.setBackground(Color.white);
		btnWorkSchedule.setForeground(Color.black);
	}
	protected void btnAttendenceMouseEntered(MouseEvent e) {
		btnAttendence.setBackground(new Color(106,90,205));
		btnAttendence.setForeground(Color.white);
	}
	protected void btnAttendenceMouseExited(MouseEvent e) {
		btnAttendence.setBackground(Color.white);
		btnAttendence.setForeground(Color.black);
	}
	protected void btnDepartmentMouseEntered(MouseEvent e) {
		btnDepartment.setBackground(new Color(106,90,205));
		btnDepartment.setForeground(Color.white);
	}
	protected void btnDepartmentMouseExited(MouseEvent e) {
		btnDepartment.setBackground(Color.white);
		btnDepartment.setForeground(Color.black);
	}
	protected void btnAccountActionPerformed(ActionEvent e) {
		try {
			if(btnAccount.isVisible() == true) {
			
				panelEmp.setVisible(false);
				panelAcc.setVisible(true);
				panelAtt.setVisible(false);
				panelDepart.setVisible(false);
				
				panelWork.setVisible(false);
				panelPos.setVisible(false);
			}
			opensidebar();
			loadAccountForm();
			hidehello();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	
	protected void btnWorkScheduleActionPerformed(ActionEvent e) {
		try {
			if(btnWorkSchedule.isVisible() == true) {
				
				panelEmp.setVisible(false);
				panelAcc.setVisible(false);
				panelAtt.setVisible(false);
				panelDepart.setVisible(false);
				panelWork.setVisible(true);
				panelPos.setVisible(false);
				openWorkSchedule();
			}
			opensidebar();
			hidehello();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	
	protected void btnAttendenceActionPerformed(ActionEvent e) {
		try {
			if(btnAttendence.isVisible() == true) {
			
				panelEmp.setVisible(false);
				panelAcc.setVisible(false);
				panelAtt.setVisible(true);
				panelDepart.setVisible(false);
				
				panelWork.setVisible(false);
				panelPos.setVisible(false);
				openAttendance();
			}
			opensidebar();
			hidehello();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	public void autoresizeJInternal() {
		JInternalFrame[] frames = desktopPane.getAllFrames();
        for (JInternalFrame frame : frames) {
            frame.setSize(desktopPane.getSize());
        }
	}
	public void panelHellomenu() {
		if(panelhello.getBounds().width ==957) {
			lblPicture.setBounds(701, 39, 210, 219);
			lblHello.setBounds(37, 51, 99, 72);
			lblName.setBounds(146, 51, 218, 72);
			lblPattern.setBounds(335, 39, 75, 100);
			txtrtext.setBounds(29, 121, 685, 82);
			txtrtext.setBounds(29, 121, 685, 82);
			lblMail.setBounds(316, 176, 230, 26);
			lblWish.setBounds(37, 203, 327, 49);
			panel_1.setBounds(0, 540, 957, 86);
		}else {
			lblPicture.setBounds(855, 39, 210, 219);
			lblHello.setBounds(191, 51, 99, 72);
			lblName.setBounds(300, 51, 218, 72);
			lblPattern.setBounds(489, 39, 75, 100);
			txtrtext.setBounds(183, 121, 685, 82);
			txtrtext.setBounds(183, 121, 685, 82);
			lblMail.setBounds(470, 176, 230, 26);
			lblWish.setBounds(191, 203, 327, 49);
			panel_1.setBounds(0, 540, 1129, 86);
		}
	}
	protected void lblMenuMouseClicked(MouseEvent e) {
		if(panelLateral.getBounds().width == 219) {
			panelLateral.setBounds(0,0,68,664);
			panelTop.setBounds(69,0,1130,37);
			desktopPane.setBounds(69,37,1129,627);
			panelhello.setBounds(0,0,1129,627);
			lblClose.setBounds(1055, 7, 46, 20);
			autoresizeJInternal();
			panelHellomenu();
			EsconderBotones();
		}else {
			opensidebar();
			JInternalFrame[] frames = desktopPane.getAllFrames();
		       for (JInternalFrame frame : frames) {
		            frame.setBounds(0, 0, 957, 627);
		       }
			panelHellomenu();
		}
	}
	
	protected void btnPositionActionPerformed(ActionEvent e) {
		try {
			if(btnPosition.isVisible() == true) {
				
				panelEmp.setVisible(false);
				panelAcc.setVisible(false);
				panelAtt.setVisible(false);
				panelDepart.setVisible(false);
				
				panelWork.setVisible(false);
				panelPos.setVisible(true);
				openPos();
			}
			opensidebar();
			hidehello();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	protected void btnPositionMouseEntered(MouseEvent e) {
		btnPosition.setBackground(new Color(106,90,205));
		btnPosition.setForeground(Color.white);
	}
	protected void btnPositionMouseExited(MouseEvent e) {
		btnPosition.setBackground(Color.white);
		btnPosition.setForeground(Color.black);
		
	}
	
	public void loadEmployeeForm() {
		JInternalFrame[] frames = desktopPane.getAllFrames();
        for (JInternalFrame frame : frames) {
            frame.doDefaultCloseAction();
        }
		
		if (femp == null || femp.isClosed()) {
	        femp = new EmployeeForm();
	        femp.setBounds(0, 0, 957, 627);
	        desktopPane.add(femp);
	        femp.setApp(this);	
	        femp.show();
	    }
		
	}
	void loadAccountForm() {
		JInternalFrame[] frames = desktopPane.getAllFrames();
        for (JInternalFrame frame : frames) {
            frame.doDefaultCloseAction();
        }
        
        if (acc == null || acc.isClosed()) {
	        acc = new Accounts();
	        acc.setBounds(0, 0, 957, 627);
	        desktopPane.add(acc);
	        acc.setApp(this);
	        acc.show();
	    }	
	}
}
