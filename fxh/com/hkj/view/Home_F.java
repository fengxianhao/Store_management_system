package fxh.com.hkj.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;


import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;

import com.hkj.entity.Goods;
import com.hkj.entity.OrdersDetil;
import com.hkj.view.Employee;

import fxh.com.hkj.db.DbHelper_F;
import fxh.com.hkj.service.Service;


public class Home_F extends javax.swing.JFrame {
	private JPanel JPanel1;
	private JLabel JLabel1;
	private JLabel JLabel2;
	private JLabel JLabel3;
	private ImageIcon backgroud;
	private ImageIcon outer;
	private javax.swing.JTable jTable1;
	private JScrollPane jScrollPane;
	private JButton JButton1;
	private JButton JButton2;
	private JButton JButton3;
	private JButton JButton4;
	private JButton JButton5;//退出按钮
	private JMenu jMenu1;
	private JMenu jMenu2;
	private JMenu jMenu3;
	private JMenu jMenu4;
	private JMenu jMenu5;
	private JMenu jMenu6;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private DefaultTableModel model;
	double total=0.00;
	float temp=0;
	public double money = 0;


	public Home_F() {
		initComponents();
	}

	private Goods showRecords(String sql) {
		Goods p = null;
		try {
			Connection conn = DbHelper_F.getConnection();

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p = new Goods();
				p.setGoodsID(rs.getInt("goodsID"));
				p.setgName(rs.getString("gName"));
				p.setPrice(rs.getDouble("Price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	public void initComponents(){

		//窗体
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setUndecorated(true);//取消外边框
		backgroud=new ImageIcon("Photo//登录.jpg");// 背景图片
		this.setBounds(300, 100, 1366, 768);//窗体位置与大小
		this.setVisible(true);//显示窗口
		//		this.setResizable(false);//取消窗口最小化按钮操作
		this.getLayeredPane().setLayout(null);//自由布局
		// 把背景图片添加到分层窗格的最底层作为背景
		JPanel1 = new JPanel();//创建JPanel1容器
		/**
		 * 创建JPanel1标签
		 * 把背景图片显示在JPanel1标签里面
		 */
		JLabel1 = new JLabel(backgroud);
		JLabel1.setBounds(0, 0, 1366, 768);  // 把标签的大小位置设置为图片刚好填充整个页面
		JPanel1= (JPanel) this.getContentPane();
		JPanel1.setOpaque(false);// 内容窗格默认的布局管理器为BorderLayout
		JPanel1.setLayout(null);
		this.getLayeredPane().add(JLabel1, new Integer(Integer.MIN_VALUE));


		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				int x = JOptionPane.showConfirmDialog(new Home_F(), "确认退出么？", "友情提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
				if(x==JOptionPane.OK_OPTION){
					System.exit(0);
				}else {
					setVisible(false);
				}
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});


		//关闭按钮
		outer=new ImageIcon("Photo//退出1.png");
		JButton5=new JButton(outer);
		JButton5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int x = JOptionPane.showConfirmDialog(new Home_F(), "确认退出么？", "友情提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
				if(x==JOptionPane.OK_OPTION){
					System.exit(0);
				}else {
					setVisible(false);
				}
			}
		});
		this.getContentPane().add(JButton5);
		JButton5.setBounds(1336, 0,30,30);


		//meun
		final JMenu jMenu1=new JMenu("店铺收款 ");
		jMenu1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				// 点击
				new Home_F();
				setVisible(false);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				// 鼠标离开
				jMenu1.setFont(new Font("Microsoft YaHei UI", 1, 25));
				jMenu1.setForeground(Color.WHITE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				// 鼠标悬浮
				jMenu1.setFont(new Font("Microsoft YaHei UI", 1, 25));
				jMenu1.setForeground(Color.YELLOW);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		jMenu1.setBounds(0, 20, 150, 30);
		jMenu1.setFont(new Font("Microsoft YaHei UI", 1, 25));
		jMenu1.setForeground(Color.WHITE);
		final JMenu jMenu2=new JMenu("雇员管理 ");
		jMenu2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				// 雇员管理
				new Employee().setVisible(true);
				setVisible(false);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				// 鼠标离开
				jMenu2.setFont(new Font("Microsoft YaHei UI", 1, 25));
				jMenu2.setForeground(Color.WHITE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				// 鼠标悬浮
				jMenu2.setFont(new Font("Microsoft YaHei UI", 1, 25));
				jMenu2.setForeground(Color.YELLOW);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		jMenu2.setBounds(120,20, 150, 30);
		jMenu2.setFont(new Font("Microsoft YaHei UI", 1, 25));
		jMenu2.setForeground(Color.WHITE);
		final JMenu jMenu3=new JMenu("会员管理");
		jMenu3.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				// 点击

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				// 鼠标离开
				jMenu3.setFont(new Font("Microsoft YaHei UI", 1, 25));
				jMenu3.setForeground(Color.WHITE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				// 鼠标悬浮
				jMenu3.setFont(new Font("Microsoft YaHei UI", 1, 25));
				jMenu3.setForeground(Color.YELLOW);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		jMenu3.setBounds(240,20, 150, 30);
		jMenu3.setFont(new Font("Microsoft YaHei UI", 1, 25));
		jMenu3.setForeground(Color.WHITE);
		final JMenu jMenu4=new JMenu("产品管理 ");
		jMenu4.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				// 点击

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				// 鼠标离开
				jMenu4.setFont(new Font("Microsoft YaHei UI", 1, 25));
				jMenu4.setForeground(Color.WHITE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				// 鼠标悬浮
				jMenu4.setFont(new Font("Microsoft YaHei UI", 1, 25));
				jMenu4.setForeground(Color.YELLOW);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		jMenu4.setBounds(360, 20, 150, 30);
		jMenu4.setFont(new Font("Microsoft YaHei UI", 1, 25));
		jMenu4.setForeground(Color.WHITE);
		final JMenu jMenu5=new JMenu("销售统计 ");
		jMenu5.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				// 点击
				new Ststistics_F();
				setVisible(false);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				// 鼠标离开
				jMenu5.setFont(new Font("Microsoft YaHei UI", 1, 25));
				jMenu5.setForeground(Color.WHITE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				// 鼠标悬浮
				jMenu5.setFont(new Font("Microsoft YaHei UI", 1, 25));
				jMenu5.setForeground(Color.YELLOW);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		jMenu5.setBounds(480, 20, 150, 30);
		jMenu5.setFont(new Font("Microsoft YaHei UI", 1, 25));
		jMenu5.setForeground(Color.WHITE);
		final JMenu jMenu6=new JMenu("送货上门 ");
		jMenu6.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				// 点击
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				// 鼠标离开
				jMenu6.setFont(new Font("Microsoft YaHei UI", 1, 25));
				jMenu6.setForeground(Color.WHITE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				// 鼠标悬浮
				jMenu6.setFont(new Font("Microsoft YaHei UI", 1, 25));
				jMenu6.setForeground(Color.YELLOW);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		jMenu6.setBounds(600, 20, 115, 30);
		jMenu6.setFont(new Font("Microsoft YaHei UI", 1, 25));
		jMenu6.setForeground(Color.WHITE);
		this.getContentPane().add(jMenu1);
		this.getContentPane().add(jMenu2);
		this.getContentPane().add(jMenu3);
		this.getContentPane().add(jMenu4);
		this.getContentPane().add(jMenu5);
		this.getContentPane().add(jMenu6);



		//出售 产品添加
		JLabel2=new JLabel("产品ID");
		JLabel2.setForeground(Color.WHITE);
		JLabel2.setFont(new Font("Microsoft YaHei UI", 1,30));
		this.getContentPane().add(JLabel2);
		JLabel2.setBounds(50,100, 150, 30);

		JLabel3=new JLabel("购买数量");
		JLabel3.setForeground(Color.WHITE);
		JLabel3.setFont(new Font("Microsoft YaHei UI", 1, 30));
		this.getContentPane().add(JLabel3);
		JLabel3.setBounds(300, 100, 150, 30);

		JButton1=new JButton("确定");
		JButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String a = textField1.getText();
				String b = textField2.getText();

				if (!"".equals(a) && !"".equals(b)) {
					String sql="select * from goods where goodsid like '"+textField1.getText()+"'";
					Goods p=showRecords(sql);
					if (p != null) {
						int quantity = Integer.parseInt(b);
						//计算合计金额
						Object[] rows = { p.getGoodsID(), p.getgName(),
								p.getPrice(), quantity,
								p.getPrice() * quantity };
						DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
						dtm.addRow(rows);
						textField1.setText("");
						textField2.setText("");

						textField3.setEditable(false);//禁用

						money += p.getPrice() * quantity;

						textField3.setText(String.valueOf(money));

					} else {
						JOptionPane.showMessageDialog(null, "未找到该商品", "温馨提示",
								JOptionPane.INFORMATION_MESSAGE);
						textField1.setText("");
						textField2.setText("");

					}
				} else {
					JOptionPane.showMessageDialog(null, "请输入商品编号或购买数量!","温馨提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		JButton1.setFont(new Font("Microsoft YaHei UI", 1, 25));
		this.getContentPane().add(JButton1);
		JButton1.setBounds(570, 100, 100, 30);


		textField1= new JTextField(); //接收产品ID
		textField2= new JTextField();//接收数量
		textField1.setFont(new Font("Microsoft YaHei UI", 1, 17));
		textField2.setFont(new Font("Microsoft YaHei UI", 1, 17));
		this.getContentPane().add(textField1);
		this.getContentPane().add(textField2);
		textField1.setBounds(175, 100, 100, 30);
		textField2.setBounds(450, 100, 100, 30);

		//操作按钮
		JButton2=new JButton("删除");
		JButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				total=Float.parseFloat(textField3.getText());
				int row=jTable1.getSelectedRow();
				temp=Float.parseFloat(jTable1.getValueAt(row, 4).toString());
				total-=temp;
				textField3.setText(String.valueOf(total));
				model.removeRow(row);
				JOptionPane.showMessageDialog(null, "删除成功","提示",JOptionPane.INFORMATION_MESSAGE);	
			}
		});
		JButton2.setFont(new Font("Microsoft YaHei UI", 1, 25));
		this.getContentPane().add(JButton2);
		JButton2.setBounds(200,680, 100, 30);



		JButton3=new JButton("清空");
		JButton3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int num = model.getRowCount(); //得到此数据表中的行数
				for (int i = 0; i < num; i++){    //利用循环依次清空所有行
					model.removeRow(0);
				}
				textField1.setText("");
				textField2.setText("");
				textField3.setText("0.00");
				temp=0;
				total=0;
				money=0;
			}
		});
		JButton3.setFont(new Font("Microsoft YaHei UI", 1, 25));
		this.getContentPane().add(JButton3);
		JButton3.setBounds(570,680, 100, 30);

		JLabel3=new JLabel("合计:");
		JLabel3.setForeground(Color.WHITE);
		JLabel3.setFont(new Font("Microsoft YaHei UI", 1, 25));
		this.add(JLabel3);
		JLabel3.setBounds( 1045, 350,60, 30);



		//合计金额的数据框
		textField3=new JTextField("0.00");
		textField3.setColumns(10);
		textField3.setEditable(false);//禁用
		textField3.setFont(new Font("Dialog", Font.BOLD, 17));
		this.getContentPane().add(textField3);
		textField3.setBounds(1125, 350, 100, 30);


		JButton4=new JButton("结账");
		JButton4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
				int a = dtm.getRowCount();
				// TODO Auto-generated method stub
				if (a==0) {
					JOptionPane.showMessageDialog(null, "顾客未购买商品","提示",JOptionPane.OK_CANCEL_OPTION);
				}else {
					double money=Double.parseDouble(JOptionPane.showInputDialog(null, "实收:", "输入实收金额", JOptionPane.OK_CANCEL_OPTION));
					double b=Double.parseDouble(textField3.getText());
					new Trade_F(Home_F.this,money,b);
					String sql="INSERT INTO orders VALUES (null,now() ,'"+b+"' ,null )";
					Service.runAddSql(sql);
					for (int i = 0; i < a; i++) {
						String sql2="INSERT INTO ordersdetil VALUES (null,(select MAX(ordersid) from orders) ,'"+jTable1.getValueAt(i, 0).toString()+"','"+jTable1.getValueAt(i, 3).toString()+"' ,'"+jTable1.getValueAt(i, 4).toString()+"' )";
						Service.runAddSql(sql2);
					}
				}

			}
		});
		JButton4.setFont(new Font("Microsoft YaHei UI", 1, 25));
		this.getContentPane().add(JButton4);
		JButton4.setBounds( 1100, 450, 100, 30);


		//table
		String columnsName[] = { "商品编号","商品名称","价格","购买数量","合计金额"};
		model =new DefaultTableModel(columnsName, 0);
		jTable1=new JTable(model);

		//获取表头并给其设置行高
		jTable1.getTableHeader().setPreferredSize(new Dimension(jTable1.getColumnModel().getTotalColumnWidth(), 40));
		//设置表头字体
		jTable1.getTableHeader().setFont(new Font("Microsoft YaHei UI", 1, 25));

		//设置内容行高与字体
		jTable1.setRowHeight(40);
		jTable1.setFont(new Font("Microsoft YaHei UI",Font.PLAIN, 15));

		//将Table添加到滑动条容器中
		jScrollPane=new JScrollPane(jTable1);
		jScrollPane.setSize(870, 450);
		jScrollPane.setLocation(0, 175);// 相对于面板的位置
		JPanel1.add(jScrollPane);
		this.getContentPane().add(jScrollPane,new Integer(Integer.MAX_VALUE));

	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Home_F().setVisible(true);
			}
		});
	}

}
