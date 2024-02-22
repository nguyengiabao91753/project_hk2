package App;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

//import org.openqa.selenium.html5.Location;

import User_GUI.Attendance;

import User_GUI.Profile;

import User_GUI.Locations;

import User_GUI.Schedule;
import User_GUI.UserLogin;
import dao.AccountDAO;
import dao.EmployeeDAO;
import entity.Employee;
import entity.Salary;

import java.awt.SystemColor;

public class App_User extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblPicture;
	private JLabel lblFullName;
	private JLabel lblGender;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_8;
	private JLabel lblprofile;
	private JLabel lblSchedule;
	private JLabel lblAttendance;
	private JLabel lblSalary;
	private JLabel lblLocation;
	Schedule schedule;
	User_GUI.Salary sa;
	Attendance att;

	Profile pro ;

	Locations Loc ;


	UserLogin userLogin;
	Employee emp;
	private int xx, xy;

	public static JDesktopPane desktopPane;
//	private int userId;
	private JLabel lblPosition;


//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (!UserLogin.isLoggedIn()) {
			            JOptionPane.showMessageDialog(null, "Please log in first.");
			        }else {
						App_User frame = new App_User();
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
	 *  
	 */
	public App_User() {

		getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				thisContentPaneMouseDragged(e);
			}
		});
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				thisContentPaneMousePressed(e);
			}
		});
		getContentPane().setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1180, 664);
		getContentPane().setLayout(null);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 255, 255));
		desktopPane.setBounds(0, 0, 1180, 664);
		getContentPane().add(desktopPane);
		
		
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 1180, 239);
//		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("<html>\r\n\t<p style=\"font-size: 24px;color:white\">&#10006;</p>\r\n</html>");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabelMouseClicked(e);
			}
		});
		lblNewLabel.setBounds(1127, 11, 46, 27);
		panel.add(lblNewLabel);
		
		lblPicture = new JLabel("");
		lblPicture.setIcon(new ImageIcon("images\\icons8-employee-16.png"));
		lblPicture.setHorizontalAlignment(SwingConstants.CENTER);
		lblPicture.setBounds(27, 33, 147, 164);
		panel.add(lblPicture);
		
		lblFullName = new JLabel("Full Name");
		lblFullName.setForeground(new Color(255, 255, 255));
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblFullName.setBounds(198, 33, 242, 27);
		panel.add(lblFullName);
		
		lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(255, 255, 255));
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblGender.setBounds(198, 103, 242, 27);
		panel.add(lblGender);
		desktopPane.add(panel);
		
		lblPosition = new JLabel("Position");
		lblPosition.setForeground(new Color(255, 255, 255));
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPosition.setBounds(198, 170, 242, 27);
		panel.add(lblPosition);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_5MouseClicked(e);
			}
		});
		lblNewLabel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_5.setIcon(new ImageIcon("images\\icons8-test-account-96.png"));
		lblNewLabel_5.setBackground(new Color(255, 255, 255));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(357, 270, 132, 132);
		desktopPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_6MouseClicked(e);
			}
		});
		lblNewLabel_6.setIcon(new ImageIcon("images\\icons8-schedule-96.png"));
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setBackground(new Color(255, 255, 255));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(516, 270, 132, 132);
		desktopPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("");

		lblNewLabel_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_7MouseClicked(e);
			}
		});
		lblNewLabel_7.setIcon(new ImageIcon("images\\icons8-attendance-96.png"));

		lblNewLabel_7.setIcon(new ImageIcon("images\\icons8-attendance-96.png"));

		lblNewLabel_7.setOpaque(true);
		lblNewLabel_7.setBackground(new Color(255, 255, 255));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(675, 270, 132, 132);
		desktopPane.add(lblNewLabel_7);
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_9MouseClicked(e);
			}
		});
		lblNewLabel_9.setIcon(new ImageIcon("images\\icons8-salary-96.png"));
		lblNewLabel_9.setOpaque(true);
		lblNewLabel_9.setBackground(new Color(255, 255, 255));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(439, 442, 132, 132);
		desktopPane.add(lblNewLabel_9);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_8MouseClicked(e);
			}
		});
		lblNewLabel_8.setIcon(new ImageIcon("images\\icons8-address-96.png"));
		lblNewLabel_8.setOpaque(true);
		lblNewLabel_8.setBackground(new Color(255, 255, 255));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(601, 442, 132, 132);
		desktopPane.add(lblNewLabel_8);
		
		lblprofile = new JLabel("Profile");
		lblprofile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblprofileMouseClicked(e);
			}
		});
		lblprofile.setForeground(new Color(51, 102, 153));
		lblprofile.setHorizontalAlignment(SwingConstants.CENTER);
		lblprofile.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblprofile.setBounds(374, 398, 98, 31);
		desktopPane.add(lblprofile);
		
		lblSchedule = new JLabel("Schedule");
		lblSchedule.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSchedule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblScheduleMouseClicked(e);
			}
		});
		lblSchedule.setHorizontalAlignment(SwingConstants.CENTER);
		lblSchedule.setForeground(new Color(51, 102, 153));
		lblSchedule.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSchedule.setBounds(533, 400, 98, 31);
		desktopPane.add(lblSchedule);
		
		lblAttendance = new JLabel("Attendance");
		lblAttendance.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAttendance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblAttendanceMouseClicked(e);
			}
		});
		lblAttendance.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttendance.setForeground(new Color(51, 102, 153));
		lblAttendance.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAttendance.setBounds(698, 400, 98, 31);
		desktopPane.add(lblAttendance);
		
		lblSalary = new JLabel("Salary");
		lblSalary.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSalary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSalaryMouseClicked(e);
			}
		});
		lblSalary.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalary.setForeground(new Color(51, 102, 153));
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSalary.setBounds(456, 565, 98, 31);
		desktopPane.add(lblSalary);
		
		lblLocation = new JLabel("Locations");
		lblLocation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblLocationMouseClicked(e);
			}
		});
		lblLocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocation.setForeground(new Color(51, 102, 153));
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLocation.setBounds(618, 576, 98, 31);
		desktopPane.add(lblLocation);
		displayUserInfo();
	}
	protected void lblNewLabelMouseClicked(MouseEvent e) {
		System.exit(0);
	}
	protected void lblNewLabel_6MouseClicked(MouseEvent e) {
		
		if(schedule == null || schedule.isClosed()) {
			schedule = new Schedule();
			
			schedule.setBounds(0, 0, 1180, 664);
			desktopPane.add(schedule);
			schedule.show();
			schedule.toFront();
	        schedule.setVisible(true); 
	    }
	}
	protected void lblScheduleMouseClicked(MouseEvent e) {
		
		if(schedule == null || schedule.isClosed()) {
			schedule = new Schedule();
			
			schedule.setBounds(0, 0, 1180, 664);
			desktopPane.add(schedule);
			schedule.show();
			schedule.toFront();
			schedule.setVisible(true);

		}
	}

	protected void lblNewLabel_7MouseClicked(MouseEvent e) {
		if(att == null || att.isClosed()) {
			att = new Attendance();

			att.setBounds(0, 0, 1180, 664);
			desktopPane.add(att);
			att.show();
			att.toFront();
		}
	}
	protected void lblAttendanceMouseClicked(MouseEvent e) {
		if(att == null || att.isClosed()) {
			att = new Attendance();
			att.setBounds(0, 0, 1180, 664);
			desktopPane.add(att);
			att.show();
			att.toFront();
		}
	}

	protected void thisContentPaneMousePressed(MouseEvent e) {
		xx = e.getX();
        xy = e.getY();
	}
	protected void thisContentPaneMouseDragged(MouseEvent e) {
		int x = e.getXOnScreen();
        int y = e.getYOnScreen();
        App_User.this.setLocation(x - xx, y - xy);
	}
	private void displayUserInfo() {
	    EmployeeDAO dao = new EmployeeDAO();
	    Employee emp = dao.getUserById(UserLogin.getUserId());

	    if (emp != null) {
	        lblFullName.setText(emp.getFull_name());
	        lblGender.setText(emp.getGender());
	        ImageIcon icon = new ImageIcon(emp.getPicture());
	        Image image = icon.getImage();
            Image scaledImage = image.getScaledInstance(lblPicture.getWidth(), lblPicture.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            lblPicture.setIcon(scaledIcon);
	    } else {
	    	JOptionPane.showMessageDialog(this, "User information not found!");
	    }

	}
	protected void lblNewLabel_5MouseClicked(MouseEvent e) {
		if(pro == null || pro.isClosed()) {
	        pro = new Profile();
	        pro.setBounds(0, 0, 1180, 664);
	        pro.show();
	        desktopPane.add(pro);
	        pro.toFront();
	    	pro.setVisible(true);
	    }
	}
	protected void lblprofileMouseClicked(MouseEvent e) {
		if(pro == null || pro.isClosed()) {
	        pro = new Profile();
	        pro.setBounds(0, 0, 1180, 664);
	        pro.show();
	        desktopPane.add(pro);
	        pro.toFront();
	    	pro.setVisible(true);
	    }
	}
	protected void lblLocationMouseClicked(MouseEvent e) {
		if(Loc == null || Loc.isClosed()) {
			Loc = new Locations();
			
			Loc.setBounds(0, 0, 1180, 664);
			Loc.show();
			Component[] frames = desktopPane.getComponents();
	        for (Component frame : frames) {
	            frame.setVisible(false);
	        }
			desktopPane.add(Loc);
		}
	}
	protected void lblNewLabel_8MouseClicked(MouseEvent e) {
		if(Loc == null || Loc.isClosed()) {
			Loc = new Locations();
			
			Loc.setBounds(0, 0, 1180, 664);
			Loc.show();
			Component[] frames = desktopPane.getComponents();
	        for (Component frame : frames) {
	            frame.setVisible(false);
	        }
			desktopPane.add(Loc);
		}
	}

	protected void lblNewLabel_9MouseClicked(MouseEvent e) {
		if(sa == null || sa.isClosed()) {
			sa = new User_GUI.Salary();
			sa.setBounds(0, 0, 1180, 664);
			desktopPane.add(sa);
			sa.show();
			sa.toFront();
		}
	}
	protected void lblSalaryMouseClicked(MouseEvent e) {
		if(sa == null || sa.isClosed()) {
			sa = new User_GUI.Salary();
			sa.setBounds(0, 0, 1180, 664);
			desktopPane.add(sa);
			sa.show();
			sa.toFront();
		}
	}
}

	
	
	
