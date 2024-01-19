package Gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Atiendances extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private static Atiendances instance ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Atiendances frame = new Atiendances();
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
    public static Atiendances getInstance() {
        if (instance == null) {
            instance = new Atiendances();
        }
        return instance;
    }
	public Atiendances() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Atiendances");
		setBounds(100, 100, 450, 300);

	}

}
