package User_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;

public class Location extends JInternalFrame {
	
	private JComponent Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarca =null;
	private static final long serialVersionUID = 1L;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
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
	public Location() {
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
		JLabel lblNewLabel_1 = new JLabel("Location");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(81, 11, 161, 50);
		panel.add(lblNewLabel_1);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(81, 57, 140, 4);
		panel.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("B.Y.D's Management System");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(81, 61, 161, 18);
		panel.add(lblNewLabel_2);
		JPanel panelContent = new JPanel();
		panelContent.setForeground(Color.BLACK);
		panelContent.setBackground(Color.WHITE);
		panelContent.setBounds(0, 101, 1180, 536);
		getContentPane().add(panelContent);
		panelContent.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(51, 45, 777, 406);
		panelContent.add(scrollPane);
		
		JTable table = new JTable();
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);

	}
//	public void loaddata() {
//		DefaultTableModel model = new DefaultTableModel() {
//			@Override
//	         public boolean isCellEditable(int row, int column) {
//	             
//	             return false;
//	         }
//		};
//		
//		 
//		 
//		model.addColumn("Date");
//		model.addColumn("Shift");
//		model.addColumn("Room");
//		
//		workdao.getpersonSchedule(UserLogin.getUserId()).stream().forEach(work -> model.addRow(new Object[] {
//					work.getWork_date(),
//					nameShift(work.getShift_id()),
//					nameRoom(work.getRoom_id())
//			}));
//		
//		
//		table.setModel(model);
//		table.setRowHeight(40);
//	}
}
