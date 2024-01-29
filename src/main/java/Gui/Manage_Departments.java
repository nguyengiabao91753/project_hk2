package Gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultRowSorter;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entity.Deparment;
import dao.Manage_DepartmentsDAO;
import dao.RoomDAO;
import dao.ShiftDAO;
import entity.Deparment;
import entity.Room;
import entity.Shift;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import javax.swing.SwingConstants;

public class Manage_Departments extends JInternalFrame {
	private JComponent Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarca =null;

	private static final long serialVersionUID = 1L;
	private JTextField txtID;
	private JTextField txtName;
	private JLabel lblID;
	private JLabel lblName;
	private JLabel lblDeparment;
	private JLabel lblRoom;
	private JButton btnInsert;
	private JButton btnUpdate;
	
	private DefaultTableModel modelo ;
	private JTable tbemp;
	private JScrollPane scrollPane;
	Manage_DepartmentsDAO DepDAO = new Manage_DepartmentsDAO();
	Integer pageNumber =1;
	Integer rowOfPage =10;
	Double totalPage =0.0;
	Integer totalCount =0;
	private JLabel lblTextsearch;
	private JTextField textSearch;
	private JButton btnDelete;
	private JTextField txtDeparment;
	private JTextField txtRoom;
	private JButton btnPrevious;
	private JButton btnNext;
	private JTextField txtPage;
	private JTextField textField;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Departments frame = new Manage_Departments();
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
	public void Quit() {
		Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
		DimensionBarca =Barca.getPreferredSize();
		Barca.setSize(0,0);
		Barca.setPreferredSize(new Dimension(0,0));
		repaint();
	}
	public Manage_Departments() {
		Quit();
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(223, 37, 957, 626);
		getContentPane().setLayout(null);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtID.setBounds(108, 48, 150, 30);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtName.setBounds(108, 103, 150, 30);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		lblID = new JLabel("ID :");
		lblID.setBackground(SystemColor.controlHighlight);
		lblID.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblID.setBounds(10, 48, 100, 30);
		getContentPane().add(lblID);
		
		lblName = new JLabel("NAME :");
		lblName.setBackground(SystemColor.controlHighlight);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblName.setBounds(10, 103, 100, 30);
		getContentPane().add(lblName);
		
		lblDeparment = new JLabel("DEPARTMENT :");
		lblDeparment.setBackground(SystemColor.controlHighlight);
		lblDeparment.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblDeparment.setBounds(10, 154, 100, 30);
		getContentPane().add(lblDeparment);
		
		lblRoom = new JLabel("ROOM :");
		lblRoom.setBackground(SystemColor.controlHighlight);
		lblRoom.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblRoom.setBounds(10, 205, 100, 30);
		getContentPane().add(lblRoom);
		
		btnInsert = new JButton("INSERT");
		btnInsert.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInsertActionPerformed(e);
			}
		});
		btnInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGetIntoMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGetIntoMouseExited(e);
			}
		});
		btnInsert.setBackground(new Color(255, 255, 255));
		btnInsert.setBounds(134, 264, 122, 35);
		getContentPane().add(btnInsert);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(new Color(102, 51, 255));
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnUpdateMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnUpdateMouseExited(e);
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setBounds(135, 319, 122, 35);
		getContentPane().add(btnUpdate);
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144)));
		scrollPane.setBounds(266, 42, 681, 380);
		getContentPane().add(scrollPane);
		
		tbemp = new JTable();
		tbemp.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tbemp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tbempMouseClicked(e);
			}
		});
		tbemp.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(tbemp);
		tbemp.setBorder(new LineBorder(SystemColor.controlHighlight, 2));	
		
		modelo = new DefaultTableModel();
		modelo.addColumn("DEPARTMENT_ID");
		modelo.addColumn("DEPARTMENT_NAME");
		modelo.addColumn("HEAD_OF_DEPARTMENT");
		modelo.addColumn("ROOM");
		
		lblTextsearch = new JLabel(" Search :");
		lblTextsearch.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTextsearch.setBounds(266, 10, 67, 25);
		getContentPane().add(lblTextsearch);
		
		textSearch = new JTextField();
		textSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textSearchActionPerformed(e);
			}
		});
		textSearch.setColumns(10);
		textSearch.setBounds(326, 9, 62, 25);
		getContentPane().add(textSearch);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setBackground(new Color(102, 51, 255));
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDeleteMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDeleteMouseExited(e);
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}
		});
		btnDelete.setBounds(136, 371, 122, 35);
		getContentPane().add(btnDelete);
		
		txtDeparment = new JTextField();
		txtDeparment.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtDeparment.setColumns(10);
		txtDeparment.setBounds(108, 154, 150, 30);
		getContentPane().add(txtDeparment);
		
		txtRoom = new JTextField();
		txtRoom.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtRoom.setColumns(10);
		txtRoom.setBounds(108, 205, 150, 30);
		getContentPane().add(txtRoom);
		
		btnPrevious = new JButton("Previous");
		btnPrevious.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviousActionPerformed(e);
			}
		});
		btnPrevious.setBounds(450, 426, 89, 25);
		getContentPane().add(btnPrevious);
		
		btnNext = new JButton("Next");
		btnNext.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});
		btnNext.setBounds(650, 426, 89, 25);
		getContentPane().add(btnNext);
		
		txtPage = new JTextField();
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setText("1");
		txtPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPageActionPerformed(e);
			}
		});
		txtPage.setBounds(550, 427, 86, 25);
		getContentPane().add(txtPage);
		txtPage.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(861, 426, 86, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("Total :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(820, 426, 40, 25);
		getContentPane().add(lblNewLabel);
		
		loaDeparment();
	}
	
	//load
	public void loaDeparment() {
		DepDAO.selectDepartments().stream().forEach(Dep -> modelo.addRow(new Object[] {
			Dep.getDepartment_id(),
			Dep.getDepartment_name(),
			Dep.getHead_of_department(),
			Dep.getRoom()
		}));
		
		tbemp.setModel(modelo);
	}

	protected void btnGetIntoMouseEntered(MouseEvent e) {
		btnInsert.setBackground(new Color(106,90,205));
		btnInsert.setForeground(Color.black);
	}
	protected void btnGetIntoMouseExited(MouseEvent e) {
		btnInsert.setBackground(Color.green);
		btnInsert.setForeground(Color.black);
	}
	
	public void refresh() {
		DefaultTableModel model = (DefaultTableModel)tbemp.getModel();
		model.setRowCount(0); 
		DepDAO.selectAllDeparment(pageNumber, rowOfPage).stream().forEach(Dep -> model.addRow(new Object[] {
				Dep.getDepartment_id(),
				Dep.getDepartment_name(),
				Dep.getHead_of_department(),
				Dep.getRoom(),
		}));
	}
	
	public void loadDepartment() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("department_id");
		model.addColumn("department_name");
		model.addColumn("head_of_department");
		model.addColumn("room");	
		//tìm trong bảng Dep tổng số dòng :
		 totalCount = DepDAO.countDepartments();
		//tìm số trang của bảng 
		totalPage = Math.ceil(totalCount.doubleValue() / rowOfPage.doubleValue());
		
		DepDAO.selectAllDeparment(pageNumber, rowOfPage).stream().forEach(Dep -> model.addRow(new Object[] {
				Dep.getDepartment_id(),
				Dep.getDepartment_name(),
				Dep.getHead_of_department(),
				Dep.getRoom(),
		}));
		tbemp.setModel(model);
	}
	
	protected void btnInsertActionPerformed(ActionEvent e) {
		//insert
		var Dep = new Deparment();
		Dep.setDepartment_name(txtName.getText());
		Dep.setHead_of_department(txtDeparment.getText());
		Dep.setRoom(txtRoom.getText());
		var dao = new Manage_DepartmentsDAO();
		dao.insert(Dep);
		// load lai du lieu
		loadDepartment();
		refresh();
	}
	protected void btnUpdateActionPerformed(ActionEvent e) {
		
		var Dep = new Deparment();
		Dep.setDepartment_id(Integer.parseInt(txtID.getText()));
		Dep.setDepartment_name(txtName.getText());
		Dep.setHead_of_department(txtDeparment.getText());
		Dep.setRoom(txtRoom.getText());
		// load lai du lieu
		loadDepartment();
		refresh();
	}


	protected void btnUpdateMouseEntered(MouseEvent e) {
		btnUpdate.setBackground(new Color(106,90,205));
		btnUpdate.setForeground(Color.black);
	}
	protected void btnUpdateMouseExited(MouseEvent e) {
		btnUpdate.setBackground(Color.yellow);
		btnUpdate.setForeground(Color.black);
	}
	protected void btnDeleteActionPerformed(ActionEvent e) {
		var Dep = new Deparment();
		Dep.setDepartment_id(Integer.parseInt(txtID.getText()));//do ko phai la string nen lai parse ve
		var dao = new Manage_DepartmentsDAO();
		dao.delete(Dep);
		refresh();
	}
	protected void btnDeleteMouseEntered(MouseEvent e) {
		btnDelete.setBackground(new Color(106,90,205));
		btnDelete.setForeground(Color.black);
	}
	protected void btnDeleteMouseExited(MouseEvent e) {
		btnDelete.setBackground(Color.red);
		btnDelete.setForeground(Color.black);
	}
	protected void textSearchActionPerformed(ActionEvent e) {
		String find = textSearch.getText();
		DefaultRowSorter<?,?> sorter = (DefaultRowSorter<?,?>)tbemp.getRowSorter();
		sorter.setRowFilter(RowFilter.regexFilter(find));
		sorter.setSortKeys(null);
	}
	
	protected void tbempMouseClicked(MouseEvent e) {
	    int rowIndex = tbemp.getSelectedRow();
	    txtID.setText(tbemp.getValueAt(rowIndex, 0).toString());
	    txtName.setText(tbemp.getValueAt(rowIndex, 1).toString());
	    txtDeparment.setText(tbemp.getValueAt(rowIndex, 2).toString());
	    txtRoom.setText(tbemp.getValueAt(rowIndex, 3).toString());
	    }
	protected void btnPreviousActionPerformed(ActionEvent e) {
		if(pageNumber>1) {
			pageNumber--;
			txtPage.setText(pageNumber.toString());
			refresh();
		}
	}
	protected void txtPageActionPerformed(ActionEvent e) {
		int num = Integer.parseInt(txtPage.getText()) ;
		if(num>0 && num<totalPage.intValue()) {
			pageNumber = num;
			refresh();
		}else {
			JOptionPane.showMessageDialog(null, "Page Number is invalid");
		}
	}
	protected void btnNextActionPerformed(ActionEvent e) {
		if(pageNumber<totalPage.intValue()) {
			pageNumber++;
			txtPage.setText(pageNumber.toString());
			// load lại dữ liệu
			refresh();
		}
	}
}
