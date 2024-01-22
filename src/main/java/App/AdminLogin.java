package App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class AdminLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private Button button;
	private JTextField textField;
	private JSeparator separator;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JSeparator separator_1;
	private JPasswordField passwordField;
	private JLabel lblImage;
	private JLabel lblLogo;
	private JLabel lblClose;
	private int xx, xy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setUndecorated(true);
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
	public AdminLogin() {
		setBackground(Color.WHITE);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 636);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				contentPaneMouseDragged(e);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				contentPaneMousePressed(e);
			}
		});
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 606, 642);
		panel.setBackground(new Color(255, 255, 255));
		
		button = new Button("Log in ");
		button.setBounds(796, 523, 167, 39);
		button.setForeground(SystemColor.text);
		button.setBackground(SystemColor.textHighlight);
		
		textField = new JTextField();
		textField.setBounds(713, 309, 329, 52);
		textField.setColumns(10);
		
		separator = new JSeparator();
		separator.setBounds(713, 359, 329, 2);
		
		lblNewLabel = new JLabel("USERNAME ");
		lblNewLabel.setBounds(713, 268, 75, 30);
		
		lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setBounds(713, 392, 75, 30);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(713, 483, 329, 2);
		contentPane.setLayout(null);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblImage = new JLabel("");
		lblImage.setBounds(-11, 0, 676, 640);
		lblImage.setVerticalAlignment(SwingConstants.TOP);
		lblImage.setIcon(new ImageIcon("images\\medical-5459631_640.png"));
		panel.add(lblImage);
		contentPane.add(button);
		contentPane.add(textField);
		contentPane.add(separator);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(separator_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(713, 433, 329, 52);
		contentPane.add(passwordField);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("images\\z5093637837436_a45c947127ed08faeb08de9ccf099707.jpg"));
		lblLogo.setBounds(713, 60, 329, 170);
		contentPane.add(lblLogo);
		
		BufferedImage originalImage = loadImage("images\\byd2.png");
	    BufferedImage scaledImage = scaleImage(originalImage, 329, 260); 
	    setScaledImage(scaledImage, lblLogo);
		
		lblClose = new JLabel("X");
		lblClose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCloseMouseClicked(e);
			}
		});
		lblClose.setForeground(new Color(0, 128, 128));
		lblClose.setBounds(1159, 0, 46, 30);
		contentPane.add(lblClose);
	}
	protected void lblCloseMouseClicked(MouseEvent e) {
		System.exit(0);
	}

	protected void contentPaneMousePressed(MouseEvent e) {
		xx = e.getX();
        xy = e.getY();
	}
	
	protected void contentPaneMouseDragged(MouseEvent e) {
		int x = e.getXOnScreen();
        int y = e.getYOnScreen();
        AdminLogin.this.setLocation(x - xx, y - xy);
	}
	
	private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private BufferedImage scaleImage(BufferedImage originalImage, int width, int height) {
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(scaledImage, 0, 0, null);
        g2d.dispose();
        return bufferedImage;
    }

    private void setScaledImage(BufferedImage scaledImage, JLabel label) {
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        label.setIcon(scaledIcon);
    }
}
