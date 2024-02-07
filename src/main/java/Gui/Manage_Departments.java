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

import App.App_Admin;
import crud.AddDepartment;
import crud.Addschedule;
import entity.Department;
import dao.Manage_DepartmentsDAO;
import dao.RoomDAO;
import dao.ShiftDAO;
import dao.WorkscheduleDAO;
import entity.Department;
import entity.Room;
import entity.Shift;
import entity.Workschedule;

import java.awt.Color;
import java.awt.Container;
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
	private JTable tbemp;
	private JScrollPane scrollPane;
	Manage_DepartmentsDAO DepDAO = new Manage_DepartmentsDAO();
	RoomDAO RoomDAO = new RoomDAO();
	
	Integer pagenumber =1;
	Integer rowOfPage =10;
	Double totalPage =0.0;
	Integer totalCount =0;
	
	private JLabel lblTextsearch;
	private JTextField textSearch;
	private JButton btnDelete;
	private JTextField txtDeparment;
	private JButton btnPrevious;
	private JButton btnNext;
	private JTextField txtPage;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnReset;
	private JTextField txtRoom;
	private App_Admin app;


	/**
	 * Launch the application.
	 */
	public void setApp(App_Admin app) {
		this.app = app;
	}
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
		getContentPane().setBackground(SystemColor.control);
		setBounds(223, 37, 957, 626);
		getContentPane().setLayout(null);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtID.setBounds(108, 50, 150, 30);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtName.setBounds(108, 95, 150, 30);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		lblID = new JLabel("ID :");
		lblID.setBackground(SystemColor.controlHighlight);
		lblID.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblID.setBounds(10, 50, 100, 30);
		getContentPane().add(lblID);
		
		lblName = new JLabel("NAME :");
		lblName.setBackground(SystemColor.controlHighlight);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblName.setBounds(20, 95, 80, 30);
		getContentPane().add(lblName);
		
		lblDeparment = new JLabel("DEPARTMENT :");
		lblDeparment.setBackground(SystemColor.controlHighlight);
		lblDeparment.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblDeparment.setBounds(10, 140, 95, 30);
		getContentPane().add(lblDeparment);
		
		lblRoom = new JLabel("ROOM :");
		lblRoom.setBackground(SystemColor.controlHighlight);
		lblRoom.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblRoom.setBounds(10, 185, 100, 30);
		getContentPane().add(lblRoom);
		
		btnInsert = new JButton("ADD");
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
		btnInsert.setBackground(SystemColor.textHighlight);
		btnInsert.setBounds(136, 295, 122, 35);
		getContentPane().add(btnInsert);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(Color.YELLOW);
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
		btnUpdate.setBounds(134, 341, 122, 35);
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
		btnDelete.setBackground(Color.RED);
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
		btnDelete.setBounds(136, 387, 122, 35);
		getContentPane().add(btnDelete);
		
		txtDeparment = new JTextField();
		txtDeparment.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtDeparment.setColumns(10);
		txtDeparment.setBounds(108, 140, 150, 30);
		getContentPane().add(txtDeparment);
		
		btnPrevious = new JButton("Previous");
		btnPrevious.setBackground(SystemColor.inactiveCaption);
		btnPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPreviousMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPreviousMouseExited(e);
			}
		});
		btnPrevious.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviousActionPerformed(e);
			}
		});
		btnPrevious.setBounds(450, 426, 89, 25);
		getContentPane().add(btnPrevious);
		
		btnNext = new JButton("Next");
		btnNext.setBackground(SystemColor.inactiveCaption);
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNextMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNextMouseExited(e);
			}
		});
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
		
		loadDepartment();
		tbemp.setRowHeight(32);
		
		btnReset = new JButton("RESET");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnResetMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnResetMouseExited(e);
			}
		});
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnResetActionPerformed(e);
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnReset.setBackground(SystemColor.inactiveCaption);
		btnReset.setBounds(136, 249, 122, 35);
		getContentPane().add(btnReset);
		
		txtRoom = new JTextField();
		txtRoom.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtRoom.setColumns(10);
		txtRoom.setBounds(108, 185, 150, 30);
		getContentPane().add(txtRoom);

	}
	
	//load
	public void loadDepartment() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Department_Id");
		model.addColumn("Department_Name");
		model.addColumn("Dead_Of_Department");
		model.addColumn("Room");
		//tìm trong bảng tổng số dòng
		 totalCount = DepDAO.countDepartments();
		//tìm số trang của bảng 
		totalPage = Math.ceil(totalCount.doubleValue() / rowOfPage.doubleValue());
		DepDAO.getDepartments(pagenumber, rowOfPage).stream().forEach(Dep -> model.addRow(new Object[] {
			Dep.getDepartment_id(),
			Dep.getDepartment_name(),
			Dep.getHead_of_department(),
			Dep.getRoom()
		}));
		
		tbemp.setModel(model);
	}

	protected void btnGetIntoMouseEntered(MouseEvent e) {
		btnInsert.setBackground(new Color(106,90,205));
		btnInsert.setForeground(Color.black);
	}
	protected void btnGetIntoMouseExited(MouseEvent e) {
		btnInsert.setBackground(SystemColor.textHighlight);
		btnInsert.setForeground(Color.black);
	}	
	public void refresh() {
		DefaultTableModel model = (DefaultTableModel)tbemp.getModel();
		model.setRowCount(0); 
		DepDAO.getDepartments(pagenumber, rowOfPage).stream().forEach(Dep -> model.addRow(new Object[] {
				Dep.getDepartment_id(),
				Dep.getDepartment_name(),
				Dep.getHead_of_department(),
				Dep.getRoom(),
		}));
	}
	public int validateDepartment() {
		int count = 0 ;
		Manage_DepartmentsDAO DepDAO = new Manage_DepartmentsDAO();
		List<Department> listDep = DepDAO.selectAllDepartment();
		if( txtName.getText() == null || txtDeparment.getText() == null ||  txtName.getText() == null) {
			JOptionPane.showMessageDialog(null, "Please fill in all information");
			count++;
		}
		
		return count;
	}
	protected void btnInsertActionPerformed(ActionEvent e) {

		AddDepartment add =  AddDepartment.getInstance();
		if(!add.isVisible()) {
			add.setVisible(true);
			
			app.desktopPane.add(add);
			add.toFront();
			this.hide();
			//app.pack();
		}
//		if(validateDepartment() !=0) {
//			return;
//		}else {
//		var Dep = new Department();
//		Dep.setDepartment_name(txtName.getText()+1);
//		Dep.setHead_of_department(txtDeparment.getText()+1);
//		Dep.setRoom(txtRoom.getText()+1);
//		DepDAO.insert(Dep);
//		// load lai du lieu
//		loadDepartment();
//		refresh();
//		}
	}
	
	protected void btnUpdateActionPerformed(ActionEvent e) {
		
		Department DepNew = new Department();
		DepNew.setDepartment_id(Integer.parseInt(txtID.getText()));
		DepNew.setDepartment_name(txtName.getText());
		DepNew.setHead_of_department(txtDeparment.getText());
		DepNew.setRoom(txtRoom.getText());
		DepDAO.update(DepNew);
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
		JOptionPane.showConfirmDialog(null,"Are you sure want to delete?","Delete",JOptionPane.YES_NO_OPTION);
		int a = Integer.parseInt(txtID.getText());
		DepDAO.delete(a);
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
		var roommodel = new DefaultComboBoxModel();
		List<Room> listRoom = RoomDAO.selectAllRoom();
//		comboBox.setModel(roommodel);
//		for (Room room : listRoom) {
//			var room_select = tbemp.getValueAt(rowIndex, 3).toString();
//			if(room_select.equals(room.getName())) {
//				comboBox.setSelectedIndex(room.getId()-1);
//			}
//		}
		
	    txtRoom.setText(tbemp.getValueAt(rowIndex, 3).toString());
	    }
	protected void btnPreviousActionPerformed(ActionEvent e) {
		if(pagenumber>1) {
			pagenumber--;
			txtPage.setText(pagenumber.toString());
			refresh();
		}
	}
	protected void txtPageActionPerformed(ActionEvent e) {
		int num = Integer.parseInt(txtPage.getText()) ;
		if(num>0 && num<totalPage.intValue()) {
			pagenumber = num;
			refresh();
		}else {
			JOptionPane.showMessageDialog(null, "Page Number is invalid");
		}
	}
	protected void btnNextActionPerformed(ActionEvent e) {
		if(pagenumber<totalPage.intValue()) {
			pagenumber++;
			txtPage.setText(pagenumber.toString());
			// load lại dữ liệu
			refresh();
		}
	}
	protected void btnResetActionPerformed(ActionEvent e) {
	    int rowIndex = tbemp.getSelectedRow();
	    if (rowIndex != -1) { // Kiểm tra xem đã chọn hàng nào hay chưa
		    txtID.setText(tbemp.getValueAt(rowIndex, 0).toString());
	        txtName.setText("");
	        txtDeparment.setText("");
	        txtRoom.setText("");
	    }

	}
	protected void btnResetMouseEntered(MouseEvent e) {
		btnReset.setBackground(new Color(106,90,205));
		btnReset.setForeground(Color.black);
	}
	protected void btnResetMouseExited(MouseEvent e) {
		btnReset.setBackground(SystemColor.inactiveCaption);
		btnReset.setForeground(Color.black);
	}
	protected void btnPreviousMouseEntered(MouseEvent e) {
		btnPrevious.setBackground(new Color(106,90,205));
		btnPrevious.setForeground(Color.black);
	}
	protected void btnNextMouseEntered(MouseEvent e) {
		btnNext.setBackground(new Color(106,90,205));
		btnNext.setForeground(Color.black);
	}
	protected void btnPreviousMouseExited(MouseEvent e) {
		btnPrevious.setBackground(SystemColor.inactiveCaption);
		btnPrevious.setForeground(Color.black);
	}
	protected void btnNextMouseExited(MouseEvent e) {
		btnNext.setBackground(SystemColor.inactiveCaption);
		btnNext.setForeground(Color.black);
	}
}
