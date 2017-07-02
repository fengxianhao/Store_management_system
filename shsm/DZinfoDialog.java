/*
 * DZinfoDialog.java
 *
 * Created on __DATE__, __TIME__
 */

package shsm;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 *
 * @author  __USER__
 */
public class DZinfoDialog extends javax.swing.JDialog {

	/** Creates new form DZinfoDialog */
	public DZinfoDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		this.setLocationRelativeTo(null);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jTextField5 = new javax.swing.JTextField();
		jTextField6 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent evt) {
				formWindowOpened(evt);
			}
		});

		jPanel1.setLayout(null);

		jLabel1.setText("\u5730\u5740\u7f16\u53f7");
		jPanel1.add(jLabel1);
		jLabel1.setBounds(50, 50, 80, 20);

		jLabel2.setText("\u8ba2\u5355\u7f16\u53f7");
		jPanel1.add(jLabel2);
		jLabel2.setBounds(50, 100, 80, 20);

		jLabel3.setText("\u8ba2\u5355\u5730\u5740");
		jPanel1.add(jLabel3);
		jLabel3.setBounds(50, 150, 70, 20);

		jLabel4.setText("\u4e0b\u5355\u65f6\u95f4");
		jPanel1.add(jLabel4);
		jLabel4.setBounds(50, 210, 70, 20);

		jLabel5.setText("\u9001\u8fbe\u65f6\u95f4");
		jPanel1.add(jLabel5);
		jLabel5.setBounds(50, 260, 70, 20);

		jLabel6.setText("\u5feb\u9012\u5458\u7f16\u53f7");
		jPanel1.add(jLabel6);
		jLabel6.setBounds(50, 310, 100, 20);
		jPanel1.add(jTextField1);
		jTextField1.setBounds(200, 50, 160, 26);
		jPanel1.add(jTextField2);
		jTextField2.setBounds(200, 100, 160, 26);
		jPanel1.add(jTextField3);
		jTextField3.setBounds(200, 160, 160, 26);
		jPanel1.add(jTextField4);
		jTextField4.setBounds(200, 210, 160, 26);
		jPanel1.add(jTextField5);
		jTextField5.setBounds(200, 260, 160, 26);
		jPanel1.add(jTextField6);
		jTextField6.setBounds(200, 310, 160, 26);

		jButton1.setText("\u786e\u5b9a");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jPanel1.add(jButton1);
		jButton1.setBounds(90, 390, 70, 29);

		jButton2.setText("\u53d6\u6d88");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		jPanel1.add(jButton2);
		jButton2.setBounds(190, 390, 80, 29);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 487,
				Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
				String eID = jTextField1.getText().toString();
				String eName = jTextField2.getText().toString();
				String eAge = jTextField3.getText().toString();
				String ePosition = jTextField4.getText().toString();
				String eIDcard = jTextField5.getText().toString();
				String ePhone = jTextField6.getText().toString();
				String sql = "update deliver set addressid=" + eID + ",ordersid=" + eName
						+ ",address='" + eAge + "',startdate='" + ePosition + "',deliverydate='" + eIDcard + "',employeeid="
						+ ePhone + "" +" where addressid="+SHSM.xiugaiDzID+"";
				if (ShsmManage.runUpdate(sql)) {
					JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
					this.dispose();
					SHSM.showTableDzgl();
				} else {
					JOptionPane.showMessageDialog(null, "�޸�ʧ��");
				}
	}

	private void formWindowOpened(java.awt.event.WindowEvent evt) {
		// TODO add your handling code here:
		// TODO add your handling code here:
		jTextField1.setEditable(false);
		jTextField2.setEditable(false);
		jTextField4.setEditable(false);
		ResultSet rst = ShsmManage
				.runSelect("select * from deliver where addressid="
						+ SHSM.xiugaiDzID + "");
		try {
			if (rst.next()) {
				jTextField1.setText(rst.getString(1));
				jTextField2.setText(rst.getString(2));
				jTextField3.setText(rst.getString(3));
				jTextField4.setText(rst.getString(4));
				jTextField5.setText(rst.getString(5));
				jTextField6.setText(rst.getString(6));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				DZinfoDialog dialog = new DZinfoDialog(
						new javax.swing.JFrame(), true);
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
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	// End of variables declaration//GEN-END:variables

}