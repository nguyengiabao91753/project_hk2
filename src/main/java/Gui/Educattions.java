package Gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Educattions extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private static Educattions instance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Educattions frame = new Educattions();
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
    public static Educattions getInstance() {
        if (instance == null) {
            instance = new Educattions();
        }
        return instance;
    }
	public Educattions() {
		setTitle("Educattions");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 450, 300);

	}

}
