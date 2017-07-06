package fxh.com.hkj.view;




import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.PlainView;
import javax.tools.JavaCompiler;

import shsm.SHSM;



import com.hkj.entity.Goods;
import com.hkj.entity.Orders;
import com.hkj.entity.OrdersDetil;
import fxh.com.hkj.service.Service;





public class Ststistics_F extends javax.swing.JFrame {
	/**
	 * ��Ʒ��¼����
	 * 
	 */

	public Ststistics_F() {
		initComponents();
		showInfo();
	}
	public void showInfo() {
		String sql="SELECT od.ordersDetilID,g.GoodsID,g.GName,g.Price,od.number,od.allprice,o.ordersDate,g.Type FROM ordersdetil od,orders o,goods g where od.ordersID=o.ordersID AND g.GoodsID=od.goodsID ";
		ResultSet rSet=Service.runSelectRes(sql);
		ArrayList<OrdersDetil> oDetils=new ArrayList<OrdersDetil>();
		try {
			while (rSet.next()) {

				Orders orders=new Orders();
				OrdersDetil oDetil=new OrdersDetil();
				Goods goods=new Goods();
				oDetil.setOrdersDetilID(rSet.getInt("od.ordersDetilID"));

				goods.setGoodsID(rSet.getInt("g.GoodsID"));
				goods.setgName(rSet.getString("g.GName"));
				goods.setPrice(rSet.getDouble("g.Price"));

				oDetil.setNumber(rSet.getInt("od.number"));
				oDetil.setAllprice(rSet.getDouble("od.allprice"));

				orders.setOrdersDate(rSet.getString("o.ordersDate"));

				goods.setType(rSet.getString("g.Type"));

				oDetil.setOrders(orders);
				oDetil.setGoods(goods);

				oDetils.add(oDetil);
			}
			String[] heads = {"���۱��","��Ʒ���","��Ʒ����","����","��������","�ϼƽ��","��������","��Ʒ����" };
			DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
			//���ñ��ı���
			df.setColumnIdentifiers(heads);
			//��������������
			Object[][] objects = new Object[oDetils.size()][heads.length];
			int num = df.getRowCount(); //�õ������ݱ��е�����
			for (int i = 0; i < num; i++){    //����ѭ���������������
				df.removeRow(0);
			}
			for (int i = 0; i < oDetils.size(); i++) {
				OrdersDetil oDetil = oDetils.get(i);
				objects[i][0] = oDetil.getOrdersDetilID();
				objects[i][1] = oDetil.getGoods().getGoodsID();
				objects[i][2] = oDetil.getGoods().getgName();
				objects[i][3] = oDetil.getGoods().getPrice();
				objects[i][4] =	oDetil.getNumber();
				objects[i][5] = oDetil.getAllprice();
				objects[i][6] = oDetil.getOrders().getOrdersDate();
				objects[i][7] = oDetil.getGoods().getType();
				df.addRow(objects[i]);
			}
		} catch (SQLException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}

	}


	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();//�������ñ�ǩ
		jLabel2 = new javax.swing.JLabel();//��Ʒ���
		jButton1 = new javax.swing.JButton();//�˳���ť
		jButton2 = new javax.swing.JButton();//��Ʒ���ۼ�¼��ת��ť
		jButton3 = new javax.swing.JButton();//��������ͳ����ת��ť
		jButton4 = new javax.swing.JButton();//ÿ������ͳ����ת��ť
		jButton5 = new javax.swing.JButton();//��ѯ��ť
		jTextField1 = new javax.swing.JTextField();//������Ʒ��ŵ��ı���
		jTable1 = new javax.swing.JTable();//��
		jComboBox1 = new javax.swing.JComboBox();//�������Ͳ�ѯͳ�Ƶ�������
		jComboBox2 = new javax.swing.JComboBox();//�������ѯ�����ܽ��������
		jComboBox3 = new javax.swing.JComboBox();//�����²�ѯ���۶�������
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jTextField5 = new javax.swing.JTextField();
		jTextField6 = new javax.swing.JTextField();




		//��������
		ImageIcon backgroud;
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setUndecorated(true);//ȡ����߿�
		backgroud=new ImageIcon("Photo//��¼.jpg");// ����ͼƬ
		this.setBounds(300, 100, 1366, 768);//����λ�����С
		this.setVisible(true);//������ʾ
		this.getLayeredPane().setLayout(null);//���ɲ���
		// �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
		jPanel1 = new JPanel();//����JPanel1����
		/**
		 * ����JPanel1��ǩ
		 * �ѱ���ͼƬ��ʾ��JPanel1��ǩ����
		 */
		jLabel1 = new JLabel(backgroud);
		jLabel1.setBounds(0, 0,1366,768);  // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ��������ҳ��
		jPanel1= (JPanel) this.getContentPane();
		jPanel1.setOpaque(false);// ���ݴ���Ĭ�ϵĲ��ֹ�����ΪBorderLayout
		jPanel1.setLayout(null);
		this.getLayeredPane().add(jLabel1, new Integer(Integer.MIN_VALUE));
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
				int x = JOptionPane.showConfirmDialog(new Ststistics_F(), "ȷ���˳�ô��", "������ʾ", JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
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

		//�رհ�ť
		ImageIcon outer;
		outer=new ImageIcon("Photo//�˳�1.png");
		jButton1=new JButton(outer);
		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int x = JOptionPane.showConfirmDialog(new Ststistics_F(), "ȷ���˳�ô��", "������ʾ", JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
				if(x==JOptionPane.OK_OPTION){
					System.exit(0);
				}else {
					setVisible(false);
				}
			}
		});
		this.getContentPane().add(jButton1);
		jButton1.setBounds(1336, 0,30,30);


		//meun
		final JMenu jMenu1=new JMenu("�����տ� ");
		jMenu1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				// ���
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
				// ����뿪
				jMenu1.setFont(new Font("Microsoft YaHei UI", 1, 25));
				jMenu1.setForeground(Color.WHITE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				// �������
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
		final JMenu jMenu2=new JMenu("��Ա���� ");
		jMenu2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				// ���

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				// ����뿪
				jMenu2.setFont(new Font("Microsoft YaHei UI", 1, 25));
				jMenu2.setForeground(Color.WHITE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				// �������
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
		final JMenu jMenu3=new JMenu("��Ա����");
		jMenu3.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				// ���

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				// ����뿪
				jMenu3.setFont(new Font("Microsoft YaHei UI", 1, 25));
				jMenu3.setForeground(Color.WHITE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				// �������
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
		final JMenu jMenu4=new JMenu("��Ʒ���� ");
		jMenu4.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				// ���

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				// ����뿪
				jMenu4.setFont(new Font("Microsoft YaHei UI", 1, 25));
				jMenu4.setForeground(Color.WHITE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				// �������
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
		final JMenu jMenu5=new JMenu("����ͳ�� ");
		jMenu5.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				// ���
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
				// ����뿪
				jMenu5.setFont(new Font("Microsoft YaHei UI", 1, 25));
				jMenu5.setForeground(Color.WHITE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				// �������
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
		final JMenu jMenu6=new JMenu("�ͻ����� ");
		jMenu6.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				new SHSM().setVisible(true);
				setVisible(false);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				// ����뿪
				jMenu6.setFont(new Font("Microsoft YaHei UI", 1, 25));
				jMenu6.setForeground(Color.WHITE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				// �������
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


		//�Ӳ˵�
		jButton2=new JButton("��Ʒ���ۼ�¼");
		jButton2.setFont(new Font("Microsoft YaHei UI", 0, 18));
		jButton2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				// ���
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
				// ����뿪
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				// �������
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		this.getContentPane().add(jButton2);
		jButton2.setBounds(0, 70,150,30);


		jButton3=new JButton("��������ͳ��");
		jButton3.setFont(new Font("Microsoft YaHei UI", 0, 18));
		jButton3.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				JFrame f = new JFrame();
				f.getContentPane().add(new Barchart().getChartPanel());
				f.setBounds(480, 330, 880, 480);
				f.setVisible(true);
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				// ����뿪
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				// �������
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		this.getContentPane().add(jButton3);
		jButton3.setBounds(156, 70,150,30);


		jButton4=new JButton("ÿ������ͳ��");
		jButton4.setFont(new Font("Microsoft YaHei UI", 0, 18));
		jButton4.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				JFrame f = new JFrame();
				f.getContentPane().add(new BarChar().getChartjPanel());
				f.setBounds(480, 330, 880, 480);
				f.setVisible(true);
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				// ����뿪
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				// �������
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		this.getContentPane().add(jButton4);
		jButton4.setBounds(312, 70,150,30);



		//��ѯ����
		//�ø�����Ʒ���ƺ���Ʒ��Ų�ѯ
		jLabel2=new JLabel("��Ż�����");
		jLabel2.setFont(new Font("Microsoft YaHei UI", 1, 25));
		jLabel2.setBounds(20,120,200,30);
		this.getContentPane().add(jLabel2);
		//Ҫ��ѯ����Ʒ���ƺ���Ʒ��ŵ������
		jTextField1.setFont(new Font("Microsoft YaHei UI", 0, 20));
		jTextField1.setBounds(150,110,200,50);
		this.getContentPane().add(jTextField1);
		//��ѯ��ť
		ImageIcon find;
		find=new ImageIcon("Photo//����.png");
		jButton5=new JButton(find);
		jButton5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String x = jTextField1.getText();
				String sql="SELECT od.ordersDetilID,g.GoodsID,g.GName,g.Price,od.number,od.allprice,o.ordersDate,g.Type FROM ordersdetil od,orders o,goods g where od.ordersID=o.ordersID AND g.GoodsID=od.goodsID ";

				String sql2="SELECT od.ordersDetilID,g.GoodsID,g.GName,g.Price,od.number,od.allprice,o.ordersDate,g.Type FROM ordersdetil od,orders o,goods g where od.ordersID=o.ordersID AND g.GoodsID=od.goodsID AND g.GoodsID like'%"+x+"%'";

				String sql3="SELECT od.ordersDetilID,g.GoodsID,g.GName,g.Price,od.number,od.allprice,o.ordersDate,g.Type FROM ordersdetil od,orders o,goods g where od.ordersID=o.ordersID AND g.GoodsID=od.goodsID AND g.GName like'%"+x+"%'";

				ResultSet rSet=null;
				if (jTextField1.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"�������Ʒ���","����",JOptionPane.OK_CANCEL_OPTION);
					rSet=Service.runSelectRes(sql);
				} else {
					String sqll="SELECT GoodsID from goods where goodsID='"+x+"' ";
					boolean y=Service.runSelect(sqll);
					if (y) {
						rSet=Service.runSelectRes(sql2);
					}else {
						rSet=Service.runSelectRes(sql3);
					}

				}


				ArrayList<OrdersDetil> oDetils=new ArrayList<OrdersDetil>();
				try {
					while (rSet.next()) {

						Orders orders=new Orders();
						OrdersDetil oDetil=new OrdersDetil();
						Goods goods=new Goods();
						oDetil.setOrdersDetilID(rSet.getInt("od.ordersDetilID"));

						goods.setGoodsID(rSet.getInt("g.GoodsID"));
						goods.setgName(rSet.getString("g.GName"));
						goods.setPrice(rSet.getDouble("g.Price"));

						oDetil.setNumber(rSet.getInt("od.number"));
						oDetil.setAllprice(rSet.getDouble("od.allprice"));

						orders.setOrdersDate(rSet.getString("o.ordersDate"));

						goods.setType(rSet.getString("g.Type"));

						oDetil.setOrders(orders);
						oDetil.setGoods(goods);

						oDetils.add(oDetil);
					}
					String[] heads = {"���۱��","��Ʒ���","��Ʒ����","����","��������","�ϼƽ��","��������","��Ʒ����" };
					DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
					//���ñ��ı���
					df.setColumnIdentifiers(heads);
					//��������������
					Object[][] objects = new Object[oDetils.size()][heads.length];
					int num = df.getRowCount(); //�õ������ݱ��е�����
					for (int i = 0; i < num; i++){    //����ѭ���������������
						df.removeRow(0);
					}
					for (int i = 0; i < oDetils.size(); i++) {
						OrdersDetil oDetil = oDetils.get(i);
						objects[i][0] = oDetil.getOrdersDetilID();
						objects[i][1] = oDetil.getGoods().getGoodsID();
						objects[i][2] = oDetil.getGoods().getgName();
						objects[i][3] = oDetil.getGoods().getPrice();
						objects[i][4] =	oDetil.getNumber();
						objects[i][5] = oDetil.getAllprice();
						objects[i][6] = oDetil.getOrders().getOrdersDate();
						objects[i][7] = oDetil.getGoods().getType();
						df.addRow(objects[i]);
					}
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}

			}
		});
		jButton5.setBounds(350,110,50,50);
		this.getContentPane().add(jButton5);


		//�������������Ʒ���Ͳ�ѯ
		jComboBox1.addItem("--���в�Ʒ--");
		jComboBox1.addItem("�������");
		jComboBox1.addItem("������Ʒ");
		jComboBox1.addItem("���Ӳ�Ʒ");
		jComboBox1.addItem("����ʳƷ");
		jComboBox1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//					jComboBox1.getSelectedItem();
				String sql="SELECT od.ordersDetilID,g.GoodsID,g.GName,g.Price,od.number,od.allprice,o.ordersDate,g.Type FROM ordersdetil od,orders o,goods g where od.ordersID=o.ordersID AND g.GoodsID=od.goodsID ";

				String sql2="SELECT od.ordersDetilID,g.GoodsID,g.GName,g.Price,od.number,od.allprice,o.ordersDate,g.Type FROM ordersdetil od,orders o,goods g where od.ordersID=o.ordersID AND g.GoodsID=od.goodsID AND g.Type like'"+jComboBox1.getSelectedItem().toString()+"'";
				ResultSet rSet=null;

				if (jComboBox1.getSelectedItem().equals("--���в�Ʒ--")) {	
					rSet=Service.runSelectRes(sql);
				} else {
					rSet=Service.runSelectRes(sql2);
				}


				ArrayList<OrdersDetil> oDetils=new ArrayList<OrdersDetil>();
				try {
					while (rSet.next()) {

						Orders orders=new Orders();
						OrdersDetil oDetil=new OrdersDetil();
						Goods goods=new Goods();
						oDetil.setOrdersDetilID(rSet.getInt("od.ordersDetilID"));

						goods.setGoodsID(rSet.getInt("g.GoodsID"));
						goods.setgName(rSet.getString("g.GName"));
						goods.setPrice(rSet.getDouble("g.Price"));

						oDetil.setNumber(rSet.getInt("od.number"));
						oDetil.setAllprice(rSet.getDouble("od.allprice"));

						orders.setOrdersDate(rSet.getString("o.ordersDate"));

						goods.setType(rSet.getString("g.Type"));

						oDetil.setOrders(orders);
						oDetil.setGoods(goods);

						oDetils.add(oDetil);
					}
					String[] heads = {"���۱��","��Ʒ���","��Ʒ����","����","��������","�ϼƽ��","��������","��Ʒ����" };
					DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
					//���ñ��ı���
					df.setColumnIdentifiers(heads);
					//��������������
					Object[][] objects = new Object[oDetils.size()][heads.length];
					int num = df.getRowCount(); //�õ������ݱ��е�����
					for (int i = 0; i < num; i++){    //����ѭ���������������
						df.removeRow(0);
					}
					for (int i = 0; i < oDetils.size(); i++) {
						OrdersDetil oDetil = oDetils.get(i);
						objects[i][0] = oDetil.getOrdersDetilID();
						objects[i][1] = oDetil.getGoods().getGoodsID();
						objects[i][2] = oDetil.getGoods().getgName();
						objects[i][3] = oDetil.getGoods().getPrice();
						objects[i][4] =	oDetil.getNumber();
						objects[i][5] = oDetil.getAllprice();
						objects[i][6] = oDetil.getOrders().getOrdersDate();
						objects[i][7] = oDetil.getGoods().getType();
						df.addRow(objects[i]);
					}
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}

			}
		});
		jComboBox1.setBounds(1100,110,200,50);
		jComboBox1.setFont(new Font("Microsoft YaHei UI", 1, 25));
		this.getContentPane().add(jComboBox1);

		//table
		String columnsName[] = { "���۱��","��Ʒ���","��Ʒ����","����","��������","�ϼƽ��","��������","��Ʒ����"};
		DefaultTableModel model = new DefaultTableModel(columnsName, 0);
		jTable1=new JTable(model);
		//��ȡ��ͷ�����������и�
		jTable1.getTableHeader().setPreferredSize(new Dimension(jTable1.getColumnModel().getTotalColumnWidth(), 40));
		//���ñ�ͷ����
		jTable1.getTableHeader().setFont(new Font("Microsoft YaHei UI", 1, 25));

		//���������и�������
		jTable1.setRowHeight(40);
		jTable1.setFont(new Font("Microsoft YaHei UI",0, 15));

		//��Table��ӵ�������������
		JScrollPane jScrollPane = new JScrollPane(jTable1);
		jScrollPane.setSize(1366, 500);//table��С
		jScrollPane.setLocation(0, 170);// ���������λ��
		jPanel1.add(jScrollPane);
		this.getContentPane().add(jScrollPane,new Integer(Integer.MAX_VALUE));


		jComboBox2.addItem("----");
		jComboBox2.addItem("2013");
		jComboBox2.addItem("2014");
		jComboBox2.addItem("2015");
		jComboBox2.addItem("2016");
		jComboBox2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object a = jComboBox2.getSelectedItem().toString();
				if (a.equals("----")) {
					jTextField2.setText("");
					jTextField3.setText("");
					jTextField4.setText("");
					jTextField5.setText("");
				}else {
					try {
						//��������۶�
						String sql="SELECT month,sum(amount) FROM Orders WHERE year='"+a+"' GROUP BY month ORDER BY sum(amount) DESC  LIMIT 1";
						ResultSet rSet=Service.runSelectRes(sql);
						if(rSet.next()){
							String s=""+rSet.getString("month");
							jTextField4.setText(s);
						}

						//��С�����۶�
						String sql2="SELECT month,sum(amount) FROM Orders WHERE year='"+a+"' GROUP BY month ORDER BY sum(amount)  LIMIT 1";
						ResultSet rSet2=Service.runSelectRes(sql2);
						if(rSet2.next()){
							String s2=""+rSet2.getString("month");
							jTextField3.setText(s2);
						}
						//ƽ��ֵ���۶�
						String sql3="SELECT AVG(amount) FROM Orders WHERE year='"+a+"' GROUP BY month";
						ResultSet rSet3=Service.runSelectRes(sql3);
						if(rSet3.next()){
							String s3=""+rSet3.getDouble("AVG(amount)");
							jTextField5.setText(s3);
						}
						//�������ܶ�
						String sql4="SELECT SUM(amount) FROM Orders WHERE year='"+a+"' GROUP BY year";
						ResultSet rSet4=Service.runSelectRes(sql4);
						if(rSet4.next()){
							String s4=""+rSet4.getDouble("SUM(amount)");
							jTextField2.setText(s4);
						}

					} catch (SQLException e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}

				}
			}
		});
		jComboBox2.setBounds(10,685,100,30);
		jComboBox2.setFont(new Font("Microsoft YaHei UI", 0, 15));
		this.getContentPane().add(jComboBox2);



		jLabel3=new JLabel("�������ܶ");
		jLabel3.setBounds(150,685,100,30);
		jLabel3.setFont(new Font("Microsoft YaHei UI", 0, 15));
		this.getContentPane().add(jLabel3);

		jTextField2=new JTextField();
		jTextField2.setEditable(false);//����
		jTextField2.setBounds(260,685,120,30);
		jTextField2.setFont(new Font("Microsoft YaHei UI", 0, 15));
		this.getContentPane().add(jTextField2);

		jLabel4=new JLabel("��С���۶��·ݣ�");
		jLabel4.setBounds(390,685,120,30);
		jLabel4.setFont(new Font("Microsoft YaHei UI", 0, 15));
		this.getContentPane().add(jLabel4);

		jTextField3=new JTextField();
		jTextField3.setEditable(false);//����
		jTextField3.setBounds(520,685,30,30);
		jTextField3.setFont(new Font("Microsoft YaHei UI", 0, 15));
		this.getContentPane().add(jTextField3);

		jLabel5=new JLabel("������۶��·ݣ�");
		jLabel5.setBounds(560,685,120,30);
		jLabel5.setFont(new Font("Microsoft YaHei UI", 0, 15));
		this.getContentPane().add(jLabel5);

		jTextField4=new JTextField();
		jTextField4.setEditable(false);//����
		jTextField4.setBounds(690,685,30,30);
		jTextField4.setFont(new Font("Microsoft YaHei UI", 0, 15));
		this.getContentPane().add(jTextField4);

		jLabel6=new JLabel("��ƽ�����۶");
		jLabel6.setBounds(730,685,120,30);
		jLabel6.setFont(new Font("Microsoft YaHei UI", 0, 15));
		this.getContentPane().add(jLabel6);

		jTextField5=new JTextField();
		jTextField5.setEditable(false);//����
		jTextField5.setBounds(860,685,100,30);
		jTextField5.setFont(new Font("Microsoft YaHei UI", 0, 15));
		this.getContentPane().add(jTextField5);


		jComboBox3.addItem("----");
		jComboBox3.addItem("1");
		jComboBox3.addItem("2");
		jComboBox3.addItem("3");
		jComboBox3.addItem("4");
		jComboBox3.addItem("5");
		jComboBox3.addItem("6");
		jComboBox3.addItem("7");
		jComboBox3.addItem("8");
		jComboBox3.addItem("9");
		jComboBox3.addItem("10");
		jComboBox3.addItem("11");
		jComboBox3.addItem("12");
		jComboBox3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object a = jComboBox2.getSelectedItem().toString();
				Object b = jComboBox3.getSelectedItem().toString();
				if (b.equals("----")) {
					jTextField6.setText("");
				}else {
					try {
						//�������ܶ�
						String sql5="SELECT SUM(amount) FROM Orders WHERE year='"+a+"' AND month='"+b+"' GROUP BY month";
						ResultSet rSet5=Service.runSelectRes(sql5);
						if(rSet5.next()){
							String s5=""+rSet5.getDouble("SUM(amount)");
							jTextField6.setText(s5);
						}
					} catch (SQLException e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
			}
		});
		jComboBox3.setBounds(10,725,100,30);
		jComboBox3.setFont(new Font("Microsoft YaHei UI", 0, 15));
		this.getContentPane().add(jComboBox3);


		jLabel7=new JLabel("�������ܶ");
		jLabel7.setBounds(150,725,120,30);
		jLabel7.setFont(new Font("Microsoft YaHei UI", 0, 15));
		this.getContentPane().add(jLabel7);

		jTextField6=new JTextField();
		jTextField6.setEditable(false);//����
		jTextField6.setBounds(260,725,120,30);
		jTextField6.setFont(new Font("Microsoft YaHei UI", 0, 15));
		this.getContentPane().add(jTextField6);


	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Ststistics_F().setVisible(true);
			}
		});
	}


	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTable jTable1;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JComboBox jComboBox2;
	private javax.swing.JComboBox jComboBox3;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;

}