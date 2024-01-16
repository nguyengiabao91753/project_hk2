package App;

import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import App.MainJframe ;
import Gui.Page1;
import Gui.Page2;
import Gui.Page3;
import Gui.Page4;
import Gui.Page5;
import Gui.Page6;

import javax.swing.JSeparator;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainJframe extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JMenuBar menuBar;
	private JMenu mnMenu1 ;
	private JMenuItem mntmPage1;
	private JMenuItem mntmCloseJf1;
	private JSeparator separator;
	private JMenuItem mntmPage2;
	private JSeparator separator_1;
	private JMenuItem mntmPage3;
	private JSeparator separator_2;
	private JMenuItem mntmPage4;
    

    public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	MainJframe frame = new MainJframe();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainJframe() {
    	setTitle("B.Y.D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Tạo thanh menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Thêm mục "File" vào thanh menu
        JMenu mnMenu1 = new JMenu("Menu 1");
        menuBar.add(mnMenu1);
        
        JMenuItem mntmPage1 = new JMenuItem("Page 1");
        mntmPage1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mntmPage1ActionPerformed(e);
        	}
        });
        mnMenu1.add(mntmPage1);
        
        JSeparator separator_2 = new JSeparator();
        mnMenu1.add(separator_2);
        
        JMenuItem mntmPage2 = new JMenuItem("Page 2");
        mntmPage2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mntmPage2ActionPerformed(e);
        	}
        });
        mnMenu1.add(mntmPage2);
        
        JSeparator separator_3 = new JSeparator();
        mnMenu1.add(separator_3);
        
        JMenuItem mntmPage3 = new JMenuItem("Page 3");
        mntmPage3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mntmPage3ActionPerformed(e);
        	}
        });
        mnMenu1.add(mntmPage3);
        
        JSeparator separator_4 = new JSeparator();
        mnMenu1.add(separator_4);
        
        JMenuItem mntmPage4 = new JMenuItem("Page 4");
        mntmPage4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mntmPage4ActionPerformed(e);
        	}
        });
        mnMenu1.add(mntmPage4);
        
        JSeparator separator_5 = new JSeparator();
        mnMenu1.add(separator_5);

        JMenuItem exitItem = new JMenuItem("Exit");
        mnMenu1.add(exitItem);
        
        JMenu mnMenu2 = new JMenu("Menu 2");
        mnMenu2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mnMenu2ActionPerformed(e);
        	}
        });
        menuBar.add(mnMenu2);
        
        JMenuItem mntmPage5 = new JMenuItem("Page 5");
        mntmPage5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mntmPage5ActionPerformed(e);
        	}
        });
        mnMenu2.add(mntmPage5);
        
        JMenu mnMenu3 = new JMenu("Menu 3");
        mnMenu3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mnMenu3ActionPerformed(e);
        	}
        });
        menuBar.add(mnMenu3);
        
        JMenuItem mntmPage6 = new JMenuItem("Page 6");
        mntmPage6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mntmPage6ActionPerformed(e);
        	}
        });
        mnMenu3.add(mntmPage6);

        // Xử lý sự kiện khi nhấn nút Exit
        exitItem.addActionListener(e -> {
            // Thực hiện các thao tác khi nhấn Exit
            System.out.println("Exit selected");
            System.exit(0); // Thoát ứng dụng
        });
    }

	protected void mntmPage1ActionPerformed(ActionEvent e) {
		Page1 page1 = new Page1().getInstance();
		if(!page1.isVisible()) {
			page1.setVisible(true);
			contentPane.add(page1);
		}
	}
	protected void mntmPage2ActionPerformed(ActionEvent e) {
		Page2 page2 = new Page2().getInstance();
		if(!page2.isVisible()) {
			page2.setVisible(true);
			contentPane.add(page2);
		}
	}
	protected void mntmPage3ActionPerformed(ActionEvent e) {
		Page3 page3 = new Page3().getInstance();
		if(!page3.isVisible()) {
			page3.setVisible(true);
			contentPane.add(page3);
		}
	}
	protected void mntmPage4ActionPerformed(ActionEvent e) {
		Page4 page4 = new Page4().getInstance();
		if(!page4.isVisible()) {
			page4.setVisible(true);
			contentPane.add(page4);
		}
	}
	protected void mnMenu2ActionPerformed(ActionEvent e) {

	}
	protected void mnMenu3ActionPerformed(ActionEvent e) {

	}
	protected void mntmPage5ActionPerformed(ActionEvent e) {
		Page5 page5 = new Page5().getInstance();
		if(!page5.isVisible()) {
			page5.setVisible(true);
			contentPane.add(page5);
		}
	}
	protected void mntmPage6ActionPerformed(ActionEvent e) {
		Page6 page6 = new Page6().getInstance();
		if(!page6.isVisible()) {
			page6.setVisible(true);
			contentPane.add(page6);
		}
	}
}
