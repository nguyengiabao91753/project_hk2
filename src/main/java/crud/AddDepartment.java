package crud;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
public class AddDepartment extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField txtID;
	private JTextField tXTNAME;
	private JTextField txtDEPARTMENT;
	private JTextField txtROOM;
	private JLabel lblNewLabel;
	private JLabel lblName;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblCreateDepartment;
	private static AddDepartment instance ;
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
	public AddDepartment() {
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
		
		tXTNAME = new JTextField();
		tXTNAME.setColumns(10);
		tXTNAME.setBounds(140, 199, 214, 38);
		panel.add(tXTNAME);
		
		txtDEPARTMENT = new JTextField();
		txtDEPARTMENT.setColumns(10);
		txtDEPARTMENT.setBounds(550, 133, 214, 38);
		panel.add(txtDEPARTMENT);
		
		txtROOM = new JTextField();
		txtROOM.setColumns(10);
		txtROOM.setBounds(550, 199, 214, 38);
		panel.add(txtROOM);
		
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
		
		btnNewButton = new JButton("CREATE");
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(353, 277, 142, 38);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\Back (1).png"));
		btnNewButton_1.setBounds(10, 14, 60, 38);
		panel.add(btnNewButton_1);
		
		lblCreateDepartment = new JLabel("CREATE DEPARTMENT");
		lblCreateDepartment.setForeground(Color.BLUE);
		lblCreateDepartment.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblCreateDepartment.setBounds(229, 14, 357, 52);
		panel.add(lblCreateDepartment);
		getContentPane().setLayout(groupLayout);

	}
}
