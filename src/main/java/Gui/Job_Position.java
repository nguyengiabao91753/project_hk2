package Gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Job_Position extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	  private static Job_Position instance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Job_Position frame = new Job_Position();
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
    public static Job_Position getInstance() {
        if (instance == null) {
            instance = new Job_Position();
        }
        return instance;
    }
	public Job_Position() {
		setClosable(true);
		setTitle("Job Position");
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 450, 300);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 270, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);

	}

}
