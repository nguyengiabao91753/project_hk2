package crud;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import App.App_Admin;
import App.App_User;
import Gui.Manage_Departments;
import Gui.Work_Schedules;
import dao.Manage_DepartmentsDAO;
import dao.RoomDAO;
import dao.ShiftDAO;
import dao.WorkscheduleDAO;
import entity.Department;
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
import javax.swing.JDesktopPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
public class AddDepartment extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField txtID;
	private JTextField txtNAME;
	private JTextField txtDEPARTMENT;
	private JLabel lblNewLabel;
	private JLabel lblName;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnInput;
	private JLabel lblCreateDepartment;
	private static AddDepartment instance ;
	private Object DimensionBarca;
	private JComponent Barca;
	private JComboBox cbbRoom;
	private JLabel lblBack;
	private App_Admin app;
	Manage_Departments dep;
	private JDesktopPane desktopPane;
	/**
	 * Launch the application.
	 */
	public void setApp(App_Admin app) {
		this.app = app;
	}
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
	public static AddDepartment getInstance() {
        if (instance == null) {
            instance = new AddDepartment();
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
	protected void loadDep() {
		// TODO Auto-generated method stub
		var roommodel = new DefaultComboBoxModel();
		
		
		RoomDAO roomdao = new RoomDAO();
		List<Room> listroom = roomdao.selectAllRoom();
		
		
		roommodel.addAll(listroom);
		
		cbbRoom.setModel(roommodel);
		
	}	
	public AddDepartment() {
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		quit();
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(0,0,957,626);
		
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.background"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(75)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 788, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(78, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(218, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(140, 133, 214, 38);
		panel.add(txtID);
		txtID.setColumns(10);
		
		txtNAME = new JTextField();
		txtNAME.setColumns(10);
		txtNAME.setBounds(140, 199, 214, 38);
		panel.add(txtNAME);
		
		txtDEPARTMENT = new JTextField();
		txtDEPARTMENT.setColumns(10);
		txtDEPARTMENT.setBounds(550, 133, 214, 38);
		panel.add(txtDEPARTMENT);
		
		lblNewLabel = new JLabel(" ID :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(30, 133, 100, 38);
		panel.add(lblNewLabel);
		
		lblName = new JLabel("NAME :");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblName.setBounds(30, 199, 100, 38);
		panel.add(lblName);
		
		lblNewLabel_2 = new JLabel("DEPARTMENT :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(424, 133, 125, 38);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("ROOM :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(424, 199, 100, 38);
		panel.add(lblNewLabel_3);
		
		btnInput = new JButton("CREATE");
		btnInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnInputMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnInputMouseExited(e);
			}
		});
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnbtnInputActionPerformed(e);
			}
		});
		btnInput.setBackground(SystemColor.textHighlight);
		btnInput.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnInput.setBounds(353, 277, 142, 38);
		panel.add(btnInput);
		
		lblCreateDepartment = new JLabel("CREATE DEPARTMENT");
		lblCreateDepartment.setForeground(Color.BLUE);
		lblCreateDepartment.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblCreateDepartment.setBounds(229, 14, 357, 52);
		panel.add(lblCreateDepartment);
		
		cbbRoom = new JComboBox();
		cbbRoom.setBounds(550, 199, 214, 38);
		panel.add(cbbRoom);
		
		lblBack = new JLabel("");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblBackMouseClicked(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBackMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBackMouseExited(e);
			}
		});
		lblBack.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\icons8-back-32 (1).png"));
		lblBack.setOpaque(true);
		lblBack.setBackground(UIManager.getColor("Button.background"));
		lblBack.setBounds(10, 14, 40, 40);
		panel.add(lblBack);
		getContentPane().setLayout(groupLayout);
		loadDep();
	}
	protected void btnbtnInputActionPerformed(ActionEvent e) {
		if(validateDepartment()!=0) {
			return;
		}else {
	Department newDEP = new Department();
	newDEP.setDepartment_name(txtNAME.getText()+1);
	newDEP.setHead_of_department(txtDEPARTMENT.getText()+1);
	newDEP.setRoom(cbbRoom.getActionCommand()+1);
	Manage_DepartmentsDAO workdao = new Manage_DepartmentsDAO();
	if(workdao.insert(newDEP)) {
		JOptionPane.showMessageDialog(null, "Add successfully!");
		}
    	txtNAME.setText("");
    	txtDEPARTMENT.setText("");
    	cbbRoom.setToolTipText("");
		}

}
	public int validateDepartment() {
		int count = 0 ;
		String room_name;
		Manage_DepartmentsDAO DepDAO = new Manage_DepartmentsDAO();
		List<Department> listDep = DepDAO.selectAllDepartment();
		RoomDAO RoomDAO = new RoomDAO();
		List<Room> listRoom = RoomDAO.selectAllRoom();
		for (Room room : listRoom) {
			if(room.toString().equals(cbbRoom.getSelectedItem())) {
				room_name = room.getName();
				break;
			}
		}
		 Object selectedValue = cbbRoom.getSelectedItem();
		if( txtNAME.getText() == null || txtDEPARTMENT.getText() == null ||  cbbRoom.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Please fill in all information");
			count++;
		}else if(txtNAME.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill in your name");
			count++;
		}else if(txtDEPARTMENT.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill in your Department");
			count++;
		}else if(selectedValue == null) {
			JOptionPane.showMessageDialog(null, "Please fill in your Room");
			count++;
		}
		return count;

	}
	
	protected void lblBackMouseClicked(MouseEvent e) {
		App_Admin appus = new App_Admin();
		appus.setLocationRelativeTo(null);
		appus.setUndecorated(true);
		appus.setVisible(true);
	    this.setVisible(false);
	}
	protected void lblBackMouseEntered(MouseEvent e) {
		lblBack.setBackground(new Color(106,90,205));
		lblBack.setForeground(Color.black);
	}
	protected void lblBackMouseExited(MouseEvent e) {
		lblBack.setBackground(UIManager.getColor("Button.background"));
		lblBack.setForeground(Color.black);
	}
	protected void btnInputMouseEntered(MouseEvent e) {
		btnInput.setBackground(new Color(106,90,205));
		btnInput.setForeground(Color.black);
	}
	protected void btnInputMouseExited(MouseEvent e) {
		btnInput.setBackground(SystemColor.textHighlight);
		btnInput.setForeground(Color.black);
		
	}
}
