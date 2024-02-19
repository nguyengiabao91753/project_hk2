package User_GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import App.App_User;
import dao.AttendanceDAO;
import dao.ShiftDAO;
import dao.WorkscheduleDAO;
//import entity.Attendance;
import entity.Shift;
import entity.Workschedule;

import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Attendance extends JInternalFrame {

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
	private JScrollPane scrollPane;
	private JList list;
	
	AttendanceDAO attdao = new AttendanceDAO();
	private JLabel lblDate;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblShift;
	private JButton btnCheckin;
	private JButton btnCheckout;
	private JButton btnRequestForDayoff;
	private JLabel lblId;
	
	LocalDate currentDate = LocalDate.now();
	LocalTime currentTime = LocalTime.now();
	/**
	 * Launch the application.
	 */
//	public class CustomListCellRenderer extends DefaultListCellRenderer {
//	    private int cellHeight;  // Độ cao mong muốn của mỗi ô
//
//	    public CustomListCellRenderer(int cellHeight) {
//	        this.cellHeight = cellHeight;
//	    }
//
//	    @Override
//	    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//	        // Gọi phương thức của lớp cha để lấy đối tượng mô tả của ô
//	        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
//	        
//	        // Set độ cao cho ô
//	        label.setPreferredSize(new Dimension(label.getWidth(), cellHeight));
//
//	        return label;
//	    }
//	}  
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Attendance frame = new Attendance();
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
	public Attendance() {
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
		
		lblNewLabel_1 = new JLabel("Attendance ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(81, 11, 181, 50);
		panel.add(lblNewLabel_1);
		
		panel_1 = new JPanel();
		panel_1.setBounds(81, 57, 180, 4);
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
		lblNewLabel_3.setIcon(new ImageIcon("images\\icons8-back-arrow-48.png"));
		lblNewLabel_3.setBounds(10, 11, 46, 50);
		panel.add(lblNewLabel_3);
		
		
		panelContent = new JPanel();
		panelContent.setForeground(Color.BLACK);
		panelContent.setBackground(Color.WHITE);
		panelContent.setBounds(0, 101, 1180, 536);
		getContentPane().add(panelContent);
		panelContent.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 40, 643, 467);
		panelContent.add(scrollPane);
		
		list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listMouseClicked(e);
			}
		});
		list.setSelectionBackground(new Color(153, 204, 255));
		list.setFont(new Font("Tahoma", Font.PLAIN, 17));
		scrollPane.setViewportView(list);
		
		lblDate = new JLabel("");
		lblDate.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDate.setBounds(929, 105, 166, 36);
		panelContent.add(lblDate);
		
		lblNewLabel_5 = new JLabel("Date:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_5.setBounds(827, 105, 92, 36);
		panelContent.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Shift:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_6.setBounds(827, 167, 92, 36);
		panelContent.add(lblNewLabel_6);
		
		lblShift = new JLabel("");
		lblShift.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblShift.setBounds(929, 167, 166, 36);
		panelContent.add(lblShift);
		
		btnCheckin = new JButton("Check-in");
		btnCheckin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCheckinMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCheckinMouseExited(e);
			}
		});
		btnCheckin.setBackground(Color.GREEN);
		btnCheckin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCheckin.setForeground(new Color(255, 255, 255));
		btnCheckin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCheckinActionPerformed(e);
			}
		});
		btnCheckin.setBounds(805, 214, 110, 36);
		panelContent.add(btnCheckin);
		
		btnCheckout = new JButton("Check-out");
		btnCheckout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCheckoutMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCheckoutMouseExited(e);
			}
		});
		btnCheckout.setBackground(Color.RED);
		btnCheckout.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCheckout.setForeground(new Color(255, 255, 255));
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCheckoutActionPerformed(e);
			}
		});
		btnCheckout.setBounds(939, 214, 110, 36);
		panelContent.add(btnCheckout);
		
		btnRequestForDayoff = new JButton("Request for day-off");
		btnRequestForDayoff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnRequestForDayoffMouseExited(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRequestForDayoffMouseEntered(e);
			}
		});
		btnRequestForDayoff.setBackground(Color.ORANGE);
		btnRequestForDayoff.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRequestForDayoff.setForeground(new Color(255, 255, 255));
		btnRequestForDayoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRequestForDayoffActionPerformed(e);
			}
		});
		btnRequestForDayoff.setBounds(827, 261, 194, 36);
		panelContent.add(btnRequestForDayoff);
		
		lblId = new JLabel("");
		lblId.setVisible(false);
		lblId.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblId.setBounds(929, 51, 92, 36);
		panelContent.add(lblId);
		 
		load();         
         
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
	public String durationTime(String time1, String time2) {
		 LocalTime time1Start = LocalTime.parse(time1.split("-")[0]);
	        LocalTime time2Value = LocalTime.parse(time2);

	        // So sánh thời gian
	        Duration duration = Duration.between(time1Start, time2Value);

	        // Xuất ra sự chênh lệch
	        if (time2Value.isAfter(time1Start)) {
		        long hours = duration.toHours();
		        long minutes = duration.toMinutesPart();
		        if(hours>0) {
		        	return "Late: "+hours+"h "+minutes +"m";
		        }
		        return "Late: "+minutes +"m";
	        }else {
	        	return "on time";
	        }
	}
	public String statusPresent(entity.Attendance att) {
		if(!att.isPresent()) {
			return "Absent ("+(att.getLeave_type().equals("P") ? "With Permission":"Without Permission")+")";
		}else {
			return "Present - " + durationTime(showShift(att.getWorkschedule_id()), att.getArrival_time().toString());
		}
		//return null;
	}
	@SuppressWarnings("unchecked")
	public void load() {
		
		
		DefaultListModel model = new DefaultListModel();
		List<entity.Attendance> listatt =  attdao.getAttpersonal(1);
		for (entity.Attendance att : listatt) {
			LocalDate dateFromData = LocalDate.parse(showDate(att.getWorkschedule_id()), DateTimeFormatter.ofPattern("yyyy-M-d"));
			if(currentDate.isEqual(dateFromData) && att.getArrival_time() == null && att.getLeave_type().equals("WP")) {
				model.addElement("<html><body style='width: 491px; padding: 5px; border-bottom: 1px solid black;'>"+
						"(Id: "+att.getAttendance_id()+") "+showDate(att.getWorkschedule_id())+": Please check-in"
						+ "</body></html>");
			}else if(currentDate.isAfter(dateFromData) || currentDate.isEqual(dateFromData)) {
				model.addElement("<html><body style='width: 491px; padding: 5px; border-bottom: 1px solid black;'>"+
						"(Id: "+att.getAttendance_id()+") "+showDate(att.getWorkschedule_id())+": "+statusPresent(att)
						+ "</body></html>");
			}
		}
//		attdao.getAttpersonal(1).stream().forEach(att ->model.addElement("<html><body style='width: 491px; padding: 5px; border-bottom: 1px solid black;'>"+
//					"(Id: "+att.getAttendance_id()+") "+showDate(att.getWorkschedule_id())+": "+statusPresent(att)
//					+ "</body></html>"));
//		
		list.setCellRenderer(new HTMLRenderer());
		list.setModel(model);
		 //list.setCellRenderer(new CustomListCellRenderer(50));
	}
	
	
	
	 static class HTMLRenderer extends DefaultListCellRenderer {
	        @Override
	        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	            label.setText((String) value);
	            return label;
	        }
	    }
	protected void lblNewLabel_3MouseClicked(MouseEvent e) {
//		App_User appus = new App_User();
//		appus.setLocationRelativeTo(null);
//		appus.setUndecorated(true);
//		appus.setVisible(true);
	    this.dispose();
	}
	protected void lblNewLabelMouseClicked(MouseEvent e) {
		System.exit(0);
	}
	protected void listMouseClicked(MouseEvent e) {
		String value=list.getSelectedValue().toString();
		 int colonIndex = value.indexOf("Id:");
	     int closingParenthesisIndex = value.indexOf(')'); 
	     String att_id = value.substring(colonIndex + 3, closingParenthesisIndex).trim();
		lblId.setText(att_id);
		List<entity.Attendance> listatt =  attdao.getAttpersonal(1);
		for (entity.Attendance att : listatt) {
			if(att.getAttendance_id() == Integer.parseInt(att_id)) {
				lblDate.setText(showDate(att.getWorkschedule_id()));
				lblShift.setText(showShift(att.getWorkschedule_id()));
				
				LocalDate dateFromData = LocalDate.parse(showDate(att.getWorkschedule_id()), DateTimeFormatter.ofPattern("yyyy-M-d"));
				if(currentDate.isEqual(dateFromData) && att.getArrival_time() == null && att.getLeave_type().equals("WP")) {
					btnCheckin.setVisible(true);
					btnCheckout.setVisible(false);
					btnRequestForDayoff.setVisible(true);
				}else if(currentDate.isEqual(dateFromData) && att.getArrival_time() != null &&att.getDeparture_time() == null) {
					btnCheckin.setVisible(false);
					btnCheckout.setVisible(true);
					btnRequestForDayoff.setVisible(false);
				}
				else{
					btnCheckin.setVisible(false);
					btnCheckout.setVisible(false);
					btnRequestForDayoff.setVisible(false);
				}
			}
			
		}
		
	}
	protected void btnCheckinActionPerformed(ActionEvent e) {
		entity.Attendance newatt = new entity.Attendance();
		int att_id =Integer.parseInt(lblId.getText()) ;
		newatt.setAttendance_id(att_id);
		newatt.setArrival_time( Time.valueOf(currentTime));
		attdao.checkin(newatt);
		btnCheckin.setVisible(false);
		btnCheckout.setVisible(true);
		btnRequestForDayoff.setVisible(false);
		load();
	}
	protected void btnCheckoutActionPerformed(ActionEvent e) {
		entity.Attendance newatt = new entity.Attendance();
		int att_id =Integer.parseInt(lblId.getText()) ;
		newatt.setAttendance_id(att_id);
		newatt.setDeparture_time( Time.valueOf(currentTime));
		attdao.checkout(newatt);
		btnCheckout.setVisible(false);
		load();
	}
	protected void btnRequestForDayoffActionPerformed(ActionEvent e) {
		entity.Attendance newatt = new entity.Attendance();
		int att_id =Integer.parseInt(lblId.getText()) ;
		attdao.checkin(newatt);
		btnCheckin.setVisible(false);
		btnCheckout.setVisible(false);
		btnRequestForDayoff.setVisible(false);
		load();
	}
	protected void btnCheckinMouseEntered(MouseEvent e) {
		btnCheckin.setBackground(Color.white);
		btnCheckin.setForeground(Color.green);
		btnCheckin.setBorder(new LineBorder(Color.green));
	}
	protected void btnCheckinMouseExited(MouseEvent e) {
		btnCheckin.setBackground(Color.green);
		btnCheckin.setForeground(Color.white);
	}
	protected void btnCheckoutMouseEntered(MouseEvent e) {
		btnCheckout.setBackground(Color.white);
		btnCheckout.setForeground(Color.red);
		btnCheckout.setBorder(new LineBorder(Color.red));
	}
	protected void btnRequestForDayoffMouseExited(MouseEvent e) {
		btnRequestForDayoff.setBackground(Color.orange);
		btnRequestForDayoff.setForeground(Color.white);
	}
	protected void btnCheckoutMouseExited(MouseEvent e) {
		btnCheckout.setBackground(Color.red);
		btnCheckout.setForeground(Color.white);
	}
	protected void btnRequestForDayoffMouseEntered(MouseEvent e) {
		btnRequestForDayoff.setBackground(Color.white);
		btnRequestForDayoff.setForeground(Color.orange);
		btnRequestForDayoff.setBorder(new LineBorder(Color.orange));
	}
}
