package Gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

public class Work_Schedules extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private static Work_Schedules instance ;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField textSearch;
	private JLabel lblAdd;
	private JLabel lblUpdate;
	private JLabel lblDelete;
	private JLabel lblId;
	private JLabel lblEmploy_id;
	private JLabel lblShift;
	private JLabel lblRoom;
	private JDateChooser dateChooser;

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
    public static Work_Schedules getInstance() {
        if (instance == null) {
            instance = new Work_Schedules();
        }
        return instance;
    }
	public Work_Schedules() {
		setTitle("Work_Schedules");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 525, 384);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 47, 323, 155);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textSearch = new JTextField();
		textSearch.setBorder(new TitledBorder(null, "Search: ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		textSearch.setBounds(10, 11, 105, 30);
		getContentPane().add(textSearch);
		textSearch.setColumns(10);
		
		lblAdd = new JLabel("Add");
		lblAdd.setOpaque(true);
		lblAdd.setBackground(new Color(0, 128, 255));
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setBounds(387, 47, 76, 27);
		getContentPane().add(lblAdd);
		
		lblUpdate = new JLabel("Update");
		lblUpdate.setBackground(new Color(0, 255, 64));
		lblUpdate.setOpaque(true);
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setBounds(387, 97, 76, 27);
		getContentPane().add(lblUpdate);
		
		lblDelete = new JLabel("Delete");
		lblDelete.setOpaque(true);
		lblDelete.setBackground(new Color(255, 0, 0));
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setBounds(387, 145, 76, 27);
		getContentPane().add(lblDelete);
		
		lblId = new JLabel("");
		lblId.setBorder(new TitledBorder(null, "Id: ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		lblId.setBounds(20, 227, 46, 14);
		getContentPane().add(lblId);
		
		lblEmploy_id = new JLabel("");
		lblEmploy_id.setBorder(new TitledBorder(null, "Employee_id: ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		lblEmploy_id.setBounds(76, 227, 46, 14);
		getContentPane().add(lblEmploy_id);
		
		lblShift = new JLabel("");
		lblShift.setBorder(new TitledBorder(null, "Shift: ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		lblShift.setBounds(142, 227, 46, 14);
		getContentPane().add(lblShift);
		
		lblRoom = new JLabel("");
		lblRoom.setBorder(new TitledBorder(null, "Room: ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		lblRoom.setBounds(212, 227, 46, 14);
		getContentPane().add(lblRoom);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(281, 221, 74, 20);
		getContentPane().add(dateChooser);
		
		loadWorkSchedule();
	}
	
	public void loadWorkSchedule() {
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Id");
		model.addColumn("Employee_id");
		model.addColumn("Shift");
		model.addColumn("Room");
		model.addColumn("Work date");
		
		table.setModel(model);
	}
}
