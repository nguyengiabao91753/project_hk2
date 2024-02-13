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
import dao.EmployeeDAO;
import entity.Account;
import entity.Employee;

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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;

public class Accounts extends JInternalFrame {

	private JComponent northPane = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	Dimension dimensionNorthPane = null ;
	private static final long serialVersionUID = 1L;
	private static Accounts instance ;
	private JLabel lblAccountId;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private static JTextField txtAccountId;
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
	private JLabel lblStatus;
	private JComboBox cbxStatus;
	/**
	 * Launch the application.
	 */
	
	public int getAccountId() {
		String accountIdText = txtAccountId.getText().trim();

	    if (accountIdText.isEmpty()) {
	        return -1; 
	    }

	    try {
	        return Integer.parseInt(accountIdText);
	    } catch (NumberFormatException e) {

	        e.printStackTrace(); 
	        return -1; 
	    }
    }
	
    
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
		lblAccountId.setBounds(28, 55, 174, 14);
		getContentPane().add(lblAccountId);
		
		lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(28, 165, 174, 14);
		getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(28, 287, 174, 14);
		getContentPane().add(lblPassword);
		
		txtAccountId = new JTextField();
		txtAccountId.setEditable(false);
		txtAccountId.setBounds(28, 80, 174, 20);
		getContentPane().add(txtAccountId);
		txtAccountId.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(28, 190, 174, 20);
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
		btnBlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBlockActionPerformed(e);
			}
		});
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
		txtPassword.setBounds(28, 312, 174, 20);
		getContentPane().add(txtPassword);
		
		lblStatus = new JLabel("Status :");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus.setBounds(28, 407, 174, 14);
		getContentPane().add(lblStatus);
		
		cbxStatus = new JComboBox();
		cbxStatus.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		cbxStatus.setModel(new DefaultComboBoxModel(new String[] {"Block", "Active"}));
		cbxStatus.setBounds(28, 426, 174, 22);
		getContentPane().add(cbxStatus);
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
					case 3: return Integer.class;
					default: return String.class;
				}
			}
		};
		
		model.addColumn("ID");
		model.addColumn("Username");
		model.addColumn("Password");
		model.addColumn("Status");
		
		AccountDAO dao = new AccountDAO();
		
		totalCount = dao.counAccount();
		totalPage = Math.ceil(totalCount.doubleValue() / rowOfPage.doubleValue());
		
		dao.selectAccount(pageNumber , rowOfPage )
			.stream()
			.forEach(acc -> model.addRow(new Object[] {
					acc.getId(),
					acc.getUsername(),
					acc.getPassword(),
					acc.getStatus()
				}
			)
		);
		
		table.setModel(model);
		table.getColumnModel().getColumn(2).setCellRenderer(new PasswordRenderer());
		for (int i = 0; i < model.getColumnCount(); i++) {
		    if (i != 2) {
		        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		        table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		    }
		}
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
					acc.getPassword(),
					acc.getStatus(),
				}
			)
		);
		
		table.setModel(model);
		
		}
	
	protected void tableMouseClicked(MouseEvent e) {
		int rowIndex = table.getSelectedRow();
		txtAccountId.setText(table.getValueAt(rowIndex, 0).toString()); 
		txtUsername.setText(table.getValueAt(rowIndex, 1).toString());
		txtPassword.setText(table.getValueAt(rowIndex, 2).toString());
		var status = Integer.parseInt(table.getValueAt(rowIndex, 3).toString());
		cbxStatus.setSelectedItem(status == 0 ? "Block" : "Active");
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
	    String selectedStatus = cbxStatus.getSelectedItem().toString();
	    if (selectedStatus.equals("Active")) {
	        acc.setStatus(1);
	        txtUsername.setEnabled(true);
			txtPassword.setEnabled(true);
	    } else if (selectedStatus.equals("Block")) {
	        acc.setStatus(0);
			txtUsername.setEnabled(false);
			txtPassword.setEnabled(false);
	    }
		accountDao.update(acc);
		refresh();
	}
	
	protected void btnBlockActionPerformed(ActionEvent e) {
		Account acc  = new Account();
		acc.setId(Integer.parseInt(txtAccountId.getText()));
		AccountDAO dao = new AccountDAO();
		dao.block(acc);
		txtUsername.setEnabled(false);
		txtPassword.setEnabled(false);
		refresh();   
	}
	
	
}
