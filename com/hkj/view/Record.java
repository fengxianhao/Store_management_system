
package com.hkj.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.hkj.entity.GoodsEmp;
import com.hkj.service.QueryRecord;
import com.hkj.service.QueryRegister;
import com.hkj.service.Service1;

import fxh.com.hkj.service.Service;


public class Record extends javax.swing.JFrame {
	
	
	
	/** Creates new form register1 */
	public void register() {
		initComponents();
		ResultSet rstResultSet = null;
		boolean a = true;
		this.setTitle("产品入库记录");
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
	public void into(){
		//设置表格
				String [] heads={"入库编号","商品编号","商品名称","商品种类","入库数量","入库日期","负责人"};
				QueryRecord queryRecord=new QueryRecord();

				List <GoodsEmp> wlist=queryRecord.queryEmp();
				//jTable = new JTable();
				//表模型
				DefaultTableModel dtm=(DefaultTableModel)jTable.getModel();
				dtm.setColumnIdentifiers(heads);
				Object[][]data=new Object[wlist.size()][heads.length];
				for (int i = 0; i < wlist.size(); i++) {
					GoodsEmp moder=wlist.get(i);
					data[i][0]=moder.getStorageID();
					data[i][1]=moder.getGoodsID();
					data[i][2]=moder.getGName();
					data[i][3]=moder.getType();
					data[i][4]=moder.getStorageNumber();
					data[i][5]=moder.getStorageDate();
					data[i][6]=moder.getCharge();
					dtm.addRow(data[i]);
				}
				
				jTable.setRowHeight(30);
				jTable.getTableHeader().setPreferredSize(new Dimension(1, 30));//设置表头的高度
				jTable.getTableHeader().setFont(new Font("微软雅黑",0,20));
				jTable.setFont(new Font("微软雅黑",0,20));
				int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
				int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
				JScrollPane jsPane=new JScrollPane(jTable,v,h);
				jsPane.setViewportView(jTable);
				jsPane.setVisible(true);
				this.add(jsPane,null);
	}
	
	public void CheckPname1() {
		//写表头
		String[] heads = { "入库编号", "产品编号", "产品名称", "产品类别", "入库数量", "入库日期",
				"负责人" };
		Service1 linte = new Service1();
		String Ptype1 = jComboBox3.getSelectedItem().toString();
		String Ptype2 = jComboBox7.getSelectedItem().toString();
		List<GoodsEmp> wate = linte.query4(Ptype1, Ptype2);
		//创建表模型对象
		jTable = new JTable();
		DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
		dtm.setColumnIdentifiers(heads);
		dtm.getDataVector().clear();
		if (Ptype1.equals("") && Ptype2.equals("")) {
			initComponents();
			
		}
		Object[][] data = new Object[wate.size()][7];
		for (int i = 0; i < wate.size(); i++) {
			GoodsEmp moder = wate.get(i);
			data[i][0] = moder.getStorageID();
			data[i][1] = moder.getGoodsID();
			data[i][2] = moder.getGName();
			data[i][3] = moder.getType();
			data[i][4] = moder.getStorageNumber();
			data[i][5] = moder.getStorageDate();
			data[i][6] = moder.getCharge();
			dtm.addRow(data[i]);
		}
		
		jTable.getTableHeader().setPreferredSize(new Dimension(1, 30));
		jTable.setRowHeight(30);
		jTable.setFont(new Font("微软雅黑", 0, 20));
		jTable.getTableHeader().setFont(new Font("微软雅黑", 0, 20));
		//jTable.setRowMargin(2);
		jScrollPane1.setViewportView(jTable);
		//jScrollPane1.setEnabled(false);
		jScrollPane1.setBounds(42, 105, 1280, 580);
		this.add(jScrollPane1,null);
	}

	private void initComponents() {

		jComboBox1 = new javax.swing.JComboBox();
		jComboBox3 = new javax.swing.JComboBox();
		jComboBox4 = new javax.swing.JComboBox();
		jLabel1 = new javax.swing.JLabel();
		jComboBox7 = new javax.swing.JComboBox();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable = new javax.swing.JTable();
		jButton4 = new javax.swing.JButton();

		//设置表格
		String [] heads={"入库编号","商品编号","商品名称","商品种类","入库数量","入库日期","负责人"};
		QueryRecord queryRecord=new QueryRecord();

		List <GoodsEmp> wlist=queryRecord.queryEmp();
		jTable = new JTable();
		//表模型
		DefaultTableModel dtm=(DefaultTableModel)jTable.getModel();
		dtm.setColumnIdentifiers(heads);
		Object[][]data=new Object[wlist.size()][heads.length];
		for (int i = 0; i < wlist.size(); i++) {
			GoodsEmp moder=wlist.get(i);
			data[i][0]=moder.getStorageID();
			data[i][1]=moder.getGoodsID();
			data[i][2]=moder.getGName();
			data[i][3]=moder.getType();
			data[i][4]=moder.getStorageNumber();
			data[i][5]=moder.getStorageDate();
			data[i][6]=moder.getCharge();
			dtm.addRow(data[i]);
		}
		
		jTable.setRowHeight(30);
		jTable.getTableHeader().setPreferredSize(new Dimension(1, 30));//设置表头的高度
		jTable.getTableHeader().setFont(new Font("微软雅黑",0,20));
		jTable.setFont(new Font("微软雅黑",0,20));
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsPane=new JScrollPane(jTable,v,h);
		jsPane.setViewportView(jTable);
		jsPane.setVisible(true);
		this.add(jsPane,null);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		jComboBox1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"--所有产品--", "电子产品", "生活电器", "生活用品" ,"饮料食品"}));
		jComboBox1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				String sql="select StorageID,GoodsID,GName,Type,StorageNumber,StorageDate,Charge from goods";

				String sql2="select StorageID,GoodsID,GName,Type,StorageNumber,StorageDate,Charge from goods where Type like'"+jComboBox1.getSelectedItem().toString()+"'";
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

						goodsEmp.setStorageID(rSet.getInt("StorageID"));
						goodsEmp.setGoodsID(rSet.getInt("goodsID"));
						goodsEmp.setGName(rSet.getString("GName"));
						goodsEmp.setType(rSet.getString("Type"));
						goodsEmp.setStorageNumber(rSet.getInt("StorageNumber"));
						goodsEmp.setStorageDate(rSet.getString("StorageDate"));
						goodsEmp.setCharge(rSet.getString("Charge"));
						goodslist.add(goodsEmp);
					}
					String[] heads = {"入库编号","商品编号","商品名称","商品种类","入库数量","入库日期","负责人" };
					DefaultTableModel df =(DefaultTableModel) jTable.getModel();
					//设置表格的标题
					df.setColumnIdentifiers(heads);
					jTable.setRowHeight(30);
					jTable.getTableHeader().setPreferredSize(new Dimension(1, 30));//设置表头的高度
					jTable.getTableHeader().setFont(new Font("微软雅黑",0,20));
					jTable.setFont(new Font("微软雅黑",0,20));
					jTable.setBounds(42, 100, 1280, 592);


					//往表格中添加数据
					Object[][] objects = new Object[goodslist.size()][heads.length];
					int num = df.getRowCount(); //得到此数据表中的行数
					for (int i = 0; i < num; i++){    //利用循环依次清空所有行
						df.removeRow(0);
					}
					for (int i = 0; i < goodslist.size(); i++) {
						GoodsEmp oDetil = goodslist.get(i);
						objects[i][0] = oDetil.getStorageID();
						objects[i][1]=oDetil.getGoodsID();
						objects[i][2] = oDetil.getGName();
						objects[i][3] = oDetil.getType();
						objects[i][4] = oDetil.getStorageNumber();
						objects[i][5] = oDetil.getStorageDate();
						objects[i][6] = oDetil.getCharge();
						df.addRow(objects[i]);
					}
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});


		jComboBox3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"--选择时间--","2016-04-01", "2016-05-01", "2016-06-01",}));

		jComboBox3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				CheckPname1();
				
			}
		});


		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jLabel1.setText("--\u81f3--");


		jComboBox7.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"--选择时间--","2016-04-30", "2016-05-31", "2016-06-30", }));
		jComboBox7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jComboBox7.getSelectedItem().equals("--选择时间--")) {
				
				}
				CheckPname1();
			}
		});



		jScrollPane1.setEnabled(false);

		jButton4.setIcon(new javax.swing.ImageIcon(
				"Photo//返回.png")); // NOI18N
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
						.addGap(71, 71, 71)
						.addComponent(jComboBox1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(29, 29, 29)
								.addComponent(jComboBox3,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										140,
										javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addPreferredGap(
														javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGap(18, 18, 18)
														.addComponent(jLabel1)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jComboBox7,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		136,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																						.addGap(65, 65, 65).addComponent(jButton4))
																						.addGroup(
																								layout.createSequentialGroup()
																								.addGap(41, 41, 41)
																								.addComponent(jScrollPane1,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										1215, Short.MAX_VALUE)
																										.addGap(45, 45, 45)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
						.addGroup(
								layout.createParallelGroup(
										javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												layout.createSequentialGroup()
												.addContainerGap()
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(
																		jComboBox1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		42,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jComboBox3,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				40,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jLabel1)
																						.addComponent(
																								jComboBox7,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								42,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
														))
														.addComponent(jButton4))
														.addGap(46, 46, 46)
														.addComponent(jScrollPane1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																525, Short.MAX_VALUE)
																.addGap(86, 86, 86)));

		pack();
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				//new Update_Record().setVisible(true);
			}
		});
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Register register1 = new Register();
		register1.reg();

		this.setVisible(false);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		Record reg = new Record();
		reg.register();

	}


	private javax.swing.JButton jButton4;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JComboBox jComboBox3;
	private javax.swing.JComboBox jComboBox4;
	private javax.swing.JComboBox jComboBox7;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable;
}
