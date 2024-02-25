package Gui;
import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import App.App_Admin;
import crud.AddDepartment;
import crud.Addschedule;
import entity.Department;
import entity.Employee;
import dao.EmployeeDAO;
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
import javax.swing.ImageIcon;

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
	
	Integer pagenumber = 1;
	Integer rowOfPage = 10;
	Double totalPage = 0.0;
	Integer totalCount = 0;
	
	private JLabel lblTextsearch;
	private JTextField textSearch;
	private JButton btnDelete;
	private JTextField txtDeparment;
	private JTextField txtRoom;
	private App_Admin app;
	private RowFilter<?, ?> someRowFilter;
	private JLabel lblfirst;
	private JLabel lblfirst_1;
	private JLabel lblprevious;
	private JTextField textPage;
	private JLabel lblnext;
	private JLabel lbllast_1;
    private static Manage_Departments instance;


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
	
	public void hidenextlast() {
		if(pagenumber == 1) {
			lblfirst_1.setVisible(false);
			lblprevious.setVisible(false);
		}else {
			lblfirst_1.setVisible(true);
			lblprevious.setVisible(true);
		}
		if(pagenumber == totalPage.intValue()) {
			lblnext.setVisible(false);
			lbllast_1.setVisible(false);
		}else {
			lblnext.setVisible(true);
			lbllast_1.setVisible(true);
		}
	}
	
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
		getContentPane().setBackground(Color.WHITE);
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
		lblID.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblID.setBounds(25, 50, 80, 30);
		getContentPane().add(lblID);
		
		lblName = new JLabel("NAME :");
		lblName.setBackground(SystemColor.controlHighlight);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblName.setBounds(25, 95, 80, 30);
		getContentPane().add(lblName);
		
		lblDeparment = new JLabel("DEPARTMENT :");
		lblDeparment.setBackground(SystemColor.controlHighlight);
		lblDeparment.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblDeparment.setBounds(25, 140, 80, 30);
		getContentPane().add(lblDeparment);
		
		lblRoom = new JLabel("ROOM :");
		lblRoom.setBackground(SystemColor.controlHighlight);
		lblRoom.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblRoom.setBounds(25, 185, 80, 30);
		getContentPane().add(lblRoom);
		
		btnInsert = new JButton("ADD");
		btnInsert.setForeground(new Color(255, 255, 255));
		btnInsert.setFont(new Font("Times New Roman", Font.BOLD, 11));
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
		btnInsert.setBounds(266, 433, 100, 30);
		getContentPane().add(btnInsert);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(0, 255, 128));
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 11));
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
		btnUpdate.setBounds(158, 295, 100, 30);
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
		lblTextsearch.setFont(new Font("Times New Roman", Font.BOLD, 13));
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
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(Color.RED);
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 11));
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
		btnDelete.setBounds(158, 355, 100, 30);
		getContentPane().add(btnDelete);
		
		txtDeparment = new JTextField();
		txtDeparment.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtDeparment.setColumns(10);
		txtDeparment.setBounds(108, 140, 150, 30);
		getContentPane().add(txtDeparment);
		
		loadDepartment();
		tbemp.setRowHeight(35);
		
		txtRoom = new JTextField();
		txtRoom.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtRoom.setColumns(10);
		txtRoom.setBounds(108, 185, 150, 30);
		getContentPane().add(txtRoom);
		
		lblfirst = new JLabel("");
		lblfirst.setVisible(false);
		lblfirst.setOpaque(true);
		lblfirst.setBounds(765, 470, 24, 24);
		getContentPane().add(lblfirst);
		
		lblfirst_1 = new JLabel("");
		lblfirst_1.setBackground(SystemColor.menu);
		lblfirst_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblfirst_1MouseClicked(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblfirst_1MouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblfirst_1MouseExited(e);
			}
		});
		lblfirst_1.setIcon(new ImageIcon("images\\icons8-last-24 (1).png"));
		lblfirst_1.setOpaque(true);
		lblfirst_1.setBounds(773, 433, 24, 24);
		getContentPane().add(lblfirst_1);
		
		lblprevious = new JLabel("");
		lblprevious.setBackground(SystemColor.menu);
		lblprevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblpreviousMouseClicked(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblpreviousMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblpreviousMouseExited(e);
			}
		});
		lblprevious.setIcon(new ImageIcon("images\\icons8-next-24 (2).png"));
		lblprevious.setOpaque(true);
		lblprevious.setBounds(806, 433, 24, 24);
		getContentPane().add(lblprevious);
		
		textPage = new JTextField();
		textPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPageActionPerformed(e);
			}
		});
		textPage.setText("1");
		textPage.setHorizontalAlignment(SwingConstants.CENTER);
		textPage.setColumns(10);
		textPage.setBounds(840, 433, 40, 24);
		getContentPane().add(textPage);
		
		lblnext = new JLabel("");
		lblnext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblnextMouseClicked(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblnextMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblnextMouseExited(e);
			}
		});
		lblnext.setIcon(new ImageIcon("images\\icons8-next-24 (1).png"));
		lblnext.setOpaque(true);
		lblnext.setBackground(SystemColor.menu);
		lblnext.setBounds(884, 433, 24, 24);
		getContentPane().add(lblnext);
		
		lbllast_1 = new JLabel("");
		lbllast_1.setBackground(SystemColor.menu);
		lbllast_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbllast_1MouseClicked(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbllast_1MouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbllast_1MouseExited(e);
			}
		});
		lbllast_1.setIcon(new ImageIcon("images\\icons8-last-24.png"));
		lbllast_1.setOpaque(true);
		lbllast_1.setBounds(917, 433, 24, 24);
		getContentPane().add(lbllast_1);
		
		hidenextlast();
	}
	
	//load
	public String nameRoom(String a) {
		List<Room> listRoom = RoomDAO.selectAllRoom();
		for (Room room : listRoom) {
			if(a == room.getName()) {
				return room.getName();
			}
		}
		return null;
	}
	public void loadDepartment() {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
	         public boolean isCellEditable(int row, int column) {
	             
	             return false;
	         }
		};
		
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
			Dep.getRoom(),
		}));
		
		tbemp.setModel(model);
	}

	protected void btnGetIntoMouseEntered(MouseEvent e) {
		btnInsert.setBackground(new Color(106,90,205));
		btnInsert.setForeground(Color.white);
	}
	protected void btnGetIntoMouseExited(MouseEvent e) {
		btnInsert.setBackground(SystemColor.textHighlight);
		btnInsert.setForeground(Color.white);
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
		hidenextlast();
	}
	public int validateDepartment() {
		int count = 0 ;
		String room_name;
		Manage_DepartmentsDAO DepDAO = new Manage_DepartmentsDAO();
		List<Department> listDep = DepDAO.selectAllDepartment();
		RoomDAO RoomDAO = new RoomDAO();
		List<Room> listRoom = RoomDAO.selectAllRoom();
		if( txtName.getText() == null || txtDeparment.getText() == null ||  txtRoom.getText() == null) {
			JOptionPane.showMessageDialog(null, "Please fill in all information");
			count++;
		}else if(txtName.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill in your name");
			count++;
		}else if(txtDeparment.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill in your Department");
			count++;
		}else if(txtRoom.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill in your Room");
			count++;
		}
		return count;

	}
	protected void btnInsertActionPerformed(ActionEvent e) {

		AddDepartment add =  AddDepartment.getInstance();
		if(!add.isVisible()) {
			add.setVisible(true);
			app.desktopPane.add(add);
			add.setMande(this);
			add.toFront();
//			this.hide();
		}else {
			add.toFront();
		}
	}
	
	protected void btnUpdateActionPerformed(ActionEvent e) {
	    if (tbemp.getSelectedRow() == -1) {
	        JOptionPane.showMessageDialog(null, "Please select a row to update.", "Warning", JOptionPane.WARNING_MESSAGE);
	        return; // Không có dòng nào được chọn, thoát khỏi phương thức
	    }
		if(validateDepartment()!=0) {
			return;
		}else {
			
		Department DepNew = new Department();
		DepNew.setDepartment_id(Integer.parseInt(txtID.getText()));
		DepNew.setDepartment_name(txtName.getText());
		DepNew.setHead_of_department(txtDeparment.getText());
		DepNew.setRoom(txtRoom.getText());
		DepDAO.update(DepNew);
		loadDepartment();
		refresh();
	}
	}


	protected void btnUpdateMouseEntered(MouseEvent e) {
		btnUpdate.setBackground(new Color(106,90,205));
		btnUpdate.setForeground(Color.white);
	}
	protected void btnUpdateMouseExited(MouseEvent e) {
		btnUpdate.setBackground(new Color(0, 255, 128));
		btnUpdate.setForeground(Color.white);
	};
	protected void btnDeleteActionPerformed(ActionEvent e) {
	    // Kiểm tra xem có dòng nào được chọn không
	    if (tbemp.getSelectedRow() == -1) {
	        JOptionPane.showMessageDialog(null, "Please select a row to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
	        return; // Không có dòng nào được chọn, thoát khỏi phương thức
	    }

	    int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure want to delete?", "Delete", JOptionPane.YES_NO_OPTION);

	    if (dialogResult == JOptionPane.YES_OPTION) {
	        // Lấy ID từ dòng được chọn
			int a = Integer.parseInt(txtID.getText());
			EmployeeDAO emdao = new EmployeeDAO();
			for (Employee emp : emdao.selectAllEmployee()) {
				if(emp.getDepartment_id() == a) {
					JOptionPane.showMessageDialog(null, "This department is still having employees! So cannot delete");
					return;
				}
			}
			

	        // Xóa dòng được chọn
	        DepDAO.delete(a);

	        // Refresh sau khi xóa
	        refresh();
	    }
	}

	// Phương thức để lấy ID từ dòng được chọn

	protected void btnDeleteMouseEntered(MouseEvent e) {
		btnDelete.setBackground(new Color(106,90,205));
		btnDelete.setForeground(Color.white);
	}
	protected void btnDeleteMouseExited(MouseEvent e) {
		btnDelete.setBackground(Color.red);
		btnDelete.setForeground(Color.white);
	}
	protected void textSearchActionPerformed(ActionEvent e) {
	    String find = textSearch.getText();

	    // Kiểm tra xem tbemp đã có RowSorter hay chưa
	    if (tbemp.getRowSorter() == null) {
	        // Nếu chưa có, tạo một DefaultRowSorter và thiết lập cho tbemp
	        DefaultRowSorter<?, ?> sorter = new TableRowSorter<>(tbemp.getModel());
	        tbemp.setRowSorter((RowSorter<? extends TableModel>) sorter);
	    }

	    // Lấy RowSorter từ tbemp và sử dụng setRowFilter
	    DefaultRowSorter<?, ?> sorter = (DefaultRowSorter<?, ?>) tbemp.getRowSorter();
	    sorter.setRowFilter(RowFilter.regexFilter(find));
	    sorter.setSortKeys(null);
	}

	protected void tbempMouseClicked(MouseEvent e) {
		
	    int rowIndex = tbemp.getSelectedRow();
	    txtID.setText(tbemp.getValueAt(rowIndex, 0).toString());
	    txtName.setText(tbemp.getValueAt(rowIndex, 1).toString());
	    txtDeparment.setText(tbemp.getValueAt(rowIndex, 2).toString());
//		var roommodel = new DefaultComboBoxModel();
		
//		List<Room> listRoom = RoomDAO.selectAllRoom();
//		comboBox.setModel(roommodel);
//		for (Room room : listRoom) {
//			var room_select = tbemp.getValueAt(rowIndex, 3).toString();
//			if(room_select.equals(room.getName())) {
//				comboBox.setSelectedIndex(room.getId()-1);
//			}
//		}
		
	    txtRoom.setText(tbemp.getValueAt(rowIndex, 3).toString());
	    }
	protected void lblfirst_1MouseClicked(MouseEvent e) {
		pagenumber = 1;
		textPage.setText(pagenumber.toString());
		refresh();
	}
	protected void lblpreviousMouseClicked(MouseEvent e) {
		if(pagenumber >0) {
			pagenumber--;
			textPage.setText(pagenumber.toString());
			refresh();
		}
	}
	protected void lblnextMouseClicked(MouseEvent e) {
		if(pagenumber < totalPage.intValue()) {
			pagenumber++;
			textPage.setText(pagenumber.toString());
			refresh();
		}
	}
	protected void lblnextMouseEntered(MouseEvent e) {
		lblnext.setBackground(new Color(106,90,205));
		lblnext.setForeground(Color.black);
	}
	protected void lbllast_1MouseClicked(MouseEvent e) {
		pagenumber = totalPage.intValue();
		textPage.setText(pagenumber.toString());
		refresh();
	}
	
	protected void textPageActionPerformed(ActionEvent e) {
		int num = Integer.parseInt(textPage.getText()) ;
		if(num>0 && num<totalPage.intValue()) {
			pagenumber = num;
			refresh();
		}else {
			JOptionPane.showMessageDialog(null, "Page Number is invalid");
		}
	}
	protected void lblpreviousMouseEntered(MouseEvent e) {
		lblprevious.setBackground(new Color(106,90,205));
		lblprevious.setForeground(Color.black);
		
	}
	protected void lblfirst_1MouseEntered(MouseEvent e) {
		lblfirst_1.setBackground(new Color(106,90,205));
		lblfirst_1.setForeground(Color.black);
	}
	protected void lbllast_1MouseEntered(MouseEvent e) {
		lbllast_1.setBackground(new Color(106,90,205));
		lbllast_1.setForeground(Color.black);
	}
	protected void lblfirst_1MouseExited(MouseEvent e) {
		lblfirst_1.setBackground(SystemColor.menu);
		lblfirst_1.setForeground(Color.black);
	}
	protected void lblpreviousMouseExited(MouseEvent e) {
		lblprevious.setBackground(SystemColor.menu);
		lblprevious.setForeground(Color.black);
	}
	protected void lblnextMouseExited(MouseEvent e) {
		lblnext.setBackground(SystemColor.menu);
		lblnext.setForeground(Color.black);
	}
	protected void lbllast_1MouseExited(MouseEvent e) {
		lbllast_1.setBackground(SystemColor.menu);
		lbllast_1.setForeground(Color.black);
	}
}
