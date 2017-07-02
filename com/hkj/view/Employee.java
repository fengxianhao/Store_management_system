

package com.hkj.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.acl.Group;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.hkj.entity.Person;
import com.hkj.service.Lianxi;
import com.hkj.service.PersonService;


public class Employee extends javax.swing.JFrame {

	public Employee() {
		initComponents();
		initView();
	

		ResultSet rstResultSet = null;
		boolean a = true;
		this.setTitle("雇员管理");
		this.setBounds(0, 0, 1366, 768);
		this.setLocation(330, 100);
		JLabel aIconLabel = new JLabel();
		this.setFont(new Font("微软雅黑", Font.BOLD, 50));

		ImageIcon image = new ImageIcon("Photo//背景.jpg");
		
		JLabel label = new JLabel(image);
		
		label.setBounds(0, 0, 1366, 768);
		JPanel imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		this.getContentPane().add(aIconLabel);
		this.setResizable(true);
		this.setVisible(true);
		setResizable(false);
		this.showtable();
	
		this.setLocationRelativeTo(null);
	
		SimpleDateFormat sft = new SimpleDateFormat();
		Date d = new Date();
		String date = sft.format(d);
		jEditorPane8.setText(date);
	}

	public void showtable() {
		String[] hds = { "员工编号", "姓名", "性别", "年龄", "职位" };
		Lianxi dao = new Lianxi();
		List<Person> wList = dao.query();
		DefaultTableModel dtm = new DefaultTableModel(hds, 0);
		Object[][] data = new Object[wList.size()][hds.length];
		for (int i = 0; i < wList.size(); i++) {
			Person model = wList.get(i);
			data[i][0] = model.getEmployeeID();
			data[i][1] = model.getEname();
			data[i][2] = model.getSex();
			data[i][3] = model.getAge();
			data[i][4] = model.getPosition();
			dtm.addRow(data[i]);
		}
		jTable1.setModel(dtm);
	}


	private void initComponents() {
		
		buttonGroup1 = new javax.swing.ButtonGroup();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jScrollPane3 = new javax.swing.JScrollPane();
		jEditorPane2 = new javax.swing.JEditorPane();
		jScrollPane5 = new javax.swing.JScrollPane();
		jEditorPane4 = new javax.swing.JEditorPane();
		jScrollPane6 = new javax.swing.JScrollPane();
		jEditorPane5 = new javax.swing.JEditorPane();
		jScrollPane7 = new javax.swing.JScrollPane();
		jEditorPane6 = new javax.swing.JEditorPane();
		jScrollPane8 = new javax.swing.JScrollPane();
		jEditorPane7 = new javax.swing.JEditorPane();
		jScrollPane9 = new javax.swing.JScrollPane();
		jEditorPane8 = new javax.swing.JEditorPane();
		jScrollPane10 = new javax.swing.JScrollPane();
		jEditorPane9 = new javax.swing.JEditorPane();
		jScrollPane2 = new javax.swing.JScrollPane();
		jEditorPane1 = new javax.swing.JEditorPane();
		jRadioButton1 = new javax.swing.JRadioButton();
		jRadioButton2 = new javax.swing.JRadioButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu2 = new javax.swing.JMenu();
		jMenu3 = new javax.swing.JMenu();
		jMenu4 = new javax.swing.JMenu();
		jMenu5 = new javax.swing.JMenu();
		jMenu1 = new javax.swing.JMenu();
		jMenuBar2 = new javax.swing.JMenuBar();
		jMenu6 = new javax.swing.JMenu();
		jMenu7 = new javax.swing.JMenu();
		jMenu8 = new javax.swing.JMenu();
		jMenu9 = new javax.swing.JMenu();
		jMenu10 = new javax.swing.JMenu();
		jMenuBar3 = new javax.swing.JMenuBar();
		jMenu11 = new javax.swing.JMenu();
		jMenu12 = new javax.swing.JMenu();
		jMenu13 = new javax.swing.JMenu();
		jMenu14 = new javax.swing.JMenu();
		jMenu15 = new javax.swing.JMenu();
		jMenu16 = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {
				}, new String[] { "员工编号", "姓名", "性别", "年龄", "职位" }));
		jTable1.setMinimumSize(new java.awt.Dimension(300, 500));
		jTable1.setRequestFocusEnabled(false);
		jTable1.setRowHeight(45);
		jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				Employee.this.mouseClicked(evt);
			}
		});
	
		jTable1.getTableHeader().setPreferredSize(new Dimension(1, 30));
		
		jTable1.setFont(new java.awt.Font("微软雅黑", 0, 20));
		
		

		jScrollPane1.setViewportView(jTable1);

		jButton1.setBackground(new java.awt.Color(130, 191, 245));
		jButton1.setFont(new java.awt.Font("微软雅黑", 0, 36));
		jButton1.setForeground(new java.awt.Color(255, 255, 255));
		jButton1.setText("\u6dfb\u52a0");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setBackground(new java.awt.Color(130, 191, 245));
		jButton2.setFont(new java.awt.Font("微软雅黑", 0, 36));
		jButton2.setForeground(new java.awt.Color(255, 255, 255));
		jButton2.setText("\u4fee\u6539\u4fe1\u606f");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setBackground(new java.awt.Color(130, 191, 245));
		jButton3.setFont(new java.awt.Font("微软雅黑", 0, 36));
		jButton3.setForeground(new java.awt.Color(255, 255, 255));
		jButton3.setText("\u5220\u9664");
		
		ButtonGroup group=new ButtonGroup();
		group.add(jRadioButton1);
		group.add(jRadioButton2);
		
		jEditorPane1.setEnabled(false);
		
		jEditorPane8.setEnabled(false);
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
				
			}
		});

		jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel1.setText("\u5458\u5de5\u7f16\u53f7");

		jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel2.setText("\u5458\u5de5\u59d3\u540d");

		jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel3.setText("\u6027       \u522b");

		jLabel4.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel4.setText("\u5e74       \u9f84");

		jLabel5.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel5.setText("\u8eab\u4efd\u8bc1\u53f7");

		jLabel6.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel6.setText("\u8054\u7cfb\u7535\u8bdd");

		jLabel7.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel7.setText("\u8054\u7cfb\u5730\u5740");

		jLabel8.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel8.setText("\u5165\u804c\u65e5\u671f");

		jLabel9.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel9.setText("\u804c       \u4f4d");

		jScrollPane3.setViewportView(jEditorPane2);

		jScrollPane5.setViewportView(jEditorPane4);

		jScrollPane6.setViewportView(jEditorPane5);

		jScrollPane7.setViewportView(jEditorPane6);

		jScrollPane8.setViewportView(jEditorPane7);

		jScrollPane9.setViewportView(jEditorPane8);

		jScrollPane10.setViewportView(jEditorPane9);

		jScrollPane2.setViewportView(jEditorPane1);

		jRadioButton1.setBackground(new java.awt.Color(123, 185, 242));
		jRadioButton1.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jRadioButton1.setText("\u7537");
		jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton1ActionPerformed(evt);
			}
		});

		jRadioButton2.setBackground(new java.awt.Color(123, 185, 242));
		jRadioButton2.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jRadioButton2.setText("\u5973");
		jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton2ActionPerformed(evt);
			}
		});

		jMenuBar1.setBackground(new java.awt.Color(130, 191, 245));
		
		//会员管理
		jMenu2.setText("     \u96c7\u5458\u7ba1\u7406     ");
		jMenu2.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar1.add(jMenu2);
		jMenu12.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						new Member().setVisible(true);
					}
				});
				
				setVisible(false);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//会员管理
		jMenu3.setText("     \u4f1a\u5458\u7ba1\u7406     ");
		jMenu3.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar1.add(jMenu3);
		jMenu13.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				Register register=new Register();
				register.reg();
				
				setVisible(false);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		jMenu4.setText("     \u4ea7\u54c1\u7ba1\u7406     ");
		jMenu4.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar1.add(jMenu4);

		jMenu5.setText("\u5e97\u94fa\u6536\u6b3e");
		jMenu5.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar1.add(jMenu5);

		jMenu1.setText("\u9500\u552e\u7edf\u8ba1");        
		jMenu1.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar1.add(jMenu1);

		jMenuBar2.setBackground(new java.awt.Color(130, 191, 245));

		jMenu6.setText("     \u96c7\u5458\u7ba1\u7406     ");
		jMenu6.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar2.add(jMenu6);

		jMenu7.setText("     \u4f1a\u5458\u7ba1\u7406     ");
		jMenu7.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar2.add(jMenu7);

		jMenu8.setText("     \u4ea7\u54c1\u7ba1\u7406     ");
		jMenu8.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar2.add(jMenu8);

		jMenu9.setText("     \u9500\u552e\u7edf\u8ba1     ");
		jMenu9.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar2.add(jMenu9);

		jMenu10.setText("     \u5e97\u94fa\u6536\u6b3e     ");
		jMenu10.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar2.add(jMenu10);

		jMenuBar3.setBackground(new java.awt.Color(130, 191, 245));

		jMenu11.setText("    \u96c7\u5458\u7ba1\u7406    ");
		jMenu11.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar3.add(jMenu11);

		jMenu12.setText("    \u4f1a\u5458\u7ba1\u7406    ");
		jMenu12.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar3.add(jMenu12);

		jMenu13.setText("    \u4ea7\u54c1\u7ba1\u7406    ");
		jMenu13.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar3.add(jMenu13);

		jMenu14.setText("    \u9500\u552e\u7edf\u8ba1    ");
		jMenu14.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar3.add(jMenu14);

		jMenu15.setText("    \u5e97\u94fa\u6536\u6b3e    ");
		jMenu15.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar3.add(jMenu15);

		jMenu16.setText("    \u9001\u8d27\u4e0a\u95e8    ");
		jMenu16.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar3.add(jMenu16);

		setJMenuBar(jMenuBar3);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		jScrollPane1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		970,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(228,
																		228,
																		228)
																.addComponent(
																		jButton2)
																.addGap(180,
																		180,
																		180)
																.addComponent(
																		jButton3,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		180,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel7)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jScrollPane8,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		180,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel5)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jScrollPane6,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		180,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel6)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jScrollPane7,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		180,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel8)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jScrollPane9,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		180,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel4)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jScrollPane5,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		179,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel3)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jRadioButton1)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		85,
																		Short.MAX_VALUE)
																.addComponent(
																		jRadioButton2))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel2)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jScrollPane3,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		180,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel1)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jScrollPane2,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		180,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel9)
																.addGap(18, 18,
																		18)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jButton1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						179,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jScrollPane10,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						179,
																						Short.MAX_VALUE))))
								.addGap(53, 53, 53)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel1)
																				.addComponent(
																						jScrollPane2,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(27, 27,
																		27)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel2)
																				.addComponent(
																						jScrollPane3,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(30, 30,
																		30)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jLabel3)
																				.addComponent(
																						jRadioButton1)
																				.addComponent(
																						jRadioButton2))
																.addGap(28, 28,
																		28)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel4)
																				.addComponent(
																						jScrollPane5,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(30, 30,
																		30)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel5)
																				.addComponent(
																						jScrollPane6,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(30, 30,
																		30)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel6)
																				.addComponent(
																						jScrollPane7,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(28, 28,
																		28)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel7)
																				.addComponent(
																						jScrollPane8,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(28, 28,
																		28)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel8)
																				.addComponent(
																						jScrollPane9,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(22, 22,
																		22)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jScrollPane10,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jLabel9)))
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		jScrollPane1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		531,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(26, 26, 26)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton2)
												.addComponent(jButton3)
												.addComponent(jButton1))
								.addContainerGap(40, Short.MAX_VALUE)));

		pack();
	}
	
	protected void mouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub
		
		int employeeID=Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 

0).toString());
		System.out.println(employeeID);

		Person p=new Lianxi().SelectEmployeeByID(employeeID);
		jEditorPane1.setText(String.valueOf(p.getEmployeeID()));
		jEditorPane2.setText(p.getEname());

		if("男".equals(p.getSex())){
				jRadioButton1.setSelected(true);
		}
		else{
				jRadioButton2.setSelected(true);
		}

		jEditorPane4.setText(String.valueOf(p.getAge()));
		jEditorPane5.setText(p.getIDcard());
		jEditorPane6.setText(p.getPhone());
		jEditorPane7.setText(p.getAddress());
		jEditorPane8.setText(p.getcDate());
		jEditorPane9.setText(p.getPosition());
		
	}



	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Person person = new Person();
		//		person.setEmployeeID(Integer.parseInt(jEditorPane1.getText()));
		person.setEname(jEditorPane2.getText());
		person.setPosition(jEditorPane9.getText());
		person.setIDcard(jEditorPane5.getText());
		person.setPhone(jEditorPane6.getText());
		person.setAddress(jEditorPane7.getText());
		person.setcDate(jEditorPane8.getText());
		person.setPosition(jEditorPane9.getText());

		if (jRadioButton1.isSelected())
			person.setSex("男");
		else
			person.setSex("女");
		try {
			int age = Integer.valueOf(jEditorPane4.getText());
			if (age <= 100) {
				person.setAge(age);

			} else {
				JOptionPane.showMessageDialog(this, "年龄必须为小于等于100的数！","温馨提示！",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "年龄必须为整数！");
			return;
		}

		PersonService personService = new PersonService();

		try {
			if (personService.addPersons(person)) {
				JOptionPane.showMessageDialog(null, "添加成功！");
				Employee es = new Employee();
				es.setVisible(true);
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		freshView();

	}

	private void freshView() {
		

	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		if (jTable1.getSelectedRow() < 0) {
			JOptionPane.showMessageDialog(null, "请选择要删除的会员！");
		} else {
			int a = jTable1.getSelectedRow();
			int od = Integer.parseInt(jTable1.getModel().getValueAt(a, 0)
					.toString());
			PersonService dao = new PersonService();
			int model = dao.deletePerson(od);
			if (model == 1) {
				JOptionPane.showMessageDialog(null, "删除成功！");
				Employee employee = new Employee();
				this.setVisible(false);
				employee.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "删除失败！");
			}
		}
	}

	private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}


	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		if (jTable1.getSelectedRow() < 0) {
			JOptionPane.showMessageDialog(null, "请选择要修改的会员！");
		}
		Person person = new Person();
		person.setEmployeeID(Integer
				.parseInt(jEditorPane1.getText().toString()));
		person.setEname(jEditorPane2.getText());
		person.setPosition(jEditorPane9.getText());
		person.setIDcard(jEditorPane5.getText());
		person.setPhone(jEditorPane6.getText());
		person.setAddress(jEditorPane7.getText());
		person.setcDate(jEditorPane8.getText());
		person.setPosition(jEditorPane9.getText());

		if (jRadioButton1.isSelected())
			person.setSex("男");
		else
			person.setSex("女");
		try {
			int age = Integer.valueOf(jEditorPane4.getText());
			if (age <= 100) {
				person.setAge(age);

			} else {
				JOptionPane.showMessageDialog(this, "年龄必须为小于等于100的数！",
						"温馨提示！", JOptionPane.ERROR_MESSAGE);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "年龄必须为整数！");
			return;
		}
		PersonService personService = new PersonService();

		try {
			if (personService.updatePerson(person)) {
				JOptionPane.showMessageDialog(null, "修改成功！");
				Employee es = new Employee();
				es.setVisible(true);
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "修改失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		freshView();
	}


	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Employee().setVisible(true);

			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JEditorPane jEditorPane1;
	private javax.swing.JEditorPane jEditorPane2;
	private javax.swing.JEditorPane jEditorPane4;
	private javax.swing.JEditorPane jEditorPane5;
	private javax.swing.JEditorPane jEditorPane6;
	private javax.swing.JEditorPane jEditorPane7;
	private javax.swing.JEditorPane jEditorPane8;
	private javax.swing.JEditorPane jEditorPane9;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu10;
	private javax.swing.JMenu jMenu11;
	private javax.swing.JMenu jMenu12;
	private javax.swing.JMenu jMenu13;
	private javax.swing.JMenu jMenu14;
	private javax.swing.JMenu jMenu15;
	private javax.swing.JMenu jMenu16;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenu jMenu5;
	private javax.swing.JMenu jMenu6;
	private javax.swing.JMenu jMenu7;
	private javax.swing.JMenu jMenu8;
	private javax.swing.JMenu jMenu9;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuBar jMenuBar2;
	private javax.swing.JMenuBar jMenuBar3;
	private javax.swing.JRadioButton jRadioButton1;
	private javax.swing.JRadioButton jRadioButton2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane10;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JScrollPane jScrollPane6;
	private javax.swing.JScrollPane jScrollPane7;
	private javax.swing.JScrollPane jScrollPane8;
	private javax.swing.JScrollPane jScrollPane9;
	private javax.swing.JTable jTable1;

	private void initView() {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				if (JOptionPane.showConfirmDialog(null, "你确定要退出吗？", "退出提示",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
	}

}