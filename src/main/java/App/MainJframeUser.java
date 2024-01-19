package App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;

public class MainJframeUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu1;
	private JMenu mnNewMenu2;
	private JMenu mnNewMenu3;
	private JMenu mnNewMenu4;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_7;
	private JMenuItem mntmNewMenuItem_8;
	private JMenuItem mntmNewMenuItem_9;
	private JMenuItem mntmNewMenuItem_10;
	private JMenuItem mntmNewMenuItem_11;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_7;
	private JSeparator separator_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainJframeUser frame = new MainJframeUser();
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
	public MainJframeUser() {
		setTitle("User");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu1 = new JMenu("Menu1");
		menuBar.add(mnNewMenu1);
		
		mnNewMenu2 = new JMenu("Menu2");
		menuBar.add(mnNewMenu2);
		
		mntmNewMenuItem_3 = new JMenuItem("New menu item");
		mnNewMenu2.add(mntmNewMenuItem_3);
		
		separator_3 = new JSeparator();
		mnNewMenu2.add(separator_3);
		
		mntmNewMenuItem_4 = new JMenuItem("New menu item");
		mnNewMenu2.add(mntmNewMenuItem_4);
		
		separator_4 = new JSeparator();
		mnNewMenu2.add(separator_4);
		
		mntmNewMenuItem_5 = new JMenuItem("New menu item");
		mnNewMenu2.add(mntmNewMenuItem_5);
		
		mnNewMenu3 = new JMenu("Menu3");
		menuBar.add(mnNewMenu3);
		
		mntmNewMenuItem_6 = new JMenuItem("New menu item");
		mnNewMenu3.add(mntmNewMenuItem_6);
		
		separator_5 = new JSeparator();
		mnNewMenu3.add(separator_5);
		
		mntmNewMenuItem_7 = new JMenuItem("New menu item");
		mnNewMenu3.add(mntmNewMenuItem_7);
		
		separator_6 = new JSeparator();
		mnNewMenu3.add(separator_6);
		
		mntmNewMenuItem_8 = new JMenuItem("New menu item");
		mnNewMenu3.add(mntmNewMenuItem_8);
		
		mnNewMenu4 = new JMenu("Menu4");
		menuBar.add(mnNewMenu4);
		
		mntmNewMenuItem_9 = new JMenuItem("New menu item");
		mnNewMenu4.add(mntmNewMenuItem_9);
		
		separator_7 = new JSeparator();
		mnNewMenu4.add(separator_7);
		
		mntmNewMenuItem_10 = new JMenuItem("New menu item");
		mnNewMenu4.add(mntmNewMenuItem_10);
		
		separator_8 = new JSeparator();
		mnNewMenu4.add(separator_8);
		
		mntmNewMenuItem_11 = new JMenuItem("New menu item");
		mnNewMenu4.add(mntmNewMenuItem_11);
        
        mntmNewMenuItem = new JMenuItem("New menu item");
        mnNewMenu1.add(mntmNewMenuItem);
        
        separator = new JSeparator();
        mnNewMenu1.add(separator);
        
        mntmNewMenuItem_1 = new JMenuItem("New menu item");
        mnNewMenu1.add(mntmNewMenuItem_1);
        
        separator_1 = new JSeparator();
        mnNewMenu1.add(separator_1);
        
        mntmNewMenuItem_2 = new JMenuItem("New menu item");
        mnNewMenu1.add(mntmNewMenuItem_2);
        
        separator_2 = new JSeparator();
        mnNewMenu1.add(separator_2);
        JMenuItem exitItem = new JMenuItem("Exit");
        mnNewMenu1.add(exitItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
