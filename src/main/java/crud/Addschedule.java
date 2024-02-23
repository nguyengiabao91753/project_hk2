package crud;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import App.App_Admin;
import Gui.Work_Schedules;
import dao.AttendanceDAO;
import dao.EmployeeDAO;
import dao.RoomDAO;
import dao.ShiftDAO;
import dao.WorkscheduleDAO;
import entity.Employee;
import entity.Room;
import entity.Shift;
import entity.Workschedule;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class Addschedule extends JInternalFrame {

	private JComponent Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarca =null;
	private static final long serialVersionUID = 1L;
	private JTextField txtEmp;
	private JLabel lblEmployee;
	private JLabel lblRoom;
	private JLabel lblShift;
	private JLabel lblWorkDate;
	private JDateChooser dateChooser;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel panel;
	private JComboBox cbbRoom;
	private JPanel panel_1;
	private JComboBox cbbShift;
	private JButton btnSubmit;
	LocalDate currentDate = LocalDate.now();
	private static Addschedule instance ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addschedule frame = new Addschedule();
					frame.setVisible(true);
					
					frame.toFront();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static Addschedule getInstance() {
        if (instance == null) {
            instance = new Addschedule();
        }
        return instance;
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
	public Addschedule() {
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		quit();
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 636, 284);
		getContentPane().setLayout(null);
		
		txtEmp = new JTextField();
		txtEmp.setBounds(41, 100, 191, 20);
		getContentPane().add(txtEmp);
		txtEmp.setColumns(10);
		
		lblEmployee = new JLabel("Employee_id: ");
		lblEmployee.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmployee.setBounds(41, 75, 87, 14);
		getContentPane().add(lblEmployee);
		
		lblRoom = new JLabel("Room:");
		lblRoom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRoom.setBounds(41, 131, 87, 14);
		getContentPane().add(lblRoom);
		
		lblShift = new JLabel("Shift:");
		lblShift.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblShift.setBounds(375, 131, 87, 14);
		getContentPane().add(lblShift);
		
		lblWorkDate = new JLabel("Work date:");
		lblWorkDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWorkDate.setBounds(375, 75, 87, 14);
		getContentPane().add(lblWorkDate);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(375, 100, 124, 20);
		getContentPane().add(dateChooser);
		
		panel = new JPanel();
		panel.setBackground(new Color(102, 0, 255));
		panel.setBounds(0, 0, 636, 52);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel_2 = new JLabel("<html>\r\n\t<p style=\"font-size: 24px;color:white\">&#10006;</p>\r\n</html>");
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setBounds(601, 3, 25, 49);
		panel.add(lblNewLabel_2);
		
		lblNewLabel = new JLabel("Work Schedule");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 18, 171, 25);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		lblNewLabel_1 = new JLabel("-Create");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(165, 24, 63, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		cbbRoom = new JComboBox();
		cbbRoom.setBounds(41, 156, 191, 22);
		getContentPane().add(cbbRoom);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(235, 234, 233));
		panel_1.setBounds(0, 195, 636, 59);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBackground(new Color(0, 102, 255));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		btnSubmit.setBounds(43, 11, 89, 37);
		panel_1.add(btnSubmit);
		
		cbbShift = new JComboBox();
		cbbShift.setBounds(375, 156, 191, 22);
		getContentPane().add(cbbShift);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_2MouseClicked(e);
			}
		});
		loadcbb();
	}
	protected void lblNewLabel_2MouseClicked(MouseEvent e) {
		this.setVisible(false);
	}
	protected void loadcbb() {
		// TODO Auto-generated method stub
		var shiftmodel = new DefaultComboBoxModel();
		var roommodel = new DefaultComboBoxModel();
		
		
		ShiftDAO shiftdao = new ShiftDAO();
		RoomDAO roomdao = new RoomDAO();
		List<Shift> listshift = shiftdao.getAllShift();
		List<Room> listroom = roomdao.selectAllRoom();
		
		
		shiftmodel.addAll(listshift);
		roommodel.addAll(listroom);
		
		cbbShift.setModel(shiftmodel);
		cbbRoom.setModel(roommodel);
		
	}	
	public static boolean doShiftsOverlap(String shift1, String shift2) {
	    // Parse shifts in "HH:mm:ss-HH:mm:ss" format
	    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
	    
	    try {
	        String[] shift1Parts = shift1.split("-");
	        String[] shift2Parts = shift2.split("-");

	        Date shift1Start = format.parse(shift1Parts[0]);
	        Date shift1End = format.parse(shift1Parts[1]);

	        Date shift2Start = format.parse(shift2Parts[0]);
	        Date shift2End = format.parse(shift2Parts[1]);

	        // Check for overlap
//	        return (shift2End.before(shift1Start) || shift1End.before(shift2Start));
	        return (shift1Start.before(shift2End) && shift2Start.before(shift1End));

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false; // Handle parsing errors
	    }
	}
//	public int shift_id() {
//		int id=0;
//		ShiftDAO shiftdao = new ShiftDAO();
//		List<Shift> listshift = shiftdao.getAllShift();
//		for (Shift shift : listshift) {
//			if(shift.toString().equals(cbbShift.getSelectedItem())) {
//				id= shift.getId();
//				
//			}
//		}
//		return id;
//	}
//	public int room_id() {
//		RoomDAO roomdao = new RoomDAO();
//		List<Room> listroom = roomdao.selectAllRoom();
//		for (Room room : listroom) {
//			if(room.toString().equals(cbbRoom.getSelectedItem())) {
//				return  room.getId();
//				
//			}
//		}
//		return 0;
//	}
	
	public static boolean isNumeric(String str) {
	    try {
	        Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	public boolean checkEmp_id(List<Employee> listemp, int a) {
		for (Employee employee : listemp) {
			if(employee.getId() == a) {
				return true;
			}
		}
		return false;
	}
	public int validateSchedule() {
		int count =0;
		int shift_id=0;
		int room_id=0;
		EmployeeDAO empdao = new EmployeeDAO();
		RoomDAO roomdao = new RoomDAO();
		ShiftDAO shiftdao = new ShiftDAO();
		WorkscheduleDAO workdao = new WorkscheduleDAO();
		List<Workschedule> listwork = workdao.selectAllSchedule();
		List<Employee> listemp = empdao.selectAllEmployee();
		List<Room> listroom = roomdao.selectAllRoom();
		List<Shift> listshift = shiftdao.getAllShift();
		for (Shift shift : listshift) {
			if(shift.toString().equals(cbbShift.getSelectedItem())) {
				shift_id = shift.getId();
				break;
			}
		}
		
		for (Room room : listroom) {
			if(room.toString().equals(cbbRoom.getSelectedItem())) {
				room_id = room.getId();
				break;
			}
		}
		
		
		if( txtEmp.getText() == null || dateChooser.getDate() == null || cbbRoom.getSelectedItem() ==null || cbbShift.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Please fill in all information");
			count++;
		} else if(!isNumeric(txtEmp.getText())) {
			JOptionPane.showMessageDialog(null, "Employee_id must be a number!");
			count++;
		}else if(!checkEmp_id(listemp, Integer.parseInt(txtEmp.getText())) ) {
			JOptionPane.showMessageDialog(null, "Employee_id is invalid");
			count++;
		}
		else if(currentDate.equals(LocalDate.ofInstant(dateChooser.getDate().toInstant(), ZoneId.systemDefault())) || currentDate.isAfter(LocalDate.ofInstant(dateChooser.getDate().toInstant(), ZoneId.systemDefault()))) {
			JOptionPane.showMessageDialog(null, "Please choose work date is 'after' today!");
			count++;
		}
		else {
			for (Workschedule workschedule : listwork) {
				if(workschedule.getEmployee_id() == Integer.parseInt(txtEmp.getText()) && workschedule.getWork_date().equals(LocalDate.ofInstant(dateChooser.getDate().toInstant(), ZoneId.systemDefault())) 
					&& workschedule.getShift_id() == (cbbShift.getSelectedIndex()+1) && workschedule.getRoom_id() == (cbbRoom.getSelectedIndex()+1)) {
					JOptionPane.showMessageDialog(null, "This data is aldready exists");
					count++;
					return count;
				}
//				if(workschedule.getEmployee_id() == Integer.parseInt(txtEmp.getText()) && workschedule.getWork_date().equals(LocalDate.ofInstant(dateChooser.getDate().toInstant(), ZoneId.systemDefault())) 
//						&& workschedule.getShift_id() == (cbbShift.getSelectedIndex()+1) && workschedule.getRoom_id() != (cbbRoom.getSelectedIndex()+1)) {
//					JOptionPane.showMessageDialog(null, "Employee cannot work the same shift on the same date in a different room.");
//					count++;
//					return count;
//				}
			}
			
			for (Workschedule workschedule : listwork) {
				var shift_name="";
				for (Shift shift : listshift) {
					if(shift.getId() == workschedule.getShift_id()) {
						shift_name = shift.toString();
						break;
					}
				}
				if(workschedule.getEmployee_id() == Integer.parseInt(txtEmp.getText()) && workschedule.getWork_date().equals(LocalDate.ofInstant(dateChooser.getDate().toInstant(), ZoneId.systemDefault())) 
						&& workschedule.getRoom_id() != (cbbRoom.getSelectedIndex()+1) && doShiftsOverlap(shift_name,cbbShift.getSelectedItem().toString())) {
					JOptionPane.showMessageDialog(null, "Employee cannot work overlapping shifts in the same room on the same date.");
					count++;
					return count++;
				}
			}
		}
		return count;
	}
	public void resetField() {
		txtEmp.setText("");
		cbbRoom.setSelectedItem(null);
		cbbShift.setSelectedItem(null);
		dateChooser.setDate(null);
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		if(validateSchedule() !=0) {
			return;
		}else {
		Workschedule newwork = new Workschedule();
		newwork.setEmployee_id(Integer.parseInt(txtEmp.getText()));
		newwork.setShift_id(cbbShift.getSelectedIndex()+1);
		newwork.setRoom_id(cbbRoom.getSelectedIndex()+1);
		newwork.setWork_date(LocalDate.ofInstant(dateChooser.getDate().toInstant(), ZoneId.systemDefault()));
		WorkscheduleDAO workdao = new WorkscheduleDAO();
		if(workdao.insert(newwork)) {
			JOptionPane.showMessageDialog(null, "Add successfully!");
			Work_Schedules work = new Work_Schedules();
			work.setVisible(true);;
			App_Admin app = new App_Admin();
			app.desktopPane.add(work);
			resetField();
			this.hide();
		}else {
			JOptionPane.showMessageDialog(null, "Add Fail!");
		}
		}
	}
}
