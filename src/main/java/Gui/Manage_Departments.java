package Gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultRowSorter;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.Manage_DepartmentsDAO;
import dao.RoomDAO;
import dao.ShiftDAO;
import entity.DEPARTMENTS;
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
import java.util.List;

public class Manage_Departments extends JInternalFrame {
	private JComponent Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarca =null;

	private static final long serialVersionUID = 1L;
	private JTextField txtID;
	private JTextField txtName;
	private JComboBox cboDeparment;
	private JLabel lblID;
	private JLabel lblName;
	private JLabel lblDeparment;
	private JLabel lblRoom;
	private JComboBox cboRoom;
	private JButton btnAccept;
	private JButton btnInsert;
	private JButton btnUpdate;
	
	private DefaultTableModel modelo ;
	private JTable tbemp;
	private JScrollPane scrollPane;
	Manage_DepartmentsDAO DepDAO = new Manage_DepartmentsDAO();
	private JLabel lblTextsearch;
	private JTextField textSearch;
	private JButton btnDelete;

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
		txtID.setBounds(134, 42, 122, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(134, 80, 122, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		cboDeparment = new JComboBox();
		cboDeparment.setBounds(134, 114, 122, 22);
		getContentPane().add(cboDeparment);
		
		lblID = new JLabel("ID :");
		lblID.setBackground(SystemColor.controlHighlight);
		lblID.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblID.setBounds(29, 48, 95, 14);
		getContentPane().add(lblID);
		
		lblName = new JLabel("NAME :");
		lblName.setBackground(SystemColor.controlHighlight);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblName.setBounds(29, 86, 95, 14);
		getContentPane().add(lblName);
		
		lblDeparment = new JLabel("DEPARTMENT :");
		lblDeparment.setBackground(SystemColor.controlHighlight);
		lblDeparment.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblDeparment.setBounds(29, 122, 95, 14);
		getContentPane().add(lblDeparment);
		
		lblRoom = new JLabel("ROOM :");
		lblRoom.setBackground(SystemColor.controlHighlight);
		lblRoom.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblRoom.setBounds(29, 153, 95, 14);
		getContentPane().add(lblRoom);
		
		cboRoom = new JComboBox();
		cboRoom.setBounds(134, 147, 122, 22);
		getContentPane().add(cboRoom);
		
		btnAccept = new JButton("New button");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAcceptActionPerformed(e);
			}
		});
		btnAccept.setBackground(Color.GREEN);
		btnAccept.setBounds(222, 226, 34, 23);
		getContentPane().add(btnAccept);
		
		btnInsert = new JButton("INSERT");
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
		btnInsert.setBackground(new Color(102, 0, 255));
		btnInsert.setBounds(134, 264, 122, 35);
		getContentPane().add(btnInsert);
		
		btnUpdate = new JButton("UPDATE");
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
		scrollPane.setBounds(266, 42, 681, 380);
		getContentPane().add(scrollPane);
		
		tbemp = new JTable();
		tbemp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tbempMouseClicked(e);
			}
		});
		tbemp.setBackground(new Color(255, 255, 255));
		tbemp.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbemp);
		tbemp.setBorder(new LineBorder(SystemColor.controlHighlight, 2));	
		
		modelo = new DefaultTableModel();
		modelo.addColumn("DEPARTMENT_ID");
		modelo.addColumn("DEPARTMENT_NAME");
		modelo.addColumn("HEAD_OF_DEPARTMENT");
		modelo.addColumn("ROOM");
		tbemp.setModel(modelo);
		
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
		
		loaDeparment();
	}
	protected void btnAcceptActionPerformed(ActionEvent e) {
		
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
	protected void btnInsertActionPerformed(ActionEvent e) {
	}
	protected void btnUpdateActionPerformed(ActionEvent e) {
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

	    List<DEPARTMENTS> listDeparment = DepDAO.selectDepartments();

	    var deparmentmodel = new DefaultComboBoxModel();
	    var roommodel = new DefaultComboBoxModel();

	    deparmentmodel.addAll(listDeparment);
	    roommodel.addAll(listDeparment);

	    cboDeparment.setModel(deparmentmodel);
	    cboRoom.setModel(roommodel);

	 // Lấy dữ liệu từ cột 3 (head_of_department)
	    var dep_select = tbemp.getValueAt(rowIndex, 2).toString();
	    for (DEPARTMENTS dep : listDeparment) {
	        if (dep_select.equals(dep.getHead_of_department())) {
	            cboDeparment.setSelectedIndex(dep.getDepartment_id() -1);
	            break; // Dừng sau khi tìm thấy giá trị
	        }
	    }

	    // Lấy dữ liệu từ cột 4 (room)
	    var room_selected = tbemp.getValueAt(rowIndex, 3).toString();
	    for (DEPARTMENTS room : listDeparment) {
	        if (room_selected.equals(room.getRoom())) {
	            cboRoom.setSelectedIndex(room.getDepartment_id() -1);
	            break; // Dừng sau khi tìm thấy giá trị
	        }
	    }
	}
}
