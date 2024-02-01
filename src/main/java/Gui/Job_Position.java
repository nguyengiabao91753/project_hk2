package Gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import dao.PositionDAO;
import entity.Department;
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
	private JButton btnReset;
	private JLabel lblTextsearch;
	private JTextField textField;
	private JButton btnPrevious;
	private JTextField txtPage;
	private JButton btnNext;
	private JLabel lblNewLabel;
	private JTextField textField_2;
	PositionDAO PosDAO = new PositionDAO();
	
	Integer pagenumber =1;
	Integer rowOfPage =10;
	Double totalPage =0.0;
	Integer totalCount =0;

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
	public Job_Position() {
		Quit();
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		getContentPane().setBackground(new Color(255, 255, 255));
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
		lblID.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblID.setBounds(15, 80, 50, 30);
		getContentPane().add(lblID);
		
		lblName = new JLabel("NAME :");
		lblName.setBackground(SystemColor.controlHighlight);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName.setBounds(15, 140, 50, 30);
		getContentPane().add(lblName);
		
		btnInsert = new JButton("ISNERT");
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
		btnInsert.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnInsert.setBounds(127, 270, 122, 35);
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
		btnUpdate.setBackground(Color.YELLOW);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnUpdate.setBounds(127, 320, 122, 35);
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
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnDelete.setBounds(127, 370, 122, 35);
		getContentPane().add(btnDelete);
		
		btnReset = new JButton("RESET");
		btnReset.setBackground(SystemColor.inactiveCaption);
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnResetMouseClicked(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnResetMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnResetMouseExited(e);
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnReset.setBounds(127, 220, 122, 35);
		getContentPane().add(btnReset);
		
		lblTextsearch = new JLabel(" Search :");
		lblTextsearch.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTextsearch.setBounds(266, 12, 67, 25);
		getContentPane().add(lblTextsearch);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(326, 11, 62, 25);
		getContentPane().add(textField);
		
		btnPrevious = new JButton("Previous");
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
		btnPrevious.setBackground(SystemColor.inactiveCaption);
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviousActionPerformed(e);
			}
		});
		btnPrevious.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnPrevious.setBounds(450, 433, 89, 25);
		getContentPane().add(btnPrevious);
		
		txtPage = new JTextField();
		txtPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPageActionPerformed(e);
			}
		});
		txtPage.setText("1");
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setColumns(10);
		txtPage.setBounds(550, 434, 86, 25);
		getContentPane().add(txtPage);
		
		btnNext = new JButton("Next");
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
		btnNext.setBackground(SystemColor.inactiveCaption);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});
		btnNext.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNext.setBounds(650, 433, 89, 25);
		getContentPane().add(btnNext);
		
		lblNewLabel = new JLabel("Total :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(820, 433, 40, 25);
		getContentPane().add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(861, 433, 86, 25);
		getContentPane().add(textField_2);
		loadPosition();
		tbemp.setRowHeight(35);
	}
	//load
	public void loadPosition() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Position_Id");
		model.addColumn("Position_Name");
		//tìm số trang của bảng 
		totalPage = Math.ceil(totalCount.doubleValue() / rowOfPage.doubleValue());
		PosDAO.getPosition(pagenumber, rowOfPage).stream().forEach(Pos -> model.addRow(new Object[] {
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
	protected void btnResetMouseClicked(MouseEvent e) {
	    int rowIndex = tbemp.getSelectedRow();
	    if (rowIndex != -1) { // Kiểm tra xem đã chọn hàng nào hay chưa
		    txtID.setText(tbemp.getValueAt(rowIndex, 0).toString());
	        txtName.setText(""); // Thiết lập ô Name thành rỗng
	    }

	}
	public void refresh() {
		DefaultTableModel model = (DefaultTableModel)tbemp.getModel();
		model.setRowCount(0); 
		PosDAO.getPosition(pagenumber, rowOfPage).stream().forEach(Pos -> model.addRow(new Object[] {
				Pos.getPosition_id(),
				Pos.getPosition_name(),
		}));
	}
	protected void btnPreviousActionPerformed(ActionEvent e) {
		if(pagenumber>1) {
			pagenumber--;
			txtPage.setText(pagenumber.toString());
			refresh();
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
	protected void txtPageActionPerformed(ActionEvent e) {
		int num = Integer.parseInt(txtPage.getText()) ;
		if(num>0 && num<totalPage.intValue()) {
			pagenumber = num;
			refresh();
		}else {
			JOptionPane.showMessageDialog(null, "Page Number is invalid");
		}
	}
	protected void btnInsertActionPerformed(ActionEvent e) {
		 var Pos = new Position();
		
		Pos.setPosition_name(txtName.getText());
		PosDAO.insert(Pos);
		// load lai du lieu
		loadPosition();
		refresh();
	}
	protected void btnUpdateActionPerformed(ActionEvent e) {
		var Pos = new Position();
		Pos.setPosition_id(Integer.parseInt(txtID.getText()));
		Pos.setPosition_name(txtName.getText());
		PosDAO.update(Pos);
		loadPosition();
		refresh();
	}
	protected void btnDeleteActionPerformed(ActionEvent e) {
		JOptionPane.showConfirmDialog(null,"Are you sure want to delete?","Delete",JOptionPane.YES_NO_OPTION);
		int a = Integer.parseInt(txtID.getText());
		PosDAO.delete(a);
		refresh();
	}
	protected void btnResetMouseEntered(MouseEvent e) {
		btnReset.setBackground(new Color(106,90,205));
		btnReset.setForeground(Color.black);
	}
	protected void btnResetMouseExited(MouseEvent e) {
		btnReset.setBackground(SystemColor.inactiveCaption);
		btnReset.setForeground(Color.black);
	}
	protected void btnInsertMouseEntered(MouseEvent e) {
		btnInsert.setBackground(new Color(106,90,205));
		btnInsert.setForeground(Color.black);
	}
	protected void btnInsertMouseExited(MouseEvent e) {
		btnInsert.setBackground(SystemColor.textHighlight);
		btnInsert.setForeground(Color.black);
	}
	protected void btnUpdateMouseEntered(MouseEvent e) {
		btnUpdate.setBackground(new Color(106,90,205));
		btnUpdate.setForeground(Color.black);
	}
	protected void btnUpdateMouseExited(MouseEvent e) {
		btnUpdate.setBackground(Color.yellow);
		btnUpdate.setForeground(Color.black);
	}
	protected void btnDeleteMouseEntered(MouseEvent e) {
		btnDelete.setBackground(new Color(106,90,205));
		btnDelete.setForeground(Color.black);
	}
	protected void btnDeleteMouseExited(MouseEvent e) {
		btnDelete.setBackground(Color.red);
		btnDelete.setForeground(Color.black);
	}
	protected void btnPreviousMouseEntered(MouseEvent e) {
		btnPrevious.setBackground(new Color(106,90,205));
		btnPrevious.setForeground(Color.black);
	}
	protected void btnPreviousMouseExited(MouseEvent e) {
		btnPrevious.setBackground(SystemColor.inactiveCaption);
		btnPrevious.setForeground(Color.black);
	}
	protected void btnNextMouseEntered(MouseEvent e) {
		btnNext.setBackground(new Color(106,90,205));
		btnNext.setForeground(Color.black);
	}
	protected void btnNextMouseExited(MouseEvent e) {
		btnNext.setBackground(SystemColor.inactiveCaption);
		btnNext.setForeground(Color.black);
	}
}
