package crud;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

import App.App_Admin;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

public class Addaccount extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblClose;
	private JLabel lblAccount;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JLabel lblClose_1;
	private JLabel lblUsername;
	private JTextField textField;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JButton btnSubmit;
	private static Addaccount instance;
	private App_Admin app;
	
	
	


	public void setApp(App_Admin app) {
		this.app = app;
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
        if (instance == null) {
            instance = new Addaccount();
        }
        return instance;
    }

	/**
	 * Create the frame.
	 */
	public Addaccount() {
		setTitle("Create Account");
		setBounds(100, 100, 463, 514);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(102, 0, 255));
		panel.setBounds(0, 0, 447, 52);
		getContentPane().add(panel);
		
		lblClose = new JLabel("<html>\r\n\t<p style=\"font-size: 24px;color:white\">&#10006;</p>\r\n</html>");
		lblClose.setBounds(445, 3, 25, 49);
		panel.add(lblClose);
		
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
		panel_1.setBounds(0, 432, 447, 52);
		getContentPane().add(panel_1);
		
		lblClose_1 = new JLabel("<html>\r\n\t<p style=\"font-size: 24px;color:white\">&#10006;</p>\r\n</html>");
		lblClose_1.setBounds(445, 3, 25, 49);
		panel_1.add(lblClose_1);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSubmit.setBorder(null);
		btnSubmit.setBackground(Color.BLUE);
		btnSubmit.setBounds(170, 8, 89, 37);
		panel_1.add(btnSubmit);
		
		lblUsername = new JLabel("Username :");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(130, 152, 174, 14);
		getContentPane().add(lblUsername);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(130, 177, 174, 20);
		getContentPane().add(textField);
		
		lblPassword = new JLabel("Password : ");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(130, 274, 174, 14);
		getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(130, 299, 174, 20);
		getContentPane().add(passwordField);

	}
}
