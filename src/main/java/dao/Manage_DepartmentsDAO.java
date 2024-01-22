package dao;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Manage_DepartmentsDAO extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_DepartmentsDAO frame = new Manage_DepartmentsDAO();
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
	public Manage_DepartmentsDAO() {
		setBounds(100, 100, 450, 300);

	}

}
