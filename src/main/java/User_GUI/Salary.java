package User_GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import dao.AttendanceDAO;
import dao.EmployeeDAO;
import dao.SalaryDAO;
import dao.ShiftDAO;
import dao.WorkscheduleDAO;
import entity.Attendance;
import entity.Employee;
import entity.Shift;
import entity.Workschedule;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Salary extends JInternalFrame {

	private JComponent Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarca =null;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JPanel panelContent;
	private JLabel lblBaseSalary;
	private JLabel lblSalaryFactor;
	private JLabel lblAllowance;
	private JLabel lblBS;
	private JLabel lblSF;
	private JLabel lblAF;
	private JLabel lblNewLabel_4;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel lblSalary;
	private JLabel lblLateleaveEarly;
	private JLabel lblOvertime;
	private JLabel lblFOvertime;
	private JLabel lblLateLeave;
	private JLabel lblFSalary;
	private JLabel lblTotal;
	private JLabel lblFTotal;
	private JPanel panel_6;
	private JLabel lblNewLabel_5;
	private JComboBox cbbMonth;
	private JComboBox cbbYear;
	private JLabel lblYear;
	private JLabel lblMonth;
	private JButton btnNewButton;
	private JPanel panel_7;
	private JPanel panel_8;
	AttendanceDAO attdao=new AttendanceDAO();
	private JLabel lblAbsent;
	private JLabel lblFAsent;
	public int sa;
	public float saperday;
	LocalDate currentDate = LocalDate.now();
	private JLabel lbldola;
	private JLabel lbldola_1;
	private JLabel lbldola_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salary frame = new Salary();
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
	public Salary() {
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		quit();
		
		setBounds(100, 100, 1180, 664);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 1180, 101);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("<html>\r\n\t<p style=\"font-size: 24px;color:white\">&#10006;</p>\r\n</html>");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabelMouseClicked(e);
			}
		});
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setBounds(1127, 11, 46, 27);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Salary");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(81, 11, 161, 50);
		panel.add(lblNewLabel_1);
		
		panel_1 = new JPanel();
		panel_1.setBounds(81, 57, 140, 4);
		panel.add(panel_1);
		
		lblNewLabel_2 = new JLabel("B.Y.D's Management System");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(81, 61, 161, 18);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_3MouseClicked(e);
			}
		});
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\doan_ky2\\images\\icons8-back-arrow-48.png"));
		lblNewLabel_3.setBounds(10, 11, 46, 50);
		panel.add(lblNewLabel_3);
		
		panelContent = new JPanel();
		panelContent.setForeground(Color.BLACK);
		panelContent.setBackground(Color.WHITE);
		panelContent.setBounds(0, 101, 1180, 536);
		getContentPane().add(panelContent);
		panelContent.setLayout(null);
		
		lblBaseSalary = new JLabel("Base Salary:");
		lblBaseSalary.setForeground(SystemColor.activeCaption);
		lblBaseSalary.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBaseSalary.setBounds(128, 125, 148, 34);
		panelContent.add(lblBaseSalary);
		
		lblSalaryFactor = new JLabel("Salary Factor:");
		lblSalaryFactor.setForeground(SystemColor.activeCaption);
		lblSalaryFactor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalaryFactor.setBounds(128, 186, 148, 34);
		panelContent.add(lblSalaryFactor);
		
		lblAllowance = new JLabel("Allowance Factor:");
		lblAllowance.setForeground(SystemColor.activeCaption);
		lblAllowance.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAllowance.setBounds(128, 242, 148, 34);
		panelContent.add(lblAllowance);
		
		lblBS = new JLabel("");
		lblBS.setForeground(SystemColor.windowBorder);
		lblBS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBS.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBS.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblBS.setBounds(316, 125, 98, 34);
		panelContent.add(lblBS);
		
		lblSF = new JLabel("");
		lblSF.setForeground(SystemColor.windowBorder);
		lblSF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSF.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSF.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSF.setBounds(316, 186, 98, 34);
		panelContent.add(lblSF);
		
		lblAF = new JLabel("");
		lblAF.setForeground(SystemColor.windowBorder);
		lblAF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAF.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAF.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblAF.setBounds(316, 242, 98, 34);
		panelContent.add(lblAF);
		
		lblNewLabel_4 = new JLabel("Information:");
		lblNewLabel_4.setForeground(SystemColor.controlShadow);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_4.setBounds(93, 70, 203, 42);
		panelContent.add(lblNewLabel_4);
		
		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaptionBorder);
		panel_2.setBounds(93, 110, 246, 3);
		panelContent.add(panel_2);
		
		panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaptionBorder);
		panel_3.setBounds(212, 302, 246, 3);
		panelContent.add(panel_3);
		
		panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.activeCaptionBorder);
		panel_4.setBounds(440, 125, 3, 200);
		panelContent.add(panel_4);
		
		panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.activeCaptionBorder);
		panel_5.setBounds(115, 90, 3, 200);
		panelContent.add(panel_5);
		
		lblSalary = new JLabel("Salary:");
		lblSalary.setForeground(SystemColor.activeCaption);
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalary.setBounds(727, 125, 148, 34);
		panelContent.add(lblSalary);
		
		lblLateleaveEarly = new JLabel("Late/Leave early:");
		lblLateleaveEarly.setForeground(SystemColor.activeCaption);
		lblLateleaveEarly.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLateleaveEarly.setBounds(726, 242, 148, 34);
		panelContent.add(lblLateleaveEarly);
		
		lblOvertime = new JLabel("Overtime:");
		lblOvertime.setForeground(SystemColor.activeCaption);
		lblOvertime.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOvertime.setBounds(726, 298, 148, 34);
		panelContent.add(lblOvertime);
		
		lblFOvertime = new JLabel("");
		lblFOvertime.setForeground(SystemColor.windowBorder);
		lblFOvertime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFOvertime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFOvertime.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFOvertime.setBounds(914, 298, 144, 34);
		panelContent.add(lblFOvertime);
		
		lblLateLeave = new JLabel("");
		lblLateLeave.setForeground(SystemColor.windowBorder);
		lblLateLeave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLateLeave.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLateLeave.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblLateLeave.setBounds(914, 242, 144, 34);
		panelContent.add(lblLateLeave);
		
		lblFSalary = new JLabel("");
		lblFSalary.setForeground(SystemColor.windowBorder);
		lblFSalary.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFSalary.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFSalary.setBounds(915, 125, 143, 34);
		panelContent.add(lblFSalary);
		
		lblTotal = new JLabel("Total:");
		lblTotal.setForeground(SystemColor.activeCaption);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotal.setBounds(726, 376, 148, 34);
		panelContent.add(lblTotal);
		
		lblFTotal = new JLabel("");
		lblFTotal.setForeground(SystemColor.windowBorder);
		lblFTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFTotal.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFTotal.setBounds(914, 376, 98, 34);
		panelContent.add(lblFTotal);
		
		panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.controlHighlight);
		panel_6.setBounds(726, 358, 287, 3);
		panelContent.add(panel_6);
		
		lblNewLabel_5 = new JLabel("Claim:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(SystemColor.controlShadow);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_5.setBounds(657, 70, 203, 42);
		panelContent.add(lblNewLabel_5);
		
		cbbMonth = new JComboBox();
		cbbMonth.setBounds(727, 11, 148, 34);
		panelContent.add(cbbMonth);
		
		cbbYear = new JComboBox();
		cbbYear.setBounds(944, 11, 155, 34);
		panelContent.add(cbbYear);
		
		lblYear = new JLabel("Year:");
		lblYear.setBackground(SystemColor.textInactiveText);
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYear.setBounds(885, 11, 59, 34);
		panelContent.add(lblYear);
		
		lblMonth = new JLabel("Month:");
		lblMonth.setBackground(SystemColor.textInactiveText);
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMonth.setBounds(669, 11, 59, 34);
		panelContent.add(lblMonth);
		
		btnNewButton = new JButton("GO");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setForeground(SystemColor.inactiveCaptionBorder);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		btnNewButton.setBounds(1110, 11, 59, 34);
		panelContent.add(btnNewButton);
		
		panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.activeCaptionBorder);
		panel_7.setBounds(686, 110, 246, 3);
		panelContent.add(panel_7);
		
		panel_8 = new JPanel();
		panel_8.setBackground(SystemColor.activeCaptionBorder);
		panel_8.setBounds(708, 90, 3, 200);
		panelContent.add(panel_8);
		
		lblAbsent = new JLabel("Absent:");
		lblAbsent.setForeground(SystemColor.activeCaption);
		lblAbsent.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAbsent.setBounds(727, 186, 148, 34);
		panelContent.add(lblAbsent);
		
		lblFAsent = new JLabel("");
		lblFAsent.setForeground(SystemColor.windowBorder);
		lblFAsent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFAsent.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFAsent.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFAsent.setBounds(915, 186, 143, 34);
		panelContent.add(lblFAsent);
		
		lbldola = new JLabel("$");
		lbldola.setForeground(SystemColor.windowBorder);
		lbldola.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbldola.setBounds(415, 125, 22, 34);
		panelContent.add(lbldola);
		
		lbldola_1 = new JLabel("$");
		lbldola_1.setForeground(SystemColor.windowBorder);
		lbldola_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbldola_1.setBounds(1059, 125, 16, 34);
		panelContent.add(lbldola_1);
		
		lbldola_2 = new JLabel("$");
		lbldola_2.setForeground(SystemColor.windowBorder);
		lbldola_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbldola_2.setBounds(1013, 376, 22, 34);
		panelContent.add(lbldola_2);
		
		loadcbb();
		showinfo();
	}
	protected void lblNewLabelMouseClicked(MouseEvent e) {
		System.exit(0);
	}
	
	protected void lblNewLabel_3MouseClicked(MouseEvent e) {
		try {
			this.setClosed(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public String showDate(int a) {
		String date=null;
		WorkscheduleDAO workdao = new WorkscheduleDAO();
		List<Workschedule> listwork = workdao.selectAllSchedule();
		for (Workschedule workschedule : listwork) {
			if(workschedule.getId() == a) {
				date = workschedule.getWork_date().toString();
				break;
			}
		}
		return date;
	}
	public String showShift(int a) {
		String shift=null;
		WorkscheduleDAO workdao = new WorkscheduleDAO();
		ShiftDAO shiftdao = new ShiftDAO();
		List<Workschedule> listwork = workdao.selectAllSchedule();
		List<Shift> listshift = shiftdao.getAllShift();
		for (Workschedule workschedule : listwork) {
			if(workschedule.getId() == a) {
				for (Shift shift2 : listshift) {
					if(shift2.getId() == workschedule.getShift_id()) {
						shift = shift2.toString();
					}
				}
			}
		}
		return shift;
	}
	public void loadcbb() {
		List<Attendance> listatt = attdao.getAttpersonal(7);
		int[] month = new int[100];
		int[] year = new int[100];
		int y=0,m=0,a=0,b=0;
		//Loc thang va nam
		for (Attendance att : listatt) {
			LocalDate dateFromData = LocalDate.parse(showDate(att.getWorkschedule_id()), DateTimeFormatter.ofPattern("yyyy-M-d"));
			for (int i=0;i<100;i++) {
				y=0;
				m=0;
				if(year[i]==dateFromData.getYear()) {
					y=1;
					break;
				}
				if(month[i]==dateFromData.getMonthValue()) {
					m=1;
					break;
				}
			}
			if(y==0) {
				year[a] = dateFromData.getYear();
				a++;
			}
			if(m==0) {
				month[b] = dateFromData.getMonthValue();
				b++;
			}
			
		}
		//sap xep
		for(int i=0;i<a-1;i++) {
			for(int j=i+1;j<a;j++) {
				if(year[i] < year[j]) {
					int tmp = year[i];
					year[i] = year[j];
					year[j] = tmp;
				}
			}
		}
		for(int i=0;i<b-1;i++) {
			for(int j=i+1;j<b;j++) {
				if(month[i] > month[j]) {
					int tmp = month[i];
					month[i] = month[j];
					month[j] = tmp;
				}
			}
		}
		//truyen vao cbb
		DefaultComboBoxModel yearmodel = new DefaultComboBoxModel();
		DefaultComboBoxModel monthmodel = new DefaultComboBoxModel();
		yearmodel.addElement("Select Year");
		monthmodel.addElement("Select Month");
		
		for(int i=0;i<a;i++) {
			
			yearmodel.addElement(year[i]);
		}
		for(int i=0;i<b;i++) {
			
			monthmodel.addElement(month[i]);
		}
		
		cbbYear.setModel(yearmodel);
		cbbMonth.setModel(monthmodel);
		
		cbbMonth.setSelectedIndex(0);
		cbbYear.setSelectedIndex(0);
	}
	public void showinfo() {
		EmployeeDAO empdao = new EmployeeDAO();
		SalaryDAO sadao = new SalaryDAO();
		List<entity.Salary> listsa = sadao.selectAllSalary();
		Employee emp = empdao.getUserById(UserLogin.getUserId());
		
		for (entity.Salary salary : listsa) {
			if(salary.getId() == emp.getSalary_level()) {
				lblBS.setText(salary.getBase_salary()+"");
				lblSF.setText(salary.getSalary_factor()+"");
				lblAF.setText(salary.getAllowance_factor()+"");
				sa = salary.getBase_salary() * salary.getSalary_factor() * salary.getAllowance_factor();
				saperday = salary.getBase_salary()/30;
				break;
			}
		}
	}
	public boolean late(String time1, String time2) {
		 LocalTime time1Start = LocalTime.parse(time1.split("-")[0]);
	        LocalTime time2Value = LocalTime.parse(time2);

	        // So sánh thời gian
	        Duration duration = Duration.between(time1Start, time2Value);

	        // Xuất ra sự chênh lệch
	        if (time2Value.isAfter(time1Start)) {
		        long hours = duration.toHours();
		        long minutes = duration.toMinutesPart();
		      
		        return true; //co di tre
	        }else {
	        	return false;
	        }
	}
	public boolean leaveearly(String time1, String time2) {
		LocalTime time1End = LocalTime.parse(time1.split("-")[1]);
        LocalTime time2Value = LocalTime.parse(time2);

        // So sánh thời gian
        Duration duration = Duration.between(time1End, time2Value);
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        // Xuất ra sự chênh lệch
        if (time2Value.isAfter(time1End)) {
	        return false; //overtime
        }else {
        	return true; //ve som
        }
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		List<Attendance> listatt = attdao.getAttpersonal(UserLogin.getUserId());
		List<Attendance> newlist = new ArrayList<>();
		
		int month, year;
		int countwp=0, countlate=0, countovertime=0,countp=0;
		float saabsent=0, salate= 0, saover=0, total=0;
		if(!cbbMonth.getSelectedItem().toString().equals("Select Month") && !cbbYear.getSelectedItem().toString().equals("Select Year")) {
			 month = Integer.parseInt(cbbMonth.getSelectedItem().toString());
			 year = Integer.parseInt(cbbYear.getSelectedItem().toString());
		}else {
			return;
		}
		if(month >= currentDate.getMonthValue() && year == currentDate.getYear()) {
			JOptionPane.showMessageDialog(null, "The working month hasn't ended yet so there's no salary yet");
			return;
		}
		
		//loc list theo lua chon
		for (Attendance att : listatt) {
			LocalDate dateFromData = LocalDate.parse(showDate(att.getWorkschedule_id()), DateTimeFormatter.ofPattern("yyyy-M-d"));
			if(dateFromData.getMonthValue() == month && dateFromData.getYear() == year) {
				newlist.add(att);
				if(!att.isPresent() ) {
					if(att.getLeave_type().equals("WP")) {
						countwp++;
					}else {
						countp++;
					}
				}
				if(late(showShift(att.getWorkschedule_id()), att.getArrival_time().toString()) ){
					countlate++;
				}
				if(leaveearly(showShift(att.getWorkschedule_id()), att.getDeparture_time().toString())) {
					countlate++;
				}else {
					countovertime++;
				}
			}
		}
		if(countp ==0) {
			saabsent = saperday*(countwp+((countp)/2));
		}else if(countp==1) {
			saabsent = saperday*(countwp+((countp-1)/2));
		}else {
			saabsent = saperday*(countwp+((countp-2)/2));
		}
		salate = (saperday/2) *countlate;
		saover=(saperday/2)* countovertime;
		total = sa - saabsent - salate + saover;
		lblFSalary.setText(sa+"");
		lblFAsent.setText("-"+saabsent+" ("+(countwp+countp)+"times)");
		lblLateLeave.setText("-"+salate+" ("+(countlate)+"times)");
		lblFOvertime.setText("+"+saover+" ("+(countovertime)+"times)");
		lblFTotal.setText(""+total);
	}
	
	public void loaddata() {
		
	}
}
