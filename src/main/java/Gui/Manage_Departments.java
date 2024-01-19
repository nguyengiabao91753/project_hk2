package Gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;

public class Manage_Departments extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	  private static Manage_Departments instance;
	  private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Departments frame = new Manage_Departments();
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
    public static Manage_Departments getInstance() {
        if (instance == null) {
            instance = new Manage_Departments();
        }
        return instance;
    }
	public Manage_Departments() {
		getContentPane().setBackground(new Color(128, 128, 255));
		setTitle("Manager_Departments");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		btnNewButton = new JButton("New button");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(83)
					.addComponent(btnNewButton)
					.addContainerGap(262, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(85)
					.addComponent(btnNewButton)
					.addContainerGap(162, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
