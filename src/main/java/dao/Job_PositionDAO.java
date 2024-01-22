package dao;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Job_PositionDAO extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Job_PositionDAO frame = new Job_PositionDAO();
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
	public Job_PositionDAO() {
		setBounds(100, 100, 450, 300);

	}

}
