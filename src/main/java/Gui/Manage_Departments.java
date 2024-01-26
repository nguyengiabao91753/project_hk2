package Gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Manage_Departments extends JInternalFrame {
	private JComponent Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarca =null;

	private static final long serialVersionUID = 1L;
	private JTextField txtID;
	private JTextField txtName;
	private JComboBox cboDeparment;
	private JLabel lblID;
	private JLabel lblName;
	private JLabel lblDeparment;
	private JLabel lblRoom;
	private JComboBox cboRoom;
	private JButton btnAccept;
	private JButton btnGetInto;
	private JButton btnNotch;
	
	private DefaultTableModel modelo ;
	private JTable tbemp;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Departments frame = new Manage_Departments();
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
	public void Quit() {
		Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
		DimensionBarca =Barca.getPreferredSize();
		Barca.setSize(0,0);
		Barca.setPreferredSize(new Dimension(0,0));
		repaint();
	}
	public Manage_Departments() {
		Quit();
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(223, 37, 957, 626);
		getContentPane().setLayout(null);
		
		txtID = new JTextField();
		txtID.setBounds(127, 11, 122, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(127, 49, 122, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		cboDeparment = new JComboBox();
		cboDeparment.setBounds(127, 83, 122, 22);
		getContentPane().add(cboDeparment);
		
		lblID = new JLabel("ID :");
		lblID.setBackground(SystemColor.controlHighlight);
		lblID.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblID.setBounds(22, 17, 95, 14);
		getContentPane().add(lblID);
		
		lblName = new JLabel("NAME :");
		lblName.setBackground(SystemColor.controlHighlight);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblName.setBounds(22, 55, 95, 14);
		getContentPane().add(lblName);
		
		lblDeparment = new JLabel("DEPARTMENT :");
		lblDeparment.setBackground(SystemColor.controlHighlight);
		lblDeparment.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblDeparment.setBounds(22, 91, 95, 14);
		getContentPane().add(lblDeparment);
		
		lblRoom = new JLabel("ROOM :");
		lblRoom.setBackground(SystemColor.controlHighlight);
		lblRoom.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblRoom.setBounds(22, 122, 95, 14);
		getContentPane().add(lblRoom);
		
		cboRoom = new JComboBox();
		cboRoom.setBounds(127, 116, 122, 22);
		getContentPane().add(cboRoom);
		
		btnAccept = new JButton("New button");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAcceptActionPerformed(e);
			}
		});
		btnAccept.setBackground(Color.GREEN);
		btnAccept.setBounds(215, 195, 34, 23);
		getContentPane().add(btnAccept);
		
		btnGetInto = new JButton("GET INTO");
		btnGetInto.setBounds(127, 233, 122, 35);
		getContentPane().add(btnGetInto);
		
		btnNotch = new JButton("NOTCH");
		btnNotch.setBounds(127, 279, 122, 35);
		getContentPane().add(btnNotch);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(266, 42, 681, 380);
		getContentPane().add(scrollPane);
		
		tbemp = new JTable();
		tbemp.setBackground(new Color(255, 255, 255));
		tbemp.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbemp);
		tbemp.setBorder(new LineBorder(SystemColor.controlHighlight, 2));
		
		modelo = new DefaultTableModel();
		modelo.addColumn("DEPARTMENT_ID");
		modelo.addColumn("DEPARTMENT_NAME");
		modelo.addColumn("HEAD_OF_DEPARTMENT");
		modelo.addColumn("ROOM");
		tbemp.setModel(modelo);
	}
	protected void btnAcceptActionPerformed(ActionEvent e) {
		
	}
}
