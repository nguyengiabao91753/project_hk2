package Gui;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import dao.AttendanceDAO;
import dao.EmployeeDAO;
import dao.ShiftDAO;
import dao.WorkscheduleDAO;
import entity.Attendance;
import entity.Employee;
import entity.Shift;
import entity.Workschedule;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultRowSorter;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Atiendances extends JInternalFrame {

	private JComponent Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarca =null;
	private static final long serialVersionUID = 1L;
	private static Atiendances instance ;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField textSearch;
	private JLabel lblFid;
	private JLabel lblFshift;
	private JDateChooser dateChooser;
	private JTextField lblArrivalTime;
	private JTextField lblDepTime;
	private JComboBox cbbType;
	private JLabel lblId;
	private JLabel lblScheduleid;
	private JTextField textFsche;
	private JCheckBox chckbxGender;
	private JLabel lblShift;
	private JLabel lblDate;
	private JLabel lblPresent;
	private JLabel lblAt;
	private JLabel lblDt;
	private JLabel lblType;
	private JLabel lblFemp;
	private JLabel lblEmployeeid;
	EmployeeDAO emdao = new EmployeeDAO();
	AttendanceDAO attdao = new AttendanceDAO();
	private JLabel lblUpdate;
	private JLabel lblDelete;
	private JTextField txtPage;
	private JLabel lblNext;
	private JLabel lblLast;
	private JLabel lblPrevious;
	private JLabel lblFirst;
	
	
	Integer pageNumber =1;
	Integer rowOfPage =10;
	Double totalPage =0.0;
	Integer totalCount =0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Atiendances frame = new Atiendances();
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
	public void hidenextlast() {
		if(pageNumber==1) {
			lblFirst.setVisible(false);
			lblPrevious.setVisible(false);
		}else {
			lblFirst.setVisible(true);
			lblPrevious.setVisible(true);
		}
		if(pageNumber == totalPage.intValue()) {
			lblNext.setVisible(false);
			lblLast.setVisible(false);
		}else {
			lblNext.setVisible(true);
			lblLast.setVisible(true);
		}
	}
	public void quit() {
		Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
		DimensionBarca =Barca.getPreferredSize();
		Barca.setSize(0,0);
		Barca.setPreferredSize(new Dimension(0,0));
		repaint();
	}
    public static Atiendances getInstance() {
        if (instance == null) {
            instance = new Atiendances();
        }
        return instance;
    }
	public Atiendances() {
		getContentPane().setForeground(SystemColor.textInactiveText);
		getContentPane().setBackground(new Color(255, 255, 255));
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		quit();
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Atiendances");
		setBounds(223, 37, 957, 626);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(267, 58, 664, 347);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		
		textSearch = new JTextField();
		textSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldActionPerformed(e);
			}
		});
		textSearch.setBorder(new TitledBorder(null, "Search: ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(192, 192, 192)));
		textSearch.setBounds(267, 11, 105, 36);
		getContentPane().add(textSearch);
		textSearch.setColumns(10);
		
		lblFid = new JLabel("");
		lblFid.setEnabled(false);
		lblFid.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFid.setBounds(127, 90, 117, 20);
		getContentPane().add(lblFid);
		
		lblFshift = new JLabel("");
		lblFshift.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFshift.setBounds(127, 210, 117, 21);
		getContentPane().add(lblFshift);
		
		dateChooser = new JDateChooser();
		dateChooser.setEnabled(false);
		dateChooser.setBorder(new LineBorder(new Color(0, 0, 0)));
		dateChooser.setBounds(127, 250, 117, 20);
		getContentPane().add(dateChooser);
		
		lblArrivalTime = new JTextField("");
		lblArrivalTime.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblArrivalTime.setBounds(127, 330, 117, 20);
		getContentPane().add(lblArrivalTime);
		
		lblDepTime = new JTextField("");
		lblDepTime.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDepTime.setBounds(127, 360, 117, 20);
		getContentPane().add(lblDepTime);
		
		cbbType = new JComboBox();
		cbbType.setModel(new DefaultComboBoxModel(new String[] {"Null", "permission", "without permission"}));
		cbbType.setBorder(new LineBorder(new Color(0, 0, 0)));
		cbbType.setBounds(127, 400, 117, 23);
		getContentPane().add(cbbType);
		
		lblId = new JLabel("ID: ");
		lblId.setForeground(SystemColor.textInactiveText);
		lblId.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblId.setBounds(30, 90, 72, 20);
		getContentPane().add(lblId);
		
		lblScheduleid = new JLabel("Schedule_id:");
		lblScheduleid.setForeground(SystemColor.textInactiveText);
		lblScheduleid.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblScheduleid.setBounds(30, 130, 72, 20);
		getContentPane().add(lblScheduleid);
		
		textFsche = new JTextField();
		textFsche.setDisabledTextColor(new Color(0, 0, 0));
		textFsche.setEnabled(false);
		textFsche.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFsche.setBounds(127, 130, 117, 20);
		getContentPane().add(textFsche);
		textFsche.setColumns(10);
		
		chckbxGender = new JCheckBox("");
		chckbxGender.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				chckbxGenderItemStateChanged(e);
			}
		});
		chckbxGender.setBackground(SystemColor.text);
		chckbxGender.setBounds(149, 290, 21, 23);
		getContentPane().add(chckbxGender);
		
		lblShift = new JLabel("Shift:");
		lblShift.setForeground(SystemColor.textInactiveText);
		lblShift.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblShift.setBounds(30, 210, 46, 21);
		getContentPane().add(lblShift);
		
		lblDate = new JLabel("Date:");
		lblDate.setForeground(SystemColor.textInactiveText);
		lblDate.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDate.setBounds(30, 250, 72, 20);
		getContentPane().add(lblDate);
		
		lblPresent = new JLabel("Present: ");
		lblPresent.setForeground(SystemColor.textInactiveText);
		lblPresent.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblPresent.setBounds(30, 290, 72, 20);
		getContentPane().add(lblPresent);
		
		lblAt = new JLabel("At:");
		lblAt.setForeground(SystemColor.textInactiveText);
		lblAt.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblAt.setBounds(30, 330, 46, 20);
		getContentPane().add(lblAt);
		
		lblDt = new JLabel("Dt:");
		lblDt.setForeground(SystemColor.textInactiveText);
		lblDt.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDt.setBounds(30, 360, 46, 20);
		getContentPane().add(lblDt);
		
		lblType = new JLabel("Type:");
		lblType.setForeground(SystemColor.textInactiveText);
		lblType.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblType.setBounds(30, 400, 46, 14);
		getContentPane().add(lblType);
		
		lblFemp = new JLabel("");
		lblFemp.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFemp.setBounds(127, 170, 117, 20);
		getContentPane().add(lblFemp);
		
		lblEmployeeid = new JLabel("Employee_id:");
		lblEmployeeid.setForeground(SystemColor.textInactiveText);
		lblEmployeeid.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEmployeeid.setBounds(30, 170, 87, 20);
		getContentPane().add(lblEmployeeid);
		
		lblUpdate = new JLabel("Update");
		lblUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblUpdateMouseClicked(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblUpdateMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblUpdateMouseExited(e);
			}
		});
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setOpaque(true);
		lblUpdate.setBackground(Color.GREEN);
		lblUpdate.setForeground(new Color(255, 255, 255));
		lblUpdate.setBounds(30, 466, 76, 27);
		getContentPane().add(lblUpdate);
		
		lblDelete = new JLabel("Delete");
		lblDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblDeleteMouseClicked(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDeleteMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblDeleteMouseExited(e);
			}
		});
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setOpaque(true);
		lblDelete.setBackground(Color.RED);
		lblDelete.setForeground(new Color(255, 255, 255));
		lblDelete.setBounds(168, 466, 76, 27);
		getContentPane().add(lblDelete);
		
		txtPage = new JTextField();
		txtPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPageActionPerformed(e);
			}
		});
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setText("1");
		txtPage.setBounds(840, 416, 38, 24);
		getContentPane().add(txtPage);
		txtPage.setColumns(10);
		
		lblNext = new JLabel("");
		lblNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNextMouseClicked(e);
			}
		});
		lblNext.setIcon(new ImageIcon("images\\icons8-next-24 (1).png"));
		lblNext.setBounds(878, 416, 24, 24);
		getContentPane().add(lblNext);
		
		lblLast = new JLabel("");
		lblLast.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblLastMouseClicked(e);
			}
		});
		lblLast.setIcon(new ImageIcon("images\\icons8-last-24.png"));
		lblLast.setBounds(905, 416, 24, 24);
		getContentPane().add(lblLast);
		
		lblPrevious = new JLabel("");
		lblPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblPreviousMouseClicked(e);
			}
		});
		lblPrevious.setIcon(new ImageIcon("images\\icons8-next-24 (2).png"));
		lblPrevious.setBounds(817, 416, 24, 24);
		getContentPane().add(lblPrevious);
		
		lblFirst = new JLabel("");
		lblFirst.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblFirstMouseClicked(e);
			}
		});
		lblFirst.setBackground(new Color(240, 240, 240));
		lblFirst.setIcon(new ImageIcon("images\\icons8-last-24 (1).png"));
		lblFirst.setBounds(790, 416, 24, 24);
		getContentPane().add(lblFirst);
		
		loadAtt();
		hidenextlast();

	}
	public int showEmp_id(int a) {
		int emp=0;
		WorkscheduleDAO workdao = new WorkscheduleDAO();
		List<Workschedule> listwork = workdao.selectAllSchedule();
		for (Workschedule workschedule : listwork) {
			if(workschedule.getId() == a) {
				emp = workschedule.getEmployee_id();
				break;
			}
		}
		return emp;
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
	
	public Employee emp(int a) {
		for (Employee emp : emdao.selectAllEmployee()) {
			if(emp.getId() == a) {
				return emp;
			}
		}
		return null;
	}
	public void loadAtt() {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
	         public boolean isCellEditable(int row, int column) {
	             // Không cho phép chỉnh sửa bất kỳ ô nào
	             return false;
	         }
		};
		model.addColumn("Id");
		model.addColumn("Schedule_id");
		model.addColumn("Emp_id");
		model.addColumn("Shift");
		model.addColumn("Date");
		model.addColumn("Present");
		model.addColumn("Arrival Time");
		model.addColumn("Dep Time");
		model.addColumn("Leave Type");
		
		totalCount = attdao.countAtt();
		//tìm số trang của bảng 
		totalPage = Math.ceil(totalCount.doubleValue() / rowOfPage.doubleValue());
		
		attdao.getAtt(pageNumber,rowOfPage).stream()
		.filter(att -> emp(showEmp_id(att.getWorkschedule_id())).getStatus() ==1)
		.forEach(att -> model.addRow(new Object[] {
						att.getAttendance_id(),
						att.getWorkschedule_id(),
						showEmp_id(att.getWorkschedule_id()),
						showShift(att.getWorkschedule_id()),
						showDate(att.getWorkschedule_id()),
						att.isPresent(),
						att.getArrival_time(),
						att.getDeparture_time(),
						att.getLeave_type()
		}));
		
		table.setModel(model);
		table.setRowHeight(32);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);
		
	}
	public void refresh() {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);  
		totalCount = attdao.countAtt();
		//tìm số trang của bảng 
		totalPage = Math.ceil(totalCount.doubleValue() / rowOfPage.doubleValue());
		
		attdao.getAtt(pageNumber,rowOfPage).stream().forEach(att -> model.addRow(new Object[] {
						att.getAttendance_id(),
						att.getWorkschedule_id(),
						showEmp_id(att.getWorkschedule_id()),
						showShift(att.getWorkschedule_id()),
						showDate(att.getWorkschedule_id()),
						att.isPresent(),
						att.getArrival_time(),
						att.getDeparture_time(),
						att.getLeave_type()
		}));
		hidenextlast();
	}
	
//	public void validation() {
//		if(textFsche.getText() == null && ) {
//			
//		}
//	}
	
	public int validateAtt() {
		int count =0;
		int ss = cbbType.getSelectedIndex();
		if(!chckbxGender.isSelected() && ss==0) {
			JOptionPane.showMessageDialog(null, "CANNOT chosse 'Null' at 'Type' if Employee was absent");
			count++;
		}
		return count;
	}
	protected void textFieldActionPerformed(ActionEvent e) {
		String find = textSearch.getText();
		
		DefaultRowSorter<?,?> sorter = (DefaultRowSorter<?,?>)table.getRowSorter();
		
		sorter.setRowFilter(RowFilter.regexFilter(find));
		sorter.setSortKeys(null);
	}
	
	protected void tableMouseClicked(MouseEvent e) {
		int rowIndex = table.getSelectedRow();
		lblFid.setText(table.getValueAt(rowIndex, 0).toString());
		textFsche.setText(table.getValueAt(rowIndex, 1).toString());
		lblFemp.setText(table.getValueAt(rowIndex, 2).toString());
		lblFshift.setText(table.getValueAt(rowIndex, 3).toString());
		try {
			dateChooser.setDate(
					new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(rowIndex, 4).toString())
					);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		chckbxGender.setSelected(table.getValueAt(rowIndex, 5).toString().equals("true"));
		if(table.getValueAt(rowIndex, 6) == null) {
			lblArrivalTime.setText("");
		}else {
			lblArrivalTime.setText(table.getValueAt(rowIndex, 6).toString());
		}
		
		
		if(table.getValueAt(rowIndex, 7) == null) {
			lblDepTime.setText("");
		}else {
			lblDepTime.setText(table.getValueAt(rowIndex, 7).toString());
		}
		
		if(table.getValueAt(rowIndex, 8) == null) {
			cbbType.setSelectedIndex(0);
		}else {
			cbbType.setSelectedIndex((table.getValueAt(rowIndex, 8).toString().equals("P") ? 1:2));
		}
		
		
		
	}
	protected void chckbxGenderItemStateChanged(ItemEvent e) {
		if(chckbxGender.isSelected()) {
			//cbbType.insertItemAt("Null", 0);
			cbbType.setSelectedIndex(0);
			cbbType.setEnabled(false);
			lblArrivalTime.setEnabled(true);
			lblDepTime.setEnabled(true);
		}else {
			cbbType.setEnabled(true);
			//cbbType.removeItem("Null");
			lblArrivalTime.setText("");;
			lblDepTime.setText("");
			lblArrivalTime.setEnabled(false);
			lblDepTime.setEnabled(false);
		}
	}
	public void resetfield() {
		lblFid.setText("");
		textFsche.setText("");
		chckbxGender.setSelected(false);
		lblArrivalTime.setText("");
		lblDepTime.setText("");
		
	}
	protected void lblUpdateMouseClicked(MouseEvent e) {
		if(lblFid.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Please select row to update");
		}else if(validateAtt()!=0) {
			return;
		}
		else {
		Attendance newatt = new Attendance();
		newatt.setAttendance_id(Integer.parseInt(lblFid.getText()));
		newatt.setWorkschedule_id(Integer.parseInt(textFsche.getText()));
		newatt.setPresent(chckbxGender.isSelected());
		newatt.setArrival_time(Time.valueOf(lblArrivalTime.getText()));
		newatt.setDeparture_time(Time.valueOf(lblDepTime.getText()));
		int a = cbbType.getSelectedIndex();
		String c;
		if(a ==0) {
			c=null;
			
		}else {
			c=(a==1)? "P" : "WP";
		}
		newatt.setLeave_type(c);
		
		attdao.update(newatt);
		refresh();
		}
	}
	protected void lblDeleteMouseClicked(MouseEvent e) {
		if(lblFid.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Please select row to delete");
		}else {
		int a = Integer.parseInt(lblFid.getText());
		int choose=JOptionPane.showConfirmDialog(null,"Are you sure want to delete?","Delete",JOptionPane.YES_NO_OPTION);
		if(choose == JOptionPane.YES_OPTION) {
			attdao.delete(a);
			refresh();
		}
		}
	}
	protected void txtPageActionPerformed(ActionEvent e) {
		int a = Integer.parseInt(txtPage.getText());
		if(a > totalPage.intValue() && a<1) {
			JOptionPane.showMessageDialog(null, "Page number is invalid!");
			return;
		}
		pageNumber=a;
		refresh();
	}
	protected void lblNextMouseClicked(MouseEvent e) {
		if(pageNumber < totalPage.intValue()) {
			pageNumber++;
			txtPage.setText(pageNumber+"");
			refresh();
		}
	}
	protected void lblPreviousMouseClicked(MouseEvent e) {
		if(pageNumber > 1) {
			pageNumber--;
			txtPage.setText(pageNumber+"");
			refresh();
		}
	}
	protected void lblFirstMouseClicked(MouseEvent e) {	
			pageNumber=1;
			txtPage.setText(pageNumber+"");
			refresh();
	}
	protected void lblLastMouseClicked(MouseEvent e) {
		pageNumber=totalPage.intValue();
		txtPage.setText(pageNumber+"");
		refresh();
	}
	protected void lblUpdateMouseEntered(MouseEvent e) {
		lblUpdate.setForeground(Color.GREEN);
		lblUpdate.setBackground(Color.white);
		lblUpdate.setBorder(new LineBorder(Color.green));
		
	}
	protected void lblUpdateMouseExited(MouseEvent e) {
		lblUpdate.setForeground(Color.white);
		lblUpdate.setBackground(Color.green);
	}
	protected void lblDeleteMouseEntered(MouseEvent e) {
		lblDelete.setForeground(Color.red);
		lblDelete.setBackground(Color.white);
		lblDelete.setBorder(new LineBorder(Color.red));
	}
	protected void lblDeleteMouseExited(MouseEvent e) {
		lblDelete.setForeground(Color.white);
		lblDelete.setBackground(Color.red);
	}
}
