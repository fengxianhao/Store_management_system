
package com.hkj.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.hkj.entity.GoodsEmp;
//import com.hkj.service.QueryGoodsID;
//import com.hkj.service.QueryRecord;
//import com.hkj.service.QueryStockNumber;
import com.hkj.service.QueryStock;

import fxh.com.hkj.service.Service;
import com.hkj.service.Service1;

public class Stock extends javax.swing.JFrame {

	public void note() {
		initComponents();

		ResultSet rstResultSet = null;
		boolean a = true;
		this.setTitle("产品库存情况");
		this.setBounds(300, 100, 1366, 768);
		JLabel aIconLabel = new JLabel();
		this.setFont(new Font("宋体", Font.BOLD, 50));
		ImageIcon image = new ImageIcon("Photo//背景.jpg");
		// 把背景图片显示在一个标签里面
		JLabel label = new JLabel(image);
		// 把标签的大小位置设置为图片刚好填充整个面板
		label.setBounds(0, 0, 1366, 768);

		JPanel imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		// 把背景图片添加到分层窗格的最底层作为背景
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		this.getContentPane().add(aIconLabel);
		this.setResizable(false);
		this.setVisible(true);




	}

	private void initComponents() {

		jComboBox1 = new javax.swing.JComboBox();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		//jTable = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();



		//设置表格
		String [] heads={"产品编号","产品名称","产品种类","产品库存" };
		QueryStock qStock=new QueryStock();

		List <GoodsEmp> wlist=qStock.queryEmp();
		final JTable jTable = new JTable();
		//表模型
		DefaultTableModel dtm=(DefaultTableModel)jTable.getModel();
		dtm.setColumnIdentifiers(heads);
		Object[][]data=new Object[wlist.size()][heads.length];
		for (int i = 0; i < wlist.size(); i++) {
			GoodsEmp moder=wlist.get(i);

			data[i][0]=moder.getGoodsID();
			data[i][1]=moder.getGName();
			data[i][2]=moder.getType();
			data[i][3]=moder.getStockNumber();
			dtm.addRow(data[i]);
		}

		jTable.setRowHeight(30);
		jTable.getTableHeader().setPreferredSize(new Dimension(1, 30));//设置表头的高度
		jTable.getTableHeader().setFont(new Font("微软雅黑",0,20));
		jTable.setFont(new Font("微软雅黑",0,20));
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jScrollPane1=new JScrollPane(jTable,v,h);
		jScrollPane1.setBounds(42, 110, 1280, 580);
		jScrollPane1.setViewportView(jTable);
		this.add(jScrollPane1,null);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		jComboBox1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"--所有产品--", "电子产品", "生活电器", "生活用品" ,"饮料食品"}));
		jComboBox1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub


				String sql="SELECT GoodsID,GName,Type,StockNumber FROM goods";

				String sql2="SELECT GoodsID,GName,Type,StockNumber FROM goods where Type like'"+jComboBox1.getSelectedItem().toString()+"'";
				ResultSet rSet=null;

				if (jComboBox1.getSelectedItem().equals("--所有产品--")) {	
					rSet=Service.runSelectRes(sql);
				} else {
					rSet=Service.runSelectRes(sql2);
				}


				ArrayList<GoodsEmp> goodslist=new ArrayList<GoodsEmp>();
				try {
					while (rSet.next()) {

						GoodsEmp goodsEmp=new GoodsEmp();

						goodsEmp.setGoodsID(rSet.getInt("goodsID"));
						goodsEmp.setGName(rSet.getString("GName"));
						goodsEmp.setType(rSet.getString("Type"));
						goodsEmp.setStockNumber(rSet.getInt("StockNumber"));
						goodslist.add(goodsEmp);
					}
					String[] heads = {"产品编号","产品名称","产品种类","产品库存"  };
					DefaultTableModel df =(DefaultTableModel) jTable.getModel();
					jTable.setRowHeight(30);
					jTable.getTableHeader().setPreferredSize(new Dimension(1, 30));//设置表头的高度
					jTable.getTableHeader().setFont(new Font("微软雅黑",0,20));
					jTable.setFont(new Font("微软雅黑",0,20));
					jTable.setBounds(42, 100, 1280, 592);

					//设置表格的标题
					df.setColumnIdentifiers(heads);

					//往表格中添加数据
					Object[][] objects = new Object[goodslist.size()][heads.length];
					int num = df.getRowCount(); //得到此数据表中的行数
					for (int i = 0; i < num; i++){    //利用循环依次清空所有行
						df.removeRow(0);
					}
					for (int i = 0; i < goodslist.size(); i++) {
						GoodsEmp oDetil = goodslist.get(i);

						objects[i][0]=oDetil.getGoodsID();
						objects[i][1] = oDetil.getGName();
						objects[i][2] = oDetil.getType();
						objects[i][3] = oDetil.getStockNumber();
						df.addRow(objects[i]);
					}
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}


			}
		});




		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jLabel1.setText("\u4ea7\u54c1\u5e93\u5b58\u533a\u95f4\uff1a");

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jLabel2.setText("--------");






		//库存查询
		JButton jButton2=new JButton();
		jButton2.setText("查询");
		jButton2.setBounds(1050, 68, 60, 40);
		this.add(jButton2);


		jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String sql="SELECT GoodsID,Gname,type,StockNumber FROM goods";

				String sql2="SELECT GoodsID,Gname,type,StockNumber FROM goods where StockNumber between'"+jTextField1.getText()+"'and'"+jTextField2.getText()+"'";
				ResultSet rSet=null;
				if (jTextField1.getText().equals("")||jTextField2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "请输入产品库存数量！");
					rSet=Service1.runSelectRes(sql);
				} else {
					rSet=Service1.runSelectRes(sql2);
				}


				ArrayList<GoodsEmp> goodsEmps=new ArrayList<GoodsEmp>();
				try {
					while (rSet.next()) {

						GoodsEmp goodsEmp=new GoodsEmp();
						goodsEmp.setGoodsID(rSet.getInt("GoodsID"));
						goodsEmp.setGName(rSet.getString("GName"));
						goodsEmp.setType(rSet.getString("Type"));
						goodsEmp.setStockNumber(rSet.getInt("StockNumber"));
						

						goodsEmps.add(goodsEmp);				}
					String[] heads = {"产品编号","产品名称","产品种类","产品库存" };
					DefaultTableModel df = (DefaultTableModel) jTable.getModel();
					//设置表格的标题
					df.setColumnIdentifiers(heads);
					//往表格中添加数据
					Object[][] objects = new Object[goodsEmps.size()][heads.length];
					int num = df.getRowCount();//得到此数据表中的行数
					for (int i = 0; i < num; i++){//利用循环依次清空所有行
						df.removeRow(0);
					}
					for (int i = 0; i < goodsEmps.size(); i++) {
						GoodsEmp goEmp = goodsEmps.get(i);
						objects[i][0] = goEmp.getGoodsID();
						objects[i][1] = goEmp.getGName();
						objects[i][2] = goEmp.getType();
						objects[i][3] = goEmp.getStockNumber();
						
						df.addRow(objects[i]);
					}
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}

			}
		});

		jButton1.setIcon(new javax.swing.ImageIcon(
				"Photo//返回.png")); // NOI18N
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jTextField1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));

		jTextField2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
						.addContainerGap(286, Short.MAX_VALUE)
						.addComponent(jComboBox1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(jLabel1)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jTextField1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												135,
												javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(
														javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jLabel2)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jTextField2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		128,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(335, 335, 335))
																		.addGroup(
																				layout.createSequentialGroup()
																				.addGap(81, 81, 81)
																				.addComponent(jScrollPane1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						1118,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addContainerGap(108, Short.MAX_VALUE))
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								layout.createSequentialGroup()
																								.addContainerGap(1226, Short.MAX_VALUE)
																								.addComponent(jButton1)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
						.addComponent(jButton1)
						.addGap(7, 7, 7)
						.addGroup(
								layout.createParallelGroup(
										javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(
												jComboBox1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												38,
												javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jLabel1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														45,
														javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																35,
																javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		jLabel2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		45,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jTextField2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				38,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																						.addComponent(jScrollPane1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								525,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addContainerGap(
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)));

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Register register1 = new Register();
		register1.reg();

		this.setVisible(false);
	}

	public static void main(String args[]) {
		Stock no = new Stock();
		no.note();
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
}
