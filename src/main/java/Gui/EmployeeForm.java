package Gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.EmployeeDAO;

import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

public class EmployeeForm extends JInternalFrame {

	private JComponent northPane = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	Dimension dimensionNorthPane = null ;
	private static final long serialVersionUID = 1L;
	private JTextField txtEmployeeId;
	private JTextField txtFullName;
	private JTextField txtEthnicity;
	private JTextField txtDate;
	private JTextField txtAddress;
	private JComboBox cboGender;
	private JTextField txtSalary;
	private JLabel lblPicture;
	private JLabel lblEmployeeId;
	private JLabel lblName;
	private JLabel lblEthnicity;
	private JLabel lblDateOfBirth;
	private JLabel lblGender;
	private JLabel lblAddress;
	private JLabel lblSalary;
	private JLabel lblSupervisorId;
	private JLabel lblDepartmentId;
	private JLabel lblEducationId;
	private JLabel lblPositionId;
	private JLabel lblImage;
	private JButton btnAccept;
	private JButton btnInsert;
	private JButton btnNewButton_1;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblLevel;
	private JComboBox cboLevel;
	
	Integer pageNumber = 1 ;
	Integer rowOfPage = 10 ;
	Integer totalCount = 0 ;
	Double totalPage = 0.0;
	private JLabel lblTotal;
	private JLabel lblStatus;
	private JComboBox cbxSupervisorId;
	private JComboBox cbxDepartmentId;
	private JComboBox cbxEducationId;
	private JComboBox cbxPositionId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeForm frame = new EmployeeForm();
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
	
	public void hideTitleBar() {
	    northPane = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	    dimensionNorthPane = northPane.getPreferredSize();
	    northPane.setSize(0, 0);
	    northPane.setPreferredSize(new Dimension(0, 0));
	    repaint();

	}

	
	public EmployeeForm() {
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		hideTitleBar();
		getContentPane().setBackground(Color.WHITE);
		setBounds(223,37,957,627);
		getContentPane().setLayout(null);
		
		txtEmployeeId = new JTextField();
		txtEmployeeId.setBounds(131, 49, 86, 20);
		getContentPane().add(txtEmployeeId);
		txtEmployeeId.setColumns(10);
		
		txtFullName = new JTextField();
		txtFullName.setColumns(10);
		txtFullName.setBounds(131, 80, 86, 20);
		getContentPane().add(txtFullName);
		
		txtEthnicity = new JTextField();
		txtEthnicity.setColumns(10);
		txtEthnicity.setBounds(131, 111, 86, 20);
		getContentPane().add(txtEthnicity);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(131, 142, 86, 20);
		getContentPane().add(txtDate);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(131, 204, 86, 20);
		getContentPane().add(txtAddress);
		
		cboGender = new JComboBox<Object>();
		cboGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cboGender.setBounds(131, 173, 86, 22);
		getContentPane().add(cboGender);
		
		txtSalary = new JTextField();
		txtSalary.setBounds(131, 235, 86, 20);
		getContentPane().add(txtSalary);
		txtSalary.setColumns(10);
		
		lblPicture = new JLabel("");
		lblPicture.setOpaque(true);
		lblPicture.setBackground(Color.GRAY);
		lblPicture.setBounds(131, 390, 86, 60);
		getContentPane().add(lblPicture);
		
		lblEmployeeId = new JLabel("Employee ID :");
		lblEmployeeId.setBounds(22, 52, 86, 14);
		getContentPane().add(lblEmployeeId);
		
		lblName = new JLabel("Full name :");
		lblName.setBounds(22, 83, 86, 14);
		getContentPane().add(lblName);
		
		lblEthnicity = new JLabel("Ethnicity :");
		lblEthnicity.setBounds(22, 114, 86, 14);
		getContentPane().add(lblEthnicity);
		
		lblDateOfBirth = new JLabel("Date of birth :");
		lblDateOfBirth.setBounds(22, 145, 86, 14);
		getContentPane().add(lblDateOfBirth);
		
		lblGender = new JLabel("Gender :");
		lblGender.setBounds(22, 177, 86, 14);
		getContentPane().add(lblGender);
		
		lblAddress = new JLabel("Address :");
		lblAddress.setBounds(22, 207, 86, 14);
		getContentPane().add(lblAddress);
		
		lblSalary = new JLabel("Salary level :");
		lblSalary.setBounds(22, 238, 86, 14);
		getContentPane().add(lblSalary);
		
		lblSupervisorId = new JLabel("Supervisor ID :");
		lblSupervisorId.setBounds(22, 269, 86, 14);
		getContentPane().add(lblSupervisorId);
		
		lblDepartmentId = new JLabel("Department ID :");
		lblDepartmentId.setBounds(22, 300, 99, 14);
		getContentPane().add(lblDepartmentId);
		
		lblEducationId = new JLabel("Education ID :");
		lblEducationId.setBounds(22, 331, 86, 14);
		getContentPane().add(lblEducationId);
		
		lblPositionId = new JLabel("Position ID :");
		lblPositionId.setBounds(22, 362, 86, 14);
		getContentPane().add(lblPositionId);
		
		lblImage = new JLabel("Image :");
		lblImage.setBounds(22, 414, 86, 14);
		getContentPane().add(lblImage);
		
		btnAccept = new JButton("");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAcceptActionPerformed(e);
			}
		});
		btnAccept.setIcon(new ImageIcon("C:\\Users\\luong\\eclipse-workspace\\project-hk2\\images\\Custom-Icon-Design-Mono-General-1-Success.512-fotor-2024012517561.png"));
		btnAccept.setBackground(Color.GREEN);
		btnAccept.setBounds(181, 498, 36, 23);
		getContentPane().add(btnAccept);
		
		btnInsert = new JButton("Insert ");
		btnInsert.setBounds(128, 532, 89, 23);
		getContentPane().add(btnInsert);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(131, 566, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(241, 49, 690, 400);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(227, 227, 227), 2));
		
		lblLevel = new JLabel("Level :");
		lblLevel.setBounds(22, 466, 86, 14);
		getContentPane().add(lblLevel);
		
		cboLevel = new JComboBox();
		cboLevel.setModel(new DefaultComboBoxModel(new String[] {"Admin", "User"}));
		cboLevel.setBounds(131, 461, 86, 22);
		getContentPane().add(cboLevel);
		
		lblTotal = new JLabel("Total Employee : 0");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setBounds(779, 498, 152, 23);
		getContentPane().add(lblTotal);
		
		lblStatus = new JLabel("page 1 of 6");
		lblStatus.setBounds(241, 498, 138, 23);
		getContentPane().add(lblStatus);
		
		cbxSupervisorId = new JComboBox();
		cbxSupervisorId.setBounds(131, 265, 86, 22);
		getContentPane().add(cbxSupervisorId);
		
		cbxDepartmentId = new JComboBox();
		cbxDepartmentId.setBounds(131, 296, 86, 22);
		getContentPane().add(cbxDepartmentId);
		
		cbxEducationId = new JComboBox();
		cbxEducationId.setBounds(131, 327, 86, 22);
		getContentPane().add(cbxEducationId);
		
		cbxPositionId = new JComboBox();
		cbxPositionId.setBounds(131, 358, 86, 22);
		getContentPane().add(cbxPositionId);
		loadEmployee();
	}
	
	public void loadEmployee() {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public Class<?> getColumnClass(int column){
				switch(column) {
					case 0: return Integer.class;
					case 1: return String.class;
					case 2: return String.class;
					case 3: return String.class;
					case 4: return Boolean.class;
					case 5: return String.class;
					case 6: return Integer.class;
					case 7: return Integer.class;
					case 8: return Integer.class;
					case 9: return Integer.class;
					case 10: return Integer.class;
					case 11: return ImageIcon.class;
					case 12: return String.class;// đường dẫn hình
					default: return String.class;
				}
			}
			@Override 
			public boolean isCellEditable(int row , int col) {
				switch(col){
					case 3: return false;
					default: return true;
				}
			}
		}; 
		
		model.addColumn("ID");
		model.addColumn("Full name");
		model.addColumn("Ethnicity");
		model.addColumn("Date of birth");
		model.addColumn("Gender");
		model.addColumn("Address");
		model.addColumn("Salary level");
		model.addColumn("Supervisor ID");
		model.addColumn("Department ID");
		model.addColumn("Education ID");
		model.addColumn("Position ID");
		model.addColumn("pathpicture");
		model.addColumn("Picture");
		model.addColumn("Level");

		EmployeeDAO dao = new EmployeeDAO();
		
		totalCount = dao.countEmployee();
		totalPage = Math.ceil(totalCount.doubleValue() / rowOfPage.doubleValue());
		
		lblStatus.setText("page "+pageNumber+" of "+totalPage.intValue());
		lblTotal.setText("total employee: 60");
		dao.selectEmployee(pageNumber, rowOfPage)
			.stream()
			.forEach(emp -> model.addRow(new Object[] {
				emp.getId(),
				emp.getFull_name(),
				emp.getEthnicity(),
				emp.getDate_of_birth(),
				emp.isGender(),
				emp.getAddress(),
				emp.getSalary_level(),
				emp.getSupervisor_id(),
				emp.getDepartment_id(),
				emp.getEducation_id(),
				emp.getPosition_id(),
				new ImageIcon(
					new ImageIcon(emp.getPicture()).getImage().getScaledInstance(120, 60, Image.SCALE_SMOOTH)	
				),//biến lấy picture
				emp.getPicture(),//lấy đường dẫn hình
				emp.getLevel()
		}));;
		table.setModel(model);
		table.setRowHeight(60);
		table.getColumn("pathpicture").setMinWidth(0);
		table.getColumn("pathpicture").setMaxWidth(0);
		table.getColumn("pathpicture").setWidth(0);
	}
	
	
	protected void btnAcceptActionPerformed(ActionEvent e) {
		int rowIndex = table.getSelectedRow();
		txtEmployeeId.setText(table.getValueAt(rowIndex, 0).toString());
		txtFullName.setText(table.getValueAt(rowIndex, 1).toString());
		txtEthnicity.setText(table.getValueAt(rowIndex, 2).toString());
		try {
			txtDate.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(rowIndex, 3).toString()));
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	protected void tableMouseClicked(MouseEvent e) {
	}
}
