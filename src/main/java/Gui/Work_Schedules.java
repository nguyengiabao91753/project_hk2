package Gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import dao.RoomDAO;
import dao.ShiftDAO;
import dao.WorkscheduleDAO;
import entity.Room;
import entity.Shift;

import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;

public class Work_Schedules extends JInternalFrame {
	
	private JComponent Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarca =null;
	private static final long serialVersionUID = 1L;
	private static Work_Schedules instance ;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField textSearch;
	private JLabel lblAdd;
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
		table.setFillsViewportHeight(true);
		table.setBorder(new LineBorder(new Color(192, 192, 192)));
		scrollPane.setColumnHeaderView(table);
		
		textSearch = new JTextField();
		textSearch.setBorder(new TitledBorder(null, "Search: ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		textSearch.setBounds(267, 11, 105, 36);
		getContentPane().add(textSearch);
		textSearch.setColumns(10);
		
		lblAdd = new JLabel("ADD");
		lblAdd.setForeground(new Color(255, 255, 255));
		lblAdd.setOpaque(true);
		lblAdd.setBackground(new Color(51, 0, 255));
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setBounds(855, 421, 76, 27);
		getContentPane().add(lblAdd);
		
		lblUpdate = new JLabel("UPDATE");
		lblUpdate.setForeground(Color.WHITE);
		lblUpdate.setBackground(new Color(0, 255, 64));
		lblUpdate.setOpaque(true);
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setBounds(29, 313, 76, 27);
		getContentPane().add(lblUpdate);
		
		lblDelete = new JLabel("DELETE");
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
		lblId.setBounds(117, 98, 105, 25);
		getContentPane().add(lblId);
		
		dateChooser = new JDateChooser();
		dateChooser.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		dateChooser.setBounds(117, 251, 105, 31);
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
		cbbRoom.setBounds(117, 170, 105, 30);
		getContentPane().add(cbbRoom);
		
		cbbShift = new JComboBox();
		cbbShift.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		cbbShift.setBackground(Color.WHITE);
		cbbShift.setBounds(117, 211, 105, 30);
		getContentPane().add(cbbShift);
		
		txtEmployee = new JTextField();
		txtEmployee.setBounds(117, 134, 105, 27);
		getContentPane().add(txtEmployee);
		txtEmployee.setColumns(10);
		
		loadWorkSchedule();
	}
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
	protected void tableMouseClicked(MouseEvent e) {
		int rowIndex = table.getSelectedRow();
		lblId.setText(table.getValueAt(rowIndex, 0).toString());
		txtEmployee.setText(table.getValueAt(rowIndex, 1).toString());
		
		var roommodel = new DefaultComboBoxModel();
		
		List<Room> listRoom = roomdao.selectAllRoom();
		
		roommodel.addAll(listRoom);
		cbbRoom.setModel(roommodel);
		for (Room room : listRoom) {
			var room_select = table.getValueAt(rowIndex, 2).toString();
			if(room_select.equals(room.getName())) {
				cbbRoom.setSelectedIndex(room.getId()-1);
			}
		}
		try {
			dateChooser.setDate(
					new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(rowIndex, 4).toString())
					);
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
	}
}
