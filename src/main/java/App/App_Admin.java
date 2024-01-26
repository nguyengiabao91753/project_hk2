package App;

import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.awt.Image;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Gui.Manage_Departments;
import Gui.Work_Schedules;

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


public class App_Admin extends JFrame {
	
	Manage_Departments femp ;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelLateral;
	private JPanel panelTop;
	private JDesktopPane desktopPane;
	private JLabel lblMenu;
	private JLabel lblClose;
	private int xx ,xy;
	private JButton btnSta;
	private JButton btnEmployee;
	private JButton btnAccount;
	private JButton btnWorkSchedule;
	private JButton btnAttendence;
	private JButton btnDepartment;
	private JButton btnEducation;
	private JPanel panelSta;
	private JPanel panelEmp;
	private JPanel panelAcc;
	private JPanel panelWork;
	private JPanel panelAtt;
	private JPanel panelDepart;
	private JPanel panelEdu;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	Work_Schedules work;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App_Admin frame = new App_Admin();
					frame.setLocationRelativeTo(null);
					frame.setUndecorated(true);
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
	public void EsconderBotones() {
		btnSta.setBounds(10, 105, 187, 37);
		btnSta.setText("");
		btnEmployee.setBounds(10, 150, 187, 37);
		btnEmployee.setText("");
		btnAccount.setBounds(10, 185, 187, 37);
		btnAccount.setText("");
		btnWorkSchedule.setBounds(10, 240, 187, 37);
		btnWorkSchedule.setText("");
		btnAttendence.setBounds(10, 285, 187, 37);
		btnAttendence.setText("");
		btnDepartment.setBounds(10, 330, 187, 37);
		btnDepartment.setText("");
		btnEducation.setBounds(10, 375, 187, 37);
		btnEducation.setText("");
	}
	public void mostarBotones() {
		btnSta.setBounds(10, 105, 187, 37);
		btnSta.setText("Statistical");
		btnEmployee.setBounds(10, 150, 187, 37);
		btnEmployee.setText("Employee");
		btnAccount.setBounds(10, 185, 187, 37);
		btnAccount.setText("Acount");
		btnWorkSchedule.setBounds(10, 240, 187, 37);
		btnWorkSchedule.setText("Work Schedule");
		btnAttendence.setBounds(10, 285, 187, 37);
		btnAttendence.setText("Attendance");
		btnDepartment.setBounds(10, 330, 187, 37);
		btnDepartment.setText("Department");
		btnEducation.setBounds(10, 375, 187, 37);
		btnEducation.setText("Education");
	}
	public void opensidebar() {
		panelLateral.setBounds(0,0,219,663);
		panelTop.setBounds(223, 0, 957, 37);
		desktopPane.setBounds(223,37,957,627);
		lblClose.setBounds(901, 7, 46, 20);
		mostarBotones();
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

		panelLateral.setBackground(Color.WHITE);
		panelLateral.setBounds(0,0,219,663);
		contentPane.add(panelLateral);
		
		btnSta = new JButton("<html>\r\n\t<p>\tStatistical</p>\r\n</html>");
		btnSta.setBounds(10, 105, 187, 37);
		btnSta.setFocusPainted(false);
		btnSta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnStaMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnStaMouseExited(e);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnStaMouseClicked(e);
			}
		});
		btnSta.setIcon(new ImageIcon("images\\icons8-chart-24.png"));
		btnSta.setBackground(new Color(255, 255, 255));
		btnSta.setHorizontalAlignment(SwingConstants.LEFT);
		btnSta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		btnSta.setBorderPainted(false);
		
		btnEmployee = new JButton("\tEmployee");
		btnEmployee.setBounds(10, 150, 187, 37);
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
		btnAccount.setBounds(10, 195, 187, 37);
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
		btnWorkSchedule.setBounds(10, 240, 187, 37);
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
		btnAttendence.setBounds(10, 285, 187, 37);
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
		btnDepartment.setBounds(10, 330, 187, 37);
		btnDepartment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDepartmentMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDepartmentMouseExited(e);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDepartmentMouseClicked(e);
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
		
		btnEducation = new JButton("Education");
		btnEducation.setBounds(10, 375, 187, 37);
		btnEducation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEducationMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEducationMouseExited(e);
			}
		});
		btnEducation.setIcon(new ImageIcon("images\\icons8-graduate-24.png"));
		btnEducation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSta_6ActionPerformed(e);
			}
		});
		btnEducation.setHorizontalAlignment(SwingConstants.LEFT);
		btnEducation.setFocusPainted(false);
		btnEducation.setBorderPainted(false);
		btnEducation.setBackground(Color.WHITE);
		
		panelSta = new JPanel();
		panelSta.setBounds(199, 105, 9, 37);
		panelSta.setVisible(false);
		panelSta.setBackground(new Color(102, 0, 255));
		
		panelEmp = new JPanel();
		panelEmp.setBounds(199, 150, 9, 37);
		panelEmp.setVisible(false);
		panelEmp.setBackground(new Color(102, 0, 255));
		
		panelAcc = new JPanel();
		panelAcc.setBounds(199, 195, 9, 37);
		panelAcc.setVisible(false);
		panelAcc.setBackground(new Color(102, 0, 255));
		
		panelWork = new JPanel();
		panelWork.setBounds(199, 240, 9, 37);
		panelWork.setVisible(false);
		panelWork.setBackground(new Color(102, 0, 255));
		
		panelAtt = new JPanel();
		panelAtt.setBounds(199, 285, 9, 37);
		panelAtt.setVisible(false);
		panelAtt.setBackground(new Color(102, 0, 255));
		
		panelDepart = new JPanel();
		panelDepart.setBounds(199, 330, 9, 37);
		panelDepart.setVisible(false);
		panelDepart.setBackground(new Color(102, 0, 255));
		
		panelEdu = new JPanel();
		panelEdu.setBounds(199, 375, 9, 37);
		panelEdu.setVisible(false);
		panelEdu.setBackground(new Color(102, 0, 255));
		panelLateral.setLayout(null);
		panelLateral.add(btnSta);
		panelLateral.add(btnEmployee);
		panelLateral.add(btnAccount);
		panelLateral.add(btnWorkSchedule);
		panelLateral.add(btnAttendence);
		panelLateral.add(btnDepartment);
		panelLateral.add(btnEducation);
		panelLateral.add(panelSta);
		panelLateral.add(panelEmp);
		panelLateral.add(panelAcc);
		panelLateral.add(panelWork);
		panelLateral.add(panelAtt);
		panelLateral.add(panelDepart);
		panelLateral.add(panelEdu);
		
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
		contentPane.add(desktopPane);
	}
	
	public void openWorkSchedule() {
		if(work == null || work.isClosed()) {
			work = new Work_Schedules();
			work.setBounds(0,0,957,626);
			desktopPane.add(work);
			work.show();
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
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		try {
			if(btnSta.isVisible() == true ) {
				panelSta.setVisible(true);
				panelEmp.setVisible(false);
				panelAcc.setVisible(false);
				panelAtt.setVisible(false);
				panelDepart.setVisible(false);
				panelEdu.setVisible(false);
				panelWork.setVisible(false);
			}
			opensidebar();
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	protected void btnStaMouseEntered(MouseEvent e) {
		btnSta.setBackground(new Color(106,90,205));
		btnSta.setForeground(Color.white);
		
	}
	protected void btnStaMouseExited(MouseEvent e) {
		btnSta.setBackground(Color.white);
		btnSta.setForeground(Color.black);
	}
	protected void btnSta_6ActionPerformed(ActionEvent e) {
		try {
			if(btnEducation.isVisible() == true) {
				panelSta.setVisible(false);
				panelEmp.setVisible(false);
				panelAcc.setVisible(false);
				panelAtt.setVisible(false);
				panelDepart.setVisible(false);
				panelEdu.setVisible(true);
				panelWork.setVisible(false);
			}
			opensidebar();
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	protected void btnDepartmentActionPerformed(ActionEvent e) {
		try {
			if(btnDepartment.isVisible() == true) {
				panelSta.setVisible(false);
				panelEmp.setVisible(false);
				panelAcc.setVisible(false);
				panelAtt.setVisible(false);
				panelDepart.setVisible(true);
				panelEdu.setVisible(false);
				panelWork.setVisible(false);
			}
			opensidebar();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	protected void btnEmployeeActionPerformed(ActionEvent e) {
		try {
			if(btnEmployee.isVisible() == true) {
				panelSta.setVisible(false);
				panelEmp.setVisible(true);
				panelAcc.setVisible(false);
				panelAtt.setVisible(false);
				panelDepart.setVisible(false);
				panelEdu.setVisible(false);
				panelWork.setVisible(false);
			}
			opensidebar();
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
	protected void btnEducationMouseEntered(MouseEvent e) {
		btnEducation.setBackground(new Color(106,90,205));
		btnEducation.setForeground(Color.white);
	}
	protected void btnEducationMouseExited(MouseEvent e) {
		btnEducation.setBackground(Color.white);
		btnEducation.setForeground(Color.black);
	}
	protected void btnAccountActionPerformed(ActionEvent e) {
		try {
			if(btnAccount.isVisible() == true) {
				panelSta.setVisible(false);
				panelEmp.setVisible(false);
				panelAcc.setVisible(true);
				panelAtt.setVisible(false);
				panelDepart.setVisible(false);
				panelEdu.setVisible(false);
				panelWork.setVisible(false);
			}
			opensidebar();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	protected void btnWorkScheduleActionPerformed(ActionEvent e) {
		try {
			if(btnWorkSchedule.isVisible() == true) {
				panelSta.setVisible(false);
				panelEmp.setVisible(false);
				panelAcc.setVisible(false);
				panelAtt.setVisible(false);
				panelDepart.setVisible(false);
				panelEdu.setVisible(false);
				panelWork.setVisible(true);
				openWorkSchedule();
			}
			opensidebar();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	protected void btnAttendenceActionPerformed(ActionEvent e) {
		try {
			if(btnAttendence.isVisible() == true) {
				panelSta.setVisible(false);
				panelEmp.setVisible(false);
				panelAcc.setVisible(false);
				panelAtt.setVisible(true);
				panelDepart.setVisible(false);
				panelEdu.setVisible(false);
				panelWork.setVisible(false);
			}
			opensidebar();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	protected void lblMenuMouseClicked(MouseEvent e) {
		if(panelLateral.getBounds().width == 219) {
			panelLateral.setBounds(0,0,68,664);
			panelTop.setBounds(69,0,1130,37);
			desktopPane.setBounds(69,37,1129,627);
			lblClose.setBounds(1055, 7, 46, 20);
			EsconderBotones();
		}else {
			opensidebar();
			
		}
	}
	protected void btnStaMouseClicked(MouseEvent e) {
	}	
	
	
	protected void btnDepartmentMouseClicked(MouseEvent e) {
		if(femp == null || femp.isClosed()) {
			femp = new Manage_Departments() ;
			femp.setBounds(0,0,957,627);
			desktopPane.add(femp);
			femp.show();
		}
	}
}
