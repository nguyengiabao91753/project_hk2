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
	private static AddPosition instance ;
	AddDepartment AddDep ;
	private Object DimensionBarca;
	private JComponent Barca;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JPanel panel_2;
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
		setBounds(100, 100, 637, 521);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(152, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		txtNAME = new JTextField();
		txtNAME.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNAME.setColumns(10);
		txtNAME.setBounds(169, 136, 347, 40);
		panel.add(txtNAME);
		
		lblNewLabel_2 = new JLabel("NAME :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(64, 136, 82, 40);
		panel.add(lblNewLabel_2);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(102, 0, 255));
		panel_1.setBounds(0, 0, 636, 56);
		panel.add(panel_1);
		
		lblNewLabel = new JLabel("<html>\r\n\t<p style=\"font-size: 24px;color:white\">&#10006;</p>\r\n</html>");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabelMouseEntered(e);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabelMouseClicked(e);
			}
		});
		lblNewLabel.setBounds(601, 11, 25, 34);
		panel_1.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("    Job Position");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(10, 18, 159, 25);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_3 = new JLabel("-Create");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(167, 27, 63, 14);
		panel_1.add(lblNewLabel_3);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(235, 234, 233));
		panel_2.setBounds(0, 266, 636, 65);
		panel.add(panel_2);
		
		btnInput = new JButton("CREATE");
		btnInput.setBounds(246, 11, 150, 40);
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
				btnInputActionPerformed(e);
			}
		});
		btnInput.setBackground(Color.BLUE);
		btnInput.setFont(new Font("Times New Roman", Font.BOLD, 15));
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
	protected void btnInputMouseEntered(MouseEvent e) {
		btnInput.setBackground(new Color(106,90,205));
		btnInput.setForeground(Color.black);
		
	}
	protected void btnInputMouseExited(MouseEvent e) {
		btnInput.setBackground(new Color(0, 191, 255));
		btnInput.setForeground(Color.black);
	}
	
	protected void lblNewLabelMouseEntered(MouseEvent e) {
		lblNewLabel.setBackground(new Color(106,90,205));
		lblNewLabel.setForeground(Color.black);
	}
	protected void lblNewLabelMouseClicked(MouseEvent e) {
		this.setVisible(false);
	}
	
}
