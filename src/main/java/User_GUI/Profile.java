package User_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Profile extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
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
	public Profile() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

	}

}
