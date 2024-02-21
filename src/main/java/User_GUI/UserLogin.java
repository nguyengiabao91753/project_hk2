package User_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import App.App_Admin;
import App.App_User;
import dao.AccountDAO;
import entity.Account;
import entity.Employee;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblClose;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblDisable;
	private int xx, xy;
	private JCheckBox chckbxNewCheckBox;
	private JButton btnLogin;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblShow;
	private static int userId;
	private static boolean isLoggedIn = false;
	public static void setUserId(int id) {
        userId = id;
    }


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
					frame.setUndecorated(true);
					frame.setLocationRelativeTo(null);
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
	public static int getUserId() {
		return userId;
	}
	public UserLogin() {
		setUndecorated(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				thisWindowOpened(e);
			}
		});
		setTitle("User Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 636);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				contentPaneMouseDragged(e);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				contentPaneMousePressed(e);
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 675, 636);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images\\868320_people_512x512.png"));
		lblNewLabel.setBounds(77, 39, 512, 541);
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(675, 0, 525, 636);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblClose = new JLabel("X");
		lblClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCloseMouseClicked(e);
			}
		});
		lblClose.setForeground(new Color(0, 0, 0));
		lblClose.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblClose.setBounds(490, 0, 46, 30);
		panel_1.add(lblClose);
		
		lblNewLabel_1 = new JLabel("USER LOGIN");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 83, 525, 76);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(41, 170, 416, 43);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("___________________________________________________");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(41, 235, 416, 19);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("images\\Sample_User_Icon (1).png"));
		lblNewLabel_4.setBounds(465, 222, 50, 50);
		panel_1.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(41, 319, 416, 43);
		panel_1.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("___________________________________________________");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(41, 384, 416, 19);
		panel_1.add(lblNewLabel_6);
		
		lblDisable = new JLabel("");
		lblDisable.setBorder(null);
		lblDisable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDisable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblDisableMouseClicked(e);
			}
		});
		lblDisable.setIcon(new ImageIcon("images\\Screenshot_2024-02-09_220647-rem.png"));
		lblDisable.setBounds(465, 384, 50, 43);
		panel_1.add(lblDisable);
		
		chckbxNewCheckBox = new JCheckBox("Rememeber Password");
		chckbxNewCheckBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chckbxNewCheckBox.setForeground(new Color(255, 255, 255));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxNewCheckBox.setBackground(SystemColor.activeCaption);
		chckbxNewCheckBox.setBounds(41, 443, 221, 23);
		panel_1.add(chckbxNewCheckBox);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoginActionPerformed(e);
			}
		});
		btnLogin.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setForeground(SystemColor.activeCaption);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.setBounds(41, 517, 470, 60);
		panel_1.add(btnLogin);
		
		txtUsername = new JTextField();
		txtUsername.setForeground(new Color(255, 255, 255));
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsername.setBorder(null);
		txtUsername.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtUsername.setBackground(SystemColor.activeCaption);
		txtUsername.setBounds(41, 214, 408, 30);
		panel_1.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setForeground(new Color(255, 255, 255));
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setBorder(null);
		txtPassword.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtPassword.setBackground(SystemColor.activeCaption);
		txtPassword.setBounds(41, 362, 408, 30);
		panel_1.add(txtPassword);
		
		lblShow = new JLabel("");
		lblShow.setBorder(null);
		lblShow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblShowMouseClicked(e);
			}
		});
		lblShow.setIcon(new ImageIcon("images\\Screenshot_2024-02-09_220632-removebg-preview.png"));
		lblShow.setBounds(468, 384, 46, 43);
		panel_1.add(lblShow);
	}
	protected void lblCloseMouseClicked(MouseEvent e) {
		System.exit(0);
	}
	protected void contentPaneMousePressed(MouseEvent e) {
		xx = e.getX();
        xy = e.getY();
	}
	protected void contentPaneMouseDragged(MouseEvent e) {
		int x = e.getXOnScreen();
        int y = e.getYOnScreen();
        UserLogin.this.setLocation(x - xx, y - xy);
	}
	protected void lblDisableMouseClicked(MouseEvent e) {
		txtPassword.setEchoChar((char)0);
		lblDisable.setVisible(false);
		lblDisable.setEnabled(false);
		lblShow.setVisible(true);
		lblShow.setEnabled(true);
	}
	protected void lblShowMouseClicked(MouseEvent e) {
		txtPassword.setEchoChar((char)8226);
		lblDisable.setVisible(true);
		lblDisable.setEnabled(true);
		lblShow.setVisible(false);
		lblShow.setEnabled(false);
	}
	protected void thisWindowOpened(WindowEvent e) {
		for(double i = 0.0; i <= 1.0 ; i = i+ 0.1 ) {
			String val = i + "";
			float f = Float.valueOf(val);
			this.setOpacity(f);
			try {
				Thread.sleep(50);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	protected void btnLoginActionPerformed(ActionEvent e) {
		String username = txtUsername.getText();
	    String password = new String(txtPassword.getPassword()); 

	    Account acc = new Account(); 
	    acc.setUsername(username); 
	    acc.setPassword(password); 

	    AccountDAO dao = new AccountDAO();
	    String loginMessage = dao.loginUser(acc);

	    if (loginMessage.equals("Login successful.")) {
	    	isLoggedIn = true;
	    	userId = dao.getUserId(username); 
	        dispose();
//	    	this.setVisible(false);
	        App_User app = new App_User();
	        app.setUndecorated(true);
	        app.setLocationRelativeTo(null);
	        app.setVisible(true);
	        //App_User.main(null);
	        
	    } else {
	        JOptionPane.showMessageDialog(null, loginMessage);
	    }
	}
	
	 public static boolean isLoggedIn() {
	        return isLoggedIn;
	 }
	
}
