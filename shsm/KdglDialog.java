/*
 * KdglDialog.java
 *
 * Created on __DATE__, __TIME__
 */

package shsm;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

/**
 *
 * @author  __USER__
 */
public class KdglDialog extends javax.swing.JDialog {
	static String date;

	/** Creates new form KdglDialog */
	public KdglDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		this.setLocationRelativeTo(null);
		this.setTitle("快递员信息");
		
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel4 = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jComboBox1 = new javax.swing.JComboBox();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jTextField5 = new javax.swing.JTextField();
		jTextField6 = new javax.swing.JTextField();
		jTextField7 = new javax.swing.JTextField();
		jTextField8 = new javax.swing.JTextField();
		jTextField9 = new javax.swing.JTextField();
		jTextField10 = new javax.swing.JTextField();
		jTextField11 = new javax.swing.JTextField();
		jLabel13 = new javax.swing.JLabel();

		jLabel4.setText("jLabel4");

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent evt) {
				formWindowOpened(evt);
			}
		});

		jPanel1.setLayout(null);

		jLabel1.setText("\u5feb\u9012\u5458\u7f16\u53f7");
		jPanel1.add(jLabel1);
		jLabel1.setBounds(40, 30, 90, 20);

		jLabel2.setText("\u5feb\u9012\u5458\u59d3\u540d");
		jPanel1.add(jLabel2);
		jLabel2.setBounds(40, 70, 80, 20);

		jLabel3.setText("\u5feb\u9012\u5458\u6027\u522b");
		jPanel1.add(jLabel3);
		jLabel3.setBounds(40, 110, 80, 20);

		jLabel5.setText("\u5feb\u9012\u5458\u5e74\u9f84");
		jPanel1.add(jLabel5);
		jLabel5.setBounds(40, 150, 75, 20);

		jLabel6.setText("\u804c\u4f4d");
		jPanel1.add(jLabel6);
		jLabel6.setBounds(40, 190, 60, 20);

		jLabel7.setText("\u5361\u53f7");
		jPanel1.add(jLabel7);
		jLabel7.setBounds(40, 230, 30, 20);

		jLabel8.setText("\u7535\u8bdd");
		jPanel1.add(jLabel8);
		jLabel8.setBounds(40, 270, 30, 20);

		jLabel9.setText("\u5730\u5740");
		jPanel1.add(jLabel9);
		jLabel9.setBounds(40, 310, 30, 20);

		jLabel10.setText("\u5165\u804c\u65e5\u671f");
		jPanel1.add(jLabel10);
		jLabel10.setBounds(40, 350, 60, 20);

		jLabel11.setText("\u8d26\u53f7");
		jPanel1.add(jLabel11);
		jLabel11.setBounds(40, 390, 30, 20);

		jLabel12.setText("\u5bc6\u7801");
		jPanel1.add(jLabel12);
		jLabel12.setBounds(40, 430, 30, 20);

		jButton1.setText("\u786e\u5b9a");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jPanel1.add(jButton1);
		jButton1.setBounds(60, 510, 70, 29);

		jButton2.setText("\u53d6\u6d88");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		jPanel1.add(jButton2);
		jButton2.setBounds(150, 510, 70, 29);
		jPanel1.add(jTextField1);
		jTextField1.setBounds(150, 30, 120, 26);
		jPanel1.add(jTextField2);
		jTextField2.setBounds(150, 70, 120, 26);

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"男", "女" }));
		jPanel1.add(jComboBox1);
		jComboBox1.setBounds(150, 110, 120, 26);
		jPanel1.add(jTextField3);
		jTextField3.setBounds(150, 150, 120, 26);
		jPanel1.add(jTextField4);
		jTextField4.setBounds(150, 190, 120, 26);
		jPanel1.add(jTextField5);
		jTextField5.setBounds(150, 230, 120, 26);
		jPanel1.add(jTextField6);
		jTextField6.setBounds(150, 270, 120, 26);
		jPanel1.add(jTextField7);
		jTextField7.setBounds(150, 310, 120, 26);
		jPanel1.add(jTextField8);
		jTextField8.setBounds(150, 350, 120, 26);
		jPanel1.add(jTextField9);
		jTextField9.setBounds(150, 390, 120, 26);
		jPanel1.add(jTextField10);
		jTextField10.setBounds(150, 430, 120, 26);
		jPanel1.add(jTextField11);
		jTextField11.setBounds(150, 470, 120, 26);

		jLabel13.setText("\u6743\u9650");
		jPanel1.add(jLabel13);
		jLabel13.setBounds(40, 470, 30, 20);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 338,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 575,
				Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void formWindowOpened(java.awt.event.WindowEvent evt) {
		// TODO add your handling code here:
		jTextField8.setText(time());
		jTextField8.setEditable(false);
	}

	//创建转换时间方法
	public static String time() {
		try {
			date = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss")
					.format(new java.util.Date());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return date;
	}

	//确定事件
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String eID = jTextField1.getText().toString();
		String eName = jTextField2.getText().toString();
		String eSex = jComboBox1.getSelectedItem().toString();
		String eAge = jTextField3.getText().toString();
		String ePosition = jTextField4.getText().toString();
		String eIDcard = jTextField5.getText().toString();
		String ePhone = jTextField6.getText().toString();
		String eAddress = jTextField7.getText().toString();
		String eDate = jTextField8.getText().toString();
		String eNumber = jTextField9.getText().toString();
		String ePw = jTextField10.getText().toString();
		String ePower = jTextField11.getText().toString();
		String sql = "insert into employee values (" + eID + ",'" + eName
				+ "','" + eSex + "'," + eAge + ",'" + ePosition + "','"
				+ eIDcard + "'" + ",'" + ePhone + "','" + eAddress + "','"
				+ eDate + "','" + eNumber + "','" + ePw + "'," + ePower + ")";
		if (ShsmManage.runUpdate(sql)) {
              JOptionPane.showMessageDialog(null, "添加成功");
              this.dispose();
              SHSM.showTableKdgl();
		}else {
			JOptionPane.showMessageDialog(null, "添加失败");
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		this.dispose();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				KdglDialog dialog = new KdglDialog(new javax.swing.JFrame(),
						true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField10;
	private javax.swing.JTextField jTextField11;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	private javax.swing.JTextField jTextField7;
	private javax.swing.JTextField jTextField8;
	private javax.swing.JTextField jTextField9;
	// End of variables declaration//GEN-END:variables

}