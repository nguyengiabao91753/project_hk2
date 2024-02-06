package App;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import User_GUI.Schedule;

import java.awt.SystemColor;

public class App_User extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
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
	public JDesktopPane desktopPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App_User frame = new App_User();
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
	public App_User() {
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
		//getContentPane().add(panel);
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
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\doan_ky2\\images\\icons8-employee-16.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(41, 11, 147, 142);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("FULL NAME");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(198, 42, 242, 39);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(198, 80, 93, 19);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Phone number");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(198, 110, 187, 26);
		panel.add(lblNewLabel_4);
		desktopPane.add(panel);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\doan_ky2\\images\\icons8-test-account-96.png"));
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
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\doan_ky2\\images\\icons8-schedule-96.png"));
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setBackground(new Color(255, 255, 255));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(516, 270, 132, 132);
		desktopPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\doan_ky2\\images\\icons8-attendance-96.png"));
		lblNewLabel_7.setOpaque(true);
		lblNewLabel_7.setBackground(new Color(255, 255, 255));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(681, 270, 132, 132);
		desktopPane.add(lblNewLabel_7);
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\doan_ky2\\images\\icons8-salary-96.png"));
		lblNewLabel_9.setOpaque(true);
		lblNewLabel_9.setBackground(new Color(255, 255, 255));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(439, 442, 132, 132);
		desktopPane.add(lblNewLabel_9);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\doan_ky2\\images\\icons8-address-96.png"));
		lblNewLabel_8.setOpaque(true);
		lblNewLabel_8.setBackground(new Color(255, 255, 255));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(601, 442, 132, 132);
		desktopPane.add(lblNewLabel_8);
		
		lblprofile = new JLabel("Profile");
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
		lblAttendance.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttendance.setForeground(new Color(51, 102, 153));
		lblAttendance.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAttendance.setBounds(698, 400, 98, 31);
		desktopPane.add(lblAttendance);
		
		lblSalary = new JLabel("Salary");
		lblSalary.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalary.setForeground(new Color(51, 102, 153));
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSalary.setBounds(456, 565, 98, 31);
		desktopPane.add(lblSalary);
		
		lblLocation = new JLabel("Location");
		lblLocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocation.setForeground(new Color(51, 102, 153));
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLocation.setBounds(618, 576, 98, 31);
		desktopPane.add(lblLocation);
		
		
		
	}
	protected void lblNewLabelMouseClicked(MouseEvent e) {
		System.exit(0);
	}
	protected void lblNewLabel_6MouseClicked(MouseEvent e) {
		
		if(schedule == null || schedule.isClosed()) {
			schedule = new Schedule();
			schedule.setAppus(this);
			schedule.setBounds(0, 0, 1180, 664);
			schedule.show();
			Component[] frames = desktopPane.getComponents();
	        for (Component frame : frames) {
	            frame.setVisible(false);
	        }
			desktopPane.add(schedule);
			//this.setVisible(false);
		}
	}
	protected void lblScheduleMouseClicked(MouseEvent e) {
		
		if(schedule == null || schedule.isClosed()) {
			schedule = new Schedule();
			schedule.setAppus(this);
			schedule.setBounds(0, 0, 1180, 664);
			schedule.show();
			Component[] frames = desktopPane.getComponents();
	        for (Component frame : frames) {
	            frame.setVisible(false);
	        }
			desktopPane.add(schedule);
			
			//this.setVisible(false);
		}
	}
}

	
	
	