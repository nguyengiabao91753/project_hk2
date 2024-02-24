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
import javax.swing.DefaultRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import App.App_Admin;
import crud.AddDepartment;
import crud.AddPosition;
import dao.EmployeeDAO;
import dao.PositionDAO;
import entity.Department;
import entity.Employee;
import entity.Position;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Job_Position extends JInternalFrame {
	private JComponent Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension DimensionBarca =null;

	private static final long serialVersionUID = 1L;
	private JTextField txtID;
	private JTextField txtName;
	private JLabel lblID;
	private JLabel lblName;
	private JButton btnInsert;
	private JButton btnUpdate;
	
	private DefaultTableModel model ;
	private JTable tbemp;
	private JScrollPane scrollPane;
	private JButton btnDelete;
	private JLabel lblTextsearch;
	private JTextField textSearch;
	PositionDAO PosDAO = new PositionDAO();
	private App_Admin app;
	
	Integer pageNumber =1;
	Integer rowsOfPage =10;
	Double totalPage =0.0;
	Integer totalCount =0;
	private JLabel lblfirst;
	private JLabel lblprevious;
	private JTextField textPage;
	private JLabel lblnext;
	private JLabel lbllast;

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
					Job_Position frame = new Job_Position();
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
		if(pageNumber == 1) {
			lblfirst.setVisible(false);
			lblprevious.setVisible(false);
		}else {
			lblfirst.setVisible(true);
			lblprevious.setVisible(true);
		}
		if(pageNumber == totalPage.intValue()) {
			lblnext.setVisible(false);
			lbllast.setVisible(false);
		}else {
			lblnext.setVisible(true);
			lbllast.setVisible(true);
		}
	}
	public void Quit() {
		Barca = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
		DimensionBarca =Barca.getPreferredSize();
		Barca.setSize(0,0);
		Barca.setPreferredSize(new Dimension(0,0));
		repaint();
	}
	public Job_Position() {
		Quit();
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		getContentPane().setBackground(Color.WHITE);
		setBounds(223, 37, 957, 626);
		getContentPane().setLayout(null);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(69, 80, 180, 30);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(69, 140, 180, 30);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		lblID = new JLabel("ID :");
		lblID.setBackground(SystemColor.controlHighlight);
		lblID.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblID.setBounds(15, 80, 50, 30);
		getContentPane().add(lblID);
		
		lblName = new JLabel("NAME :");
		lblName.setBackground(SystemColor.controlHighlight);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblName.setBounds(15, 140, 50, 30);
		getContentPane().add(lblName);
		
		btnInsert = new JButton("ADD");
		btnInsert.setForeground(new Color(255, 255, 255));
		btnInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnInsertMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnInsertMouseExited(e);
			}
		});
		btnInsert.setBackground(SystemColor.textHighlight);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInsertActionPerformed(e);
			}
		});
		btnInsert.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnInsert.setBounds(266, 433, 100, 30);
		getContentPane().add(btnInsert);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(new Color(255, 255, 255));
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
		btnUpdate.setBackground(new Color(0, 255, 0));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnUpdate.setBounds(149, 277, 100, 30);
		getContentPane().add(btnUpdate);
		
		scrollPane = new JScrollPane();
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
		tbemp.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbemp);
		tbemp.setBorder(new LineBorder(SystemColor.controlHighlight, 2));	
		btnDelete = new JButton("DELETE");
		btnDelete.setForeground(new Color(255, 255, 255));
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
		btnDelete.setBackground(Color.RED);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btnDelete.setBounds(149, 344, 100, 30);
		getContentPane().add(btnDelete);
		
		lblTextsearch = new JLabel(" Search :");
		lblTextsearch.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTextsearch.setBounds(266, 12, 67, 25);
		getContentPane().add(lblTextsearch);
		
		textSearch = new JTextField();
		textSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldActionPerformed(e);
			}
		});
		textSearch.setColumns(10);
		textSearch.setBounds(326, 11, 62, 25);
		getContentPane().add(textSearch);
		loadPosition();
		tbemp.setRowHeight(35);
		
		lblfirst = new JLabel("");
		lblfirst.setIcon(new ImageIcon("images\\icons8-last-24 (1).png"));
		lblfirst.setBackground(SystemColor.menu);
		lblfirst.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblfirstMouseClicked(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblfirstMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblfirstMouseExited(e);
			}
		});
		lblfirst.setOpaque(true);
		lblfirst.setBounds(783, 433, 24, 24);
		getContentPane().add(lblfirst);
		
		lblprevious = new JLabel("");
		lblprevious.setIcon(new ImageIcon("images\\icons8-next-24 (2).png"));
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
		lblprevious.setOpaque(true);
		lblprevious.setBackground(SystemColor.menu);
		lblprevious.setBounds(812, 433, 24, 24);
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
		lblnext.setIcon(new ImageIcon("images\\icons8-next-24 (1).png"));
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
		lblnext.setOpaque(true);
		lblnext.setBackground(SystemColor.menu);
		
		lblnext.setBounds(884, 433, 24, 24);
		getContentPane().add(lblnext);
		
		lbllast = new JLabel("");
		lbllast.setIcon(new ImageIcon("images\\icons8-last-24.png"));
		lbllast.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbllastMouseClicked(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbllastMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbllastMouseExited(e);
			}
		});
		lbllast.setOpaque(true);
		lbllast.setBounds(913, 433, 24, 24);
		getContentPane().add(lbllast);
		
		hidenextlast();
	}
	
	//load
	public void loadPosition() {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
	         public boolean isCellEditable(int row, int column) {
	             
	             return false;
	         }
		};
		model.addColumn("Position_Id");
		model.addColumn("Position_Name");
		//tìm trong bảng tổng số dòng
		 totalCount = PosDAO.countPosition();
		//tìm số trang của bảng 
		totalPage = Math.ceil(totalCount.doubleValue() / rowsOfPage.doubleValue());
		PosDAO.getPosition(pageNumber, rowsOfPage).stream().forEach(Pos -> model.addRow(new Object[] {
				Pos.getPosition_id(),
				Pos.getPosition_name(),
		}));
		
		tbemp.setModel(model);
	}
	protected void tbempMouseClicked(MouseEvent e) {
	    int rowIndex = tbemp.getSelectedRow();
	    txtID.setText(tbemp.getValueAt(rowIndex, 0).toString());
	    txtName.setText(tbemp.getValueAt(rowIndex, 1).toString());
	}
	public void refresh() {
		DefaultTableModel model = (DefaultTableModel)tbemp.getModel();
		model.setRowCount(0); 
		PosDAO.getPosition(pageNumber, rowsOfPage).stream().forEach(Pos -> model.addRow(new Object[] {
				Pos.getPosition_id(),
				Pos.getPosition_name(),
		}));
		hidenextlast();
	}
	protected void btnInsertActionPerformed(ActionEvent e) {
		AddPosition add =  AddPosition.getInstance();
		if(!add.isVisible()) {
			add.setVisible(true);
			app.desktopPane.add(add);
			add.toFront();
//			this.hide();
		}else {
			add.toFront();
		}
	}
	public int validatePosition() {
		int count = 0 ;
		if( txtName.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill in your name");
			count++;
		}
		return count;
	}
	protected void btnUpdateActionPerformed(ActionEvent e) {
	    if (tbemp.getSelectedRow() == -1) {
	        JOptionPane.showMessageDialog(null, "Please select a row to update.", "Warning", JOptionPane.WARNING_MESSAGE);
	        return; // Không có dòng nào được chọn, thoát khỏi phương thức
	    }
		if(validatePosition()!=0) {
			return;
		}else {
		var Pos = new Position();
		Pos.setPosition_id(Integer.parseInt(txtID.getText()));
		Pos.setPosition_name(txtName.getText());
		PosDAO.update(Pos);
		loadPosition();
		refresh();
		}
	}
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
			EmployeeDAO Posdao = new EmployeeDAO();
			for (Employee Pos : Posdao.selectAllEmployee()) {
				if(Pos.getDepartment_id() == a) {
					JOptionPane.showMessageDialog(null, "This position is still having employees! So cannot delete .");
					return;
				}
			}

	        // Xóa dòng được chọn
	        PosDAO.delete(a);

	        // Refresh sau khi xóa
	        refresh();
	    }
	}
	protected void btnInsertMouseEntered(MouseEvent e) {
		btnInsert.setBackground(new Color(106,90,205));
		btnInsert.setForeground(Color.white);
	}
	protected void btnInsertMouseExited(MouseEvent e) {
		btnInsert.setBackground(SystemColor.textHighlight);
		btnInsert.setForeground(Color.white);
	}
	protected void btnUpdateMouseEntered(MouseEvent e) {
		btnUpdate.setBackground(new Color(106,90,205));
		btnUpdate.setForeground(Color.white);
	}
	protected void btnUpdateMouseExited(MouseEvent e) {
		btnUpdate.setBackground(new Color(0, 255, 0));
		btnUpdate.setForeground(Color.white);
	}
	protected void btnDeleteMouseEntered(MouseEvent e) {
		btnDelete.setBackground(new Color(106,90,205));
		btnDelete.setForeground(Color.white);
	}
	protected void btnDeleteMouseExited(MouseEvent e) {
		btnDelete.setBackground(Color.red);
		btnDelete.setForeground(Color.white);
	}
	protected void textFieldActionPerformed(ActionEvent e) {
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
	protected void lblfirstMouseClicked(MouseEvent e) {
		pageNumber = 1;
		textPage.setText(pageNumber.toString());
		refresh();
	}
	protected void lblpreviousMouseClicked(MouseEvent e) {
		if(pageNumber >0) {
			pageNumber--;
			textPage.setText(pageNumber.toString());
			refresh();
		}
	}
	protected void textPageActionPerformed(ActionEvent e) {
		int num = Integer.parseInt(textPage.getText()) ;
		if(num>0 && num<totalPage.intValue()) {
			pageNumber = num;
			refresh();
		}else {
			JOptionPane.showMessageDialog(null, "Page Number is invalid");
		}
	}
	protected void lblnextMouseClicked(MouseEvent e) {
		if(pageNumber < totalPage.intValue()) {
			pageNumber++;
			textPage.setText(pageNumber.toString());
			refresh();
		}
	}
	protected void lbllastMouseClicked(MouseEvent e) {
		pageNumber = totalPage.intValue();
		textPage.setText(pageNumber.toString());
		refresh();
	}
	protected void lblnextMouseEntered(MouseEvent e) {
		lblnext.setBackground(new Color(106,90,205));
		lblnext.setForeground(Color.black);
	}
	protected void lblnextMouseExited(MouseEvent e) {
		lblnext.setBackground(SystemColor.menu);
		lblnext.setForeground(Color.black);
	}
	protected void lblfirstMouseEntered(MouseEvent e) {
		lblfirst.setBackground(new Color(106,90,205));
		lblfirst.setForeground(Color.black);
	}
	protected void lblfirstMouseExited(MouseEvent e) {
		lblfirst.setBackground(SystemColor.menu);
		lblfirst.setForeground(Color.black);
	}
	protected void lblpreviousMouseEntered(MouseEvent e) {
		lblprevious.setBackground(new Color(106,90,205));
		lblprevious.setForeground(Color.black);
	}
	protected void lblpreviousMouseExited(MouseEvent e) {
		lblprevious.setBackground(SystemColor.menu);
		lblprevious.setForeground(Color.black);
	}
	protected void lbllastMouseEntered(MouseEvent e) {
		lbllast.setBackground(new Color(106,90,205));
		lbllast.setForeground(Color.black);
	}
	protected void lbllastMouseExited(MouseEvent e) {
		lbllast.setBackground(SystemColor.menu);
		lbllast.setForeground(Color.black);
	}
}
