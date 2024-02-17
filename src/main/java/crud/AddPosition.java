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
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class AddPosition extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField txtNAME;
	private JLabel lblNewLabel_2;
	private JButton btnInput;
	private JLabel lblCreateDepartment;
	private static AddPosition instance ;
	AddDepartment AddDep ;
	private Object DimensionBarca;
	private JComponent Barca;
	private JLabel lblBack;
	private JPanel panel_1;
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
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 902, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 708, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(null);
		
		txtNAME = new JTextField();
		txtNAME.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNAME.setColumns(10);
		txtNAME.setBounds(240, 137, 500, 40);
		panel.add(txtNAME);
		
		lblNewLabel_2 = new JLabel("NAME :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(150, 136, 100, 40);
		panel.add(lblNewLabel_2);
		
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
				btnInputActionPerformed(e);
			}
		});
		btnInput.setBackground(Color.BLUE);
		btnInput.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnInput.setBounds(319, 276, 180, 45);
		panel.add(btnInput);
		
		lblCreateDepartment = new JLabel("     CREATE POSITION");
		lblCreateDepartment.setForeground(Color.BLUE);
		lblCreateDepartment.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblCreateDepartment.setBounds(229, 10, 400, 60);
		panel.add(lblCreateDepartment);
		
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
		lblBack.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\icons8-back-48.png"));
		lblBack.setOpaque(true);
		lblBack.setBackground(new Color(0, 191, 255));
		lblBack.setBounds(10, 10, 48, 48);
		panel.add(lblBack);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(0, 0, 902, 78);
		panel.add(panel_1);
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
			JOptionPane.showMessageDialog(null, "Please fill in your name .");
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
		lblBack.setBackground(new Color(0, 191, 255));
		lblBack.setForeground(Color.black);
	}
	protected void lblBackMouseExited(MouseEvent e) {
		lblBack.setBackground(new Color(0, 191, 255));
		lblBack.setForeground(Color.black);
	}
	protected void btnInputMouseEntered(MouseEvent e) {
		btnInput.setBackground(new Color(106,90,205));
		btnInput.setForeground(Color.black);
		
	}
	protected void btnInputMouseExited(MouseEvent e) {
		btnInput.setBackground(new Color(0, 191, 255));
		btnInput.setForeground(Color.black);
	}
	
}
