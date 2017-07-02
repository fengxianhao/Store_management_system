
package com.hkj.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.hkj.db.DbConnection;
import com.hkj.entity.GoodsEmp;

import com.hkj.service.AddRecord;
import com.mysql.jdbc.Connection;

public class Add_Record extends javax.swing.JFrame {
	
	//控制时间格式
 	private static final String PARRENT = "yyyy-MM-dd";
	
	/** Creates new form Add_Record */
	public  void add(ArrayList  b) {
		initComponents();
		
	  	//日期显示在窗体上
		SimpleDateFormat sft = new SimpleDateFormat(PARRENT);
		Date d = new Date();
		String date = sft.format(d);
		jTextField3.setText(date);
		jTextField3.setEnabled(false);
		
		//自动获取产品编号
		int goodsID = Integer.parseInt(b.get(0).toString());
		String charge=b.get(1).toString();
		jTextField1.setText(String.valueOf(goodsID));
		jTextField2.setText("雷国庆");
		jTextField1.setForeground(Color.gray);
		jTextField2.setForeground(Color.gray);
		jTextField1.setEditable(false);
		jTextField2.setEditable(false);
		

		ResultSet rstResultSet = null;
		boolean a = true;
		this.setTitle("添加");
		this.setBounds(620, 250, 600, 420);
		JLabel aIconLabel = new JLabel();
		this.setFont(new Font("宋体", Font.BOLD, 50));
		ImageIcon image = new ImageIcon("Photo//背景.jpg");
		// 把背景图片显示在一个标签里面
		JLabel label = new JLabel(image);
		// 把标签的大小位置设置为图片刚好填充整个面板
		label.setBounds(0, 0, 600, 500);
		JPanel imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		// 把背景图片添加到分层窗格的最底层作为背景
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		this.getContentPane().add(aIconLabel);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		jTextField5 = new javax.swing.JTextField();

		//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		setFont(new java.awt.Font("Agency FB", 0, 18));
		setName("\u5165\u5e93\u7f16\u53f7\uff1a");

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jLabel1.setText("\u4ea7\u54c1\u7f16\u53f7\uff1a");

		jTextField1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20));
		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jLabel2.setText("\u767b\u8bb0\u8d1f\u8d23\u4eba\uff1a");

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jLabel3.setText("\u5165\u5e93\u65e5\u671f\uff1a");

		jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jLabel4.setText("\u5165\u5e93\u6570\u91cf\uff1a");

		jTextField2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20));
		jTextField2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}
		});

		jTextField3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20));
		jTextField3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField3ActionPerformed(evt);
			}
		});

		jTextField4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20));
		jTextField4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField4ActionPerformed(evt);
			}
		});

		jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jButton1.setIcon(new javax.swing.ImageIcon(
				"Photo//确定1.png")); // NOI18N
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jButton2.setIcon(new javax.swing.ImageIcon(
				"Photo//取消2.png")); // NOI18N
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jLabel5.setText("\u5165\u5e93\u7f16\u53f7\uff1a");

		jTextField5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20));
		jTextField5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField5ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap(44, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jLabel1)
																				.addComponent(
																						jLabel5)
																				.addComponent(
																						jLabel4)
																				.addComponent(
																						jLabel3)
																				.addComponent(
																						jLabel2))
																.addGap(13, 13,
																		13))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jButton1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		63,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jTextField4,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		254,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jTextField2,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						254,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jTextField3,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						254,
																						javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jTextField1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		254,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		jTextField5,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		254,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(105,
																		105,
																		105)
																.addComponent(
																		jButton2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		62,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(77, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jLabel5,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														52,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jTextField5,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														38,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														jTextField1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														38,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jLabel1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														52,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														jTextField4,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														38,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jLabel4,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														52,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														jTextField3,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														38,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jLabel3,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														52,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														jTextField2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														38,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jLabel2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														52,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														jButton1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														50,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jButton2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														50,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(30, Short.MAX_VALUE)));

		pack();
	}
	
	
	private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				GoodsEmp emp = new GoodsEmp();
				
				String storageID=jTextField5.getText();
//				
				String Charge=jTextField2.getText();
				
				//String goodsID= jTextField1.getText();
				
				String sql="select  StorageID  from goods where StorageID="+storageID;
				
				//String sql1="select charge from goods where charge="+Charge;
				
				
				Connection conn;
				conn =(Connection) DbConnection.getConnection();
				
				try {
					java.sql.PreparedStatement ps=conn.prepareStatement(sql);
					
					// java.sql.PreparedStatement ps1=conn.prepareStatement(sql1);
					

					if(ps.executeQuery().next()) {
						JOptionPane.showMessageDialog(null, "入库编号已存在！");
					}
//					if  (jTextField1.getText().equals("")||jTextField2.getText().equals("")||jTextField3.getText().equals("")||jTextField4.getText().equals("")) {
//									JOptionPane.showMessageDialog(null, "输入信息不为空！");
////					}else if (!(ps1.executeQuery().next())) {
//						JOptionPane.showMessageDialog(null, "登记人不存在！");
					else{
						
						String cString = jTextField5.getText();
						int StorageID = Integer.parseInt(cString);
						emp.setStorageID(StorageID);

						String aString = jTextField4.getText();
						int StorageNumber = Integer.parseInt(aString);
						emp.setStorageNumber(StorageNumber);

						String StorageDate = jTextField3.getText();
						emp.setStorageDate(StorageDate);

						String charge = jTextField2.getText();
						emp.setCharge(charge);

						String dString = jTextField1.getText();
						int GoodsID = Integer.parseInt(dString);
						emp.setGoodsID(GoodsID);

						jTextField1.setText("");
						jTextField2.setText("");
						jTextField3.setText("");
						jTextField4.setText("");
						jTextField5.setText("");

						AddRecord addRecord = new AddRecord();

						boolean flag = addRecord.updategoods(emp);

						if (flag) {
							JOptionPane.showMessageDialog(null, "添加成功！");
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}				
			}
		});
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Register register = new Register();
		register.reg();

		this.setVisible(false);
	}

	private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
//		java.awt.EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				//new Add_Record().setVisible(true);
//
//			}
//		});
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;

}