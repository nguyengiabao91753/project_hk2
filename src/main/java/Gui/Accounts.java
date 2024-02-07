	package Gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.mindrot.jbcrypt.BCrypt;

import App.App_Admin;
import dao.AccountDAO;
import entity.Account;
import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultRowSorter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;

public class Accounts extends JInternalFrame {

	private JComponent northPane = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	Dimension dimensionNorthPane = null ;
	private static final long serialVersionUID = 1L;
	private static Accounts instance ;
	private JLabel lblAccountId;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField txtAccountId;
	private JTextField txtUsername;
	private JScrollPane scrollPane;
	private JTable table;
	private App_Admin app;
	
	Integer pageNumber = 1 ;
	Integer rowOfPage = 10 ;
	Integer totalCount = 0 ;
	Double totalPage = 0.0;
	private JButton btnUpdate;
	private JButton btnBlock;
	private JTextField txtSearch;
	AccountDAO accountDao = new AccountDAO();
	private JPasswordField txtPassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accounts frame = new Accounts();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setApp(App_Admin app) {
		this.app = app;
	}
	
	public void hideTitleBar() {
	    northPane = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	    dimensionNorthPane = northPane.getPreferredSize();
	    northPane.setSize(0, 0);
	    northPane.setPreferredSize(new Dimension(0, 0));
	    repaint();

	}

	/**
	 * Create the frame.
	 */
//    public static Acounts getInstance() {
//        if (instance == null) {
//            instance = new Acounts();
//        }
//        return instance;
//    }
	public Accounts() {
		getContentPane().setBackground(Color.WHITE);
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		hideTitleBar();
		setTitle("Acounts");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(223,37,957,627);
		getContentPane().setLayout(null);
		
		lblAccountId = new JLabel("Account ID :");
		lblAccountId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAccountId.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountId.setBounds(36, 131, 174, 14);
		getContentPane().add(lblAccountId);
		
		lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(36, 241, 174, 14);
		getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(36, 363, 174, 14);
		getContentPane().add(lblPassword);
		
		txtAccountId = new JTextField();
		txtAccountId.setBounds(36, 156, 174, 20);
		getContentPane().add(txtAccountId);
		txtAccountId.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(36, 266, 174, 20);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(240, 240, 240));
		scrollPane.setBounds(241, 55, 716, 419);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBorder(null);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setBackground(Color.GREEN);
		btnUpdate.setBounds(80, 473, 89, 23);
		getContentPane().add(btnUpdate);
		
		btnBlock = new JButton("BLOCK");
		btnBlock.setBorder(null);
		btnBlock.setBackground(Color.RED);
		btnBlock.setBounds(80, 507, 89, 23);
		getContentPane().add(btnBlock);
		
		txtSearch = new JTextField();
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSearchActionPerformed(e);
			}
		});
		txtSearch.setColumns(10);
		txtSearch.setBorder(new TitledBorder(null, "Search :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		txtSearch.setBounds(241, 8, 140, 36);
		getContentPane().add(txtSearch);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(36, 388, 174, 20);
		getContentPane().add(txtPassword);
		loadAccount();
	}
	
	
	
	public void loadAccount() {
		var model = new DefaultTableModel() {
			@Override
			public Class<?> getColumnClass(int column){
				switch(column) {
					case 0: return Integer.class;
					case 1: return String.class;
					case 2: return String.class;
					default: return String.class;
				}
			}
		};
		
		model.addColumn("ID");
		model.addColumn("Username");
		model.addColumn("Password");
		
		AccountDAO dao = new AccountDAO();
		
		totalCount = dao.counAccount();
		totalPage = Math.ceil(totalCount.doubleValue() / rowOfPage.doubleValue());
		
		dao.selectAccount(pageNumber , rowOfPage )
			.stream()
			.forEach(acc -> model.addRow(new Object[] {
					acc.getId(),
					acc.getUsername(),
					acc.getPassword()				
				}
			)
		);
		
		table.setModel(model);
		table.getColumnModel().getColumn(2).setCellRenderer(new PasswordRenderer());
	}
	
	class PasswordRenderer extends DefaultTableCellRenderer {
	    private static final char BULLET = '\u2022';

	    @Override
	    protected void setValue(Object value) {
	        if (value instanceof String) {
	            setText(maskPassword((String) value));
	        } else {
	            super.setValue(value);
	        }
	    }

	    private String maskPassword(String password) {
	        return "••••••••"; 
	    }
	}
	
	private void refresh() {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);
		AccountDAO dao = new AccountDAO();
		dao.selectAccount(pageNumber , rowOfPage )
			.stream()
			.forEach(acc -> model.addRow(new Object[] {
					acc.getId(),
					acc.getUsername(),
					acc.getPassword()
				}
			)
		);
		
		table.setModel(model);
		
		}
	
	protected void tableMouseClicked(MouseEvent e) {
		int rowIndex = table.getSelectedRow();
		if (rowIndex >= 0 && rowIndex < table.getRowCount()) {
		       txtAccountId.setText(table.getValueAt(rowIndex, 0).toString()); 
		       txtUsername.setText(table.getValueAt(rowIndex, 1).toString());
		       txtPassword.setText(table.getValueAt(rowIndex, 2).toString());
		   } else {
		    JOptionPane.showMessageDialog(this, "Please select a row from the table.");
		   }
}
	
	protected void txtSearchActionPerformed(ActionEvent e) {
		String find = txtSearch.getText();
		DefaultRowSorter<?, ?> sorter = (DefaultRowSorter<?, ?>)table.getRowSorter();
		sorter.setRowFilter(RowFilter.regexFilter(find));
		sorter.setSortKeys(null);
	}
	
	protected void btnUpdateActionPerformed(ActionEvent e) {
		Account acc = new Account();
		acc.setId(Integer.parseInt(txtAccountId.getText()));
		acc.setUsername(txtUsername.getText());
		char[] passwordChars = txtPassword.getPassword();
		String plainPassword = new String(passwordChars);
		String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
	    acc.setPassword(hashedPassword);
		accountDao.update(acc);
		refresh();
	}
}
