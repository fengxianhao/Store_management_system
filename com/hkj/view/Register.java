

package com.hkj.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;

import shsm.SHSM;

import com.hkj.entity.Goods;
import com.hkj.entity.GoodsEmp;
import com.hkj.entity.Orders;
import com.hkj.entity.OrdersDetil;
import com.hkj.service.Deleteregister;
import com.hkj.service.QueryGoodsID;
import com.hkj.service.QueryRegister;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import fxh.com.hkj.service.Service;
import fxh.com.hkj.view.Ststistics_F;


public class Register extends JFrame {


	private JPanel imagePanel;

	private ImageIcon background;
	private JTable jTable;

	JFrame frame = new JFrame("产品入库登记");

	/** Creates new form login */
	public void reg() {
		// TODO Auto-generated constructor stub

		frame.setBounds(300, 100, 1366, 768);
		frame.setUndecorated(true);
		frame.setVisible(true);

		final JMenu jMenu1=new JMenu("店铺收款");
		jMenu1.setBounds(10, 10, 130, 50);
		jMenu1.setFont(new Font("微软雅黑",1,30));
		frame.add(jMenu1);


		final JMenu jMenu2=new JMenu("雇员管理");
		jMenu2.setBounds(150, 10, 130, 50);
		jMenu2.setFont(new Font("微软雅黑",1,30));
		frame.add(jMenu2);


		final JMenu jMenu3=new JMenu("会员管理");
		jMenu3.setBounds(290, 10, 130, 50);
		jMenu3.setFont(new Font("微软雅黑",1,30));
		frame.add(jMenu3);


		final JMenu jMenu4=new JMenu("产品管理");
		jMenu4.setBounds(430, 10, 130, 50);
		jMenu4.setFont(new Font("微软雅黑",1,30));
		frame.add(jMenu4);

		final JMenu jMenu5=new JMenu("销售统计");
		jMenu5.setBounds(570, 10, 130, 50);
		jMenu5.setFont(new Font("微软雅黑",1,30));
		frame.add(jMenu5);

		final JMenu jMenu6=new JMenu("送货上门");
		jMenu6.setBounds(710, 10, 130, 50);
		jMenu6.setFont(new Font("微软雅黑",1,30));
		frame.add(jMenu6);

		JLabel jLabel1=new JLabel("按产品编号查找");
		jLabel1.setBounds(20, 75, 170, 50);
		jLabel1.setFont(new Font("微软雅黑",0,22));
		frame.add(jLabel1);

		final JTextField jTextField=new JTextField();
		jTextField.setBounds(190, 78, 170, 50);
		jTextField.setFont(new Font("微软雅黑",0,18));
		frame.add(jTextField);

		Icon icon5=new ImageIcon("Photo//查找.png");
		JButton jButton1=new JButton(icon5);
		jButton1.setBounds(380, 78, 110, 50);
		jButton1.setFont(new Font("微软雅黑",0,18));
		jButton1.setBorderPainted(false);//隐藏按钮边框
		frame.add(jButton1);

		JLabel jLabel3=new JLabel("产品种类");
		jLabel3.setBounds(500, 75, 170, 50);
		jLabel3.setFont(new Font("微软雅黑",0,25));
		frame.add(jLabel3);


		final JComboBox jComboBox1=new JComboBox(); 
		jComboBox1.addItem("--所有产品--");
		jComboBox1.addItem("电子产品");
		jComboBox1.addItem("生活电器");
		jComboBox1.addItem("生活用品");
		jComboBox1.addItem("饮料食品");
		jComboBox1.setFont(new Font("微软雅黑",0,22));//其中""中的代表字体，1代表粗体，22代表字体大小
		jComboBox1.setBounds(615, 85, 150, 40);//设置位置，前面两个代表横纵坐标，后面两个代表宽高
		frame.add(jComboBox1);

		//设置表格
		String [] heads={"商品编号","商品名称","商品价格","商品种类"};
		QueryRegister queryRegister=new QueryRegister();
		List <GoodsEmp> wlist=queryRegister.queryEmp();
		final JTable jTable = new JTable();
		//表模型
		DefaultTableModel dtm=(DefaultTableModel)jTable.getModel();
		dtm.setColumnIdentifiers(heads);
		Object[][]data=new Object[wlist.size()][heads.length];
		for (int i = 0; i < wlist.size(); i++) {
			GoodsEmp moder=wlist.get(i);
			data[i][0]=moder.getGoodsID();
			data[i][1]=moder.getGName();
			data[i][2]=moder.getPrice();
			data[i][3]=moder.getType();
			dtm.addRow(data[i]);
		}

		jTable.setRowHeight(28);
		jTable.getTableHeader().setPreferredSize(new Dimension(1, 30));//设置表头的高度
		jTable.getTableHeader().setFont(new Font("微软雅黑",0,20));
		jTable.setFont(new Font("微软雅黑",0,20));
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsPane=new JScrollPane(jTable,v,h);
		jsPane.setBounds(20, 150, 800, 420);
		frame.add(jsPane,null);

		Icon icon=new ImageIcon("Photo//添加3.png");	
		JButton jButton2=new JButton("添加",icon);
		jButton2.setBounds(40, 620, 160, 50);
		jButton2.setFont(new Font("微软雅黑",0,18));
		frame.add(jButton2);

		Icon icon1=new ImageIcon("Photo//修改3.png");	
		JButton jButton3=new JButton("修改信息",icon1);
		jButton3.setBounds(310, 620, 220, 50);
		jButton3.setFont(new Font("微软雅黑",0,18));
		frame.add(jButton3);


		Icon icon2=new ImageIcon("Photo//删除3.png");	
		JButton jButton4=new JButton("删除",icon2);
		jButton4.setBounds(600, 620, 170, 50);
		jButton4.setFont(new Font("微软雅黑",0,18));
		frame.add(jButton4);

		JButton jButton5=new JButton("产品入库登记");
		jButton5.setBounds(920, 200, 250, 80);
		jButton5.setFont(new Font("微软雅黑",0,30));
		frame.add(jButton5);

		JButton jButton6=new JButton("产品入库记录");
		jButton6.setBounds(920, 300, 250, 80);
		jButton6.setFont(new Font("微软雅黑",0,30));
		frame.add(jButton6);

		JButton jButton7=new JButton("产品库存情况");
		jButton7.setBounds(920, 400, 250, 80);
		jButton7.setFont(new Font("微软雅黑",0,30));
		frame.add(jButton7);

		Icon icon4=new ImageIcon("Photo//退出1.png");
		JButton jButton8=new JButton(icon4);
		jButton8.setBounds(1310, 10, 43, 43);
		jButton8.setFont(new Font("黑体",1,20));
		jButton8.setBorderPainted(false);//隐藏按钮边框
		
		frame.add(jButton8);

		//店铺收款
		jMenu1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}
			//鼠标离开
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				jMenu1.setForeground(Color.black);
			}
			//鼠标悬浮
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jMenu1.setForeground(Color.YELLOW);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		//雇员管理菜单按钮
		jMenu2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						new Employee().setVisible(true);
						Employee table=new Employee();
					}
				});

				frame.setVisible(false);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				jMenu2.setForeground(Color.black);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jMenu2.setForeground(Color.YELLOW);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		//会员管理按钮
		jMenu3.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						new Member().setVisible(true);
					}
				});

				frame.setVisible(false);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				jMenu3.setForeground(Color.black);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jMenu3.setForeground(Color.YELLOW);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		//产品管理
		jMenu4.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				Register register=new Register();
				register.reg();

				frame.setVisible(false);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				jMenu4.setForeground(Color.black);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jMenu4.setForeground(Color.YELLOW);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		//统计销售
		jMenu5.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						new Ststistics_F().setVisible(true);
					}
				});
				frame.setVisible(false);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				jMenu5.setForeground(Color.black);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jMenu5.setForeground(Color.YELLOW);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		//送货上门
		jMenu6.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						new SHSM().setVisible(true);
					}
				});
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				jMenu6.setForeground(Color.black);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jMenu6.setForeground(Color.YELLOW);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		//按编号查询
		jButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql="SELECT GoodsID,Gname,price,type FROM goods";

				String sql2="SELECT GoodsID,Gname,price,type FROM goods where GoodsID like'"+jTextField.getText()+"'";
				ResultSet rSet=null;
				if (jTextField.getText().equals("")) {	
					JOptionPane.showMessageDialog(null, "请输入产品编号！");
					rSet=Service.runSelectRes(sql);
				} else {
					rSet=Service.runSelectRes(sql2);
				}


				ArrayList<GoodsEmp> goodsEmps=new ArrayList<GoodsEmp>();
				try {
					while (rSet.next()) {

						GoodsEmp goodsEmp=new GoodsEmp();
						goodsEmp.setGoodsID(rSet.getInt("GoodsID"));
						goodsEmp.setGName(rSet.getString("GName"));
						goodsEmp.setPrice(rSet.getString("Price"));
						goodsEmp.setType(rSet.getString("Type"));

						goodsEmps.add(goodsEmp);				}
					String[] heads = {"商品编号","商品名称","商品价格","商品类型" };
					DefaultTableModel df = (DefaultTableModel) jTable.getModel();
					//设置表格的标题
					df.setColumnIdentifiers(heads);
					//往表格中添加数据
					Object[][] objects = new Object[goodsEmps.size()][heads.length];
					int num = df.getRowCount(); //得到此数据表中的行数
					for (int i = 0; i < num; i++){    //利用循环依次清空所有行
						df.removeRow(0);
					}
					for (int i = 0; i < goodsEmps.size(); i++) {
						GoodsEmp goEmp = goodsEmps.get(i);
						objects[i][0] = goEmp.getGoodsID();
						objects[i][1] = goEmp.getGName();
						objects[i][2] = goEmp.getPrice();
						objects[i][3] = goEmp.getType();
						df.addRow(objects[i]);
					}
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}



			}
		});

		//按产品种类查询（下拉框）
		jComboBox1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO Auto-generated method stub
				//jComboBox1.getSelectedItem();
				String sql="SELECT GoodsID,Gname,price,type FROM goods";

				String sql2="SELECT GoodsID,Gname,price,type FROM Goods where Type like'"+jComboBox1.getSelectedItem().toString()+"'";
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

						goodsEmp.setGoodsID(rSet.getInt("GoodsID"));
						goodsEmp.setGName(rSet.getString("GName"));
						goodsEmp.setPrice(rSet.getString("Price"));
						goodsEmp.setType(rSet.getString("Type"));
						goodslist.add(goodsEmp);
					}
					String[] heads = {"商品编号","商品名称","商品价格","商品类型" };
					DefaultTableModel df =(DefaultTableModel) jTable.getModel();
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
						objects[i][0] = oDetil.getGoodsID();
						objects[i][1] = oDetil.getGName();
						objects[i][2] = oDetil.getPrice();
						objects[i][3] = oDetil.getType();
						df.addRow(objects[i]);
					}
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}



			}
		});

		//修改按钮
		jButton3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//获取表格选中的某行
					int row=jTable.getSelectedRow();
					int goodsID=Integer.parseInt(jTable.getModel().getValueAt(row, 0).toString());
					String GName=jTable.getModel().getValueAt(row, 1).toString();
					int Price=Integer.parseInt(jTable.getModel().getValueAt(row, 2).toString());
					String Type=jTable.getModel().getValueAt(row, 3).toString();


					//把结果把保存到集合
					ArrayList arrayList=new ArrayList();
					arrayList.add(goodsID);
					arrayList.add(GName);
					arrayList.add(Price);
					arrayList.add(Type);

					Update_Register updateRegister=new Update_Register();
					updateRegister.Update_Register(arrayList);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"请选择要修改的行！");
				}

			}
		});

		//产品入库登记按钮
		jButton5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					//获取表格选中的某行
					int a=jTable.getSelectedRow();

					int goodsID=Integer.parseInt(jTable.getModel().getValueAt(a, 0).toString());
					String charge=jTable.getModel().getValueAt(a, 1).toString();
					//把结果把保存到集合
					ArrayList arrayList=new ArrayList();
					arrayList.add(goodsID);
					arrayList.add(charge);

					Add_Record addRecord=new Add_Record();
					addRecord.add(arrayList);
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "请选择要登记的产品！");
				}



			}
		});

		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int a=jTable.getSelectedRow();
					int b=Integer.parseInt(jTable.getModel().getValueAt(a, 0).toString());

					Deleteregister deleteregister=new Deleteregister();
					int h =  deleteregister.delectgoods(b);

					if (h==1) {
						JOptionPane.showMessageDialog(null,"删除成功！");

					}

					if(h!=1){
						Register register=new Register();
						register.reg();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"请选择要删除的行！");
				}



			}
		});

		jButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Record reg = new Record();
				reg.register();
				frame.setVisible(false);
			}
		});

		jButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stock no = new Stock();
				no.note();
				frame.setVisible(false);
			}
		});

		jButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int show= JOptionPane.showConfirmDialog(null, "确定退出吗？", "请选择", JOptionPane.YES_NO_OPTION);
				if(show==JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		});


		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Register add = new Add_Register();
				add.Adds();
			}
		});


		//插入背景图片
		background = new ImageIcon("Photo//背景.jpg");// 背景图片
		JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
		// 把标签的大小位置设置为图片刚好填充整个面板
		label.setBounds(0, 0, background.getIconWidth(),
				background.getIconHeight());
		// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
		imagePanel = (JPanel) frame.getContentPane();
		imagePanel.setOpaque(false);
		// 内容窗格默认的布局管理器为绝对定位
		imagePanel.setLayout(null);
		frame.getLayeredPane().setLayout(null);
		// 把背景图片添加到分层窗格的最底层作为背景
		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(background.getIconWidth(), background.getIconHeight());
		frame.setResizable(true);
		frame.setVisible(true);    


	}


	public static void main(String args[]) {

		Register register=new Register();
		register.reg();

	}
}




