package App;

import java.awt.EventQueue;
<<<<<<< HEAD
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
=======
import java.awt.Image;
>>>>>>> 5c2440c2941751e4b0dbf3de7bc494e59b85bd24

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
<<<<<<< HEAD
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
=======
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
>>>>>>> 5c2440c2941751e4b0dbf3de7bc494e59b85bd24

public class App_Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelLateral;
	private JPanel panelTop;
	private JDesktopPane desktopPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

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
		panelLateral.setLayout(null);
		
		panelTop = new JPanel();
		panelTop.setBackground(new Color(102, 0, 255));
		panelTop.setBounds(223, 0, 957, 37);
		contentPane.add(panelTop);
		panelTop.setLayout(null);
<<<<<<< HEAD
=======
		
		lblNewLabel = new JLabel("<html>\r\n\t<p style=\"font-size:24\">&#9776;</p>\r\r\n</html>");
		lblNewLabel.setBounds(13, 8, 46, 22);
		panelTop.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("<html>\r\n\t<p style=\"font-size: 22px\">&#10006;</p>\r\n</html>");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(901, 11, 46, 20);
		panelTop.add(lblNewLabel_1);
>>>>>>> 5c2440c2941751e4b0dbf3de7bc494e59b85bd24
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(223, 37, 957, 626);
		contentPane.add(desktopPane);
	}
}
