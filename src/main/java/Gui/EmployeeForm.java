package Gui;

import java.awt.EventQueue;

import java.awt.Image;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


import dao.Manage_DepartmentsDAO;
import dao.AccountDAO;
import dao.EducationDAO;
import dao.EmployeeDAO;
import dao.PositionDAO;
import dao.SalaryDAO;
import entity.Account;
import entity.Department;
import entity.Education;
import entity.Employee;
import entity.Position;
import entity.Room;
import entity.Salary;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultRowSorter;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

import App.AdminLogin;
import App.App_Admin;
import crud.Addemployee;
import crud.Addschedule;

import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.MatteBorder;
import java.awt.Font;

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
	private JButton btnDelete;
	private JButton btnPicture;
	private static JTable table;
	private JScrollPane scrollPane;
	private JLabel lblLevel;
	private JComboBox cbxLevel;
	private App_Admin app;

	
	Integer pageNumber = 1 ;
	Integer rowOfPage = 7 ;
	Integer totalCount = 0 ;
	Double totalPage = 0.0;
	
	private String fileName = null;
	private String fileOld = null;
	private String dirNew = null;
	private String dirOld = null;
	private JComboBox cbxSupervisorId;
	private JComboBox cbxDepartmentId;
	private JComboBox cbxEducationId;
	private JComboBox cbxPositionId;
	private JDateChooser dateChooser;
	private JComboBox cbxSalary;
	SalaryDAO salaryDao = new SalaryDAO();
	EmployeeDAO employeeDao = new EmployeeDAO();
	Manage_DepartmentsDAO departmentDao = new Manage_DepartmentsDAO();
	EducationDAO educationDao = new EducationDAO();
	PositionDAO positionDao = new PositionDAO();
	AccountDAO accountDao = new AccountDAO();
	private JTextField txtSearch;
	private JButton btnInsert;
	private JButton btnFirst;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnLast;
	private JTextField txtPage;
 


   
	
	public static JTable getTable() {
        return table;
    }
	/**
	 * Launch the application.
	 */
	
	public void setApp(App_Admin app) {
		this.app = app;
	}
	
	
	public App_Admin getApp() {
		return app;
	}
	
	
	

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

	public void hidenextlast() {
		if(pageNumber==1) {
			btnFirst.setVisible(false);
			btnPrevious.setVisible(false);
		}else {
			btnFirst.setVisible(true);
			btnPrevious.setVisible(true);
		}
		if(pageNumber == totalPage.intValue()) {
			btnNext.setVisible(false);
			btnLast.setVisible(false);
		}else {
			btnNext.setVisible(true);
			btnLast.setVisible(true);
		}
	}
	
	public EmployeeForm() {
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		hideTitleBar();
		getContentPane().setBackground(Color.WHITE);
		setBounds(223,37,957,627);
		getContentPane().setLayout(null);
		
		txtEmployeeId = new JTextField();
		txtEmployeeId.setBackground(new Color(255, 255, 255));
		txtEmployeeId.setEditable(false);
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
		lblEmployeeId.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEmployeeId.setBounds(22, 52, 86, 14);
		getContentPane().add(lblEmployeeId);
		
		lblName = new JLabel("Full name :");
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblName.setBounds(22, 83, 86, 14);
		getContentPane().add(lblName);
		
		lblEthnicity = new JLabel("Ethnicity :");
		lblEthnicity.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEthnicity.setBounds(22, 114, 86, 14);
		getContentPane().add(lblEthnicity);
		
		lblDateOfBirth = new JLabel("Date of birth :");
		lblDateOfBirth.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDateOfBirth.setBounds(22, 145, 86, 14);
		getContentPane().add(lblDateOfBirth);
		
		lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblGender.setBounds(22, 177, 86, 14);
		getContentPane().add(lblGender);
		
		lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblAddress.setBounds(22, 207, 86, 14);
		getContentPane().add(lblAddress);
		
		lblSalary = new JLabel("Salary level :");
		lblSalary.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblSalary.setBounds(22, 238, 86, 14);
		getContentPane().add(lblSalary);
		
		lblSupervisorId = new JLabel("Supervisor  :");
		lblSupervisorId.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblSupervisorId.setBounds(22, 269, 86, 14);
		getContentPane().add(lblSupervisorId);
		
		lblDepartmentId = new JLabel("Department  :");
		lblDepartmentId.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDepartmentId.setBounds(22, 300, 99, 14);
		getContentPane().add(lblDepartmentId);
		
		lblEducationId = new JLabel("Education  :");
		lblEducationId.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEducationId.setBounds(22, 331, 86, 14);
		getContentPane().add(lblEducationId);
		
		lblPositionId = new JLabel("Position  :");
		lblPositionId.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblPositionId.setBounds(22, 362, 86, 14);
		getContentPane().add(lblPositionId);
		
		lblImage = new JLabel("Image :");
		lblImage.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblImage.setBounds(22, 414, 86, 20);
		getContentPane().add(lblImage);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBorder(null);
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnUpdateMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnUpdateMouseExited(e);
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setBackground(Color.GREEN);
		btnUpdate.setBounds(22, 528, 86, 23);
		getContentPane().add(btnUpdate);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBorder(null);
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDeleteMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDeleteMouseExited(e);
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}
		});
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(131, 528, 86, 23);
		getContentPane().add(btnDelete);
		
		btnPicture = new JButton("Choose Image");
		btnPicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPictureActionPerformed(e);
			}
		});
		btnPicture.setBounds(22, 461, 195, 23);
		getContentPane().add(btnPicture);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(240, 240, 240));
		scrollPane.setBounds(227, 49, 730, 435);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				tableMousePressed(e);
			}
		});
//		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
//		table.setBorder(new LineBorder(new Color(227, 227, 227), 2));
		
		lblLevel = new JLabel("Level :");
		lblLevel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblLevel.setBounds(22, 495, 86, 14);
		getContentPane().add(lblLevel);
		
		cbxLevel = new JComboBox();
		cbxLevel.setModel(new DefaultComboBoxModel(new String[] {"Admin", "User"}));
		cbxLevel.setBounds(131, 495, 86, 22);
		getContentPane().add(cbxLevel);
		
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
		txtSearch.setBounds(239, 0, 140, 36);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		btnInsert = new JButton("ADD");
		btnInsert.setForeground(new Color(255, 255, 255));
		btnInsert.setBorder(null);
		btnInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnInsertMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnInsertMouseExited(e);
			}
		});
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInsertActionPerformed(e);
			}
		});
		btnInsert.setBackground(Color.BLUE);
		btnInsert.setBounds(77, 562, 86, 23);
		getContentPane().add(btnInsert);
		
		btnFirst = new JButton("");
		btnFirst.setIcon(new ImageIcon("images\\icons8-last-24 (1).png"));
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFirstActionPerformed(e);
			}
		});
		btnFirst.setMnemonic('F');
		btnFirst.setBounds(742, 495, 21, 23);
		getContentPane().add(btnFirst);
		
		btnPrevious = new JButton("");
		btnPrevious.setIcon(new ImageIcon("images\\icons8-next-24 (2).png"));
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviousActionPerformed(e);
			}
		});
		btnPrevious.setBounds(762, 495, 21, 23);
		getContentPane().add(btnPrevious);
		
		btnNext = new JButton("");
		btnNext.setIcon(new ImageIcon("images\\icons8-next-24 (1).png"));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});
		btnNext.setBounds(914, 495, 21, 23);
		getContentPane().add(btnNext);
		
		btnLast = new JButton("");
		btnLast.setIcon(new ImageIcon("images\\icons8-last-24.png"));
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLastActionPerformed(e);
			}
		});
		btnLast.setBounds(936, 495, 21, 23);
		getContentPane().add(btnLast);
		
		txtPage = new JTextField();
		txtPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPageActionPerformed(e);
			}
		});
		txtPage.setBackground(Color.LIGHT_GRAY);
		txtPage.setText("1");
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setColumns(10);
		txtPage.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 255)));
		txtPage.setBounds(793, 497, 111, 20);
		getContentPane().add(txtPage);
		loadEmployee();
		hidenextlast();
	}
	
	public String baseSalary(int a) {
		List<Salary> listSalary = salaryDao.selectAllSalary();
		for(Salary salary : listSalary) {
			if(a == salary.getId()) {
				return String.valueOf(salary.getBase_salary());
			}
		}
		return null ;
	}
	
	public String departmentName(int a) {
		List<Department> listDepartment = departmentDao.selectAllDepartment();
		for(Department dep : listDepartment) {
			if(a == dep.getDepartment_id()) {
				return dep.getDepartment_name();
			}
		}
		return null;
	}
	
	public String degreeName(int a) {
		List<Education> listEducation = educationDao.selectAllEducation();
		for(Education edu : listEducation) {
			if(a == edu.getId()) {
				return edu.getDegree_name();
			}
		}
		return null;
	}
	
	public String positionName(int a) {
		List<Position> listPosition = positionDao.selectAllPosition();
		for(Position pos : listPosition) {
			if(a == pos.getPosition_id()) {
				return pos.getPosition_name();
			}
		}
		return null;
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
					case 12: return String.class;// Image dir
					default: return String.class;
				}
			}
			@Override 
			public boolean isCellEditable(int row , int col) {
				switch(col){

					case 11: return false;

					default: return false;
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
		model.addColumn("Supervisor");
		model.addColumn("Department");
		model.addColumn("Education");
		model.addColumn("Position");
		model.addColumn("Picture");
		model.addColumn("pathpicture");
		model.addColumn("Level");

		EmployeeDAO dao = new EmployeeDAO();
		totalCount = dao.countEmployee();
		totalPage = Math.ceil(totalCount.doubleValue() / rowOfPage.doubleValue());
		totalCount = dao.countEmployee();
		totalPage = Math.ceil(totalCount.doubleValue() / rowOfPage.doubleValue());
		dao.selectEmployee(pageNumber, rowOfPage)
			.stream()
			.filter(emp -> emp.getStatus()== 1)
			.forEach(emp -> model.addRow(new Object[] {
				emp.getId(),
				emp.getFull_name(),
				emp.getEthnicity(),
				emp.getDate_of_birth(),
				emp.getGender(),
				emp.getAddress(),
				baseSalary(emp.getSalary_level()),
				emp.getSupervisor_id(),
				departmentName(emp.getDepartment_id()),
				degreeName(emp.getEducation_id()),
				positionName(emp.getPosition_id()),
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
		for (int i = 0; i < model.getColumnCount(); i++) {
		    if (i != 11) {
		        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		        table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		    }
		}
	}
	
//	public ImageIcon getSelectedImageIcon() {
//	    int selectedRow = table.getSelectedRow();
//	    int imageColumn = 11; // Index of the column containing the ImageIcon
//
//	    if (selectedRow != -1) {
//	        return (ImageIcon) table.getModel().getValueAt(selectedRow, imageColumn);
//	    }
//
//	    return null;
//	}

	
	public void refresh() {
		DefaultTableModel model =  (DefaultTableModel)table.getModel();
		model.setRowCount(0); 
		EmployeeDAO dao = new EmployeeDAO();
		
		
//		totalCount = dao.countEmployee();
//		
//		totalPage = Math.ceil(totalCount.doubleValue() / rowOfPage.doubleValue());
		
//		lblStatus.setText("page "+pageNumber+" of "+totalPage.intValue());
//		lblTotal.setText("total customer: "+totalCount);

		
		dao.selectEmployee(pageNumber, rowOfPage).stream().filter(emp -> emp.getStatus()== 1).forEach(
				emp ->model.addRow(new Object[] {
						emp.getId(),
						emp.getFull_name(),
						emp.getEthnicity(),
						emp.getDate_of_birth(),
						emp.getGender(),
						emp.getAddress(),
						baseSalary(emp.getSalary_level()),
						emp.getSupervisor_id(),
						departmentName(emp.getDepartment_id()),
						degreeName(emp.getEducation_id()),
						positionName(emp.getPosition_id()),
						new ImageIcon(
							new ImageIcon(emp.getPicture()).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)	
						),
						emp.getPicture(),
						emp.getLevel()
						}
				)
			);
		table.setModel(model);
		hidenextlast();
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
		
		listSalary.forEach(salary -> salaryModel.addElement(salary.getBase_salary()));
		listSupervisor.forEach(sup -> supervisorModel.addElement(sup.getId()));
		listDepartment.forEach(dep -> departmentModel.addElement(dep.getDepartment_name()));
		listEducation.forEach(edu -> educationModel.addElement(edu.getDegree_name()));
		listPosition.forEach(pos -> positionModel.addElement(pos.getPosition_name()));

		cbxSalary.setModel(salaryModel);
		cbxSupervisorId.setModel(supervisorModel);
		cbxDepartmentId.setModel(departmentModel);
		cbxEducationId.setModel(educationModel);
		cbxPositionId.setModel(positionModel);
		
		var salaryId_select = String.valueOf(table.getValueAt(rowIndex, 6).toString());
		var supervisorId_select = Integer.parseInt(table.getValueAt(rowIndex, 7).toString()); 
		var departmentId_select = String.valueOf(table.getValueAt(rowIndex, 8).toString());
		var educationId_select = String.valueOf(table.getValueAt(rowIndex, 9).toString());
		var positionId_select = String.valueOf(table.getValueAt(rowIndex, 10).toString());

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
	
//	public void compareImages() {
//        String expectedImagePath = "D:\\AutomationTestImages\\Expected_Image.png";
//        String actualImagePath = "D:\\AutomationTestImages\\Actual_Image.png";
//
//        try {
//            File expectedImageFile = new File(expectedImagePath);
//            File actualImageFile = new File(actualImagePath);
//
//            BufferedImage expectedImage = ImageIO.read(expectedImageFile);
//            BufferedImage actualImage = ImageIO.read(actualImageFile);
//
//            ImageDiffer imgDiff = new ImageDiffer();
//
//            ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);
//
//            if (diff.hasDiff()) {
//                System.out.println("Images are NOT the same");
//            } else {
//                System.out.println("Images are the same");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
	
	private boolean areImagePathsEqual(String path1, String path2) {
	    if (path1 == null || path2 == null) {
	        return false;
	    }

	    File file1 = new File(path1);
	    File file2 = new File(path2);

	    try {
	        String canonicalPath1 = file1.getCanonicalPath().toLowerCase();
	        String canonicalPath2 = file2.getCanonicalPath().toLowerCase();

	        return canonicalPath1.equals(canonicalPath2);
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	
	protected void txtSearchActionPerformed(ActionEvent e) {
		String find = txtSearch.getText();
		DefaultRowSorter<?, ?> sorter = (DefaultRowSorter<?, ?>)table.getRowSorter();
		sorter.setRowFilter(RowFilter.regexFilter(find));
		sorter.setSortKeys(null);
	}
	
	
	protected void btnPictureActionPerformed(ActionEvent e) {
		var chooser = new JFileChooser();
		chooser.setDialogTitle("open image");
		chooser.setFileFilter(
				new FileNameExtensionFilter("image", "png", "jpg", "gif")
		);
		chooser.setAcceptAllFileFilterUsed(false);
		int result = chooser.showOpenDialog(null);
		if(result == JFileChooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();
			fileName = f.getName();
			dirOld = f.getAbsolutePath();
			
			lblPicture.setIcon(
				new ImageIcon(
					new ImageIcon(
						f.getAbsolutePath()).getImage()
						.getScaledInstance(
						lblPicture.getWidth(),
						lblPicture.getHeight(),
						Image.SCALE_SMOOTH)
				)
			);
		}
	}
	
	
	public int validateEmp() {
	    int count = 0;
	    int salary_level = 0;
	    int supervisor_id = 0;
	    int department_id = 0;
	    int education_id = 0;
	    int position_id = 0;

	    SalaryDAO salaryDao = new SalaryDAO();
	    EmployeeDAO employeeDao = new EmployeeDAO();
	    Manage_DepartmentsDAO departmentDao = new Manage_DepartmentsDAO();
	    EducationDAO educationDao = new EducationDAO();
	    PositionDAO positionDao = new PositionDAO();

	    List<Salary> listSalary = salaryDao.selectAllSalary();
	    List<Employee> listSupervisor = employeeDao.selectAllEmployee();
	    List<Department> listDepartment = departmentDao.selectAllDepartment();
	    List<Education> listEducation = educationDao.selectAllEducation();
	    List<Position> listPosition = positionDao.selectAllPosition();

	    for (Salary sal : listSalary) {
	        if (sal.toString().equals(cbxSalary.getSelectedItem())) {
	            salary_level = sal.getId();
	            break;
	        }
	    }

	    for (Employee emp : listSupervisor) {
	    	if (emp.toString().equals(cbxSupervisorId.getSelectedItem())) {
		            supervisor_id = emp.getId();
		            break;
		    }
	    }

	    for (Department dep : listDepartment) {
	        if (dep.toString().equals(cbxDepartmentId.getSelectedItem())) {
	            department_id = dep.getDepartment_id();
	            break;
	        }
	    }

	    for (Education edu : listEducation) {
	        if (edu.toString().equals(cbxEducationId.getSelectedItem())) {
	            education_id = edu.getId();
	            break;
	        }
	    }

	    for (Position pos : listPosition) {
	        if (pos.toString().equals(cbxPositionId.getSelectedItem())) {
	            position_id = pos.getPosition_id();
	            break;
	        }
	    }

	    if (txtFullName.getText().isEmpty() || txtEthnicity.getText().isEmpty() || 
	    	    dateChooser.getDate() == null || cbxGender.getSelectedItem() == null || 
	    	    cbxLevel.getSelectedItem() == null || cbxSupervisorId.getSelectedItem() == null ||
	    	    cbxDepartmentId.getSelectedItem() == null || cbxEducationId.getSelectedItem() == null || 
	    	    cbxPositionId.getSelectedItem() == null || txtAddress.getText().isEmpty() || 
	    	    lblPicture.getIcon() == null) {
	    	    JOptionPane.showMessageDialog(null, "Please fill in all information");
	    	    count++;
	    	}
	    Employee emp = employeeDao.getUserById(Integer.parseInt(txtEmployeeId.getText()));
	    if(emp.getLevel().equals("Admin") && AdminLogin.getAdminId() != Integer.parseInt(txtEmployeeId.getText())) {
	    	JOptionPane.showMessageDialog(null, "Don't have any permission to do");
    	    count++;
	    }
	    return count;
	}

	private boolean validatePicture(String newImagePath) {
		 int columnToCompare = 12; 
		    int rowCount = table.getRowCount();

		    for (int row = 0; row < rowCount; row++) {
		        String lblPicturePath = (String) table.getValueAt(row, columnToCompare);
		        System.out.println("lblPicturePath at row " + row + ": " + lblPicturePath);

		        if (areImagePathsEqual(lblPicturePath, newImagePath)) {
		            JOptionPane.showMessageDialog(null, "This picture is already exists");
		            return false; 
		        }
		    }

		    return true; 
	}

	protected void btnUpdateActionPerformed(ActionEvent e) {
		if(txtEmployeeId.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Please select row to delete");
			
		}else {
			if(validateEmp() != 0) {
				return;
			}else {
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
				emp.setSupervisor_id(Integer.parseInt(cbxSupervisorId.getSelectedItem().toString()));
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
					
					if (!validatePicture("images/" + fileName)) {
			               return;
			           }
					
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
	}
	
	
	
	protected void btnInsertActionPerformed(ActionEvent e) {
	        Addemployee add = Addemployee.getInstance();
	        add.setEmpform(this);
	        this.toBack();
	        if (!add.isVisible() || add.isClosed() ) {
	            add.setVisible(true);
	            add.setApp(app);
	            app.desktopPane.add(add);
	            add.toFront();
	            //this.hide();
	        }else {
	        	add.toFront();
	        }
	}
	
	protected void btnDeleteActionPerformed(ActionEvent e) {
		if(txtEmployeeId.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Please select row to delete");
			
		}else {
			int employeeId = Integer.parseInt(txtEmployeeId.getText());
			if (employeeId == AdminLogin.getAdminId()) {
			    JOptionPane.showMessageDialog(null, "You are logged in with this account, so you cannot delete it.");
			    return;
			}
			
			String employeeName = txtFullName.getText();
			
			int selectedRow = table.getSelectedRow();
		    if (selectedRow >= 0) {
		      int selectedEmployeeId = Integer.parseInt(table.getValueAt(selectedRow, 0).toString()); // Lấy ID employee từ table

		      // Kiểm tra xem employee có supervisor là selectedEmployeeId hay không
		      EmployeeDAO dao = new EmployeeDAO();
		      List<Employee> listEmp = dao.selectAllEmployee();
		      boolean isSupervisor = false;
		      for (Employee employee : listEmp) {
		        if (employee.getSupervisor_id() == selectedEmployeeId) {
		          isSupervisor = true;
		          break;
		        }
		      }
		      	Employee emp = employeeDao.getUserById(Integer.parseInt(txtEmployeeId.getText()));
			    if(emp.getLevel().equals("Admin")) {
			    	JOptionPane.showMessageDialog(null, "Don't have any permission to do");
		    	    return;
			    }
		      // Hiển thị thông báo nếu employee là supervisor
		      if (isSupervisor) {
		        JOptionPane.showMessageDialog(null, "Cannot delete this employee because they are a supervisor.");
		        return;
		      }
		    }
//			EmployeeDAO dao = new EmployeeDAO();
//			List<Employee> listEmp = dao.selectAllEmployee();
//			for(Employee employee : listEmp) {
//				if(employee.getId() == supervisorId) {
//					JOptionPane.showMessageDialog(null, "Cannot delete this employee because you are a supervisor.");
//					return;
//				}
//			}
			
			int dialogResult = JOptionPane.showConfirmDialog(
			            null,
			            "Are you sure you want to delete employee '" + employeeName + "'?\nTheir account will also be deleted.",
			            "Confirm Deletion",
			            JOptionPane.YES_NO_OPTION);
			 
			if (dialogResult == JOptionPane.YES_OPTION) {
				 	Accounts accounts = new Accounts();
			        Employee emp = new Employee();
			        Account acc = new Account();
	
			        acc.setId(accounts.getAccountId()); 
			        emp.setId(employeeId);
	
			        AccountDAO accDao = new AccountDAO();
			        EmployeeDAO empDao = new EmployeeDAO();
					
			        accDao.deleteAccountAndEmployee(acc, emp);
			        empDao.deleteEmployeeAndAccount(emp, acc);
			        
	
			        refresh();
			}
		}
	}
	
	protected void tableMousePressed(MouseEvent e) {
		JPopupMenu menu = new JPopupMenu("delete...");
		JMenuItem item = new JMenuItem("delete row" , 'd');
		menu.add(item);
		
		item.addActionListener(this::deleteRow);
		
		if(e.getButton() == MouseEvent.BUTTON3) {
			
			int r = table.rowAtPoint(e.getPoint());
			table.setRowSelectionInterval(r, r);
			menu.show(table , e.getX() , e.getY());
		}
	}
	
	private void deleteRow(ActionEvent e) {
		if (Integer.parseInt(txtEmployeeId.getText()) == AdminLogin.getAdminId()) {
		    JOptionPane.showMessageDialog(null, "You are logged in with this account, so you cannot delete it.");
		    return;
		}
		String employeeName = txtFullName.getText(); 
		
		int selectedRow = table.getSelectedRow();
	    if (selectedRow >= 0) {
	      int selectedEmployeeId = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());

	      EmployeeDAO dao = new EmployeeDAO();
	      List<Employee> listEmp = dao.selectAllEmployee();
	      boolean isSupervisor = false;
	      for (Employee employee : listEmp) {
	        if (employee.getSupervisor_id() == selectedEmployeeId) {
	          isSupervisor = true;
	          break;
	        }
	      }

	      if (isSupervisor) {
	        JOptionPane.showMessageDialog(null, "Cannot delete this employee because they are a supervisor.");
	        return;
	      }
	    }
		
		int dialogResult = JOptionPane.showConfirmDialog(
	            null,
	            "Are you sure you want to delete employee '" + employeeName + "'?\nTheir account will also be deleted.",
	            "Confirm Deletion",
	            JOptionPane.YES_NO_OPTION);
		
		Employee emp = new Employee();
		int rowindex = table.getSelectedRow();
		emp.setId(
				Integer.parseInt(
						table.getValueAt( rowindex,0).toString()
				)
		);
		if (dialogResult == JOptionPane.YES_OPTION) {
			Accounts accounts = new Accounts();
	        Account acc = new Account();

	        acc.setId(accounts.getAccountId()); 

	        AccountDAO accDao = new AccountDAO();
	        EmployeeDAO empDao = new EmployeeDAO();

	        accDao.deleteAccountAndEmployee(acc, emp);
	        empDao.deleteEmployeeAndAccount(emp, acc);

	        refresh();
		}
	}
	
	protected void btnFirstActionPerformed(ActionEvent e) {
		pageNumber =1;
		txtPage.setText(pageNumber.toString());
		refresh();
	}
	
	
	protected void btnLastActionPerformed(ActionEvent e) {
		pageNumber = totalPage.intValue();
		txtPage.setText(pageNumber.toString());
		refresh();
	}
	
	protected void txtPageActionPerformed(ActionEvent e) {
		int page = Integer.parseInt(txtPage.getText());
		
		if(page >= 1 && page <= totalPage.intValue()) {
			pageNumber = page;
			refresh();
		}else {
			JOptionPane.showMessageDialog(txtPage, "page must be 1 to" + totalPage.intValue());
			txtPage.setText(pageNumber.toString());
		}
	}
	
	protected void btnPreviousActionPerformed(ActionEvent e) {
		if(pageNumber > 1) {
			pageNumber--;
			txtPage.setText(pageNumber.toString());
			refresh();
		}
	}
	
	protected void btnNextActionPerformed(ActionEvent e) {
		if(pageNumber < totalPage.intValue()) {
			pageNumber++;
			txtPage.setText(pageNumber.toString());
			refresh();
		}
	}
	
	protected void btnUpdateMouseEntered(MouseEvent e) {
		btnUpdate.setForeground(new Color(0, 255, 64));
		btnUpdate.setBorder(new LineBorder(new Color(0, 255, 64)));
		btnUpdate.setBackground(Color.white);
	}
	
	protected void btnUpdateMouseExited(MouseEvent e) {
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(new Color(0, 255, 64));
	}
	
	protected void btnDeleteMouseEntered(MouseEvent e) {
		btnDelete.setForeground(Color.RED);
		btnDelete.setBorder(new LineBorder(Color.RED));
		btnDelete.setBackground(Color.white);
	}
	
	protected void btnDeleteMouseExited(MouseEvent e) {
		btnDelete.setForeground(Color.white);
		btnDelete.setBackground(Color.RED);
	}
	
	protected void btnInsertMouseEntered(MouseEvent e) {
		btnInsert.setBackground(Color.white);
		btnInsert.setBorder(new LineBorder(new Color(0, 102, 255)));
		btnInsert.setForeground(new Color(0, 102, 255));
	}
	
	protected void btnInsertMouseExited(MouseEvent e) {
		btnInsert.setForeground(Color.WHITE);
		btnInsert.setBackground(new Color(0, 102, 255));
	}
}
