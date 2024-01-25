package Gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Employees extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JComboBox comboBox;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JLabel lblNewLabel;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employees frame = new Employees();
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
	public Employees() {
		setBounds(223,37,957,627);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(131, 49, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(131, 80, 86, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(131, 111, 86, 20);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(131, 142, 86, 20);
		getContentPane().add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(131, 204, 86, 20);
		getContentPane().add(textField_5);
		
		comboBox = new JComboBox();
		comboBox.setBounds(131, 173, 86, 22);
		getContentPane().add(comboBox);
		
		textField_4 = new JTextField();
		textField_4.setBounds(131, 235, 86, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(131, 266, 86, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(131, 297, 86, 20);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(131, 328, 86, 20);
		getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(131, 359, 86, 20);
		getContentPane().add(textField_9);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(163, 459, 46, 14);
		getContentPane().add(lblNewLabel);
		
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
		lblDepartmentId.setBounds(22, 300, 86, 14);
		getContentPane().add(lblDepartmentId);
		
		lblEducationId = new JLabel("Education ID :");
		lblEducationId.setBounds(22, 331, 86, 14);
		getContentPane().add(lblEducationId);
		
		lblPositionId = new JLabel("Position ID :");
		lblPositionId.setBounds(22, 362, 86, 14);
		getContentPane().add(lblPositionId);
		
		lblImage = new JLabel("Image :");
		lblImage.setBounds(22, 459, 86, 14);
		getContentPane().add(lblImage);

	}
}
