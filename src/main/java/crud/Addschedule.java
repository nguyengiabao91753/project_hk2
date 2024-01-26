package crud;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

import dao.RoomDAO;
import dao.ShiftDAO;
import entity.Room;
import entity.Shift;
import entity.Workschedule;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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

	}
	protected void lblNewLabel_2MouseClicked(MouseEvent e) {
		System.exit(0);
	}
	private void loadcbb() {
		// TODO Auto-generated method stub
		var shiftmodel = new DefaultComboBoxModel();
		var roommodel = new DefaultComboBoxModel();
		List<Shift> listshift = new ArrayList<>();
		List<Room> listroom = new ArrayList<>();
		ShiftDAO shiftdao = new ShiftDAO();
		RoomDAO roomdao = new RoomDAO();
		
		shiftmodel.addAll(listshift);
		roommodel.addAll(listroom);
		cbbShift.setModel(shiftmodel);
		
	}	
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		Workschedule newwork = new Workschedule();
		newwork.setEmployee_id(Integer.parseInt(txtEmp.getText()));
		newwork.setShift_id(cbbShift.getSelectedIndex()+1);
	}
}
