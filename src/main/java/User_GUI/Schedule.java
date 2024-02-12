package User_GUI;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import App.App_User;
import dao.RoomDAO;
import dao.ShiftDAO;
import dao.WorkscheduleDAO;
import entity.Room;
import entity.Shift;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Schedule extends JInternalFrame {

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
	private JButton btnApply;
	private JLabel lblMonth;
	private JLabel lblYear;
	private JLabel lblNewLabel_6;
	private JSeparator separator;
	private JComboBox cbbYear;
	private JTable table;
	
	WorkscheduleDAO workdao = new WorkscheduleDAO();
	ShiftDAO shiftdao = new ShiftDAO();
	RoomDAO roomdao = new RoomDAO();
	private JLabel lblNewLabel_7;
	private JComboBox cbbShow;
	private JComboBox cbbMonth;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Schedule frame = new Schedule();
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
	public Schedule() {
		
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
		
		lblNewLabel_1 = new JLabel("Schedule");
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(51, 45, 777, 406);
		panelContent.add(scrollPane);
		
		table = new JTable();
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		
		btnApply = new JButton("Apply");
		btnApply.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnApply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnApplyMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnApplyMouseExited(e);
			}
		});
		btnApply.setBackground(SystemColor.activeCaption);
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnApplyActionPerformed(e);
			}
		});
		btnApply.setVisible(false);
		btnApply.setForeground(Color.WHITE);
		btnApply.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnApply.setBounds(999, 264, 101, 35);
		panelContent.add(btnApply);
		
		lblMonth = new JLabel("Month:");
		lblMonth.setVisible(false);
		lblMonth.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblMonth.setBounds(886, 153, 57, 30);
		panelContent.add(lblMonth);
		
		lblYear = new JLabel("Year:");
		lblYear.setVisible(false);
		lblYear.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblYear.setBounds(886, 206, 57, 30);
		panelContent.add(lblYear);
		
		lblNewLabel_6 = new JLabel("Filter:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_6.setBounds(886, 43, 214, 23);
		panelContent.add(lblNewLabel_6);
		
		separator = new JSeparator();
		separator.setBounds(886, 64, 214, 3);
		panelContent.add(separator);
		
		cbbYear = new JComboBox();
		cbbYear.setVisible(false);
		cbbYear.setModel(new DefaultComboBoxModel(new String[] {"2024"}));
		cbbYear.setBounds(999, 206, 101, 35);
		panelContent.add(cbbYear);
		
		lblNewLabel_7 = new JLabel("Show:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_7.setBounds(886, 92, 57, 30);
		panelContent.add(lblNewLabel_7);
		
		cbbShow = new JComboBox();
		cbbShow.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBox_1ItemStateChanged(e);
			}
		});
		cbbShow.setModel(new DefaultComboBoxModel(new String[] {"All", "Filter"}));
		cbbShow.setBounds(999, 92, 101, 35);
		panelContent.add(cbbShow);
		
		cbbMonth = new JComboBox();
		cbbMonth.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cbbMonthItemStateChanged(e);
			}
		});
		cbbMonth.setVisible(false);
		cbbMonth.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbbMonth.setBounds(999, 148, 101, 35);
		panelContent.add(cbbMonth);
		
		loaddata();
	}
	
	

	protected void lblNewLabelMouseClicked(MouseEvent e) {
		System.exit(0);
	}
	protected void lblNewLabel_3MouseClicked(MouseEvent e) {
		App_User appus = new App_User();
		appus.setLocationRelativeTo(null);
		appus.setUndecorated(true);
		appus.setVisible(true);
	    this.setVisible(false);
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
	
	public void loaddata() {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
	         public boolean isCellEditable(int row, int column) {
	             
	             return false;
	         }
		};
		
		 
		 
		model.addColumn("Date");
		model.addColumn("Shift");
		model.addColumn("Room");
		
		workdao.getpersonSchedule(1).stream().forEach(work -> model.addRow(new Object[] {
					work.getWork_date(),
					nameShift(work.getShift_id()),
					nameRoom(work.getRoom_id())
			}));
		
		
		table.setModel(model);
		table.setRowHeight(40);
	}
	protected void comboBox_1ItemStateChanged(ItemEvent e) {
		if(cbbShow.getSelectedItem().toString().equals("All")) {
			lblMonth.setVisible(false);
			lblYear.setVisible(false);
			cbbMonth.setVisible(false);
			cbbYear.setVisible(false);
			btnApply.setVisible(false);
		}else {
			lblMonth.setVisible(true);
			lblYear.setVisible(true);
			cbbMonth.setVisible(true);
			cbbYear.setVisible(true);
			btnApply.setVisible(true);
		}
	}
	protected void cbbMonthItemStateChanged(ItemEvent e) {
		
	}
	protected void btnApplyActionPerformed(ActionEvent e) {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);  
		workdao.getpersonSchedule(1)
        .stream()
        .filter(work -> work.getWork_date().getMonthValue() == Integer.parseInt(cbbMonth.getSelectedItem().toString())  )
        .forEach(work -> model.addRow(new Object[] {
                work.getWork_date(),
                nameShift(work.getShift_id()),
                nameRoom(work.getRoom_id())
        }));
		
	}
	protected void btnApplyMouseEntered(MouseEvent e) {
		btnApply.setBackground(Color.white);
		btnApply.setForeground(SystemColor.activeCaption);
		btnApply.setBorder(new LineBorder(SystemColor.activeCaption));
	}
	protected void btnApplyMouseExited(MouseEvent e) {
		btnApply.setBackground(SystemColor.activeCaption);
		btnApply.setForeground(Color.white);
	}
}
