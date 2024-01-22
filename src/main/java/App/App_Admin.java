package App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JDesktopPane;

public class App_Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelLateral;
	private JPanel panelTop;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App_Admin frame = new App_Admin();
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
	public App_Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1180, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelLateral = new JPanel();
		panelLateral.setBackground(Color.WHITE);
		panelLateral.setBounds(0,0,219,663);
		contentPane.add(panelLateral);
		
		panelTop = new JPanel();
		panelTop.setBackground(new Color(102, 0, 255));
		panelTop.setBounds(223, 0, 957, 37);
		contentPane.add(panelTop);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(223, 37, 957, 626);
		contentPane.add(desktopPane);
	}
}
