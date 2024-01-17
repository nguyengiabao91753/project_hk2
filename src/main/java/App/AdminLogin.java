package App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(124, 69, 170, 36);
		textField.setBorder(new TitledBorder(null, "Email:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(124, 116, 170, 36);
		passwordField.setBorder(new TitledBorder(null, "Password:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		contentPane.setLayout(null);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoginActionPerformed(e);
			}
		});
		btnLogin.setBounds(124, 163, 170, 23);
		btnLogin.setBackground(new Color(128, 128, 128));
		contentPane.add(btnLogin);
		contentPane.add(passwordField);
		contentPane.add(textField);
		
		panel = new JPanel();
		panel.setBackground(new Color(128, 128, 0));
		panel.setBounds(87, 37, 245, 196);
		contentPane.add(panel);
		panel.setLayout(null);
	}
	protected void btnLoginActionPerformed(ActionEvent e) {
		MainJframe admin = new MainJframe();
		admin.setVisible(true);
		this.setVisible(false);
	}
}
