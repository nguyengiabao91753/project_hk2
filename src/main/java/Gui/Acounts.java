package Gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Acounts extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private static Acounts instance ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acounts frame = new Acounts();
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
    public static Acounts getInstance() {
        if (instance == null) {
            instance = new Acounts();
        }
        return instance;
    }
	public Acounts() {
		setTitle("Acounts");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);

	}

}
