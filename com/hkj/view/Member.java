

package com.hkj.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import com.hkj.db.DbConnection;
import com.hkj.entity.Vip;
import com.hkj.service.GuiUtil;
import com.hkj.service.MemberServiceImpl;
import com.hkj.service.MyTableModel;



public class Member extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private MemberServiceImpl mSev = new MemberServiceImpl();
	MyTableModel dtm;

	public Member() {
		initComponents();
		this.setTitle("会员管理界面");
		this.setBounds(300, 100, 1366, 768);
		JLabel aIconLabel = new JLabel();
		this.setFont(new Font("微软雅黑", Font.BOLD, 50));

		ImageIcon image = new ImageIcon("photo/背景.jpg");

		JLabel label = new JLabel(image);
	
		label.setBounds(0, 0, 1366, 768);
		JPanel imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);

		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		this.getContentPane().add(aIconLabel);
		this.setResizable(true);
		this.setVisible(true);
		setResizable(false);

		this.setLocationRelativeTo(null);

		SimpleDateFormat sft = new SimpleDateFormat();
		Date d = new Date();
		String date = sft.format(d);
		dateTxt.setText(date);
		initView();
	}

	
	private void initView() {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				if (JOptionPane.showConfirmDialog(null, "你确定要退出吗？","退出提示",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
		idTxt.setEditable(false);
		idTxt.setEnabled(false);
		dateTxt.setEditable(false);
		dateTxt.setEnabled(false);
		getMemberList();
	}


	private void getMemberList() {

		new Thread() {
			public void run() {

				new SwingWorker<Boolean, Void>() {
					@SuppressWarnings("unused")
					String msg;
					ArrayList<Vip> vips;

					@Override
					protected Boolean doInBackground() throws Exception {
						try {
							DbConnection.getConnection();
						} catch (Exception e) {
							msg = e.getMessage();
							return false;
						}
						Thread.sleep(500);

						return true;
					}

					protected void done() {
						try {
							memberTable.removeAll();
							vips = (ArrayList<Vip>) mSev.findAll("");
							Object[][] obj;
							try {
								obj = new Object[vips.size()][5];
								for (int i = 0; i < vips.size(); i++) {
									obj[i][0] = vips.get(i).getVipId();
									obj[i][1] = vips.get(i).getvName();
									obj[i][2] = vips.get(i).getSex();
									obj[i][3] = vips.get(i).getAge();
									obj[i][4] = vips.get(i).getNumber();

								}
							} catch (Exception e) {
								e.printStackTrace();
								obj = new Object[0][5];
								return;
							}

							dtm = new MyTableModel(obj, new String[] { "会员编号",
									"姓名", "性别", "年龄", "完美卡号" });

							memberTable.setModel(dtm);
							GuiUtil.formatTb(memberTable);

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				}.execute();

			}
		}.start();

	}

	public static void centerWindow(Container win) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension scr = toolkit.getScreenSize();
		int x = (scr.width - win.getWidth()) / 2;
		int y = (scr.height - win.getHeight()) / 2;
		win.setLocation(x, y);
	}


	private void initComponents() {

		jSeparator1 = new javax.swing.JSeparator();
		sexGroup = new javax.swing.ButtonGroup();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();
		jMenu3 = new javax.swing.JMenu();
		jMenu4 = new javax.swing.JMenu();
		jMenu5 = new javax.swing.JMenu();
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
		jMenuBar4 = new javax.swing.JMenuBar();
		jMenu16 = new javax.swing.JMenu();
		jMenu17 = new javax.swing.JMenu();
		jMenu18 = new javax.swing.JMenu();
		jMenu19 = new javax.swing.JMenu();
		jMenu20 = new javax.swing.JMenu();
		jMenuBar5 = new javax.swing.JMenuBar();
		jMenu21 = new javax.swing.JMenu();
		jMenu22 = new javax.swing.JMenu();
		jMenu23 = new javax.swing.JMenu();
		jMenu24 = new javax.swing.JMenu();
		jMenu25 = new javax.swing.JMenu();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		idTxt = new javax.swing.JTextPane();
		jScrollPane3 = new javax.swing.JScrollPane();
		nameTxt = new javax.swing.JTextPane();
		jScrollPane4 = new javax.swing.JScrollPane();
		ageTxt = new javax.swing.JTextPane();
		jScrollPane5 = new javax.swing.JScrollPane();
		idcardTxt = new javax.swing.JTextPane();
		jScrollPane6 = new javax.swing.JScrollPane();
		phoneTxt = new javax.swing.JTextPane();
		jScrollPane7 = new javax.swing.JScrollPane();
		addressTxt = new javax.swing.JTextPane();
		jScrollPane8 = new javax.swing.JScrollPane();
		dateTxt = new javax.swing.JTextPane();
		jScrollPane9 = new javax.swing.JScrollPane();
		vipId = new javax.swing.JTextPane();
		radiobtn1 = new javax.swing.JRadioButton();
		radiobtn2 = new javax.swing.JRadioButton();
		jButton4 = new javax.swing.JButton();
		listPanel = new javax.swing.JPanel();
		jScrollPane10 = new javax.swing.JScrollPane();
		memberTable = new javax.swing.JTable();
		jMenuBar6 = new javax.swing.JMenuBar();
		jMenu27 = new javax.swing.JMenu();
		jMenu28 = new javax.swing.JMenu();
		jMenu29 = new javax.swing.JMenu();
		jMenu30 = new javax.swing.JMenu();
		jMenu26 = new javax.swing.JMenu();
		jMenuBar7 = new javax.swing.JMenuBar();
		jMenu31 = new javax.swing.JMenu();
		jMenu32 = new javax.swing.JMenu();
		jMenu33 = new javax.swing.JMenu();
		jMenu34 = new javax.swing.JMenu();
		jMenu35 = new javax.swing.JMenu();
		jMenuBar8 = new javax.swing.JMenuBar();
		jMenu36 = new javax.swing.JMenu();
		jMenu37 = new javax.swing.JMenu();
		jMenu38 = new javax.swing.JMenu();
		jMenu39 = new javax.swing.JMenu();
		jMenu40 = new javax.swing.JMenu();
		jMenu41 = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel1.setText("\u4f1a\u5458\u7f16\u53f7");

		jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel2.setText("\u4f1a\u5458\u59d3\u540d");

		jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel3.setText("\u6027       \u522b");

		jLabel5.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel5.setText("\u5e74       \u9f84");

		jLabel6.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel6.setText("\u8eab\u4efd\u8bc1\u53f7");

		jLabel7.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel7.setText("\u8054\u7cfb\u7535\u8bdd");

		jLabel8.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel8.setText("\u8054\u7cfb\u5730\u5740");

		jLabel9.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel9.setText("\u52a0\u5165\u65e5\u671f");

		jLabel10.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel10.setText("\u5b8c\u7f8e\u5361\u53f7");

		jMenuBar1.setBackground(new java.awt.Color(130, 191, 245));

		jMenu1.setText("     \u5e97\u94fa\u6536\u6b3e     ");
		jMenu1.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar1.add(jMenu1);

		jMenu2.setText("     \u96c7\u5458\u7ba1\u7406     ");
		jMenu2.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar1.add(jMenu2);

		jMenu3.setText("     \u4f1a\u5458\u7ba1\u7406     ");
		jMenu3.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar1.add(jMenu3);

		jMenu4.setText("     \u4ea7\u54c1\u7ba1\u7406     ");
		jMenu4.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar1.add(jMenu4);

		jMenu5.setText("     \u9500\u552e\u7edf\u8ba1     ");
		jMenu5.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar1.add(jMenu5);

		jMenuBar2.setBackground(new java.awt.Color(130, 191, 245));

		jMenu6.setText("     \u5e97\u94fa\u6536\u6b3e     ");
		jMenu6.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar2.add(jMenu6);

		jMenu7.setText("     \u96c7\u5458\u7ba1\u7406     ");
		jMenu7.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar2.add(jMenu7);

		jMenu8.setText("     \u4f1a\u5458\u7ba1\u7406     ");
		jMenu8.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar2.add(jMenu8);

		jMenu9.setText("     \u4ea7\u54c1\u7ba1\u7406     ");
		jMenu9.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar2.add(jMenu9);

		jMenu10.setText("     \u9500\u552e\u7edf\u8ba1     ");
		jMenu10.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar2.add(jMenu10);

		jMenuBar3.setBackground(new java.awt.Color(130, 191, 245));

		jMenu11.setText("     \u5e97\u94fa\u6536\u6b3e     ");
		jMenu11.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar3.add(jMenu11);

		jMenu12.setText("     \u96c7\u5458\u7ba1\u7406     ");
		jMenu12.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar3.add(jMenu12);

		jMenu13.setText("     \u4f1a\u5458\u7ba1\u7406     ");
		jMenu13.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar3.add(jMenu13);

		jMenu14.setText("     \u4ea7\u54c1\u7ba1\u7406     ");
		jMenu14.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar3.add(jMenu14);

		jMenu15.setText("     \u9500\u552e\u7edf\u8ba1     ");
		jMenu15.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar3.add(jMenu15);

		jMenuBar4.setBackground(new java.awt.Color(130, 191, 245));

		jMenu16.setText("     \u5e97\u94fa\u6536\u6b3e     ");
		jMenu16.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar4.add(jMenu16);

		jMenu17.setText("     \u96c7\u5458\u7ba1\u7406     ");
		jMenu17.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar4.add(jMenu17);

		jMenu18.setText("     \u4f1a\u5458\u7ba1\u7406     ");
		jMenu18.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar4.add(jMenu18);

		jMenu19.setText("     \u4ea7\u54c1\u7ba1\u7406     ");
		jMenu19.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar4.add(jMenu19);

		jMenu20.setText("     \u9500\u552e\u7edf\u8ba1     ");
		jMenu20.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar4.add(jMenu20);

		jMenuBar5.setBackground(new java.awt.Color(130, 191, 245));

		jMenu21.setText("     \u5e97\u94fa\u6536\u6b3e     ");
		jMenu21.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar5.add(jMenu21);

		jMenu22.setText("     \u96c7\u5458\u7ba1\u7406     ");
		jMenu22.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar5.add(jMenu22);

		jMenu23.setText("     \u4f1a\u5458\u7ba1\u7406     ");
		jMenu23.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar5.add(jMenu23);

		jMenu24.setText("     \u4ea7\u54c1\u7ba1\u7406     ");
		jMenu24.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar5.add(jMenu24);

		jMenu25.setText("     \u9500\u552e\u7edf\u8ba1     ");
		jMenu25.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar5.add(jMenu25);

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
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jScrollPane2.setViewportView(idTxt);

		jScrollPane3.setViewportView(nameTxt);

		jScrollPane4.setViewportView(ageTxt);

		jScrollPane5.setViewportView(idcardTxt);

		jScrollPane6.setViewportView(phoneTxt);

		jScrollPane7.setViewportView(addressTxt);

		jScrollPane8.setViewportView(dateTxt);

		jScrollPane9.setViewportView(vipId);

		radiobtn1.setBackground(new java.awt.Color(130, 191, 245));
		sexGroup.add(radiobtn1);
		radiobtn1.setFont(new java.awt.Font("微软雅黑", 0, 18));
		radiobtn1.setText("\u7537");

		radiobtn2.setBackground(new java.awt.Color(130, 191, 245));
		sexGroup.add(radiobtn2);
		radiobtn2.setFont(new java.awt.Font("微软雅黑", 0, 18));
		radiobtn2.setText("\u5973");

		jButton4.setText("jButton4");

		memberTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null } },
				new String[] { "浼氬憳缂栧彿", "濮撳悕", "鎬у埆", "骞撮緞", "瀹岀編鍗″彿" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false,
					true };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});

		memberTable.getTableHeader().setPreferredSize(new Dimension(1, 30));

		memberTable.setFont(new java.awt.Font("妤蜂綋", 0, 20));
		memberTable.setRowHeight(45);

		memberTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				Member.this.mouseClicked(evt);
			}
		});
		jScrollPane10.setViewportView(memberTable);

		javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(
				listPanel);
		listPanel.setLayout(listPanelLayout);
		listPanelLayout.setHorizontalGroup(listPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 975,
				Short.MAX_VALUE));
		listPanelLayout.setVerticalGroup(listPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 657,
				Short.MAX_VALUE));

		jMenuBar6.setBackground(new java.awt.Color(130, 191, 245));

		jMenu27.setText("     \u96c7\u5458\u7ba1\u7406     ");
		jMenu27.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar6.add(jMenu27);

		jMenu28.setText("     \u4f1a\u5458\u7ba1\u7406     ");
		jMenu28.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar6.add(jMenu28);

		jMenu29.setText("     \u4ea7\u54c1\u7ba1\u7406     ");
		jMenu29.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar6.add(jMenu29);

		jMenu30.setText("     \u9500\u552e\u7edf\u8ba1     ");
		jMenu30.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar6.add(jMenu30);

		jMenu26.setText("     \u5e97\u94fa\u6536\u6b3e     ");
		jMenu26.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar6.add(jMenu26);

		jMenuBar7.setBackground(new java.awt.Color(130, 191, 245));

		jMenu31.setText("     \u96c7\u5458\u7ba1\u7406     ");
		jMenu31.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar7.add(jMenu31);

		jMenu32.setText("     \u4f1a\u5458\u7ba1\u7406     ");
		jMenu32.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar7.add(jMenu32);

		jMenu33.setText("     \u4ea7\u54c1\u7ba1\u7406     ");
		jMenu33.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar7.add(jMenu33);

		jMenu34.setText("     \u9500\u552e\u7edf\u8ba1     ");
		jMenu34.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar7.add(jMenu34);

		jMenu35.setText("     \u5e97\u94fa\u6536\u6b3e     ");
		jMenu35.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar7.add(jMenu35);

		jMenuBar8.setBackground(new java.awt.Color(130, 191, 245));
		
		//雇员管理
		jMenu36.setText("    \u96c7\u5458\u7ba1\u7406    ");
		jMenu36.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenu36.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						new Employee().setVisible(true);
						
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
		
		
		jMenuBar8.add(jMenu36);

		jMenu37.setText("    \u4f1a\u5458\u7ba1\u7406    ");
		jMenu37.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar8.add(jMenu37);
		
		//产品管理
		jMenu38.setText("    \u4ea7\u54c1\u7ba1\u7406    ");
		jMenu38.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenu38.addMouseListener(new MouseListener() {
			
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
		
		
		jMenuBar8.add(jMenu38);

		jMenu39.setText("    \u9500\u552e\u7edf\u8ba1    ");
		jMenu39.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar8.add(jMenu39);

		jMenu40.setText("    \u5e97\u94fa\u6536\u6b3e    ");
		jMenu40.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar8.add(jMenu40);

		jMenu41.setText("    \u9001\u8d27\u4e0a\u95e8    ");
		jMenu41.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jMenuBar8.add(jMenu41);

		setJMenuBar(jMenuBar8);

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
																.addComponent(
																		listPanel,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel1)
																								.addGap(18,
																										18,
																										18)
																								.addComponent(
																										jScrollPane2,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										211,
																										Short.MAX_VALUE))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel2)
																								.addGap(18,
																										18,
																										18)
																								.addComponent(
																										jScrollPane3,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										211,
																										Short.MAX_VALUE))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel3)
																								.addGap(18,
																										18,
																										18)
																								.addComponent(
																										radiobtn1)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																										116,
																										Short.MAX_VALUE)
																								.addComponent(
																										radiobtn2))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel5)
																								.addGap(15,
																										15,
																										15)
																								.addComponent(
																										jScrollPane4,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										213,
																										Short.MAX_VALUE))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel6)
																								.addGap(15,
																										15,
																										15)
																								.addComponent(
																										jScrollPane5,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										214,
																										Short.MAX_VALUE))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel9)
																								.addGap(15,
																										15,
																										15)
																								.addComponent(
																										jScrollPane8,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										214,
																										Short.MAX_VALUE))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel8)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										jScrollPane7,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										214,
																										Short.MAX_VALUE))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel7)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										jScrollPane6,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										214,
																										Short.MAX_VALUE))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel10)
																								.addGap(15,
																										15,
																										15)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														jButton1,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														179,
																														javax.swing.GroupLayout.PREFERRED_SIZE)
																												.addComponent(
																														jScrollPane9,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														214,
																														Short.MAX_VALUE)))))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(186,
																		186,
																		186)
																.addComponent(
																		jButton2)
																.addGap(192,
																		192,
																		192)
																.addComponent(
																		jButton3,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		180,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(22, 22, 22)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														listPanel,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
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
																.addGap(26, 26,
																		26)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jScrollPane3,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jLabel2))
																.addGap(37, 37,
																		37)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																								.addComponent(
																										radiobtn1)
																								.addComponent(
																										radiobtn2))
																				.addComponent(
																						jLabel3))
																.addGap(28, 28,
																		28)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jScrollPane4,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jLabel5))
																.addGap(30, 30,
																		30)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						jLabel6,
																						javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jScrollPane5,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(39, 39,
																		39)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jLabel7)
																				.addComponent(
																						jScrollPane6,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(31, 31,
																		31)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jLabel8)
																				.addComponent(
																						jScrollPane7,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		84,
																		Short.MAX_VALUE)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						jLabel9,
																						javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jScrollPane8,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		85,
																		Short.MAX_VALUE)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jScrollPane9,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jLabel10))))
								.addGap(34, 34, 34)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton3)
												.addComponent(jButton2)
												.addComponent(jButton1))
								.addContainerGap()));

		pack();
	}

	
	private void mouseClicked(java.awt.event.MouseEvent evt) {

		int row = memberTable.getSelectedRow();
		if (row == -1)
			return;

		int id = (Integer) dtm.getValueAt(row, 0);
		if (id == 0)
			return;
		Vip vip = null;
		try {
			vip = mSev.findById("", id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

	
		idTxt.setText(vip.getVipId() + "");
		idTxt.setEditable(false);
		nameTxt.setText(vip.getvName());
		if (vip.getSex().equals("男"))
			radiobtn1.setSelected(true);
		else
			radiobtn2.setSelected(true);

		ageTxt.setText(vip.getAge() + "");
		idcardTxt.setText(vip.getIdCard());
		phoneTxt.setText(vip.getPhone());
		addressTxt.setText(vip.getAddress());
		dateTxt.setText(vip.getDate().toString());
		dateTxt.setEditable(false);
		vipId.setText(vip.getNumber());

	}


	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

		if (memberTable == null) {
			JOptionPane.showConfirmDialog(null, "没有可删除的记录", "提示信息",
					JOptionPane.OK_OPTION);
			return;
		}

		int row = memberTable.getSelectedRow();
		if (row < 0) {
			JOptionPane.showConfirmDialog(null, "请选择要删除的会员？", "提示信息",
					JOptionPane.OK_OPTION);
			return;
		} else {
			int id = (Integer) dtm.getValueAt(row, 0);

			@SuppressWarnings("unused")
			Vip vip = null;
			try {

				int n = JOptionPane.showConfirmDialog(null, "你确定要删除吗？", "提示信息",
						JOptionPane.YES_NO_OPTION);
				System.out.println(n);
				if (n == 1)
					return;

				if (mSev.delete("", id)) {
					JOptionPane.showConfirmDialog(null, "删除成功！", "提示信息",
							JOptionPane.YES_OPTION);

					freshView();
				}

			} catch (Exception e1) {
				e1.printStackTrace();
				return;
			}

		}

	}

	/**
	 * 
	 */
	private void freshView() {
		idTxt.setText("");
		nameTxt.setText("");
		radiobtn1.setSelected(true);
		ageTxt.setText("");
		idcardTxt.setText("");
		phoneTxt.setText("");
		addressTxt.setText("");
		dateTxt.setText("");
		vipId.setText("");
		getMemberList();
	}

	
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

		Vip vip = new Vip();
		vip.setvName(nameTxt.getText().trim());
		if (radiobtn1.isSelected())
			vip.setSex("男");
		else
			vip.setSex("女");
		try {
			vip.setAge(Integer.parseInt(ageTxt.getText().trim()));
			int age = Integer.valueOf(ageTxt.getText());
			if (age <= 100) {
				vip.setAge(age);
			} else {
				JOptionPane.showMessageDialog(this, "年龄必须为小于等于100的数！", "温馨提示！",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "请输入年龄！");
			ageTxt.setText("");
			return;
		}

		vip.setIdCard(idcardTxt.getText().trim());
		vip.setPhone(phoneTxt.getText().trim());
		vip.setAddress(addressTxt.getText().trim());
		vip.setNumber(vipId.getText().trim());
		vip.setLive(1);
		try {
			if (mSev.insertOrUpdate("", vip, false))
				JOptionPane.showMessageDialog(null, "添加成功！");
			else
				JOptionPane.showMessageDialog(null, "添加失败！");
		} catch (Exception e) {
			e.printStackTrace();
		}

		freshView();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

		if (memberTable == null) {
			JOptionPane.showConfirmDialog(null, "没有可删除的记录！", "提示信息",
					JOptionPane.OK_OPTION);
			return;
		}

		int row = memberTable.getSelectedRow();
		if (row < 0) {
			JOptionPane.showConfirmDialog(null, "请选择要修改的会员！", "提示信息",
			JOptionPane.OK_OPTION);
			return;
		} else {

			Vip vip = new Vip();
			vip.setVipId(Integer.parseInt(idTxt.getText().trim()));
			vip.setvName(nameTxt.getText().trim());
			if (radiobtn1.isSelected())
				vip.setSex("男");
			else
				vip.setSex("女");
			try {
				vip.setAge(Integer.parseInt(ageTxt.getText().trim()));
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "年龄必须为整数！");
				ageTxt.setText("");
				return;
			}

			vip.setIdCard(idcardTxt.getText().trim());
			vip.setPhone(phoneTxt.getText().trim());
			vip.setAddress(addressTxt.getText().trim());
			vip.setNumber(vipId.getText().trim());

			vip.setLive(1);
			try {
				if (mSev.insertOrUpdate("", vip, true))
					JOptionPane.showMessageDialog(null, "修改成功！");
				else
					JOptionPane.showMessageDialog(null, "修改失败！");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		freshView();
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Member().setVisible(true);
			}
		});
	}

	private javax.swing.JTextPane addressTxt;
	private javax.swing.JTextPane ageTxt;
	private javax.swing.JTextPane dateTxt;
	private javax.swing.JTextPane idTxt;
	private javax.swing.JTextPane idcardTxt;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
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
	private javax.swing.JMenu jMenu17;
	private javax.swing.JMenu jMenu18;
	private javax.swing.JMenu jMenu19;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu20;
	private javax.swing.JMenu jMenu21;
	private javax.swing.JMenu jMenu22;
	private javax.swing.JMenu jMenu23;
	private javax.swing.JMenu jMenu24;
	private javax.swing.JMenu jMenu25;
	private javax.swing.JMenu jMenu26;
	private javax.swing.JMenu jMenu27;
	private javax.swing.JMenu jMenu28;
	private javax.swing.JMenu jMenu29;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu30;
	private javax.swing.JMenu jMenu31;
	private javax.swing.JMenu jMenu32;
	private javax.swing.JMenu jMenu33;
	private javax.swing.JMenu jMenu34;
	private javax.swing.JMenu jMenu35;
	private javax.swing.JMenu jMenu36;
	private javax.swing.JMenu jMenu37;
	private javax.swing.JMenu jMenu38;
	private javax.swing.JMenu jMenu39;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenu jMenu40;
	private javax.swing.JMenu jMenu41;
	private javax.swing.JMenu jMenu5;
	private javax.swing.JMenu jMenu6;
	private javax.swing.JMenu jMenu7;
	private javax.swing.JMenu jMenu8;
	private javax.swing.JMenu jMenu9;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuBar jMenuBar2;
	private javax.swing.JMenuBar jMenuBar3;
	private javax.swing.JMenuBar jMenuBar4;
	private javax.swing.JMenuBar jMenuBar5;
	private javax.swing.JMenuBar jMenuBar6;
	private javax.swing.JMenuBar jMenuBar7;
	private javax.swing.JMenuBar jMenuBar8;
	private javax.swing.JScrollPane jScrollPane10;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JScrollPane jScrollPane6;
	private javax.swing.JScrollPane jScrollPane7;
	private javax.swing.JScrollPane jScrollPane8;
	private javax.swing.JScrollPane jScrollPane9;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JPanel listPanel;
	private javax.swing.JTable memberTable;
	private javax.swing.JTextPane nameTxt;
	private javax.swing.JTextPane phoneTxt;
	private javax.swing.JRadioButton radiobtn1;
	private javax.swing.JRadioButton radiobtn2;
	private javax.swing.ButtonGroup sexGroup;
	private javax.swing.JTextPane vipId;


}