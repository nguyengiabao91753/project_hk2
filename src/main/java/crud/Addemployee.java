package crud;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import App.App_Admin;
import Gui.EmployeeForm;
import dao.Manage_DepartmentsDAO;
import dao.EducationDAO;
import dao.EmployeeDAO;
import dao.PositionDAO;
import dao.RoomDAO;
import dao.SalaryDAO;
import dao.ShiftDAO;
import dao.WorkscheduleDAO;
import entity.Department;
import entity.Education;
import entity.Employee;
import entity.Position;
import entity.Room;
import entity.Salary;
import entity.Shift;
import entity.Workschedule;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Addemployee extends JInternalFrame {

	private JComponent Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarca =null;
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblClose;
	private JLabel lblEmployee;
	private JLabel lblNewLabel_2;
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
	private JTextField txtFullName;
	private JTextField txtEthnicity;
	private JDateChooser dateChooser;
	private JComboBox cbxGender;
	private JTextField txtAddress;
	private JComboBox cbxSupervisorId;
	private JComboBox cbxDepartmentId;
	private JComboBox cbxEducationId;
	private JLabel lblPicture;
	private JLabel lblLevel;
	private JComboBox cbxLevel;
	private JButton btnPicture;
	private JPanel panel_1;
	private JButton btnCreate;
	private JComboBox cbxPositionId;
	private static Addemployee instance;
	private App_Admin app;
	private Employee emp;
	LocalDate currentDate = LocalDate.now();
	EmployeeForm empform;
	
	public EmployeeForm getEmpform() {
		return empform;
	}


	public void setEmpform(EmployeeForm empform) {
		this.empform = empform;
	}


	SalaryDAO salaryDao = new SalaryDAO();
	EmployeeDAO employeeDao = new EmployeeDAO();
	Manage_DepartmentsDAO departmentDao = new Manage_DepartmentsDAO();
	EducationDAO educationDao = new EducationDAO();
	PositionDAO positionDao = new PositionDAO();
	
	private String fileName = null;
	private String fileOld = null;
	private String dirNew = null;
	private String dirOld = null;
	private JComboBox cbxSalaryId;
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
					Addemployee frame = new Addemployee();
					frame.setVisible(true);
					frame.toFront();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static Addemployee getInstance() {
        if (instance == null || instance.isClosed()) {
            instance = new Addemployee();
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
	
	public Addemployee() {
		getContentPane().setBackground(Color.WHITE);
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		quit();
		
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		setTitle("Add Employee");
		setBounds(223,5,480,627);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(102, 0, 255));
		panel.setBounds(0, 0, 480, 52);
		getContentPane().add(panel);
		
		lblClose = new JLabel("<html>\r\n\t<p style=\"font-size: 24px;color:white\">&#10006;</p>\r\n</html>");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCloseMouseClicked(e);
			}
		});
		lblClose.setBounds(445, 3, 25, 49);
		panel.add(lblClose);
		
		lblEmployee = new JLabel("Employee");
		lblEmployee.setForeground(Color.WHITE);
		lblEmployee.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEmployee.setBounds(10, 18, 171, 25);
		panel.add(lblEmployee);
		
		lblNewLabel_2 = new JLabel("-Create");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(117, 18, 63, 14);
		panel.add(lblNewLabel_2);
		
		lblName = new JLabel("Full name :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(42, 108, 86, 14);
		getContentPane().add(lblName);
		
		lblEthnicity = new JLabel("Ethnicity :");
		lblEthnicity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEthnicity.setBounds(42, 139, 86, 14);
		getContentPane().add(lblEthnicity);
		
		lblDateOfBirth = new JLabel("Date of birth :");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDateOfBirth.setBounds(42, 170, 86, 14);
		getContentPane().add(lblDateOfBirth);
		
		lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGender.setBounds(42, 202, 86, 14);
		getContentPane().add(lblGender);
		
		lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress.setBounds(42, 232, 86, 14);
		getContentPane().add(lblAddress);
		
		lblSalary = new JLabel("Salary level :");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSalary.setBounds(42, 263, 86, 14);
		getContentPane().add(lblSalary);
		
		lblSupervisorId = new JLabel("Supervisor :");
		lblSupervisorId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSupervisorId.setBounds(42, 294, 86, 14);
		getContentPane().add(lblSupervisorId);
		
		lblDepartmentId = new JLabel("Department :");
		lblDepartmentId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDepartmentId.setBounds(42, 325, 99, 14);
		getContentPane().add(lblDepartmentId);
		
		lblEducationId = new JLabel("Education :");
		lblEducationId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEducationId.setBounds(42, 356, 86, 14);
		getContentPane().add(lblEducationId);
		
		lblPositionId = new JLabel("Position :");
		lblPositionId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPositionId.setBounds(42, 387, 86, 14);
		getContentPane().add(lblPositionId);
		
		lblImage = new JLabel("Image :");
		lblImage.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblImage.setBounds(42, 439, 86, 14);
		getContentPane().add(lblImage);
		
		txtFullName = new JTextField();
		txtFullName.setColumns(10);
		txtFullName.setBounds(151, 105, 278, 20);
		getContentPane().add(txtFullName);
		
		txtEthnicity = new JTextField();
		txtEthnicity.setColumns(10);
		txtEthnicity.setBounds(151, 136, 278, 20);
		getContentPane().add(txtEthnicity);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(151, 167, 278, 20);
		getContentPane().add(dateChooser);
		
		cbxGender = new JComboBox();
		cbxGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cbxGender.setBounds(151, 198, 278, 22);
		getContentPane().add(cbxGender);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(151, 229, 278, 20);
		getContentPane().add(txtAddress);
		
		cbxSupervisorId = new JComboBox();
		cbxSupervisorId.setBounds(151, 290, 278, 22);
		getContentPane().add(cbxSupervisorId);
		
		cbxDepartmentId = new JComboBox();
		cbxDepartmentId.setBounds(151, 321, 278, 22);
		getContentPane().add(cbxDepartmentId);
		
		cbxEducationId = new JComboBox();
		cbxEducationId.setBounds(151, 352, 278, 22);
		getContentPane().add(cbxEducationId);
		
		lblPicture = new JLabel("");
		lblPicture.setOpaque(true);
		lblPicture.setBackground(Color.GRAY);
		lblPicture.setBounds(151, 415, 278, 60);
		getContentPane().add(lblPicture);
		
		lblLevel = new JLabel("Level :");
		lblLevel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLevel.setBounds(42, 520, 86, 14);
		getContentPane().add(lblLevel);
		
		cbxLevel = new JComboBox();
		cbxLevel.setModel(new DefaultComboBoxModel(new String[] {"", "Admin", "User"}));
		cbxLevel.setBounds(151, 520, 278, 22);
		getContentPane().add(cbxLevel);
		
		btnPicture = new JButton("Choose Image");
		btnPicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPictureActionPerformed(e);
			}
		});
		btnPicture.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPicture.setBounds(151, 486, 278, 23);
		getContentPane().add(btnPicture);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(235, 234, 233));
		panel_1.setBounds(0, 545, 480, 62);
		getContentPane().add(panel_1);
		
		btnCreate = new JButton("NEXT");
		btnCreate.setForeground(Color.WHITE);
		btnCreate.addMouseListener(new MouseAdapter() {
			
		});
		btnCreate.setBorder(null);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateActionPerformed(e);
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCreate.setBackground(Color.BLUE);
		btnCreate.setBounds(192, 14, 89, 37);
		panel_1.add(btnCreate);
		
		cbxPositionId = new JComboBox();
		cbxPositionId.setBounds(151, 383, 278, 22);
		getContentPane().add(cbxPositionId);
		
		cbxSalaryId = new JComboBox();
		cbxSalaryId.setBounds(151, 259, 278, 22);
		getContentPane().add(cbxSalaryId);
		loadcbx();
		cbxGender.setSelectedItem(null);
		cbxSalaryId.setSelectedItem(null);
		cbxSupervisorId.setSelectedItem(null);
		cbxDepartmentId.setSelectedItem(null);
		cbxEducationId.setSelectedItem(null);
		cbxPositionId.setSelectedItem(null);
	}
	
	protected void loadcbx() {
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
		listSupervisor.stream().filter(emp -> emp.getStatus()== 1).forEach(emp -> supervisorModel.addElement(emp.getId()));
//		listDepartment.forEach(dep -> departmentModel.addElement(dep.getDepartment_id()));
//		listEducation.forEach(edu -> educationModel.addElement(edu.getId()));
//		listPosition.forEach(pos -> positionModel.addElement(pos.getPosition_id()));
		listDepartment.forEach(dep -> departmentModel.addElement(dep.getDepartment_name()));
		listEducation.forEach(edu -> educationModel.addElement(edu.getDegree_name()));
		listPosition.forEach(pos -> positionModel.addElement(pos.getPosition_name()));
		
		cbxSalaryId.setModel(salaryModel);
		cbxSupervisorId.setModel(supervisorModel);
		cbxDepartmentId.setModel(departmentModel);
		cbxEducationId.setModel(educationModel);
		cbxPositionId.setModel(positionModel);
	}
	
	protected void lblCloseMouseClicked(MouseEvent e) {
		this.dispose();
	}
	
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
	
	public int validateAddEmployee() {
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
	        if (sal.toString().equals(cbxSalaryId.getSelectedItem())) {
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
	    //|| cbxSupervisorId.getSelectedItem() == null
	    if (txtFullName.getText().isEmpty() || txtEthnicity.getText().isEmpty() || 
	    	    dateChooser.getDate() == null || cbxGender.getSelectedItem() == null || 
	    	    cbxLevel.getSelectedItem() == null  ||
	    	    cbxDepartmentId.getSelectedItem() == null || cbxEducationId.getSelectedItem() == null || 
	    	    cbxPositionId.getSelectedItem() == null || txtAddress.getText().isEmpty() || 
	    	    lblPicture.getIcon() == null) {
	    	    JOptionPane.showMessageDialog(null, "Please fill in all information");
	    	    count++;
	    	}
	    
	    int bd = currentDate.getYear() - LocalDate.ofInstant(dateChooser.getDate().toInstant(), ZoneId.systemDefault()).getYear();
	    if(currentDate.equals(LocalDate.ofInstant(dateChooser.getDate().toInstant(), ZoneId.systemDefault())) || currentDate.isAfter(LocalDate.ofInstant(dateChooser.getDate().toInstant(), ZoneId.systemDefault())) && bd <=18) {
	    	JOptionPane.showMessageDialog(null, "Must be older than 18 years old");
    	    count++;
	    }
	    return count;
	}
	
	private boolean validatePicture(String newImagePath) {
		 int columnToCompare = 12; 
		    int rowCount = EmployeeForm.getTable().getRowCount();

		    for (int row = 0; row < rowCount; row++) {
		        String lblPicturePath = (String) EmployeeForm.getTable().getValueAt(row, columnToCompare);
		        System.out.println("lblPicturePath at row " + row + ": " + lblPicturePath);

		        if (areImagePathsEqual(lblPicturePath, newImagePath)) {
		            JOptionPane.showMessageDialog(null, "This picture is already exists");
		            return false; 
		        }
		    }

		    return true; 
	}
	
	public void resetField() {
		txtFullName.setText("");
		txtEthnicity.setText("");
		cbxGender.setSelectedItem(null);
		txtAddress.setText("");
		cbxSalaryId.setSelectedItem(null);
		cbxSupervisorId.setSelectedItem(null);
		cbxDepartmentId.setSelectedItem(null);
		cbxEducationId.setSelectedItem(null);
		cbxPositionId.setSelectedItem(null);
		lblPicture.setIcon(null);
		cbxLevel.setSelectedItem(null);
	}
	
	protected void btnCreateActionPerformed(ActionEvent e) {
		if(validateAddEmployee() !=0) {
			return;
		}else {
			Employee emp = new Employee();
			emp.setFull_name(txtFullName.getText());
			emp.setEthnicity(txtEthnicity.getText());
			emp.setDate_of_birth(LocalDate.ofInstant(dateChooser.getDate().toInstant(), ZoneId.systemDefault()));
			emp.setGender(cbxGender.getSelectedItem().toString());
			emp.setAddress(txtAddress.getText());
			emp.setSalary_level(cbxSalaryId.getSelectedIndex()+1);
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
			
			Addaccount add = Addaccount.getInstance();
			add.setEmp(emp);
			add.setEmpform(empform);
			
	        if (!add.isVisible()) {
	            add.setVisible(true);
	            app.desktopPane.add(add);
	            add.toFront();
	            this.hide();
	        }else {
	        	add.toFront();
	        }
	        resetField();
		}
		
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
	
	
}
