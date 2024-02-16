package User_GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import App.App_User;

import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Locations extends JInternalFrame {
	
	private JComponent Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarca =null;
	private static final long serialVersionUID = 1L;
	private JPanel panel;
    private JPanel panelContent;

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
	public void quit() {
		Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
		DimensionBarca =Barca.getPreferredSize();
		Barca.setSize(0,0);
		Barca.setPreferredSize(new Dimension(0,0));
		repaint();
	}
	public Locations() {
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		quit();
		
		setBounds(100, 100, 1180, 664);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 1180, 101);
		getContentPane().add(panel);
		panel.setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("Locations");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(81, 11, 161, 50);
		panel.add(lblNewLabel_1);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(81, 57, 140, 4);
		panel.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("B.Y.D's Management System");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(81, 61, 161, 18);
		panel.add(lblNewLabel_2);
		
		JLabel lblBack = new JLabel("New label");
		lblBack.setBackground(SystemColor.activeCaption);
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_5MouseClicked(e);
			}
		});
		lblBack.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\icons8-back-32 (1).png"));
		lblBack.setBounds(10, 21, 40, 40);
		panel.add(lblBack);
		JPanel panelContent = new JPanel();
		panelContent.setForeground(Color.BLACK);
		panelContent.setBackground(Color.WHITE);
		panelContent.setBounds(0, 101, 1180, 536);
		getContentPane().add(panelContent);
		panelContent.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\icons8-done-16.png"));
		lblNewLabel.setBounds(25, 22, 30, 50);
		panelContent.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Hospital B.Y.D");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(70, 22, 200, 25);
		panelContent.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("    35/6 Street D5, Ward 25, Binh Thanh, Ho Chi Minh City .");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_4.setBounds(70, 53, 1100, 25);
		panelContent.add(lblNewLabel_4);
		
	}
	protected void lblNewLabel_5MouseClicked(MouseEvent e) {
		App_User appus = new App_User();
		appus.setLocationRelativeTo(null);
		appus.setUndecorated(true);
		appus.setVisible(true);
	    this.setVisible(false);
	}
}
