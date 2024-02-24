package crud;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

//import org.mindrot.jbcrypt.BCrypt;

import App.App_Admin;
import Gui.Accounts;
import Gui.EmployeeForm;
import Gui.Work_Schedules;
import dao.AccountDAO;
import dao.EmployeeDAO;
import entity.Account;
import entity.Employee;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Addaccount extends JInternalFrame {

	private JComponent Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarca =null;
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblAccount;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JLabel lblUsername;
	private JTextField txtUsername;
	private JLabel lblPassword;
	private JPasswordField txtPassword;
	private JButton btnSubmit;
	private static Addaccount instance;
	private App_Admin app;
	private Employee emp;
	
	EmployeeForm empform = new EmployeeForm();
	
	public EmployeeForm getEmpform() {
		return empform;
	}


	public void setEmpform(EmployeeForm empform) {
		this.empform = empform;
	}

	public void setApp(App_Admin app) {
		this.app = app;
	}
	
	


	public void setEmp(Employee emp) {
		this.emp = emp;
	}



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addaccount frame = new Addaccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static Addaccount getInstance() {
        if (instance == null || instance.isClosed()) {
            instance = new Addaccount();
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
	
	public Addaccount() {
		getContentPane().setBackground(Color.WHITE);
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		quit();
		
		setTitle("Create Account");
		setBounds(100, 50, 463, 514);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(102, 0, 255));
		panel.setBounds(0, 0, 463, 52);
		getContentPane().add(panel);
		
		lblAccount = new JLabel("Account");
		lblAccount.setForeground(Color.WHITE);
		lblAccount.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblAccount.setBounds(10, 18, 171, 25);
		panel.add(lblAccount);
		
		lblNewLabel = new JLabel("-Create");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(110, 18, 63, 14);
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(SystemColor.controlHighlight);
		panel_1.setBounds(0, 432, 463, 55);
		getContentPane().add(panel_1);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSubmitActionPerformed(e);
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSubmit.setBorder(null);
		btnSubmit.setBackground(Color.BLUE);
		btnSubmit.setBounds(178, 11, 89, 37);
		panel_1.add(btnSubmit);
		
		lblUsername = new JLabel("Username :");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(141, 152, 174, 14);
		getContentPane().add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsername.setColumns(10);
		txtUsername.setBounds(94, 177, 282, 39);
		getContentPane().add(txtUsername);
		
		lblPassword = new JLabel("Password : ");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(141, 274, 174, 14);
		getContentPane().add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setBounds(94, 299, 282, 39);
		getContentPane().add(txtPassword);

	}
<<<<<<< HEAD
=======
	protected void lblCloseMouseClicked(MouseEvent e) {
		this.dispose();
	}
>>>>>>> 504635e2edb826f7678d00ddfcbc4ba77aaeff1d
	
	public void resetAccount() {
		lblUsername.setText("");
		lblPassword.setText("");
	}

	protected void btnSubmitActionPerformed(ActionEvent e) {
		String username = txtUsername.getText();
		String password = new String(txtPassword.getPassword());

		if (!Accounts.validateUsername(username) || !Accounts.valPassword(password)) {
		        return;
		    }
		    
		EmployeeDAO employeeDAO = new EmployeeDAO();
		AccountDAO accountDAO = new AccountDAO();
		
		if (accountDAO.isUsernameExists(txtUsername.getText())) {
	        JOptionPane.showMessageDialog(null, "Username already exists. Please choose another username.");
	        return;
	    }
	    
		if (employeeDAO.insert(emp)) {
		    Account acc = new Account();
		    acc.setUsername(txtUsername.getText());
		    acc.setPassword(password);

		    int defaultStatus = 1;
		    if (accountDAO.insert(acc,defaultStatus)) {
		        JOptionPane.showMessageDialog(null, "Add successfully!");
<<<<<<< HEAD
		        resetAccount();
		        var empForm = new EmployeeForm();
		        empForm.setVisible(true);;
		        App_Admin app = new App_Admin();
		        app.desktopPane.add(empForm);
		        this.hide();
		        return;
=======
		        empform.toFront();
		        empform.refresh();
//		        empform.refresh();
//		        empForm.setVisible(true);;
//		        App_Admin app = new App_Admin();
//		        app.loadEmployeeForm();
		        this.dispose();
		        
>>>>>>> 504635e2edb826f7678d00ddfcbc4ba77aaeff1d
		    } else {
		        JOptionPane.showMessageDialog(null, "Add Fail!");
		    }
		} else {
		    JOptionPane.showMessageDialog(null, "Addemplogyee Fail!");
		}
	}	
}
