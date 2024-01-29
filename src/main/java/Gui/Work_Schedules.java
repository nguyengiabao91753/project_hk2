package Gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import App.App_Admin;
import crud.Addschedule;
import dao.RoomDAO;
import dao.ShiftDAO;
import dao.WorkscheduleDAO;
import entity.Room;
import entity.Shift;
import entity.Workschedule;

import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultRowSorter;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class Work_Schedules extends JInternalFrame {
	
	private JComponent Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarca =null;
	private static final long serialVersionUID = 1L;
	private static Work_Schedules instance ;
	private JScrollPane scrollPane;
	private JTextField textSearch;
	private JLabel lblId;
	private JDateChooser dateChooser;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JComboBox cbbRoom;
	private JComboBox cbbShift;
	private JTextField txtEmployee;
	
	Integer pageNumber =1;
	Integer rowOfPage =10;
	Double totalPage =0.0;
	Integer totalCount =0;
	
	
	RoomDAO roomdao = new RoomDAO();
	ShiftDAO shiftdao = new ShiftDAO();
	
	WorkscheduleDAO workdao = new WorkscheduleDAO();
	private JButton btnAdd;
	private App_Admin app;
	private JTable table;
	private JLabel lblnext;
	private JTextField textPage;
	private JLabel lbllast;
	private JLabel lblDelete;
	private JLabel lblUpdate;
	private JLabel lblprevious;
	private JLabel lblfirst;
	
	
	public void setApp(App_Admin app) {
		this.app = app;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Work_Schedules frame = new Work_Schedules();
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
			lblfirst.setVisible(false);
			lblprevious.setVisible(false);
		}else {
			lblfirst.setVisible(true);
			lblprevious.setVisible(true);
		}
		if(pageNumber == totalPage.intValue()) {
			lblnext.setVisible(false);
			lbllast.setVisible(false);
		}else {
			lblnext.setVisible(true);
			lbllast.setVisible(true);
		}
	}
	public void quit() {
		Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
		DimensionBarca =Barca.getPreferredSize();
		Barca.setSize(0,0);
		Barca.setPreferredSize(new Dimension(0,0));
		repaint();
	}
    public static Work_Schedules getInstance() {
        if (instance == null) {
            instance = new Work_Schedules();
        }
        return instance;
    }
	public Work_Schedules() {
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		quit();
		
		getContentPane().setBackground(Color.WHITE);
		setTitle("Work_Schedules");
		setBounds(223, 37, 957, 626);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		scrollPane.setBounds(267, 58, 664, 347);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		
		textSearch = new JTextField();
		textSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textSearchActionPerformed(e);
			}
		});
		textSearch.setBorder(new TitledBorder(null, "Search: ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		textSearch.setBounds(267, 11, 105, 36);
		getContentPane().add(textSearch);
		textSearch.setColumns(10);
		
		lblId = new JLabel("");
		lblId.setEnabled(false);
		lblId.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		lblId.setOpaque(true);
		lblId.setBackground(Color.WHITE);
		lblId.setBounds(99, 98, 149, 25);
		getContentPane().add(lblId);
		
		dateChooser = new JDateChooser();
		dateChooser.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		dateChooser.setBounds(99, 251, 149, 31);
		getContentPane().add(dateChooser);
		
		lblNewLabel = new JLabel("ID:");
		lblNewLabel.setForeground(SystemColor.textInactiveText);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel.setBounds(29, 98, 46, 25);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Employee:");
		lblNewLabel_1.setForeground(SystemColor.textInactiveText);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(29, 134, 78, 27);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Room:");
		lblNewLabel_2.setForeground(SystemColor.textInactiveText);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(29, 172, 46, 25);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Shift:");
		lblNewLabel_3.setForeground(SystemColor.textInactiveText);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(29, 212, 46, 27);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Date:");
		lblNewLabel_4.setForeground(SystemColor.textInactiveText);
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(29, 257, 46, 25);
		getContentPane().add(lblNewLabel_4);
		
		cbbRoom = new JComboBox();
		cbbRoom.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		cbbRoom.setBackground(Color.WHITE);
		cbbRoom.setBounds(99, 170, 149, 30);
		getContentPane().add(cbbRoom);
		
		cbbShift = new JComboBox();
		cbbShift.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		cbbShift.setBackground(Color.WHITE);
		cbbShift.setBounds(99, 211, 149, 30);
		getContentPane().add(cbbShift);
		
		txtEmployee = new JTextField();
		txtEmployee.setBounds(99, 134, 149, 27);
		getContentPane().add(txtEmployee);
		txtEmployee.setColumns(10);
		
		btnAdd = new JButton("ADD");
		btnAdd.setBackground(new Color(0, 102, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});
		btnAdd.setBounds(267, 416, 89, 23);
		getContentPane().add(btnAdd);
		
		loadWorkSchedule();
		table.setRowHeight(32);
		
		lblnext = new JLabel("");
		lblnext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblnextMouseClicked(e);
			}
		});
		lblnext.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\doan_ky2\\images\\icons8-next-24 (1).png"));
		lblnext.setBounds(878, 416, 24, 24);
		getContentPane().add(lblnext);
		
		textPage = new JTextField();
		textPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPageActionPerformed(e);
			}
		});
		textPage.setText("1");
		textPage.setHorizontalAlignment(SwingConstants.CENTER);
		textPage.setColumns(10);
		textPage.setBounds(840, 416, 38, 24);
		getContentPane().add(textPage);
		
		lbllast = new JLabel("");
		lbllast.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbllastMouseClicked(e);
			}
		});
		lbllast.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\doan_ky2\\images\\icons8-last-24.png"));
		lbllast.setBounds(907, 416, 24, 24);
		getContentPane().add(lbllast);
		
		lblDelete = new JLabel("DELETE");
		lblDelete.setOpaque(true);
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setForeground(Color.WHITE);
		lblDelete.setBackground(Color.RED);
		lblDelete.setBounds(159, 304, 76, 27);
		getContentPane().add(lblDelete);
		
		lblUpdate = new JLabel("UPDATE");
		lblUpdate.setOpaque(true);
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setForeground(Color.WHITE);
		lblUpdate.setBackground(new Color(0, 255, 64));
		lblUpdate.setBounds(42, 304, 76, 27);
		getContentPane().add(lblUpdate);
		
		lblprevious = new JLabel("");
		lblprevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblpreviousMouseClicked(e);
			}
		});
		lblprevious.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\doan_ky2\\images\\icons8-next-24 (2).png"));
		lblprevious.setBounds(817, 416, 24, 24);
		getContentPane().add(lblprevious);
		
		lblfirst = new JLabel("");
		lblfirst.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblfirstMouseClicked(e);
			}
		});
		lblfirst.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\doan_ky2\\images\\icons8-last-24 (1).png"));
		lblfirst.setBounds(790, 416, 24, 24);
		getContentPane().add(lblfirst);
		
		hidenextlast();
	}
//	public void String nameEmpolyee(int a) {
//		List<Employee> listEmp = 
//	}
	public String nameRoom(int a) {
		List<Room> listRoom = roomdao.selectAllRoom();
		for (Room room : listRoom) {
			if(a == room.getId()) {
				return room.getName();
			}
		}
		return null;
	}
	public String nameShift(int a) {
		List<Shift> listShift = shiftdao.getAllShift();
		for (Shift shift : listShift) {
			if(a== shift.getId()) {
				return shift.getStart()+"-"+shift.getEnd();
			}
		}
		return null;
	}
	
	public void loadWorkSchedule() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Employee_id");
		model.addColumn("Room");
		model.addColumn("Shift");
		model.addColumn("Work date");
		
		//tìm trong bảng customer tổng số dòng
		 totalCount = workdao.countSchedule();
		//tìm số trang của bảng 
		totalPage = Math.ceil(totalCount.doubleValue() / rowOfPage.doubleValue());
		
		workdao.getSchedule(pageNumber, rowOfPage).stream().forEach(work -> model.addRow(new Object[] {
				work.getId(),
				work.getEmployee_id(),
				nameRoom(work.getRoom_id()),
				nameShift(work.getShift_id()),
				work.getWork_date()
		}));
		table.setModel(model);
	}
	public void refresh() {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0); 
		workdao.getSchedule(pageNumber, rowOfPage).stream().forEach(work -> model.addRow(new Object[] {
				work.getId(),
				work.getEmployee_id(),
				nameRoom(work.getRoom_id()),
				nameShift(work.getShift_id()),
				work.getWork_date()
		}));
		hidenextlast();
	}
	protected void textSearchActionPerformed(ActionEvent e) {
		String find = textSearch.getText();
		DefaultRowSorter<?,?> sorter = (DefaultRowSorter<?,?>)table.getRowSorter();
		sorter.setRowFilter(RowFilter.regexFilter(find));
		sorter.setSortKeys(null);
	}
	protected void btnAddActionPerformed(ActionEvent e) {
		
//		if(add == null || add.isClosed()) {
//			add  = new Addschedule();
//			add.setBounds(0,0,957,626);
//			add.show();
//			add.toFront();
//		}
		
		Addschedule add = new Addschedule().getInstance();
		if(!add.isVisible()) {
			add.setVisible(true);
			
			app.desktopPane.add(add);
			add.toFront();
			this.hide();
			//app.pack();
		}
	}
	protected void tableMouseClicked(MouseEvent e) {
		int rowIndex = table.getSelectedRow();
		lblId.setText(table.getValueAt(rowIndex, 0).toString());
		txtEmployee.setText(table.getValueAt(rowIndex, 1).toString());
		
		var roommodel = new DefaultComboBoxModel();
		var shiftmodel = new DefaultComboBoxModel();
		
		List<Room> listRoom = roomdao.selectAllRoom();
		List<Shift> listshift = shiftdao.getAllShift();
		
		roommodel.addAll(listRoom);
		shiftmodel.addAll(listshift);
		
		cbbRoom.setModel(roommodel);
		cbbShift.setModel(shiftmodel);
		
		for (Room room : listRoom) {
			var room_select = table.getValueAt(rowIndex, 2).toString();
			if(room_select.equals(room.getName())) {
				cbbRoom.setSelectedIndex(room.getId()-1);
			}
		}
		
		for(Shift shift : listshift) {
			var shift_selected = table.getValueAt(rowIndex, 3).toString();
			if(shift_selected.equals(shift.getStart()+"-"+shift.getEnd())){
				cbbShift.setSelectedIndex(shift.getId()-1);
			}
		}
		
		try {
			dateChooser.setDate(
					new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(rowIndex, 4).toString())
					);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	protected void lblnextMouseClicked(MouseEvent e) {
		if(pageNumber < totalPage.intValue()) {
			pageNumber++;
			textPage.setText(pageNumber.toString());
			refresh();
		}

	}
	protected void lblpreviousMouseClicked(MouseEvent e) {
		if(pageNumber >0) {
			pageNumber--;
			textPage.setText(pageNumber.toString());
			refresh();
		}
	}
	protected void textPageActionPerformed(ActionEvent e) {
		int num = Integer.parseInt(textPage.getText()) ;
		if(num>0 && num<totalPage.intValue()) {
			pageNumber = num;
			refresh();
		}else {
			JOptionPane.showMessageDialog(null, "Page Number is invalid");
		}
	}
	protected void lbllastMouseClicked(MouseEvent e) {
		pageNumber = totalPage.intValue();
		textPage.setText(pageNumber.toString());
		refresh();
	}
	protected void lblfirstMouseClicked(MouseEvent e) {
		pageNumber = 1;
		textPage.setText(pageNumber.toString());
		refresh();
	}
}
