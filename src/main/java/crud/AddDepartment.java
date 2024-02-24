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
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Cursor;
public class AddDepartment extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField txtDepparment;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnInput;
	private static AddDepartment instance ;
	private Object DimensionBarca;
	private JComponent Barca;
	private App_Admin app;
	Manage_Departments dep;
	private JDesktopPane desktopPane;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_4;
	private JTextField txtRoom;
	private JLabel lblNewLabel_5;
	private JTextField txtName;
	private JPanel panel_2;
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
        if (instance == null || instance.isClosed()) {
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
		
	}	
	public AddDepartment() {
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		quit();
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 637, 406);
		
		panel = new JPanel();
		panel.setBounds(0, 58, 637, 347);
		panel.setBackground(new Color(255, 255, 255));
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 636, 52);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(102, 0, 255));
		
		lblNewLabel = new JLabel("<html>\r\n\t<p style=\"font-size: 24px;color:white\">&#10006;</p>\r\n</html>");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabelMouseClicked(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabelMouseEntered(e);
			}
		});
		lblNewLabel.setBounds(600, 11, 26, 35);
		panel_1.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Manager Department");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(10, 18, 216, 25);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_4 = new JLabel("-Create");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(236, 27, 63, 14);
		panel_1.add(lblNewLabel_4);
		panel.setLayout(null);
		
		txtDepparment = new JTextField();
		txtDepparment.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		txtDepparment.setColumns(10);
		txtDepparment.setBounds(180, 129, 300, 40);
		panel.add(txtDepparment);
		
		lblNewLabel_2 = new JLabel("DEPARTMENT :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_2.setBounds(49, 130, 121, 40);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("ROOM :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_3.setBounds(49, 211, 82, 40);
		panel.add(lblNewLabel_3);
		
		txtRoom = new JTextField();
		txtRoom.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		txtRoom.setColumns(10);
		txtRoom.setBounds(180, 210, 300, 40);
		panel.add(txtRoom);
		
		lblNewLabel_5 = new JLabel("NAME :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_5.setBounds(49, 50, 82, 40);
		panel.add(lblNewLabel_5);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		txtName.setColumns(10);
		txtName.setBounds(180, 49, 300, 40);
		panel.add(txtName);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(235, 234, 233));
		panel_2.setBounds(-11, 281, 647, 65);
		panel.add(panel_2);
		
		btnInput = new JButton("Submit");
		btnInput.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInput.setForeground(new Color(255, 255, 255));
		btnInput.setBounds(65, 11, 89, 37);
		panel_2.add(btnInput);
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
		getContentPane().setLayout(null);
		btnInput.setBackground(new Color(0, 0, 255));
		btnInput.setFont(new Font("Times New Roman", Font.BOLD, 12));
		getContentPane().add(panel);
		getContentPane().add(panel_1);
		loadDep();
	}
	
	public int validateDepartment() {
		int count = 0 ;
		String room_name;
		Manage_DepartmentsDAO DepDAO = new Manage_DepartmentsDAO();
		List<Department> listDep = DepDAO.selectAllDepartment();
		RoomDAO RoomDAO = new RoomDAO();
		if( txtDepparment.getText() == null || txtDepparment.getText() == null ||  txtDepparment.getText() == null) {
			JOptionPane.showMessageDialog(null, "Please fill in all information");
			count++;
		}else if(txtName.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill in your name");
			count++;
		}else if(txtDepparment.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill in your Department");
			count++;
		}else if(txtRoom.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill in your Room");
			count++;
		}
		return count;

	}
	
	protected void btnbtnInputActionPerformed(ActionEvent e) {
		if(validateDepartment()!=0) {
			return;
		}else {
	Department newDEP = new Department();
	newDEP.setDepartment_name(txtName.getText()+1);
	newDEP.setHead_of_department(txtDepparment.getText()+1);
	newDEP.setRoom(txtRoom.getText()+1);
	Manage_DepartmentsDAO workdao = new Manage_DepartmentsDAO();
	if(workdao.insert(newDEP)) {
		JOptionPane.showMessageDialog(null, "Add successfully!");
		}
    	txtName.setText("");
    	txtDepparment.setText("");
    	txtRoom.setText("");
    	this.dispose();
		}

}
	
	protected void btnInputMouseEntered(MouseEvent e) {
		btnInput.setBackground(new Color(106,90,205));
		btnInput.setForeground(Color.white);
	}
	protected void btnInputMouseExited(MouseEvent e) {
		btnInput.setBackground(new Color(102, 0, 255));
		btnInput.setForeground(Color.white);
		
	}
	protected void lblNewLabelMouseClicked(MouseEvent e) {
		this.dispose();
	}
	protected void lblNewLabelMouseEntered(MouseEvent e) {
		lblNewLabel.setBackground(new Color(106,90,205));
		lblNewLabel.setForeground(Color.black);
	}
}
