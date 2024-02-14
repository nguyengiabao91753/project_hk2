package crud;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import App.App_Admin;
import Gui.Job_Position;
import Gui.Manage_Departments;
import Gui.Work_Schedules;
import dao.Manage_DepartmentsDAO;
import dao.PositionDAO;
import dao.RoomDAO;
import dao.ShiftDAO;
import dao.WorkscheduleDAO;
import entity.Department;
import entity.Position;
import entity.Room;
import entity.Shift;
import entity.Workschedule;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class AddPosition extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField txtID;
	private JTextField txtNAME;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JButton btnInput;
	private JButton btnNewButton_1;
	private JLabel lblCreateDepartment;
	private static AddPosition instance ;
	AddDepartment AddDep ;
	private Object DimensionBarca;
	private JComponent Barca;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDepartment frame = new AddDepartment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static AddPosition getInstance() {
        if (instance == null) {
            instance = new AddPosition();
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
	public AddPosition() {
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		quit();
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(0,0,957,626);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 788, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(100, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(204, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(139, 162, 214, 38);
		panel.add(txtID);
		txtID.setColumns(10);
		
		txtNAME = new JTextField();
		txtNAME.setColumns(10);
		txtNAME.setBounds(549, 162, 214, 38);
		panel.add(txtNAME);
		
		lblNewLabel = new JLabel(" ID :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(29, 162, 100, 38);
		panel.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(423, 162, 125, 38);
		panel.add(lblNewLabel_2);
		
		btnInput = new JButton("CREATE");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInputActionPerformed(e);
			}
		});
		btnInput.setBackground(Color.BLUE);
		btnInput.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnInput.setBounds(319, 276, 142, 38);
		panel.add(btnInput);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\Back (1).png"));
		btnNewButton_1.setBounds(10, 14, 60, 38);
		panel.add(btnNewButton_1);
		
		lblCreateDepartment = new JLabel("     CREATE POSITION");
		lblCreateDepartment.setForeground(Color.BLUE);
		lblCreateDepartment.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblCreateDepartment.setBounds(229, 14, 357, 52);
		panel.add(lblCreateDepartment);
		getContentPane().setLayout(groupLayout);
	}
	protected void btnInputActionPerformed(ActionEvent e) {
		if(validatePosition()!=0) {
			return;
		}else {
	Position Pos = new Position();
	Pos.setPosition_name(txtNAME.getText()+1);
	PositionDAO workdao = new PositionDAO();
	if(workdao.insert(Pos)) {
		JOptionPane.showMessageDialog(null, "Add successfully!");
		Job_Position work = new Job_Position();
		work.setVisible(true);;
		App_Admin app = new App_Admin();
		app.desktopPane.add(work);
		this.hide();
	}
		}
}
	public int validatePosition() {
		int count = 0 ;
		if( txtNAME.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill in all information");
			count++;
		}
		return count;
	}
}
