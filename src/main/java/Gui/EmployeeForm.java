package Gui;

import java.awt.EventQueue;

import java.awt.Image;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.DepartmentDAO;
import dao.EducationDAO;
import dao.EmployeeDAO;
import dao.PositionDAO;
import dao.SalaryDAO;
import entity.Department;
import entity.Education;
import entity.Employee;
import entity.Position;
import entity.Room;
import entity.Salary;

import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultRowSorter;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.toedter.calendar.JDateChooser;
import javax.swing.border.TitledBorder;

public class EmployeeForm extends JInternalFrame {

	private JComponent northPane = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	Dimension dimensionNorthPane = null ;
	private static final long serialVersionUID = 1L;
	private JTextField txtEmployeeId;
	private JTextField txtFullName;
	private JTextField txtEthnicity;
	private JTextField txtAddress;
	private JComboBox cbxGender;
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
	private JButton btnUpdate;
	private JButton btnInsert;
	private JButton btnNewButton_1;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblLevel;
	private JComboBox cbxLevel;
	
	Integer pageNumber = 1 ;
	Integer rowOfPage = 10 ;
	Integer totalCount = 0 ;
	Double totalPage = 0.0;
	
	private String fileName = null;
	private String fileOld = null;
	private String dirNew = null;
	private String dirOld = null;

	private JLabel lblTotal;
	private JLabel lblStatus;
	private JComboBox cbxSupervisorId;
	private JComboBox cbxDepartmentId;
	private JComboBox cbxEducationId;
	private JComboBox cbxPositionId;
	private JDateChooser dateChooser;
	private JComboBox cbxSalary;
	SalaryDAO salaryDao = new SalaryDAO();
	EmployeeDAO employeeDao = new EmployeeDAO();
	DepartmentDAO departmentDao = new DepartmentDAO();
	EducationDAO educationDao = new EducationDAO();
	PositionDAO positionDao = new PositionDAO();
	private JTextField txtSearch;


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
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(131, 204, 86, 20);
		getContentPane().add(txtAddress);
		
		cbxGender = new JComboBox<Object>();
		cbxGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cbxGender.setBounds(131, 173, 86, 22);
		getContentPane().add(cbxGender);
		
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
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\luong\\eclipse-workspace\\project-hk2\\images\\Custom-Icon-Design-Mono-General-1-Success.512-fotor-2024012517561.png"));
		btnUpdate.setBackground(Color.GREEN);
		btnUpdate.setBounds(22, 528, 195, 23);
		getContentPane().add(btnUpdate);
		
		btnInsert = new JButton("Delete");
		btnInsert.setBounds(22, 566, 195, 23);
		getContentPane().add(btnInsert);
		
		btnNewButton_1 = new JButton("Choose Image");
		btnNewButton_1.setBounds(22, 461, 195, 23);
		getContentPane().add(btnNewButton_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(227, 49, 730, 435);
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
		lblLevel.setBounds(22, 495, 86, 14);
		getContentPane().add(lblLevel);
		
		cbxLevel = new JComboBox();
		cbxLevel.setModel(new DefaultComboBoxModel(new String[] {"Admin", "User"}));
		cbxLevel.setBounds(131, 495, 86, 22);
		getContentPane().add(cbxLevel);
		
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
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(131, 142, 86, 20);
		getContentPane().add(dateChooser);
		
		cbxSalary = new JComboBox();
		cbxSalary.setBounds(131, 234, 86, 22);
		getContentPane().add(cbxSalary);
		
		txtSearch = new JTextField();
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSearchActionPerformed(e);
			}
		});
		txtSearch.setBorder(new TitledBorder(null, "Search :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		txtSearch.setBounds(239, 2, 140, 36);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
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
					case 4: return String.class;
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
		model.addColumn("Picture");
		model.addColumn("pathpicture");
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
				emp.getGender(),
				emp.getAddress(),
				emp.getSalary_level(),
				emp.getSupervisor_id(),
				emp.getDepartment_id(),
				emp.getEducation_id(),
				emp.getPosition_id(),
				new ImageIcon(
					new ImageIcon(emp.getPicture()).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)	
				),
				emp.getPicture(),
				emp.getLevel()
				}
			)
		);
		table.setModel(model);
		table.setRowHeight(60);
		table.getColumn("pathpicture").setMinWidth(0);
		table.getColumn("pathpicture").setMaxWidth(0);
		table.getColumn("pathpicture").setWidth(0);
	}
	
	private void refresh() {
		DefaultTableModel model =  (DefaultTableModel)table.getModel();
		model.setRowCount(0); 
		EmployeeDAO dao = new EmployeeDAO();
		
		
		totalCount = dao.countEmployee();
		
		totalPage = Math.ceil(totalCount.doubleValue() / rowOfPage.doubleValue());
		
		lblStatus.setText("page "+pageNumber+" of "+totalPage.intValue());
		lblTotal.setText("total customer: "+totalCount);

		
		dao.selectEmployee(pageNumber, rowOfPage).stream().forEach(
				emp ->model.addRow(new Object[] {
						emp.getId(),
						emp.getFull_name(),
						emp.getEthnicity(),
						emp.getDate_of_birth(),
						emp.getGender(),
						emp.getAddress(),
						emp.getSalary_level(),
						emp.getSupervisor_id(),
						emp.getDepartment_id(),
						emp.getEducation_id(),
						emp.getPosition_id(),
						new ImageIcon(
							new ImageIcon(emp.getPicture()).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)	
						),
						emp.getPicture(),
						emp.getLevel()
						}
				)
			);
		table.setModel(model);
	}
	
	protected void tableMouseClicked(MouseEvent e) {
		int rowIndex = table.getSelectedRow();
		txtEmployeeId.setText(table.getValueAt(rowIndex, 0).toString());
		txtFullName.setText(table.getValueAt(rowIndex, 1).toString());
		txtEthnicity.setText(table.getValueAt(rowIndex, 2).toString());
		try {
			dateChooser.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(rowIndex, 3).toString()));
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		var gender = table.getValueAt(rowIndex, 4).toString().equals("Male") ?0:1;
		cbxGender.setSelectedIndex(gender);
		
		txtAddress.setText(table.getValueAt(rowIndex, 5).toString());
		
		var salaryModel = new DefaultComboBoxModel<>();
		var supervisorModel = new DefaultComboBoxModel<>();
		var departmentModel = new DefaultComboBoxModel<>();
		var educationModel = new DefaultComboBoxModel<>();
		var positionModel = new DefaultComboBoxModel<>();

		List<Salary> listSalary = salaryDao.selectAllSalary();
		List<Employee> listSupervisor = employeeDao.selectAllEmployee();
		List<Department> listDepartment = departmentDao.selectAllDepartment();
		List<Education> listEducation =  educationDao.selectAllEducation();
		List<Position> listPosition = positionDao.selectAllPosition();
		
		listSalary.forEach(salary -> salaryModel.addElement(salary.getId()));
		listSupervisor.forEach(emp -> supervisorModel.addElement(emp.getId()));
		listDepartment.forEach(dep -> departmentModel.addElement(dep.getId()));
		listEducation.forEach(edu -> educationModel.addElement(edu.getId()));
		listPosition.forEach(pos -> positionModel.addElement(pos.getId()));

		cbxSalary.setModel(salaryModel);
		cbxSupervisorId.setModel(supervisorModel);
		cbxDepartmentId.setModel(departmentModel);
		cbxEducationId.setModel(educationModel);
		cbxPositionId.setModel(positionModel);
		
		var salaryId_select = Integer.parseInt(table.getValueAt(rowIndex, 6).toString());
		var supervisorId_select = Integer.parseInt(table.getValueAt(rowIndex, 7).toString()); 
		var departmentId_select = Integer.parseInt(table.getValueAt(rowIndex, 8).toString());
		var educationId_select = Integer.parseInt(table.getValueAt(rowIndex, 9).toString());
		var positionId_select = Integer.parseInt(table.getValueAt(rowIndex, 10).toString());

		cbxSalary.setSelectedItem(salaryId_select);
		cbxSupervisorId.setSelectedItem(supervisorId_select); 
		cbxDepartmentId.setSelectedItem(departmentId_select);
		cbxEducationId.setSelectedItem(educationId_select);
		cbxPositionId.setSelectedItem(positionId_select);
		
		lblPicture.setIcon(
				new ImageIcon(
						new ImageIcon(
								table.getValueAt(rowIndex, 12).toString()
								).getImage()
								.getScaledInstance(lblPicture.getWidth(),
								lblPicture.getHeight(),
								Image.SCALE_SMOOTH)
					)
				);
		fileOld = table.getValueAt(rowIndex, 12).toString();
		
		var level = table.getValueAt(rowIndex, 13).toString().equals("Admin") ? 0 : 1;
		cbxLevel.setSelectedIndex(level);

	}
	
	protected void txtSearchActionPerformed(ActionEvent e) {
		String find = txtSearch.getText();
		DefaultRowSorter<?, ?> sorter = (DefaultRowSorter<?, ?>)table.getRowSorter();
		sorter.setRowFilter(RowFilter.regexFilter(find));
		sorter.setSortKeys(null);
	}
	
	

	protected void btnUpdateActionPerformed(ActionEvent e) {
		if(lblPicture.getIcon() == null) {
			JOptionPane.showMessageDialog(null, "please choose image");
			return;
		}
		
		Employee emp = new Employee();
		emp.setId(Integer.parseInt(txtEmployeeId.getText()));
		emp.setFull_name(txtFullName.getText());
		emp.setEthnicity(txtEthnicity.getText());
		emp.setDate_of_birth(
				LocalDate.ofInstant(dateChooser.getDate().toInstant(), ZoneId.systemDefault())
		);
		emp.setAddress(txtAddress.getText());
		emp.setGender(cbxGender.getSelectedItem().toString());
		emp.setSalary_level(cbxSalary.getSelectedIndex()+1);
		emp.setSupervisor_id(cbxSupervisorId.getSelectedIndex()+1);
		emp.setDepartment_id(cbxDepartmentId.getSelectedIndex()+1);
		emp.setEducation_id(cbxEducationId.getSelectedIndex()+1);
		emp.setPosition_id(cbxPositionId.getSelectedIndex()+1);
		
		if(fileName != null) {
			dirNew = System.getProperty("user.dir") + "\\images";
			Path pathOld = Paths.get(dirOld);
			Path pathNew = Paths.get(dirNew);
	
			try {
				Files.copy(
						pathOld, 
						pathNew.resolve(fileName),
						StandardCopyOption.REPLACE_EXISTING
				);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			emp.setPicture("images/" + fileName);
		}else {
			emp.setPicture(fileOld);
		}
		
		emp.setLevel(cbxLevel.getSelectedItem().toString());
		
		employeeDao.update(emp);
		fileName =null;
		lblPicture.setIcon(null);
		refresh();
	}
}
