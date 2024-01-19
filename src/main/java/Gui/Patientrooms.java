package Gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Patientrooms extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private static Patientrooms instance ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patientrooms frame = new Patientrooms();
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
    public static Patientrooms getInstance() {
        if (instance == null) {
            instance = new Patientrooms();
        }
        return instance;
    }
	public Patientrooms() {
		setTitle("Patientrooms");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);

	}

}
