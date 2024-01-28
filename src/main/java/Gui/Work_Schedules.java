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

public class Work_Schedules extends JInternalFrame {
	
	private JComponent Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarca =null;
	private static final long serialVersionUID = 1L;
	private static Work_Schedules instance ;
	private JScrollPane scrollPane;
	private JTextField textSearch;
	private JLabel lblUpdate;
	private JLabel lblDelete;
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
	
	RoomDAO roomdao = new RoomDAO();
	ShiftDAO shiftdao = new ShiftDAO();
	
	WorkscheduleDAO workdao = new WorkscheduleDAO();
	private JTextField textPageNum;
	private JButton btnAdd;
	private JPanel panel;
	private App_Admin app;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTable table;
	
	
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
		
		lblUpdate = new JLabel("UPDATE");
		lblUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblUpdateMouseClicked(e);
			}
		});
		lblUpdate.setForeground(Color.WHITE);
		lblUpdate.setBackground(new Color(0, 255, 64));
		lblUpdate.setOpaque(true);
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setBounds(29, 313, 76, 27);
		getContentPane().add(lblUpdate);
		
		lblDelete = new JLabel("DELETE");
		lblDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblDeleteMouseClicked(e);
			}
		});
		lblDelete.setForeground(Color.WHITE);
		lblDelete.setOpaque(true);
		lblDelete.setBackground(new Color(255, 0, 0));
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setBounds(146, 313, 76, 27);
		getContentPane().add(lblDelete);
		
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
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 0, 937, 541);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\doan_ky2\\images\\icons8-next-24 (1).png"));
		lblNewLabel_5.setBounds(852, 418, 29, 24);
		panel.add(lblNewLabel_5);
		
		textPageNum = new JTextField();
		textPageNum.setBounds(760, 418, 86, 24);
		panel.add(textPageNum);
		textPageNum.setHorizontalAlignment(SwingConstants.CENTER);
		textPageNum.setText("1");
		textPageNum.setColumns(10);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\doan_ky2\\images\\icons8-last-24.png"));
		lblNewLabel_6.setBounds(876, 418, 29, 24);
		panel.add(lblNewLabel_6);
		
		loadWorkSchedule();
		table.setRowHeight(32);
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
		
		workdao.selectAllSchedule().stream().forEach(work -> model.addRow(new Object[] {
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
		workdao.selectAllSchedule().stream().forEach(work -> model.addRow(new Object[] {
				work.getId(),
				work.getEmployee_id(),
				nameRoom(work.getRoom_id()),
				nameShift(work.getShift_id()),
				work.getWork_date()
		}));
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
	protected void lblUpdateMouseClicked(MouseEvent e) {
		Workschedule worknew = new Workschedule();
		worknew.setId(Integer.parseInt(lblId.getText()));
		worknew.setEmployee_id(Integer.parseInt(txtEmployee.getText()));
		worknew.setShift_id(cbbShift.getSelectedIndex()+1);
		worknew.setRoom_id(cbbRoom.getSelectedIndex()+1);
		worknew.setWork_date(LocalDate.ofInstant(dateChooser.getDate().toInstant(), ZoneId.systemDefault()));
		
		workdao.update(worknew);
		refresh();
	}
	protected void lblDeleteMouseClicked(MouseEvent e) {
		JOptionPane.showConfirmDialog(null,"Are you sure want to delete?","Delete",JOptionPane.YES_NO_OPTION);
		int a = Integer.parseInt(lblId.getText());
		workdao.delete(a);
		refresh();
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
}
